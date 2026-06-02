
import java.util.Random;
import java.util.Scanner;

public class mainTeste {//

    public static void escolhendoNavil(Scanner scanner, char[][] tabu) {
        String espaço = "                                                        ";
        char x = 'p';
        int y = 11;

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
                    System.out.println(espaço + "            \u001B[38;5;202mPOSIÇAO INVALIDA\u001B[0m");
                    delay.delay(1000);
                    limparTerminal.limparTerminal();
                    continue navio;
                } else if (y < 0 || y >= 10) {
                    System.out.println(espaço + "            \u001B[38;5;202mPOSIÇAO INVALIDA\u001B[0m");
                    delay.delay(1000);
                    limparTerminal.limparTerminal();
                    continue navio;
                } else if (posiçao.length() > 3) {
                    System.out.println(espaço + "            \u001B[38;5;202mPOSIÇAO INVALIDA\u001B[0m");
                    delay.delay(1000);
                    limparTerminal.limparTerminal();
                    continue navio;
                } else {
                    break navio;
                }
            } while (true);

            int conv = -1;
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

            int contadorPos = 0;
            escolhaOnavil:
            do {

                String opçoes = navegandoPeloMenu.opçoes(scanner);

                if (opçoes.equals("Direita")) {
                    if (conv + 2 < 10) {
                        for (int i = 0; i < 3; i++) {
                            if (tabu[y][conv + i] == '═') {
                                for (int j = 0; j < i; j++) {
                                    tabu[y][conv + j] = '~'; // desfaz
                                }
                                System.out.println(espaço + "      \u001B[38;5;202mNAO PODE OBSTRUIR OUTRA EMBARCAÇAO");
                                delay.delay(1000);
                                limparTerminal.limparTerminal();
                                continue escolhaOnavil;

                            }
                            tabu[y][conv + i] = '═';
                        }
                    } else {
                        System.out.println(espaço + "\u001B[38;5;202mO NAVIO ULTRAPASSA O LIMITE DO TABULEIRO\u001B[0m");
                        delay.delay(1000);
                        limparTerminal.limparTerminal();
                        continue escolhaOnavil;
                    }
                    break escolhaOnavil;

                } else if (opçoes.equals("Esquerda")) {
                    if (conv - 2 >= 0) {
                        for (int i = 0; i < 3; i++) {
                            if (tabu[y][conv - i] == '═') {
                                for (int j = 0; j < i; j++) {
                                    tabu[y][conv - j] = '~'; // desfaz
                                }
                                System.out.println(espaço + "      \u001B[38;5;202mNAO PODE OBSTRUIR OUTRA EMBARCAÇAO");
                                delay.delay(1000);
                                limparTerminal.limparTerminal();
                                continue escolhaOnavil;
                            }
                            tabu[y][conv - i] = '═';
                        }

                    } else {
                        System.out.println(espaço + "\u001B[38;5;202mO NAVIO ULTRAPASSA O LIMITE DO TABULEIRO\u001B[0m");
                        delay.delay(1000);
                        limparTerminal.limparTerminal();
                        continue escolhaOnavil;
                    }

                    break escolhaOnavil;
                } else if (opçoes.equals("Baixo")) {
                    if (y + 2 < 10) {
                        for (int i = 0; i < 3; i++) {
                            if (tabu[y + i][conv] == '═') {
                                for (int j = 0; j < i; j++) {
                                    tabu[y + j][conv] = '~';
                                }
                                System.out.println(espaço + "      \u001B[38;5;202mNAO PODE OBSTRUIR OUTRA EMBARCAÇAO");
                                delay.delay(1000);
                                limparTerminal.limparTerminal();
                                continue escolhaOnavil;
                            }
                            tabu[y + i][conv] = '═';
                        }
                    } else {
                        System.out.println(espaço + "\u001B[38;5;202mO NAVIO ULTRAPASSA O LIMITE DO TABULEIRO\u001B[0m");
                        delay.delay(1000);
                        limparTerminal.limparTerminal();
                        continue escolhaOnavil;
                    }
                    break escolhaOnavil;
                } else if (opçoes.equals("Cima")) {
                    if (y - 2 >= 0) {
                        for (int i = 0; i < 3; i++) {
                            if (tabu[y - i][conv] == '═') {
                                for (int j = 0; j < i; j++) {
                                    tabu[y - j][conv] = '~';
                                }
                                System.out.println(espaço + "      \u001B[38;5;202mNAO PODE OBSTRUIR OUTRA EMBARCAÇAO");
                                delay.delay(1000);
                                limparTerminal.limparTerminal();
                                continue escolhaOnavil;
                            }
                            tabu[y - i][conv] = '═';
                        }
                    } else {
                        System.out.println(espaço + "\u001B[38;5;202mO NAVIO ULTRAPASSA O LIMITE DO TABULEIRO\u001B[0m");
                        delay.delay(1000);
                        limparTerminal.limparTerminal();
                        continue escolhaOnavil;
                    }
                    break escolhaOnavil;
                }
                contadorPos++;
                if (contadorPos == 2) {
                    break;
                }
                limparTerminal.limparTerminal();
                imprimir.imprimirtb(tabu);
            } while (true);
        }
        limparTerminal.limparTerminal();
        imprimir.imprimirtb(tabu);
        delay.delay(1500);
    }

    //___________________________________________________________________________________________________________________________________
    //___________________________________________________________________________________________________________________________________
    public static void escolhendoPORTAAVIOES(Scanner scanner, char[][] tabu) {
        String espaço = "                                                        ";
        char x = 'p';
        int y = 11;

        for (int i = 0; i < 7; i++) {
            System.out.println();
        }


        for (int N = 1; N < 3; N++) {
            limparTerminal.limparTerminal();
            imprimir.imprimirtb(tabu);
            limparTerminal.limparTerminal();

            navio:
            do {
                imprimir.imprimirtb(tabu);
                System.out.println(espaço + "   Em qual casa deseja por o " + N + "º Porta aviões ?");
                System.out.print(espaço + "  Escolha a posiçao referente ao eixo xy : ");
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
                    System.out.println(espaço + "            \u001B[38;5;202mPOSIÇAO INVALIDA\u001B[0m");
                    delay.delay(1000);
                    limparTerminal.limparTerminal();
                    continue navio;
                } else if (y < 0 || y >= 10) {
                    System.out.println(espaço + "            \u001B[38;5;202mPOSIÇAO INVALIDA\u001B[0m");
                    delay.delay(1000);
                    limparTerminal.limparTerminal();
                    continue navio;
                } else if (posiçao.length() > 3) {
                    System.out.println(espaço + "            \u001B[38;5;202mPOSIÇAO INVALIDA\u001B[0m");
                    delay.delay(1000);
                    limparTerminal.limparTerminal();
                    continue navio;
                } else {
                    break navio;
                }
            } while (true);

            int conv = -1;
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

            int contadorPos = 0;
            escolhaOnavil:
            do {

                String opçoes = navegandoPeloMenu.opçoes(scanner);

                if (opçoes.equals("Direita")) {
                    if (conv + 3 < 10) {
                        for (int i = 0; i < 4; i++) {
                            if (tabu[y][conv + i] == '═' || tabu[y][conv + i] == '■') {
                                for (int j = 0; j < i; j++) {
                                    tabu[y][conv + j] = '~';
                                }
                                System.out.println(espaço + "      \u001B[38;5;202mNAO PODE OBSTRUIR OUTRA EMBARCAÇAO");
                                delay.delay(1000);
                                limparTerminal.limparTerminal();
                                continue escolhaOnavil;

                            }
                            tabu[y][conv + i] = '■';
                        }
                    } else {
                        System.out.println(espaço + "\u001B[38;5;202mO O PORTA AVIÕES ULTRAPASSA O LIMITE DO TABULEIRO\u001B[0m");
                        delay.delay(1000);
                        limparTerminal.limparTerminal();
                        continue escolhaOnavil;
                    }
                    break escolhaOnavil;

                } else if (opçoes.equals("Esquerda")) {
                    if (conv - 3 >= 0) {
                        for (int i = 0; i < 4; i++) {
                            if (tabu[y][conv - i] == '═' || tabu[y][conv - i] == '■') {
                                for (int j = 0; j < i; j++) {
                                    tabu[y][conv - j] = '~';
                                }
                                System.out.println(espaço + "      \u001B[38;5;202mNAO PODE OBSTRUIR OUTRA EMBARCAÇAO");
                                delay.delay(1000);
                                limparTerminal.limparTerminal();
                                continue escolhaOnavil;
                            }
                            tabu[y][conv - i] = '■';
                        }

                    } else {
                        System.out.println(espaço + "\u001B[38;5;202mO O PORTA AVIÕES ULTRAPASSA O LIMITE DO TABULEIRO\u001B[0m");
                        delay.delay(1000);
                        limparTerminal.limparTerminal();
                        continue escolhaOnavil;
                    }

                    break escolhaOnavil;
                } else if (opçoes.equals("Baixo")) {
                    if (y + 3 < 10) {
                        for (int i = 0; i < 4; i++) {
                            if (tabu[y + i][conv] == '═' || tabu[y + i][conv] == '■') {
                                for (int j = 0; j < i; j++) {
                                    tabu[y + j][conv] = '~';
                                }
                                System.out.println(espaço + "      \u001B[38;5;202mNAO PODE OBSTRUIR OUTRA EMBARCAÇAO");
                                delay.delay(1000);
                                limparTerminal.limparTerminal();
                                continue escolhaOnavil;
                            }
                            tabu[y + i][conv] = '■';
                        }
                    } else {
                        System.out.println(espaço + "\u001B[38;5;202mO O PORTA AVIÕES ULTRAPASSA O LIMITE DO TABULEIRO\u001B[0m");
                        delay.delay(1000);
                        limparTerminal.limparTerminal();
                        continue escolhaOnavil;
                    }
                    break escolhaOnavil;
                } else if (opçoes.equals("Cima")) {
                    if (y - 3 >= 0) {
                        for (int i = 0; i < 4; i++) {
                            if (tabu[y - i][conv] == '═' || tabu[y - i][conv] == '■') {
                                for (int j = 0; j < i; j++) {
                                    tabu[y - j][conv] = '~';
                                }
                                System.out.println(espaço + "      \u001B[38;5;202mNAO PODE OBSTRUIR OUTRA EMBARCAÇAO");
                                delay.delay(1000);
                                limparTerminal.limparTerminal();
                                continue escolhaOnavil;
                            }
                            tabu[y - i][conv] = '■';
                        }
                    } else {
                        System.out.println(espaço + "\u001B[38;5;202mO O PORTA AVIÕES ULTRAPASSA O LIMITE DO TABULEIRO\u001B[0m");
                        delay.delay(1000);
                        limparTerminal.limparTerminal();
                        continue escolhaOnavil;
                    }
                    break escolhaOnavil;
                }
                contadorPos++;
                if (contadorPos == 2) {
                    break;
                }
                limparTerminal.limparTerminal();
                imprimir.imprimirtb(tabu);
            } while (true);
        }
        limparTerminal.limparTerminal();
        imprimir.imprimirtb(tabu);
        delay.delay(1500);
    }

//__________________________________________________________________________________________________________________________________
//___________________________________________________________________________________________________________________________________
    public static void navioCPU(char[][] tabuCPU, Random random) {
        int contador = 0;
        for (int COM = 0; COM < 2; COM++) {

            navioCPU:
            do {
                int posiçaoX = random.nextInt(10);
                int posiçaoY = random.nextInt(10);
                int direçao = random.nextInt(4) + 1;

                if (direçao == 1) { //direita
                    if (posiçaoX + 2 < 10) {
                        for (int i = 0; i < 3; i++) {
                            if (tabuCPU[posiçaoY][posiçaoX + i] == '═') {
                                for (int j = 0; j < i; j++) {
                                    tabuCPU[posiçaoY][posiçaoX + j] = '~';
                                }
                                continue navioCPU;
                            }
                            tabuCPU[posiçaoY][posiçaoX + i] = '═';
                        }
                    } else {
                        continue navioCPU; // ultrapassa o limite
                    }
                    break navioCPU;
                }
//--------------------------------------------------------------------------
                if (direçao == 2) { //esquerda
                    if (posiçaoX - 2 >= 0) {
                        for (int i = 0; i < 3; i++) {
                            if (tabuCPU[posiçaoY][posiçaoX - i] == '═') {
                                for (int j = 0; j < i; j++) {
                                    tabuCPU[posiçaoY][posiçaoX - j] = '~';
                                }
                                continue navioCPU;
                            }
                            tabuCPU[posiçaoY][posiçaoX - i] = '═';
                        }
                    } else {
                        continue navioCPU; // ultrapassa o limite
                    }
                    break navioCPU;
                }

//-------------------------------------------------------------------------------
                if (direçao == 3) { //baixo
                    if (posiçaoY + 2 < 10) {
                        for (int i = 0; i < 3; i++) {
                            if (tabuCPU[posiçaoY + i][posiçaoX] == '═') {
                                for (int j = 0; j < i; j++) {
                                    tabuCPU[posiçaoY + j][posiçaoX] = '~';
                                }
                                continue navioCPU;
                            }
                            tabuCPU[posiçaoY + i][posiçaoX] = '═';
                        }
                    } else {
                        continue navioCPU; // ultrapassa o limite
                    }
                    break navioCPU;
                }

//---------------------------------------------------------------------------------------
                if (direçao == 4) { //cima
                    if (posiçaoY - 2 >= 0) {
                        for (int i = 0; i < 3; i++) {
                            if (tabuCPU[posiçaoY - i][posiçaoX] == '═') {
                                for (int j = 0; j < i; j++) {
                                    tabuCPU[posiçaoY - j][posiçaoX] = '~';
                                }
                                continue navioCPU;
                            }
                            tabuCPU[posiçaoY - i][posiçaoX] = '═';
                        }
                    } else {
                        continue navioCPU; 
                    }
                    break navioCPU;
                }
                contador++;
                if (contador == 2) {
                    break;
                }

            } while (true);

        }
    }


//__________________________________________________________________PORTAAVIAO DA CPU


    public static void portaAvioesCPU(char[][] tabuCPU, Random random) {
        int contador = 0;
        for (int COM = 0; COM < 2; COM++) {

            portaaviaoCPU:
            do {
                contador++;
                int posiçaoX = random.nextInt(10);
                int posiçaoY = random.nextInt(10);
                int direçao = random.nextInt(4) + 1;

                if (direçao == 1) { //direita
                    if (posiçaoX + 4 < 10) {
                        for (int i = 0; i < 5; i++) {
                            if (tabuCPU[posiçaoY][posiçaoX + i] == '■' || tabuCPU[posiçaoY][posiçaoX + i] == '═' ) {
                                System.out.println("teste1");
                                for (int j = 0; j < i; j++) {
                                    tabuCPU[posiçaoY][posiçaoX + j] = '~';
                                }
                                continue portaaviaoCPU;
                            }
                            tabuCPU[posiçaoY][posiçaoX + i] = '■';
                        }
                    } else {
                        continue portaaviaoCPU; // ultrapassa o limite
                    }
                    break portaaviaoCPU;
                }
//--------------------------------------------------------------------------
                if (direçao == 2) { //esquerda
                    if (posiçaoX - 4 >= 0) {
                        for (int i = 0; i < 5; i++) {
                            if (tabuCPU[posiçaoY][posiçaoX - i] == '■' || tabuCPU[posiçaoY][posiçaoX - i] == '═') {
                                System.out.println("teste2");
                                for (int j = 0; j < i; j++) {
                                    tabuCPU[posiçaoY][posiçaoX - j] = '~';
                                }
                                continue portaaviaoCPU;
                            }
                            tabuCPU[posiçaoY][posiçaoX - i] = '■';
                        }
                    } else {
                        continue portaaviaoCPU; // ultrapassa o limite
                    }
                    break portaaviaoCPU;
                }

//-------------------------------------------------------------------------------
                if (direçao == 3) { //baixo
                    if (posiçaoY + 4 < 10) {
                        for (int i = 0; i < 5; i++) {
                            if (tabuCPU[posiçaoY + i][posiçaoX] == '■' || tabuCPU[posiçaoY + i][posiçaoX] == '═') {
                                System.out.println("teste3");
                                for (int j = 0; j < i; j++) {
                                    tabuCPU[posiçaoY + j][posiçaoX] = '~';
                                }
                                continue portaaviaoCPU;
                            }
                            tabuCPU[posiçaoY + i][posiçaoX] = '■';
                        }
                    } else {
                        continue portaaviaoCPU; // ultrapassa o limite
                    }
                    break portaaviaoCPU;
                }

//---------------------------------------------------------------------------------------
                if (direçao == 4) { //cima
                    if (posiçaoY - 4 >= 0) {
                        for (int i = 0; i < 5; i++) {
                            if (tabuCPU[posiçaoY - i][posiçaoX] == '■' || tabuCPU[posiçaoY - i][posiçaoX] == '═') {
                                System.out.println("teste4");
                                for (int j = 0; j < i; j++) {
                                    tabuCPU[posiçaoY - j][posiçaoX] = '~';
                                }
                                continue portaaviaoCPU;
                            }
                            tabuCPU[posiçaoY - i][posiçaoX] = '■';
                        }
                    } else {
                        continue portaaviaoCPU; // ultrapassa o limite
                    }
                    break portaaviaoCPU;
                }
                if (contador == 2) {
                    break;
                }

            } while (true);

        }
  


}




}
