package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        int[] cuenca = new int[12];
        int[] capt = new int[2];
        int turno, casilla, inicial, vacio, semillas;
        boolean finpartida, finturno;
        String input = "";

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        System.out.print("\nBienvenido a Oware.\n\nPara ver las instrucciones escriba I, para empezar la partida escriba cualquier otra cosa: ");

        if (br.readLine().equalsIgnoreCase("I"))
            instrucciones();
        do {
            inicilizarTablero(cuenca, capt);
            finpartida = false;
            turno = 0;
            do {
                visualizarTablero(cuenca, capt);
                vacio = tableroVacio(cuenca, turno);
                if (vacio > 0) {
                    if (vacio == 2) {
                        if (!falicitarSemillas(cuenca, turno)) finpartida = true;
                    } else finpartida = true;
                }
                if (!finpartida) do {
                    finturno = false;

                    System.out.printf("Jugador %d\nElija una casilla para mover o escriba FIN para terminar: ", turno(turno));
                    input = br.readLine();
                    if (!input.equalsIgnoreCase("FIN")) {
                        inicial = casilla = seleccionCasilla(input);
                        if (casilla < 0 || casilla > 11) {
                            System.out.println("Selección inválida.");
                        } else if (cuenca[casilla] == 0) {
                            System.out.println("Selección inválida.");
                        } else if ((turno(turno) == 1 && casilla > 5) || (turno(turno) == 2 && casilla < 6)) {
                            System.out.printf("Selección inválida. Es el turno de Jugador %d\n", turno(turno));
                        } else if (vacio == 2 && !facilitarSemillas(cuenca, casilla)) {
                            System.out.printf("Selección inválida. Jugador %d ha de falicitar semillas a Jugador %d.", turno(turno), turno(turno + 1));
                        } else {
                            semillas = cuenca[casilla];
                            do {
                                repartoSemillas(cuenca, casilla, inicial);
                                if (casilla != inicial) semillas--;
                                if (semillas > 0) {
                                    casilla++;
                                    if (casilla > 11) casilla = 0;
                                }
                            } while (semillas > 0);
                            conquista(cuenca, casilla, turno, capt);
                            finturno = true;
                        }
                    }
                } while (!finturno && !input.equalsIgnoreCase("FIN"));
                turno++;
            } while (!input.equalsIgnoreCase("FIN") && !finpartida);
            finPartida(capt, turno, vacio, cuenca);
            System.out.println("\n¿Desea jugar otra partida? Escriba OTRA para repetir, cualquier otra cosa para finalizar:");
            input = br.readLine();
        } while (input.equalsIgnoreCase("OTRA"));
    }

    private static void finPartida(int[] capt, int turno, int vacio, int[] cuenca) {
        if (vacio > 0) {
            if (vacio == 1) {
                System.out.printf("El Jugador %d no puede mover. Las semillas restantes se suman a la captura de Jugador %d.\n", turno(turno), turno(turno+1));
                recolectaSemillas(cuenca, capt, turno+1);
            } else {
                System.out.printf("No hay movimientos posibles para que Jugador %d tenga semillas." +
                        " Las semillas restantes se suman a la captura de Jugador %d.\n", turno(turno+1), turno(turno));
                recolectaSemillas(cuenca, capt, turno);
            }
        }
        System.out.println("\n---FIN DE LA PARTIDA---\n" +
                "Después de " + turno + " turnos las capturas son las siguientes:\n" +
                "Jugador 1: Ha capturado " + capt[0] + " semillas.\n" +
                "Jugador 2: Ha capturado " + capt[1] + " semillas.\n");

        if (capt[0] == capt[1]) System.out.println("¡Empate!");
        else if (capt[0] > capt[1]) System.out.println("¡Jugador 1 ha ganado la partida!");
        else System.out.println("¡Jugador 2 ha ganado la partida!");
    }

    private static void recolectaSemillas(int[] cuenca, int[] capt, int turno) {
        for (int aCuenca : cuenca) {
            capt[turno(turno) - 1] += aCuenca;
        }
    }

    private static void conquista(int[] cuenca, int casilla, int turno, int[] captura) {
        if (casilla < 0) casilla = 11;
        if ((turno(turno) == 1 && casilla > 5) || (turno(turno) == 2 && casilla < 6)) {
            if (cuenca[casilla] == 2 || cuenca[casilla] == 3) {
                captura[turno(turno) - 1] += cuenca[casilla];
                cuenca[casilla] = 0;
                conquista(cuenca, casilla - 1, turno, captura);
            }
        }
    }

    private static void repartoSemillas(int[] cuenca, int casilla, int casillaInicial) {
        if (casilla == casillaInicial) {
            cuenca[casilla] = 0;
        } else {
            cuenca[casilla]++;
        }
    }

    private static boolean facilitarSemillas(int[] cuenca, int casilla) {
        if (casilla > 5) return (cuenca[casilla] > 5 - casilla - 6);
        else return (cuenca[casilla] > 5 - casilla);
    }

    private static int seleccionCasilla(String input) {
        return "ABCDEFabcdef".indexOf(input);
    }

    private static boolean falicitarSemillas(int[] cuenca, int turno) {
        int desplazamiento = 0;
        if (turno(turno) == 2) desplazamiento = 6;
        for (int i = 0; i < 6; i++) {
            if (cuenca[i + desplazamiento] > 6 - i) return true;
        }
        return false;
    }

    private static int tableroVacio(int[] cuenca, int turno) {
        int desplazamiento = 0;
        if (turno(turno) == 2) desplazamiento = 6;
        for (int i = desplazamiento; i < 6 + desplazamiento; i++) {
            if (cuenca[i] > 0) break;
            if (i == 5 + desplazamiento) return 1;
        }
        for (int i = 6 - desplazamiento; i < 12 - desplazamiento; i++) {
            if (cuenca[i] > 0) break;
            if (i == 11 - desplazamiento) return 2;
        }
        return 0;
    }

    private static int turno(int turno) {
        if (turno % 2 == 0) return 1;
        else return 2;
    }

    private static void visualizarTablero(int[] cuenca, int[] capt) {
        System.out.printf("\n      ┌─────────────────────────────┐\n" +
                "      │  f │  e │  d │  c │  b │  a │\n" +
                "┌─────┼─────────────────────────────┼─────┐\n" +
                "│ J2  │ %2d │ %2d │ %2d │ %2d │ %2d │ %2d │     │\n" +
                "│ %2d  ├─────────────────────────────┤  %2d │\n" +
                "│     │ %2d │ %2d │ %2d │ %2d │ %2d │ %2d │  J1 │\n" +
                "└─────┼─────────────────────────────┼─────┘\n" +
                "      │  A │  B │  C │  D │  E │  F │\n" +
                "      └─────────────────────────────┘\n",
                cuenca[11],cuenca[10],cuenca[9],cuenca[8],cuenca[7],cuenca[6],
                capt[0],capt[1],
                cuenca[0],cuenca[1],cuenca[2],cuenca[3],cuenca[4],cuenca[5]);
    }

    private static void inicilizarTablero(int[] cuenca, int[] capt) {
        Arrays.fill(cuenca, 4);
        Arrays.fill(capt, 0);
    }

    private static void instrucciones() {
        System.out.println("\nOware se juega en un tablero de dos filas con seis cuencas cada. La fila de abajo pertenece al Jugador 1, mientrás que la de arriba pertenece a Jugador 2. El juego empieza con 4 semillas en cada cuenca.\n" +
                "En su turno el jugador escoge una de sus cuencas para coger todas sus semillas y repartirlas por las cuencas en sentido contrario al reloj. En cada cuenca el jugador pone una semilla. Si el jugador llega a la última de sus cuencas, seguirá en las del oponente, siguiendo el sentido contrario al reloj.\n" +
                "Si la última cuenca en la que ha repartido pertenece a su oponente y hay dos o tres semillas en esa cuenca el jugador las capturará. Si las cuencas previas también contienen dos o tres semillas el jugador las recolectará igualmente, así hasta llegar a una cuenca del oponente que no tenga 2 o 3.\n" +
                "Si una cuenca contiene más de doce semillas y el jugador elige repartirla, el jugador no podrá poner ninguna semilla en esta cuenca según esté repartiendo, saltando así a la siguiente cuenca.\n" +
                "Si un jugador carece de semillas en su fila para mover al comenzar el turno, las semillas restantes pasarán a la captura del oponente y la partida terminará.\n" +
                "Si el oponente se ha quedado sin semillas durante su turno, el jugador estará obligado a distribuir semillas a su oponente, siendo ilegal cualquier movimiento que no lleve a esto. Si no existe ningún movimiento que pueda dar semillas al oponente, las semillas restantes pasarán a la captura del jugador con semillas y la partida terminará.\n" +
                "Cuando queden pocas semillas en el tablero sera complicado para cualquiera de los jugadores capturar ninguna semilla. En ese caso se podrá terminar la partida escribiendo \"FIN\".\n" +
                "Al terminar la partida, el jugador con más semillas en su captura gana la partida.");
    }
}
