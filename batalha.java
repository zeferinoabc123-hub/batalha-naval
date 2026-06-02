
import java.util.Random;
import java.util.Scanner;

public class batalha {  // PARTE DO LUIZ

    public static void batalhaPrincipal(Scanner sc, char[][] tabuPlayer, char[][] tabuCPU, Random randomCPU) {
        String espaço = "                                                        ";

        char[][] visuCPU = new char[10][10];
        char[][] visuPlayer = new char[10][10];

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                visuCPU[i][j] = '~';
                visuPlayer[i][j] = '~';
            }
        }

        int naviosPlayerRestantes = 2 * 3 + 2 * 4; // 2 navios de 3 + 2 porta de 4
        int naviosCPURestantes = 2 * 3 + 2 * 4;

System.out.println("\u001B[38;5;226m" + """



                                                    ██████╗  █████╗ ████████╗ █████╗ ██╗     ██╗  ██╗ █████╗
                                                    ██╔══██╗██╔══██╗╚══██╔══╝██╔══██╗██║     ██║  ██║██╔══██╗
                                                    ██████╔╝███████║   ██║   ███████║██║     ███████║███████║
                                                    ██╔══██╗██╔══██║   ██║   ██╔══██║██║     ██╔══██║██╔══██║
                                                    ██████╔╝██║  ██║   ██║   ██║  ██║███████╗██║  ██║██║  ██║
                                                    ╚═════╝ ╚═╝  ╚═╝   ╚═╝   ╚═╝  ╚═╝╚══════╝╚═╝  ╚═╝╚═╝  ╚═╝


                                                    ██╗███╗   ██╗██╗ ██████╗██╗ █████╗ ██████╗  █████╗
                                                    ██║████╗  ██║██║██╔════╝██║██╔══██╗██╔══██╗██╔══██╗
                                                    ██║██╔██╗ ██║██║██║     ██║███████║██║  ██║███████║
                                                    ██║██║╚██╗██║██║██║     ██║██╔══██║██║  ██║██╔══██║
                                                    ██║██║ ╚████║██║╚██████╗██║██║  ██║██████╔╝██║  ██║
                                                    ╚═╝╚═╝  ╚═══╝╚═╝ ╚═════╝╚═╝╚═╝  ╚═╝╚═════╝ ╚═╝  ╚═╝


                                                              ⚓ PREPARE-SE PARA O COMBATE! ⚓
                               


""" + "\u001B[0m");
        delay.delay(1500);
        limparTerminal.limparTerminal();

        while (naviosPlayerRestantes > 0 && naviosCPURestantes > 0) {

            limparTerminal.limparTerminal();

            System.out.println(espaço + "          \u001B[38;5;46m=== SEU TURNO ===\u001B[0m");
            delay.delay(800);

            imprimir.imprimirtb(tabuPlayer); 
            System.out.println(espaço + "          TABULEIRO INIMIGO:");
            imprimir.imprimirtb(visuCPU); 

            atacarCPU(sc, tabuCPU, visuCPU, espaço);

            naviosCPURestantes = contarNaviosRestantes(tabuCPU);

            if (naviosCPURestantes == 0) {
                break;
            }

            delay.delay(1200);
            limparTerminal.limparTerminal();
            centralizar();
            System.out.println(espaço + "         \u001B[38;5;196m=== TURNO DA CPU ===\u001B[0m");
            delay.delay(1000);

            atacarPlayer(randomCPU, tabuPlayer, visuPlayer, espaço);

            naviosPlayerRestantes = contarNaviosRestantes(tabuPlayer);

            delay.delay(1500);
        }

        limparTerminal.limparTerminal();
        if (naviosCPURestantes == 0) {
            vitoria();
        } else {
            derrota();
        }
    }

    public static void atacarCPU(Scanner sc, char[][] tabuCPU, char[][] visuCPU, String espaço) {
        char x = 'p';
        int y = -1;

        do {
            System.out.print(espaço + "Escolha onde ATACAR (ex: B5): ");
            String pos = sc.nextLine().toUpperCase().trim();

            try {
                x = pos.charAt(0);
                y = Integer.parseInt(pos.substring(1)) - 1;
            } catch (Exception e) {
                x = 'p';
            }

            if (posicaoValida(x, y) == false) {
                System.out.println(espaço + "\u001B[38;5;202mPOSIÇÃO INVÁLIDA!\u001B[0m");
                delay.delay(800);
                continue;
            }

            int col = letterToCol(x);

            if (visuCPU[y][col] == 'X' || visuCPU[y][col] == 'O') {
                System.out.println(espaço + "\u001B[38;5;202mJÁ ATACOU ESTA POSIÇÃO!\u001B[0m");
                delay.delay(800);
                continue;
            }

            if (tabuCPU[y][col] == '═' || tabuCPU[y][col] == '■') {
                visuCPU[y][col] = 'X';
                tabuCPU[y][col] = 'X';
                System.out.println(espaço + "\u001B[38;5;46m    ACERTOU UM NAVIO! 🔥\u001B[0m");
            } else {
                visuCPU[y][col] = 'O';
                tabuCPU[y][col] = 'O';
                System.out.println(espaço + "\u001B[38;5;39m      ÁGUA\u001B[0m");
            }

            delay.delay(1200);
            break;

        } while (true);
    }

    //_________________________________________________________________________________________________________________________________
    //________________________________________________________________________________________________________________________________


    static int primeiroX;
    static int primeiroY;
    static int ultimoX;
    static int ultimoY;
    static boolean modoCaca = false;
    static int direçao = 1;

    public static void atacarPlayer(Random random, char[][] tabuPlayer, char[][] visuPlayer, String espaço) {
        int y = 0;
        int x = 0;
        int IA;

        do {
            if (modoCaca == true) {
                do {
                    IA = direçao;

                    if (IA == 1) {
                        x = ultimoX + 1;
                        y = ultimoY;
                    } else if (IA == 2) {
                        x = ultimoX - 1;
                        y = ultimoY;
                    } else if (IA == 3) {
                        x = ultimoX;
                        y = ultimoY + 1;
                    } else {
                        x = ultimoX;
                        y = ultimoY - 1;
                    }

                } while (x < 0 || x >= 10 || y < 0 || y >= 10);

            } else {
                y = random.nextInt(10);
                x = random.nextInt(10);
            }

        } while (visuPlayer[y][x] == 'X' || visuPlayer[y][x] == 'O');

        if (tabuPlayer[y][x] == '═' || tabuPlayer[y][x] == '■') {

            if (modoCaca == false) {
                primeiroX = x;
                primeiroY = y;
                direçao = 1;
            }

            visuPlayer[y][x] = 'X';
            tabuPlayer[y][x] = 'X';

            modoCaca = true;
            ultimoX = x;
            ultimoY = y;
            System.out.println(espaço + "\u001B[38;5;196mA    CPU ACERTOU SEU NAVIO! \u001B[0m");
            
        } else {
            visuPlayer[y][x] = 'O';
            tabuPlayer[y][x] = 'O';

            direçao++;

            ultimoX = primeiroX;
            ultimoY = primeiroY;
            System.out.println(espaço + "         \u001B[38;5;39mA   CPU errou... \u001B[0m");

            if (direçao > 4) {
                modoCaca = false;
            }
        }
                  if (visuPlayer[y][x] == 'X') {
                    System.out.print("\u001B[202mX\u001B[34m  "); //taka cor
                } else if (visuPlayer[y][x] == 'O') {
                    System.out.print("\u001B[125mO\u001B[34m  ");
                }

        delay.delay(1000);
    }

    //__________________________________________________________________________________________________________________________________
    //_________________________________________________________________________________________________________________________________

    public static int contarNaviosRestantes(char[][] tabu) {
        int contador = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (tabu[i][j] == '═' || tabu[i][j] == '■') {
                    contador++;
                }
            }
        }
        return contador;
    }
    //__________________________________________________________________________________________________________________________________
    //_________________________________________________________________________________________________________________________________


    public static boolean posicaoValida(char x, int y) {
        return (x >= 'A' && x <= 'J') && (y >= 0 && y < 10);
    }

    //__________________________________________________________________________________________________________________________________
    //_________________________________________________________________________________________________________________________________

    public static int letterToCol(char x) {
        return x - 'A';
    }

//__________________________________________________________________________________________________________________________________
//_________________________________________________________________________________________________________________________________


    public static void vitoria() {
        String espaço = "                                                        ";
        limparTerminal.limparTerminal();
System.out.println("\u001B[38;5;226m" + """



                                                    ██╗   ██╗██╗████████╗ ██████╗ ██████╗ ██╗ █████╗
                                                    ██║   ██║██║╚══██╔══╝██╔═══██╗██╔══██╗██║██╔══██╗
                                                    ██║   ██║██║   ██║   ██║   ██║██████╔╝██║███████║
                                                    ╚██╗ ██╔╝██║   ██║   ██║   ██║██╔══██╗██║██╔══██║
                                                     ╚████╔╝ ██║   ██║   ╚██████╔╝██║  ██║██║██║  ██║
                                                      ╚═══╝  ╚═╝   ╚═╝    ╚═════╝ ╚═╝  ╚═╝╚═╝╚═╝  ╚═╝


                                                           🏆 VOCÊ VENCEU A BATALHA NAVAL! 🏆


""" + "\u001B[0m");
        delay.delay(3000);
    }

    public static void derrota() {
        String espaço = "                                                        ";
        limparTerminal.limparTerminal();
 System.out.println("\u001B[38;5;196m" + """



                                                ██████╗ ███████╗██████╗ ██████╗  ██████╗ ████████╗ █████╗
                                                ██╔══██╗██╔════╝██╔══██╗██╔══██╗██╔═══██╗╚══██╔══╝██╔══██╗
                                                ██║  ██║█████╗  ██████╔╝██████╔╝██║   ██║   ██║   ███████║
                                                ██║  ██║██╔══╝  ██╔══██╗██╔══██╗██║   ██║   ██║   ██╔══██║
                                                ██████╔╝███████╗██║  ██║██║  ██║╚██████╔╝   ██║   ██║  ██║
                                                ╚═════╝ ╚══════╝╚═╝  ╚═╝╚═╝  ╚═╝ ╚═════╝    ╚═╝   ╚═╝  ╚═╝


                                                            ☠️ A CPU VENCEU... TENTE NOVAMENTE! ☠️


""" + "\u001B[0m");
        delay.delay(3000);
    }

//______________________________________________________________________________________________________________________________________
//______________________________________________________________________________________________________________________________________

   public static void centralizar(){
    for (int i = 0; i < 15; i++) {
        System.out.println();
    }
   }
}
