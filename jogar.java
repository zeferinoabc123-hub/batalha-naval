
import java.util.Scanner;

public class jogar {

    public static void escolhendoNavil(Scanner scanner, char[][] tabu) {
        String espaço = "                                                        ";
        char x;
        int y;

        for (int i = 0; i < 7; i++) {
            System.out.println();
        }

        System.out.println(espaço + "          ESTE É O SEU TABULEIRO");
        delay.delay(900);

        for (int N = 1; N < 3; N++) {
            limparTerminal.limparTerminal();
            delay.delay(800);
            imprimir.imprimirtb(tabu);
            limparTerminal.limparTerminal();

            navio:
            do {
                imprimir.imprimirtb(tabu);
                System.out.println(espaço + "   Em qual casa deseja por o " + N + "º Navil ?");
                System.out.print(espaço + "Escolha a posiçao referente ao eixo xy : ");
                String posiçao = "";
                try {
                    posiçao = scanner.nextLine().toUpperCase();
                    x = posiçao.charAt(0);
                    y = Integer.parseInt(posiçao.substring(1)) - 1;
                } catch (Exception e) {
                    x = 'p';
                    y = 11;
                }
                if ((x != 'A')
                        && (x != 'B')
                        && (x != 'C')
                        && (x != 'D')
                        && (x != 'E')
                        && (x != 'F')
                        && (x != 'G')
                        && (x != 'H')
                        && (x != 'I')
                        && (x != 'J')) {
                    System.out.println("boi");
                    System.out.println(espaço + "            \u001B[38;5;202mPOSIÇAO INVALIDA\u001B[0m");
                    delay.delay(1000);
                    limparTerminal.limparTerminal();
                    continue navio;
                } else if (y > 10) {
                    System.out.println("boiola");
                    System.out.println(espaço + "            \u001B[38;5;202mPOSIÇAO INVALIDA\u001B[0m");
                    delay.delay(1000);
                    limparTerminal.limparTerminal();
                    continue navio;
                } else if (posiçao.length() > 2) {
                    System.out.println("gay");
                    System.out.println(espaço + "            \u001B[38;5;202mPOSIÇAO INVALIDA\u001B[0m");
                    delay.delay(1000);
                    limparTerminal.limparTerminal();
                    continue navio;
                } else {
                    break navio;
                }

            } while (true);

            int conv = 0 - 1;
            //--------------------------
            switch (x) {
                case 'A':
                    conv = 0;
                    break;
                case 'B':
                    conv = 1;
                    break;
                case 'C':
                    conv = 2;
                    break;
                case 'D':
                    conv = 3;
                    break;
                case 'E':
                    conv = 4;
                    break;
                case 'F':
                    conv = 5;
                    break;
                case 'G':
                    conv = 6;
                    break;
                case 'H':
                    conv = 7;
                    break;
                case 'I':
                    conv = 8;
                    break;
                case 'J':
                    conv = 9;
                    break;
            }
            limparTerminal.limparTerminal();

            escolhaOnavil:
            do {
                String opçoes = navegandoPeloMenu.opçoes(scanner);

                if (opçoes.equals("Direita")) {
                    if (conv + 3 < 10) {

                        for (int i = 0; i < 3; i++) {

                            if (tabu[y][conv + i] == '■') {

                                for (int j = 0; j < i; j++) {
                                    tabu[y][conv + j] = '~'; // desfaz
                                }

                                System.out.println("NAO PODE OBSTRUIR OUTRA EMBARCAÇAO");
                                delay.delay(1000);
                                continue escolhaOnavil;
                            }

                            tabu[y][conv + i] = '■';
                        }
                        break escolhaOnavil;
                        //-----------------------------------------------
                    } else if (opçoes.equals("Esquerda")) {
                        if (conv - 3 >= 0) {
                            for (int i = 0; i < 3; i++) {

                                if (tabu[y][conv - i] == '■') {

                                    for (int j = 0; j < i; j++) {
                                        tabu[y][conv - j] = '~'; // desfaz
                                    }

                                    System.out.println("NAO PODE OBSTRUIR OUTRA EMBARCAÇAO");
                                    delay.delay(1000);
                                    continue escolhaOnavil;
                                }

                                tabu[y][conv - i] = '■';
                            }
                        } else {
                            System.out.println("        \001B[38;5;202mO NAVIO ULTRAPASSSA O LIMITE DO TABULEIRO\u001B[0m");
                            delay.delay(1000);
                            limparTerminal.limparTerminal();
                            continue escolhaOnavil;
                        }
                        break escolhaOnavil;
                        //-------------------------------------------------
                    } else if (opçoes.equals("Baixo")) {
                        if (y + 3 < 10) {
                            for (int i = 0; i < 3; i++) {

                                if (tabu[y + i][conv] == '■') {

                                    for (int j = 0; j < i; j++) {
                                        tabu[y + i][conv] = '~'; // desfaz
                                    }

                                    System.out.println("NAO PODE OBSTRUIR OUTRA EMBARCAÇAO");
                                    delay.delay(1000);
                                    continue escolhaOnavil;
                                }

                                tabu[y + i][conv] = '■';
                            }
                        } else {
                            System.out.println("        \001B[38;5;202mO NAVIO ULTRAPASSSA O LIMITE DO TABULEIRO\u001B[0m");
                            delay.delay(1000);
                            limparTerminal.limparTerminal();
                            continue escolhaOnavil;
                        }
                        break escolhaOnavil;
                    } else if (opçoes.equals("Cima")) {
                        if (y - 3 >= 0) {
                            for (int i = 0; i < 3; i++) {

                                if (tabu[y - i][conv] == '■') {

                                    for (int j = 0; j < i; j++) {
                                        tabu[y - i][conv] = '~'; // desfaz
                                    }

                                    System.out.println("NAO PODE OBSTRUIR OUTRA EMBARCAÇAO");
                                    delay.delay(1000);
                                    continue escolhaOnavil;
                                }

                                tabu[y - i][conv] = '■';
                            }
                        }
                    } else {
                        System.out.println("        \001B[38;5;202mO NAVIO ULTRAPASSSA O LIMITE DO TABULEIRO\u001B[0m");
                        delay.delay(1000);
                        limparTerminal.limparTerminal();
                        continue escolhaOnavil;
                    }
                    break escolhaOnavil;
                }

            } while (true);

        }
        limparTerminal.limparTerminal();
        imprimir.imprimirtb(tabu);
        delay.delay(1500);
    }

    public static void tabuleiroCPU() {
        char[][] tabuCPU = new char[10][10];

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                tabuCPU[i][j] = '~';
            }
        }

    }

    public static void escolhendoPortaAviao(Scanner scanner, char[][] tabu) {
        String espaço = "                                                        ";
        for (int N = 0; N < 2; N++) {

            System.out.print("\033[H\033[2J");
            System.out.flush();
            for (int i = 0; i < 15; i++) {
                System.out.println();
            }

            System.out.println(espaço + "   Em qual casa deseja por o "+N+"º  Porta aviões ?");
            System.out.print(espaço + "Escolha a posiçao referente ao eixo x : ");
            //----------------
            String posiçao = scanner.nextLine().toUpperCase();
            char x = posiçao.charAt(0);
            int y = Integer.parseInt(posiçao.substring(1)) - 1;
            System.out.println(" ");
            int conv = 0 - 1;
            //--------------------------
            switch (x) {
                case 'A':
                    conv = 0;
                    break;
                case 'B':
                    conv = 1;
                    break;
                case 'C':
                    conv = 2;
                    break;
                case 'D':
                    conv = 3;
                    break;
                case 'E':
                    conv = 4;
                    break;
                case 'F':
                    conv = 5;
                    break;
                case 'G':
                    conv = 6;
                    break;
                case 'H':
                    conv = 7;
                    break;
                case 'I':
                    conv = 8;
                    break;
                case 'J':
                    conv = 9;
                    break;
            }
            limparTerminal.limparTerminal();
            String opçoes = navegandoPeloMenu.opçoes(scanner);

            if (opçoes.equals("Direita")) {
                if (conv + 3 < 10) {
                    for (int i = 0; i < 3; i++) {
                        tabu[y][conv + i] = '\u2663';
                    }

                } else {
                    System.out.println("        \001B[38;5;202mO NAVIO ULTRAPASSSA O LIMITE DO TABULEIRO\u001B[0m");
                    delay.delay(1000);
                    limparTerminal.limparTerminal();
                    continue;
                }
            } else if (opçoes.equals("Esquerda")) {

                if (conv - 3 >= 0) {
                    for (int i = 0; i < 3; i++) {
                        tabu[y][conv - i] = '\u2663';
                    }

                } else {
                    System.out.println("        \001B[38;5;202mO NAVIO ULTRAPASSSA O LIMITE DO TABULEIRO\u001B[0m");
                    delay.delay(1000);
                    limparTerminal.limparTerminal();
                    continue;
                }
            } else if (opçoes.equals("Baixo")) {
                if (y + 3 < 10) {
                    for (int i = 0; i < 3; i++) {
                        tabu[y + i][conv] = '\u2663';
                    }

                } else {
                    System.out.println("        \001B[38;5;202mO NAVIO ULTRAPASSSA O LIMITE DO TABULEIRO\u001B[0m");
                    delay.delay(1000);
                    limparTerminal.limparTerminal();
                    continue;
                }
            } else if (opçoes.equals("Cima")) {
                if (y - 3 >= 0) {
                    for (int i = 0; i < 3; i++) {
                        tabu[y - i][conv] = '\u2663';
                    }

                } else {
                    System.out.println("        \001B[38;5;202mO NAVIO ULTRAPASSSA O LIMITE DO TABULEIRO\u001B[0m");
                    delay.delay(1000);
                    limparTerminal.limparTerminal();
                    continue;
                }

            }
            System.out.print("\033[H\033[2J");
            System.out.flush();
            delay.delay(500);
            imprimir.imprimirtb(tabu);
            delay.delay(1500);
            System.out.println("""

        
        """);

        }
    }
}
