package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        boolean wrong, vacio1 = false, vacio2 = false;
        int turno, f, e, d, c, b, a, A, B, C, D, E, F, capt1, capt2, semilla;
        String x = "";


        System.out.println("\nBienvenido a Oware.\n\nPara ver las instrucciones escriba I, para empezar la partida escriba cualquier otra cosa:");
        String y = br.readLine();

        //instrucciones
        if (y.equalsIgnoreCase("I")) System.out.println("\nOware se juega en un tablero de dos filas con seis cuencas cada. La fila de abajo pertenece al Jugador 1, mientrás que la de arriba pertenece a Jugador 2. El juego empieza con 4 semillas en cada cuenca.\nEn su turno el jugador escoge una de sus cuencas para coger todas sus semillas y repartirlas por las cuencas en sentido contrario al reloj. En cada cuenca el jugador pone una semilla. Si el jugador llega a la última de sus cuencas, seguirá en las del oponente, siguiendo el sentido contrario al reloj.\nSi la última cuenca en la que ha repartido pertenece a su oponente y hay dos o tres semillas en esa cuenca el jugador las capturará. Si las cuencas previas también contienen dos o tres semillas el jugador las recolectará igualmente, así hasta llegar a una cuenca del oponente que no tenga 2 o 3.\nSi una cuenca contiene más de doce semillas y el jugador elige repartirla, el jugador no podrá poner ninguna semilla en esta cuenca según esté repartiendo, saltando así a la siguiente cuenca.\nSi un jugador carece de semillas en su fila para mover al comenzar el turno, las semillas restantes pasarán a la captura del oponente y la partida terminará.\nSi el oponente se ha quedado sin semillas durante su turno, el jugador estará obligado a distribuir semillas a su oponente, siendo ilegal cualquier movimiento que no lleve a esto. Si no existe ningún movimiento que pueda dar semillas al oponente, las semillas restantes pasarán a la captura del jugador con semillas y la partida terminará.\nCuando queden pocas semillas en el tablero sera complicado para cualquiera de los jugadores capturar ninguna semilla. En ese caso se podrá terminar la partida escribiendo \"FIN\".\nAl terminar la partida, el jugador con más semillas en su captura gana la partida.");

        do {    //inicializar la partida
            f = e = d = c = b = a = A = B = C = D = E = F = 4;
            semilla = capt1 = capt2 = 0;
            turno = 1;

            do {

                //tablero
                System.out.println("\n     ┌─────────────────────────────────┐");
                System.out.println("     │  f │  e │  d │  c │  b │  a │");
                System.out.println("┌─────┼─────────────────────────────────┼─────┐");
                System.out.println("│ J2 │  " + f + " │  " + e + " │  " + d + " │  " + c + " │  " + b + " │  " + a + " │     │");
                System.out.println("│  " + capt2 + " ├─────────────────────────────────┤  " + capt1 + "  │");
                System.out.println("│    │  " + A + " │  " + B + " │  " + C + " │  " + D + " │  " + E + " │  " + F + " │  J1 │");
                System.out.println("└─────┼─────────────────────────────────┼─────┘");
                System.out.println("     │  A │  B │  C │  D │  E │  F │");
                System.out.println("     └─────────────────────────────────┘\n");


                if (turno % 2 != 0) { //jugador 1 tiene turnos impares
                    if (A + B + C + D + E + F == 0) { //si el tablero propio está vacio el contrario se queda las semillas restantes y la partida termina
                        capt2 += f + e + d + c + b + a;
                        System.out.println("Jugador 1 no puede mover. Las semillas restantes se suman a la captura de Jugador 2.");
                        x = "FIN";
                    } else
                        vacio1 = false;
                    if (f + e + d + c + b + a == 0) { //si el campo contrario está vacio se limitan las jugadas
                        if (A < 6 && B < 5 && C < 4 && D < 3 && E < 2 && F < 1) { //si no hay movimientos que den más semillas al contrario se suman las semillas y termina la partida
                            capt1 += A + B + C + D + E + F;
                            System.out.println("No hay movimientos posibles para que Jugador 2 tenga semillas. Las semillas restantes se suman a la captura de Jugador 1.");
                            x = "FIN";
                        } else vacio2 = true;
                    } else vacio2 = false;
                    if (!x.equals("FIN"))
                        do {
                            wrong = false;
                            System.out.println("Jugador 1\nElija una casilla para mover o escriba FIN para terminar la partida:");
                            x = br.readLine();

                            switch (x) {

                                case "A":
                                    if (A > 0) {
                                        if (vacio2 && A < 6) {
                                            System.out.print("Jugador 1 debe facilitar semillas a Jugador 2. ");
                                            wrong = true;
                                        } else {
                                            semilla += A;
                                            A = 0;
                                            do {
                                                if (semilla > 0) {
                                                    ++B;
                                                    --semilla;
                                                }
                                                if (semilla > 0) {
                                                    ++C;
                                                    --semilla;
                                                }
                                                if (semilla > 0) {
                                                    ++D;
                                                    --semilla;
                                                }
                                                if (semilla > 0) {
                                                    ++E;
                                                    --semilla;
                                                }
                                                if (semilla > 0) {
                                                    ++F;
                                                    --semilla;
                                                }
                                                if (semilla > 0) {
                                                    ++a;
                                                    --semilla;
                                                    if (semilla == 0 && (a == 2 || a == 3)) {
                                                        capt1 += a;
                                                        a = 0;
                                                    }
                                                }
                                                if (semilla > 0) {
                                                    ++b;
                                                    --semilla;
                                                    if (semilla == 0 && (b == 2 || b == 3)) {
                                                        capt1 += b;
                                                        b = 0;
                                                        if (a == 2 || a == 3) {
                                                            capt1 += a;
                                                            a = 0;
                                                        }
                                                    }
                                                }
                                                if (semilla > 0) {
                                                    ++c;
                                                    --semilla;
                                                    if (semilla == 0 && (c == 2 || c == 3)) {
                                                        capt1 += c;
                                                        c = 0;
                                                        if (b == 2 || b == 3) {
                                                            capt1 += b;
                                                            b = 0;
                                                            if (a == 2 || a == 3) {
                                                                capt1 += a;
                                                                a = 0;
                                                            }
                                                        }
                                                    }
                                                }
                                                if (semilla > 0) {
                                                    ++d;
                                                    --semilla;
                                                    if (semilla == 0 && (d == 2 || d == 3)) {
                                                        capt1 += d;
                                                        d = 0;
                                                        if (c == 2 || c == 3) {
                                                            capt1 += c;
                                                            c = 0;
                                                            if (b == 2 || b == 3) {
                                                                capt1 += b;
                                                                b = 0;
                                                                if (a == 2 || a == 3) {
                                                                    capt1 += a;
                                                                    a = 0;
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                                if (semilla > 0) {
                                                    ++e;
                                                    --semilla;
                                                    if (semilla == 0 && (e == 2 || e == 3)) {
                                                        capt1 += e;
                                                        e = 0;
                                                        if (d == 2 || d == 3) {
                                                            capt1 += d;
                                                            d = 0;
                                                            if (c == 2 || c == 3) {
                                                                capt1 += c;
                                                                c = 0;
                                                                if (b == 2 || b == 3) {
                                                                    capt1 += b;
                                                                    b = 0;
                                                                    if (a == 2 || a == 3) {
                                                                        capt1 += a;
                                                                        a = 0;
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                    if (semilla > 0) {
                                                        ++f;
                                                        --semilla;
                                                        if (semilla == 0 && (f == 2 || f == 3)) {
                                                            capt1 += f;
                                                            f = 0;
                                                            if (e == 2 || e == 3) {
                                                                capt1 += e;
                                                                e = 0;
                                                                if (d == 2 || d == 3) {
                                                                    capt1 += d;
                                                                    d = 0;
                                                                    if (c == 2 || c == 3) {
                                                                        capt1 += c;
                                                                        c = 0;
                                                                        if (b == 2 || b == 3) {
                                                                            capt1 += b;
                                                                            b = 0;
                                                                            if (a == 2 || a == 3) {
                                                                                capt1 += a;
                                                                                a = 0;
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            } while (semilla > 0);
                                        }

                                    } else {
                                        wrong = true;
                                    }
                                    break;

                                case "B":
                                    if (B > 0) {
                                        if (vacio2 && B < 5) {
                                            System.out.print("Jugador 1 debe facilitar semillas a Jugador 2. ");
                                            wrong = true;
                                        } else {
                                            semilla += B;
                                            B = 0;
                                            do {
                                                if (semilla > 0) {
                                                    ++C;
                                                    --semilla;
                                                }
                                                if (semilla > 0) {
                                                    ++D;
                                                    --semilla;
                                                }
                                                if (semilla > 0) {
                                                    ++E;
                                                    --semilla;
                                                }
                                                if (semilla > 0) {
                                                    ++F;
                                                    --semilla;
                                                }
                                                if (semilla > 0) {
                                                    ++a;
                                                    --semilla;
                                                    if (semilla == 0 && (a == 2 || a == 3)) {
                                                        capt1 += a;
                                                        a = 0;
                                                    }
                                                }
                                                if (semilla > 0) {
                                                    ++b;
                                                    --semilla;
                                                    if (semilla == 0 && (b == 2 || b == 3)) {
                                                        capt1 += b;
                                                        b = 0;
                                                        if (a == 2 || a == 3) {
                                                            capt1 += a;
                                                            a = 0;
                                                        }
                                                    }
                                                }
                                                if (semilla > 0) {
                                                    ++c;
                                                    --semilla;
                                                    if (semilla == 0 && (c == 2 || c == 3)) {
                                                        capt1 += c;
                                                        c = 0;
                                                        if (b == 2 || b == 3) {
                                                            capt1 += b;
                                                            b = 0;
                                                            if (a == 2 || a == 3) {
                                                                capt1 += a;
                                                                a = 0;
                                                            }
                                                        }
                                                    }
                                                }
                                                if (semilla > 0) {
                                                    ++d;
                                                    --semilla;
                                                    if (semilla == 0 && (d == 2 || d == 3)) {
                                                        capt1 += d;
                                                        d = 0;
                                                        if (c == 2 || c == 3) {
                                                            capt1 += c;
                                                            c = 0;
                                                            if (b == 2 || b == 3) {
                                                                capt1 += b;
                                                                b = 0;
                                                                if (a == 2 || a == 3) {
                                                                    capt1 += a;
                                                                    a = 0;
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                                if (semilla > 0) {
                                                    ++e;
                                                    --semilla;
                                                    if (semilla == 0 && (e == 2 || e == 3)) {
                                                        capt1 += e;
                                                        e = 0;
                                                        if (d == 2 || d == 3) {
                                                            capt1 += d;
                                                            d = 0;
                                                            if (c == 2 || c == 3) {
                                                                capt1 += c;
                                                                c = 0;
                                                                if (b == 2 || b == 3) {
                                                                    capt1 += b;
                                                                    b = 0;
                                                                    if (a == 2 || a == 3) {
                                                                        capt1 += a;
                                                                        a = 0;
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                    if (semilla > 0) {
                                                        ++f;
                                                        --semilla;
                                                        if (semilla == 0 && (f == 2 || f == 3)) {
                                                            capt1 += f;
                                                            f = 0;
                                                            if (e == 2 || e == 3) {
                                                                capt1 += e;
                                                                e = 0;
                                                                if (d == 2 || d == 3) {
                                                                    capt1 += d;
                                                                    d = 0;
                                                                    if (c == 2 || c == 3) {
                                                                        capt1 += c;
                                                                        c = 0;
                                                                        if (b == 2 || b == 3) {
                                                                            capt1 += b;
                                                                            b = 0;
                                                                            if (a == 2 || a == 3) {
                                                                                capt1 += a;
                                                                                a = 0;
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                                if (semilla > 0) {
                                                    ++A;
                                                    --semilla;
                                                }
                                            } while (semilla > 0);
                                        }

                                    } else {
                                        wrong = true;
                                    }
                                    break;

                                case "C":
                                    if (C > 0) {
                                        if (vacio2 && C < 4) {
                                            System.out.print("Jugador 1 debe facilitar semillas a Jugador 2. ");
                                            wrong = true;
                                        } else {
                                            semilla += C;
                                            C = 0;
                                            do {
                                                if (semilla > 0) {
                                                    ++D;
                                                    --semilla;
                                                }
                                                if (semilla > 0) {
                                                    ++E;
                                                    --semilla;
                                                }
                                                if (semilla > 0) {
                                                    ++F;
                                                    --semilla;
                                                }
                                                if (semilla > 0) {
                                                    ++a;
                                                    --semilla;
                                                    if (semilla == 0 && (a == 2 || a == 3)) {
                                                        capt1 += a;
                                                        a = 0;
                                                    }
                                                }
                                                if (semilla > 0) {
                                                    ++b;
                                                    --semilla;
                                                    if (semilla == 0 && (b == 2 || b == 3)) {
                                                        capt1 += b;
                                                        b = 0;
                                                        if (a == 2 || a == 3) {
                                                            capt1 += a;
                                                            a = 0;
                                                        }
                                                    }
                                                }
                                                if (semilla > 0) {
                                                    ++c;
                                                    --semilla;
                                                    if (semilla == 0 && (c == 2 || c == 3)) {
                                                        capt1 += c;
                                                        c = 0;
                                                        if (b == 2 || b == 3) {
                                                            capt1 += b;
                                                            b = 0;
                                                            if (a == 2 || a == 3) {
                                                                capt1 += a;
                                                                a = 0;
                                                            }
                                                        }
                                                    }
                                                }
                                                if (semilla > 0) {
                                                    ++d;
                                                    --semilla;
                                                    if (semilla == 0 && (d == 2 || d == 3)) {
                                                        capt1 += d;
                                                        d = 0;
                                                        if (c == 2 || c == 3) {
                                                            capt1 += c;
                                                            c = 0;
                                                            if (b == 2 || b == 3) {
                                                                capt1 += b;
                                                                b = 0;
                                                                if (a == 2 || a == 3) {
                                                                    capt1 += a;
                                                                    a = 0;
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                                if (semilla > 0) {
                                                    ++e;
                                                    --semilla;
                                                    if (semilla == 0 && (e == 2 || e == 3)) {
                                                        capt1 += e;
                                                        e = 0;
                                                        if (d == 2 || d == 3) {
                                                            capt1 += d;
                                                            d = 0;
                                                            if (c == 2 || c == 3) {
                                                                capt1 += c;
                                                                c = 0;
                                                                if (b == 2 || b == 3) {
                                                                    capt1 += b;
                                                                    b = 0;
                                                                    if (a == 2 || a == 3) {
                                                                        capt1 += a;
                                                                        a = 0;
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                    if (semilla > 0) {
                                                        ++f;
                                                        --semilla;
                                                        if (semilla == 0 && (f == 2 || f == 3)) {
                                                            capt1 += f;
                                                            f = 0;
                                                            if (e == 2 || e == 3) {
                                                                capt1 += e;
                                                                e = 0;
                                                                if (d == 2 || d == 3) {
                                                                    capt1 += d;
                                                                    d = 0;
                                                                    if (c == 2 || c == 3) {
                                                                        capt1 += c;
                                                                        c = 0;
                                                                        if (b == 2 || b == 3) {
                                                                            capt1 += b;
                                                                            b = 0;
                                                                            if (a == 2 || a == 3) {
                                                                                capt1 += a;
                                                                                a = 0;
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                                if (semilla > 0) {
                                                    ++A;
                                                    --semilla;
                                                }
                                                if (semilla > 0) {
                                                    ++B;
                                                    --semilla;
                                                }
                                            } while (semilla > 0);
                                        }

                                    } else {
                                        wrong = true;
                                    }
                                    break;

                                case "D":
                                    if (D > 0) {
                                        if (vacio2 && D < 3) {
                                            System.out.print("Jugador 1 debe facilitar semillas a Jugador 2. ");
                                            wrong = true;
                                        } else {
                                            semilla += D;
                                            D = 0;
                                            do {
                                                if (semilla > 0) {
                                                    ++E;
                                                    --semilla;
                                                }
                                                if (semilla > 0) {
                                                    ++F;
                                                    --semilla;
                                                }
                                                if (semilla > 0) {
                                                    ++a;
                                                    --semilla;
                                                    if (semilla == 0 && (a == 2 || a == 3)) {
                                                        capt1 += a;
                                                        a = 0;
                                                    }
                                                }
                                                if (semilla > 0) {
                                                    ++b;
                                                    --semilla;
                                                    if (semilla == 0 && (b == 2 || b == 3)) {
                                                        capt1 += b;
                                                        b = 0;
                                                        if (a == 2 || a == 3) {
                                                            capt1 += a;
                                                            a = 0;
                                                        }
                                                    }
                                                }
                                                if (semilla > 0) {
                                                    ++c;
                                                    --semilla;
                                                    if (semilla == 0 && (c == 2 || c == 3)) {
                                                        capt1 += c;
                                                        c = 0;
                                                        if (b == 2 || b == 3) {
                                                            capt1 += b;
                                                            b = 0;
                                                            if (a == 2 || a == 3) {
                                                                capt1 += a;
                                                                a = 0;
                                                            }
                                                        }
                                                    }
                                                }
                                                if (semilla > 0) {
                                                    ++d;
                                                    --semilla;
                                                    if (semilla == 0 && (d == 2 || d == 3)) {
                                                        capt1 += d;
                                                        d = 0;
                                                        if (c == 2 || c == 3) {
                                                            capt1 += c;
                                                            c = 0;
                                                            if (b == 2 || b == 3) {
                                                                capt1 += b;
                                                                b = 0;
                                                                if (a == 2 || a == 3) {
                                                                    capt1 += a;
                                                                    a = 0;
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                                if (semilla > 0) {
                                                    ++e;
                                                    --semilla;
                                                    if (semilla == 0 && (e == 2 || e == 3)) {
                                                        capt1 += e;
                                                        e = 0;
                                                        if (d == 2 || d == 3) {
                                                            capt1 += d;
                                                            d = 0;
                                                            if (c == 2 || c == 3) {
                                                                capt1 += c;
                                                                c = 0;
                                                                if (b == 2 || b == 3) {
                                                                    capt1 += b;
                                                                    b = 0;
                                                                    if (a == 2 || a == 3) {
                                                                        capt1 += a;
                                                                        a = 0;
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                    if (semilla > 0) {
                                                        ++f;
                                                        --semilla;
                                                        if (semilla == 0 && (f == 2 || f == 3)) {
                                                            capt1 += f;
                                                            f = 0;
                                                            if (e == 2 || e == 3) {
                                                                capt1 += e;
                                                                e = 0;
                                                                if (d == 2 || d == 3) {
                                                                    capt1 += d;
                                                                    d = 0;
                                                                    if (c == 2 || c == 3) {
                                                                        capt1 += c;
                                                                        c = 0;
                                                                        if (b == 2 || b == 3) {
                                                                            capt1 += b;
                                                                            b = 0;
                                                                            if (a == 2 || a == 3) {
                                                                                capt1 += a;
                                                                                a = 0;
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                                if (semilla > 0) {
                                                    ++A;
                                                    --semilla;
                                                }
                                                if (semilla > 0) {
                                                    ++B;
                                                    --semilla;
                                                }
                                                if (semilla > 0) {
                                                    ++C;
                                                    --semilla;
                                                }
                                            } while (semilla > 0);
                                        }

                                    } else {
                                        wrong = true;
                                    }
                                    break;

                                case "E":
                                    if (E > 0) {
                                        if (vacio2 && E < 2) {
                                            System.out.print("Jugador 1 debe facilitar semillas a Jugador 2. ");
                                            wrong = true;
                                        } else {
                                            semilla += E;
                                            E = 0;
                                            do {
                                                if (semilla > 0) {
                                                    ++F;
                                                    --semilla;
                                                }
                                                if (semilla > 0) {
                                                    ++a;
                                                    --semilla;
                                                    if (semilla == 0 && (a == 2 || a == 3)) {
                                                        capt1 += a;
                                                        a = 0;
                                                    }
                                                }
                                                if (semilla > 0) {
                                                    ++b;
                                                    --semilla;
                                                    if (semilla == 0 && (b == 2 || b == 3)) {
                                                        capt1 += b;
                                                        b = 0;
                                                        if (a == 2 || a == 3) {
                                                            capt1 += a;
                                                            a = 0;
                                                        }
                                                    }
                                                }
                                                if (semilla > 0) {
                                                    ++c;
                                                    --semilla;
                                                    if (semilla == 0 && (c == 2 || c == 3)) {
                                                        capt1 += c;
                                                        c = 0;
                                                        if (b == 2 || b == 3) {
                                                            capt1 += b;
                                                            b = 0;
                                                            if (a == 2 || a == 3) {
                                                                capt1 += a;
                                                                a = 0;
                                                            }
                                                        }
                                                    }
                                                }
                                                if (semilla > 0) {
                                                    ++d;
                                                    --semilla;
                                                    if (semilla == 0 && (d == 2 || d == 3)) {
                                                        capt1 += d;
                                                        d = 0;
                                                        if (c == 2 || c == 3) {
                                                            capt1 += c;
                                                            c = 0;
                                                            if (b == 2 || b == 3) {
                                                                capt1 += b;
                                                                b = 0;
                                                                if (a == 2 || a == 3) {
                                                                    capt1 += a;
                                                                    a = 0;
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                                if (semilla > 0) {
                                                    ++e;
                                                    --semilla;
                                                    if (semilla == 0 && (e == 2 || e == 3)) {
                                                        capt1 += e;
                                                        e = 0;
                                                        if (d == 2 || d == 3) {
                                                            capt1 += d;
                                                            d = 0;
                                                            if (c == 2 || c == 3) {
                                                                capt1 += c;
                                                                c = 0;
                                                                if (b == 2 || b == 3) {
                                                                    capt1 += b;
                                                                    b = 0;
                                                                    if (a == 2 || a == 3) {
                                                                        capt1 += a;
                                                                        a = 0;
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                    if (semilla > 0) {
                                                        ++f;
                                                        --semilla;
                                                        if (semilla == 0 && (f == 2 || f == 3)) {
                                                            capt1 += f;
                                                            f = 0;
                                                            if (e == 2 || e == 3) {
                                                                capt1 += e;
                                                                e = 0;
                                                                if (d == 2 || d == 3) {
                                                                    capt1 += d;
                                                                    d = 0;
                                                                    if (c == 2 || c == 3) {
                                                                        capt1 += c;
                                                                        c = 0;
                                                                        if (b == 2 || b == 3) {
                                                                            capt1 += b;
                                                                            b = 0;
                                                                            if (a == 2 || a == 3) {
                                                                                capt1 += a;
                                                                                a = 0;
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                                if (semilla > 0) {
                                                    ++A;
                                                    --semilla;
                                                }
                                                if (semilla > 0) {
                                                    ++B;
                                                    --semilla;
                                                }
                                                if (semilla > 0) {
                                                    ++C;
                                                    --semilla;
                                                }
                                                if (semilla > 0) {
                                                    ++D;
                                                    --semilla;
                                                }
                                            } while (semilla > 0);
                                        }

                                    } else {
                                        wrong = true;
                                    }
                                    break;

                                case "F":
                                    if (F > 0) {
                                        semilla += F;
                                        F = 0;
                                        do {
                                            if (semilla > 0) {
                                                ++a;
                                                --semilla;
                                                if (semilla == 0 && (a == 2 || a == 3)) {
                                                    capt1 += a;
                                                    a = 0;
                                                }
                                            }
                                            if (semilla > 0) {
                                                ++b;
                                                --semilla;
                                                if (semilla == 0 && (b == 2 || b == 3)) {
                                                    capt1 += b;
                                                    b = 0;
                                                    if (a == 2 || a == 3) {
                                                        capt1 += a;
                                                        a = 0;
                                                    }
                                                }
                                            }
                                            if (semilla > 0) {
                                                ++c;
                                                --semilla;
                                                if (semilla == 0 && (c == 2 || c == 3)) {
                                                    capt1 += c;
                                                    c = 0;
                                                    if (b == 2 || b == 3) {
                                                        capt1 += b;
                                                        b = 0;
                                                        if (a == 2 || a == 3) {
                                                            capt1 += a;
                                                            a = 0;
                                                        }
                                                    }
                                                }
                                            }
                                            if (semilla > 0) {
                                                ++d;
                                                --semilla;
                                                if (semilla == 0 && (d == 2 || d == 3)) {
                                                    capt1 += d;
                                                    d = 0;
                                                    if (c == 2 || c == 3) {
                                                        capt1 += c;
                                                        c = 0;
                                                        if (b == 2 || b == 3) {
                                                            capt1 += b;
                                                            b = 0;
                                                            if (a == 2 || a == 3) {
                                                                capt1 += a;
                                                                a = 0;
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                            if (semilla > 0) {
                                                ++e;
                                                --semilla;
                                                if (semilla == 0 && (e == 2 || e == 3)) {
                                                    capt1 += e;
                                                    e = 0;
                                                    if (d == 2 || d == 3) {
                                                        capt1 += d;
                                                        d = 0;
                                                        if (c == 2 || c == 3) {
                                                            capt1 += c;
                                                            c = 0;
                                                            if (b == 2 || b == 3) {
                                                                capt1 += b;
                                                                b = 0;
                                                                if (a == 2 || a == 3) {
                                                                    capt1 += a;
                                                                    a = 0;
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                                if (semilla > 0) {
                                                    ++f;
                                                    --semilla;
                                                    if (semilla == 0 && (f == 2 || f == 3)) {
                                                        capt1 += f;
                                                        f = 0;
                                                        if (e == 2 || e == 3) {
                                                            capt1 += e;
                                                            e = 0;
                                                            if (d == 2 || d == 3) {
                                                                capt1 += d;
                                                                d = 0;
                                                                if (c == 2 || c == 3) {
                                                                    capt1 += c;
                                                                    c = 0;
                                                                    if (b == 2 || b == 3) {
                                                                        capt1 += b;
                                                                        b = 0;
                                                                        if (a == 2 || a == 3) {
                                                                            capt1 += a;
                                                                            a = 0;
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                            if (semilla > 0) {
                                                ++A;
                                                --semilla;
                                            }
                                            if (semilla > 0) {
                                                ++B;
                                                --semilla;
                                            }
                                            if (semilla > 0) {
                                                ++C;
                                                --semilla;
                                            }
                                            if (semilla > 0) {
                                                ++D;
                                                --semilla;
                                            }
                                            if (semilla > 0) {
                                                ++E;
                                                --semilla;
                                            }
                                        } while (semilla > 0);

                                    } else {
                                        wrong = true;
                                    }
                                    break;

                                case "FIN":
                                    break;

                                default:
                                    wrong = true;
                                    break;

                            }
                            if (wrong) System.out.println("Operación invalida.");
                        } while (wrong);


                } else { //jugador 2

                    if (a + b + c + d + e + f == 0) { //si el tablero propio está vacio el contrario se queda las semillas restantes y la partida termina
                        capt1 += F + E + D + C + B + A;
                        System.out.println("Jugador 2 no puede mover. Las semillas restantes se suman a la captura de Jugador 1.");
                        x = "FIN";
                    } else
                        vacio2 = false;

                    if (F + E + D + C + B + A == 0) { //si el campo contrario está vacio se limitan las jugadas
                        if (a < 6 && b < 5 && c < 4 && d < 3 && e < 2 && f < 1) { //si no hay movimientos que den más semillas al contrario se suman las semillas y termina la partida
                            capt2 += a + b + c + d + e + f;
                            System.out.println("No hay movimientos posibles para que Jugador 1 tenga semillas. Las semillas restantes se suman a la captura de Jugador 2.");
                            x = "FIN";
                        } else vacio1 = true;
                    } else vacio1 = false;
                    if (!x.equals("FIN"))
                        do {
                            wrong = false;
                            System.out.println("Jugador 2\nElija una casilla para mover o escriba FIN para terminar la partida:");
                            x = br.readLine();

                            switch (x) {

                                case "a":
                                    if (a > 0) {
                                        if (vacio1 && a < 6) {
                                            System.out.print("Jugador 2 debe facilitar semillas a Jugador 1. ");
                                            wrong = true;
                                        } else {
                                            semilla += a;
                                            a = 0;
                                            do {
                                                if (semilla > 0) {
                                                    ++b;
                                                    --semilla;
                                                }
                                                if (semilla > 0) {
                                                    ++c;
                                                    --semilla;
                                                }
                                                if (semilla > 0) {
                                                    ++d;
                                                    --semilla;
                                                }
                                                if (semilla > 0) {
                                                    ++e;
                                                    --semilla;
                                                }
                                                if (semilla > 0) {
                                                    ++f;
                                                    --semilla;
                                                }
                                                if (semilla > 0) {
                                                    ++A;
                                                    --semilla;
                                                    if (semilla == 0 && (A == 2 || A == 3)) {
                                                        capt2 += A;
                                                        A = 0;
                                                    }
                                                }
                                                if (semilla > 0) {
                                                    ++B;
                                                    --semilla;
                                                    if (semilla == 0 && (B == 2 || B == 3)) {
                                                        capt2 += B;
                                                        B = 0;
                                                        if (A == 2 || A == 3) {
                                                            capt2 += A;
                                                            A = 0;
                                                        }
                                                    }
                                                }
                                                if (semilla > 0) {
                                                    ++C;
                                                    --semilla;
                                                    if (semilla == 0 && (C == 2 || C == 3)) {
                                                        capt2 += C;
                                                        C = 0;
                                                        if (B == 2 || B == 3) {
                                                            capt2 += B;
                                                            B = 0;
                                                            if (A == 2 || A == 3) {
                                                                capt2 += A;
                                                                A = 0;
                                                            }
                                                        }
                                                    }
                                                }
                                                if (semilla > 0) {
                                                    ++D;
                                                    --semilla;
                                                    if (semilla == 0 && (D == 2 || D == 3)) {
                                                        capt2 += D;
                                                        D = 0;
                                                        if (C == 2 || C == 3) {
                                                            capt2 += C;
                                                            C = 0;
                                                            if (B == 2 || B == 3) {
                                                                capt2 += B;
                                                                B = 0;
                                                                if (A == 2 || A == 3) {
                                                                    capt1 += A;
                                                                    A = 0;
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                                if (semilla > 0) {
                                                    ++E;
                                                    --semilla;
                                                    if (semilla == 0 && (E == 2 || E == 3)) {
                                                        capt2 += E;
                                                        E = 0;
                                                        if (D == 2 || D == 3) {
                                                            capt2 += D;
                                                            D = 0;
                                                            if (C == 2 || C == 3) {
                                                                capt2 += C;
                                                                C = 0;
                                                                if (B == 2 || B == 3) {
                                                                    capt2 += B;
                                                                    B = 0;
                                                                    if (A == 2 || A == 3) {
                                                                        capt2 += A;
                                                                        A = 0;
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                    if (semilla > 0) {
                                                        ++F;
                                                        --semilla;
                                                        if (semilla == 0 && (F == 2 || F == 3)) {
                                                            capt2 += F;
                                                            F = 0;
                                                            if (E == 2 || E == 3) {
                                                                capt2 += E;
                                                                E = 0;
                                                                if (D == 2 || D == 3) {
                                                                    capt2 += D;
                                                                    D = 0;
                                                                    if (C == 2 || C == 3) {
                                                                        capt2 += C;
                                                                        C = 0;
                                                                        if (B == 2 || B == 3) {
                                                                            capt2 += B;
                                                                            B = 0;
                                                                            if (A == 2 || A == 3) {
                                                                                capt2 += A;
                                                                                A = 0;
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            } while (semilla > 0);
                                        }

                                    } else {
                                        wrong = true;
                                    }
                                    break;

                                case "b":
                                    if (b > 0) {
                                        if (vacio1 && b < 5) {
                                            System.out.print("Jugador 2 debe facilitar semillas a Jugador 1. ");
                                            wrong = true;
                                        } else {
                                            semilla += b;
                                            b = 0;
                                            do {
                                                if (semilla > 0) {
                                                    ++c;
                                                    --semilla;
                                                }
                                                if (semilla > 0) {
                                                    ++d;
                                                    --semilla;
                                                }
                                                if (semilla > 0) {
                                                    ++e;
                                                    --semilla;
                                                }
                                                if (semilla > 0) {
                                                    ++f;
                                                    --semilla;
                                                }
                                                if (semilla > 0) {
                                                    ++A;
                                                    --semilla;
                                                    if (semilla == 0 && (A == 2 || A == 3)) {
                                                        capt2 += A;
                                                        A = 0;
                                                    }
                                                }
                                                if (semilla > 0) {
                                                    ++B;
                                                    --semilla;
                                                    if (semilla == 0 && (B == 2 || B == 3)) {
                                                        capt2 += B;
                                                        B = 0;
                                                        if (A == 2 || A == 3) {
                                                            capt2 += A;
                                                            A = 0;
                                                        }
                                                    }
                                                }
                                                if (semilla > 0) {
                                                    ++C;
                                                    --semilla;
                                                    if (semilla == 0 && (C == 2 || C == 3)) {
                                                        capt2 += C;
                                                        C = 0;
                                                        if (B == 2 || B == 3) {
                                                            capt2 += B;
                                                            B = 0;
                                                            if (A == 2 || A == 3) {
                                                                capt2 += A;
                                                                A = 0;
                                                            }
                                                        }
                                                    }
                                                }
                                                if (semilla > 0) {
                                                    ++D;
                                                    --semilla;
                                                    if (semilla == 0 && (D == 2 || D == 3)) {
                                                        capt2 += D;
                                                        D = 0;
                                                        if (C == 2 || C == 3) {
                                                            capt2 += C;
                                                            C = 0;
                                                            if (B == 2 || B == 3) {
                                                                capt2 += B;
                                                                B = 0;
                                                                if (A == 2 || A == 3) {
                                                                    capt1 += A;
                                                                    A = 0;
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                                if (semilla > 0) {
                                                    ++E;
                                                    --semilla;
                                                    if (semilla == 0 && (E == 2 || E == 3)) {
                                                        capt2 += E;
                                                        E = 0;
                                                        if (D == 2 || D == 3) {
                                                            capt2 += D;
                                                            D = 0;
                                                            if (C == 2 || C == 3) {
                                                                capt2 += C;
                                                                C = 0;
                                                                if (B == 2 || B == 3) {
                                                                    capt2 += B;
                                                                    B = 0;
                                                                    if (A == 2 || A == 3) {
                                                                        capt2 += A;
                                                                        A = 0;
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                    if (semilla > 0) {
                                                        ++F;
                                                        --semilla;
                                                        if (semilla == 0 && (F == 2 || F == 3)) {
                                                            capt2 += F;
                                                            F = 0;
                                                            if (E == 2 || E == 3) {
                                                                capt2 += E;
                                                                E = 0;
                                                                if (D == 2 || D == 3) {
                                                                    capt2 += D;
                                                                    D = 0;
                                                                    if (C == 2 || C == 3) {
                                                                        capt2 += C;
                                                                        C = 0;
                                                                        if (B == 2 || B == 3) {
                                                                            capt2 += B;
                                                                            B = 0;
                                                                            if (A == 2 || A == 3) {
                                                                                capt2 += A;
                                                                                A = 0;
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                                if (semilla > 0) {
                                                    ++a;
                                                    --semilla;
                                                }
                                            } while (semilla > 0);
                                        }

                                    } else {
                                        wrong = true;
                                    }
                                    break;

                                case "c":
                                    if (c > 0) {
                                        if (vacio1 && c < 4) {
                                            System.out.print("Jugador 2 debe facilitar semillas a Jugador 1. ");
                                            wrong = true;
                                        } else {
                                            semilla += c;
                                            c = 0;
                                            do {
                                                if (semilla > 0) {
                                                    ++d;
                                                    --semilla;
                                                }
                                                if (semilla > 0) {
                                                    ++e;
                                                    --semilla;
                                                }
                                                if (semilla > 0) {
                                                    ++f;
                                                    --semilla;
                                                }
                                                if (semilla > 0) {
                                                    ++A;
                                                    --semilla;
                                                    if (semilla == 0 && (A == 2 || A == 3)) {
                                                        capt2 += A;
                                                        A = 0;
                                                    }
                                                }
                                                if (semilla > 0) {
                                                    ++B;
                                                    --semilla;
                                                    if (semilla == 0 && (B == 2 || B == 3)) {
                                                        capt2 += B;
                                                        B = 0;
                                                        if (A == 2 || A == 3) {
                                                            capt2 += A;
                                                            A = 0;
                                                        }
                                                    }
                                                }
                                                if (semilla > 0) {
                                                    ++C;
                                                    --semilla;
                                                    if (semilla == 0 && (C == 2 || C == 3)) {
                                                        capt2 += C;
                                                        C = 0;
                                                        if (B == 2 || B == 3) {
                                                            capt2 += B;
                                                            B = 0;
                                                            if (A == 2 || A == 3) {
                                                                capt2 += A;
                                                                A = 0;
                                                            }
                                                        }
                                                    }
                                                }
                                                if (semilla > 0) {
                                                    ++D;
                                                    --semilla;
                                                    if (semilla == 0 && (D == 2 || D == 3)) {
                                                        capt2 += D;
                                                        D = 0;
                                                        if (C == 2 || C == 3) {
                                                            capt2 += C;
                                                            C = 0;
                                                            if (B == 2 || B == 3) {
                                                                capt2 += B;
                                                                B = 0;
                                                                if (A == 2 || A == 3) {
                                                                    capt1 += A;
                                                                    A = 0;
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                                if (semilla > 0) {
                                                    ++E;
                                                    --semilla;
                                                    if (semilla == 0 && (E == 2 || E == 3)) {
                                                        capt2 += E;
                                                        E = 0;
                                                        if (D == 2 || D == 3) {
                                                            capt2 += D;
                                                            D = 0;
                                                            if (C == 2 || C == 3) {
                                                                capt2 += C;
                                                                C = 0;
                                                                if (B == 2 || B == 3) {
                                                                    capt2 += B;
                                                                    B = 0;
                                                                    if (A == 2 || A == 3) {
                                                                        capt2 += A;
                                                                        A = 0;
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                    if (semilla > 0) {
                                                        ++F;
                                                        --semilla;
                                                        if (semilla == 0 && (F == 2 || F == 3)) {
                                                            capt2 += F;
                                                            F = 0;
                                                            if (E == 2 || E == 3) {
                                                                capt2 += E;
                                                                E = 0;
                                                                if (D == 2 || D == 3) {
                                                                    capt2 += D;
                                                                    D = 0;
                                                                    if (C == 2 || C == 3) {
                                                                        capt2 += C;
                                                                        C = 0;
                                                                        if (B == 2 || B == 3) {
                                                                            capt2 += B;
                                                                            B = 0;
                                                                            if (A == 2 || A == 3) {
                                                                                capt2 += A;
                                                                                A = 0;
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                                if (semilla > 0) {
                                                    ++a;
                                                    --semilla;
                                                }
                                                if (semilla > 0) {
                                                    ++b;
                                                    --semilla;
                                                }
                                            } while (semilla > 0);
                                        }

                                    } else {
                                        wrong = true;
                                    }
                                    break;

                                case "d":
                                    if (d > 0) {
                                        if (vacio1 && d < 3) {
                                            System.out.print("Jugador 2 debe facilitar semillas a Jugador 1. ");
                                            wrong = true;
                                        } else {
                                            semilla += d;
                                            d = 0;
                                            do {
                                                if (semilla > 0) {
                                                    ++e;
                                                    --semilla;
                                                }
                                                if (semilla > 0) {
                                                    ++f;
                                                    --semilla;
                                                }
                                                if (semilla > 0) {
                                                    ++A;
                                                    --semilla;
                                                    if (semilla == 0 && (A == 2 || A == 3)) {
                                                        capt2 += A;
                                                        A = 0;
                                                    }
                                                }
                                                if (semilla > 0) {
                                                    ++B;
                                                    --semilla;
                                                    if (semilla == 0 && (B == 2 || B == 3)) {
                                                        capt2 += B;
                                                        B = 0;
                                                        if (A == 2 || A == 3) {
                                                            capt2 += A;
                                                            A = 0;
                                                        }
                                                    }
                                                }
                                                if (semilla > 0) {
                                                    ++C;
                                                    --semilla;
                                                    if (semilla == 0 && (C == 2 || C == 3)) {
                                                        capt2 += C;
                                                        C = 0;
                                                        if (B == 2 || B == 3) {
                                                            capt2 += B;
                                                            B = 0;
                                                            if (A == 2 || A == 3) {
                                                                capt2 += A;
                                                                A = 0;
                                                            }
                                                        }
                                                    }
                                                }
                                                if (semilla > 0) {
                                                    ++D;
                                                    --semilla;
                                                    if (semilla == 0 && (D == 2 || D == 3)) {
                                                        capt2 += D;
                                                        D = 0;
                                                        if (C == 2 || C == 3) {
                                                            capt2 += C;
                                                            C = 0;
                                                            if (B == 2 || B == 3) {
                                                                capt2 += B;
                                                                B = 0;
                                                                if (A == 2 || A == 3) {
                                                                    capt1 += A;
                                                                    A = 0;
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                                if (semilla > 0) {
                                                    ++E;
                                                    --semilla;
                                                    if (semilla == 0 && (E == 2 || E == 3)) {
                                                        capt2 += E;
                                                        E = 0;
                                                        if (D == 2 || D == 3) {
                                                            capt2 += D;
                                                            D = 0;
                                                            if (C == 2 || C == 3) {
                                                                capt2 += C;
                                                                C = 0;
                                                                if (B == 2 || B == 3) {
                                                                    capt2 += B;
                                                                    B = 0;
                                                                    if (A == 2 || A == 3) {
                                                                        capt2 += A;
                                                                        A = 0;
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                    if (semilla > 0) {
                                                        ++F;
                                                        --semilla;
                                                        if (semilla == 0 && (F == 2 || F == 3)) {
                                                            capt2 += F;
                                                            F = 0;
                                                            if (E == 2 || E == 3) {
                                                                capt2 += E;
                                                                E = 0;
                                                                if (D == 2 || D == 3) {
                                                                    capt2 += D;
                                                                    D = 0;
                                                                    if (C == 2 || C == 3) {
                                                                        capt2 += C;
                                                                        C = 0;
                                                                        if (B == 2 || B == 3) {
                                                                            capt2 += B;
                                                                            B = 0;
                                                                            if (A == 2 || A == 3) {
                                                                                capt2 += A;
                                                                                A = 0;
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                                if (semilla > 0) {
                                                    ++a;
                                                    --semilla;
                                                }
                                                if (semilla > 0) {
                                                    ++b;
                                                    --semilla;
                                                }
                                                if (semilla > 0) {
                                                    ++c;
                                                    --semilla;
                                                }
                                            } while (semilla > 0);
                                        }

                                    } else {
                                        wrong = true;
                                    }
                                    break;

                                case "e":
                                    if (e > 0) {
                                        if (vacio1 && e < 3) {
                                            System.out.print("Jugador 2 debe facilitar semillas a Jugador 1. ");
                                            wrong = true;
                                        } else {
                                            semilla += e;
                                            e = 0;
                                            do {
                                                if (semilla > 0) {
                                                    ++f;
                                                    --semilla;
                                                }
                                                if (semilla > 0) {
                                                    ++A;
                                                    --semilla;
                                                    if (semilla == 0 && (A == 2 || A == 3)) {
                                                        capt2 += A;
                                                        A = 0;
                                                    }
                                                }
                                                if (semilla > 0) {
                                                    ++B;
                                                    --semilla;
                                                    if (semilla == 0 && (B == 2 || B == 3)) {
                                                        capt2 += B;
                                                        B = 0;
                                                        if (A == 2 || A == 3) {
                                                            capt2 += A;
                                                            A = 0;
                                                        }
                                                    }
                                                }
                                                if (semilla > 0) {
                                                    ++C;
                                                    --semilla;
                                                    if (semilla == 0 && (C == 2 || C == 3)) {
                                                        capt2 += C;
                                                        C = 0;
                                                        if (B == 2 || B == 3) {
                                                            capt2 += B;
                                                            B = 0;
                                                            if (A == 2 || A == 3) {
                                                                capt2 += A;
                                                                A = 0;
                                                            }
                                                        }
                                                    }
                                                }
                                                if (semilla > 0) {
                                                    ++D;
                                                    --semilla;
                                                    if (semilla == 0 && (D == 2 || D == 3)) {
                                                        capt2 += D;
                                                        D = 0;
                                                        if (C == 2 || C == 3) {
                                                            capt2 += C;
                                                            C = 0;
                                                            if (B == 2 || B == 3) {
                                                                capt2 += B;
                                                                B = 0;
                                                                if (A == 2 || A == 3) {
                                                                    capt1 += A;
                                                                    A = 0;
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                                if (semilla > 0) {
                                                    ++E;
                                                    --semilla;
                                                    if (semilla == 0 && (E == 2 || E == 3)) {
                                                        capt2 += E;
                                                        E = 0;
                                                        if (D == 2 || D == 3) {
                                                            capt2 += D;
                                                            D = 0;
                                                            if (C == 2 || C == 3) {
                                                                capt2 += C;
                                                                C = 0;
                                                                if (B == 2 || B == 3) {
                                                                    capt2 += B;
                                                                    B = 0;
                                                                    if (A == 2 || A == 3) {
                                                                        capt2 += A;
                                                                        A = 0;
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                    if (semilla > 0) {
                                                        ++F;
                                                        --semilla;
                                                        if (semilla == 0 && (F == 2 || F == 3)) {
                                                            capt2 += F;
                                                            F = 0;
                                                            if (E == 2 || E == 3) {
                                                                capt2 += E;
                                                                E = 0;
                                                                if (D == 2 || D == 3) {
                                                                    capt2 += D;
                                                                    D = 0;
                                                                    if (C == 2 || C == 3) {
                                                                        capt2 += C;
                                                                        C = 0;
                                                                        if (B == 2 || B == 3) {
                                                                            capt2 += B;
                                                                            B = 0;
                                                                            if (A == 2 || A == 3) {
                                                                                capt2 += A;
                                                                                A = 0;
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                                if (semilla > 0) {
                                                    ++a;
                                                    --semilla;
                                                }
                                                if (semilla > 0) {
                                                    ++b;
                                                    --semilla;
                                                }
                                                if (semilla > 0) {
                                                    ++c;
                                                    --semilla;
                                                }
                                                if (semilla > 0) {
                                                    ++d;
                                                    --semilla;
                                                }
                                            } while (semilla > 0);
                                        }
                                    } else {
                                        wrong = true;
                                    }
                                    break;

                                case "f":
                                    if (f > 0) {
                                        if (vacio1 && f < 3) {
                                            System.out.print("Jugador 2 debe facilitar semillas a Jugador 1. ");
                                            wrong = true;
                                        } else {
                                            semilla += f;
                                            f = 0;
                                            do {
                                                if (semilla > 0) {
                                                    ++A;
                                                    --semilla;
                                                    if (semilla == 0 && (A == 2 || A == 3)) {
                                                        capt2 += A;
                                                        A = 0;
                                                    }
                                                }
                                                if (semilla > 0) {
                                                    ++B;
                                                    --semilla;
                                                    if (semilla == 0 && (B == 2 || B == 3)) {
                                                        capt2 += B;
                                                        B = 0;
                                                        if (A == 2 || A == 3) {
                                                            capt2 += A;
                                                            A = 0;
                                                        }
                                                    }
                                                }
                                                if (semilla > 0) {
                                                    ++C;
                                                    --semilla;
                                                    if (semilla == 0 && (C == 2 || C == 3)) {
                                                        capt2 += C;
                                                        C = 0;
                                                        if (B == 2 || B == 3) {
                                                            capt2 += B;
                                                            B = 0;
                                                            if (A == 2 || A == 3) {
                                                                capt2 += A;
                                                                A = 0;
                                                            }
                                                        }
                                                    }
                                                }
                                                if (semilla > 0) {
                                                    ++D;
                                                    --semilla;
                                                    if (semilla == 0 && (D == 2 || D == 3)) {
                                                        capt2 += D;
                                                        D = 0;
                                                        if (C == 2 || C == 3) {
                                                            capt2 += C;
                                                            C = 0;
                                                            if (B == 2 || B == 3) {
                                                                capt2 += B;
                                                                B = 0;
                                                                if (A == 2 || A == 3) {
                                                                    capt1 += A;
                                                                    A = 0;
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                                if (semilla > 0) {
                                                    ++E;
                                                    --semilla;
                                                    if (semilla == 0 && (E == 2 || E == 3)) {
                                                        capt2 += E;
                                                        E = 0;
                                                        if (D == 2 || D == 3) {
                                                            capt2 += D;
                                                            D = 0;
                                                            if (C == 2 || C == 3) {
                                                                capt2 += C;
                                                                C = 0;
                                                                if (B == 2 || B == 3) {
                                                                    capt2 += B;
                                                                    B = 0;
                                                                    if (A == 2 || A == 3) {
                                                                        capt2 += A;
                                                                        A = 0;
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                    if (semilla > 0) {
                                                        ++F;
                                                        --semilla;
                                                        if (semilla == 0 && (F == 2 || F == 3)) {
                                                            capt2 += F;
                                                            F = 0;
                                                            if (E == 2 || E == 3) {
                                                                capt2 += E;
                                                                E = 0;
                                                                if (D == 2 || D == 3) {
                                                                    capt2 += D;
                                                                    D = 0;
                                                                    if (C == 2 || C == 3) {
                                                                        capt2 += C;
                                                                        C = 0;
                                                                        if (B == 2 || B == 3) {
                                                                            capt2 += B;
                                                                            B = 0;
                                                                            if (A == 2 || A == 3) {
                                                                                capt2 += A;
                                                                                A = 0;
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                                if (semilla > 0) {
                                                    ++a;
                                                    --semilla;
                                                }
                                                if (semilla > 0) {
                                                    ++b;
                                                    --semilla;
                                                }
                                                if (semilla > 0) {
                                                    ++c;
                                                    --semilla;
                                                }
                                                if (semilla > 0) {
                                                    ++d;
                                                    --semilla;
                                                }
                                                if (semilla > 0) {
                                                    ++e;
                                                    --semilla;
                                                }
                                            } while (semilla > 0);
                                        }
                                    } else {
                                        wrong = true;
                                    }
                                    break;

                                case "fin":
                                case "FIN":
                                    break;

                                default:
                                    wrong = true;
                                    break;

                            }
                            if (wrong) System.out.println("Operación invalida.");
                        } while (wrong);
                }

                ++turno;

            } while (!x.equalsIgnoreCase("FIN"));
            System.out.println("---FIN DE LA PARTIDA---\n");
            System.out.println("Después de " + turno + " turnos las capturas son las siguientes:");
            System.out.println("Jugador 1: Ha capturado " + capt1 + " semillas.");
            System.out.println("Jugador 2: Ha capturado " + capt2 + " semillas.\n");

            if (capt1 == capt2) System.out.println("¡Empate!");
            if (capt1 > capt2) System.out.println("¡Jugador 1 ha ganado la partida!");
            if (capt2 < capt1) System.out.println("¡Jugador 2 ha ganado la partida!");

            System.out.println("\n¿Desea jugar otra partida? Escriba OTRA para repetir, cualquier otra cosa para finalizar:");
            x = br.readLine();

        } while (x.equalsIgnoreCase("OTRA"));
    }
}