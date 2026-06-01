
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
                
                BATALHA INICIADA!
                
                """ + "\u001B[0m");
        delay.delay(1500);
        limparTerminal.limparTerminal();

        while (naviosPlayerRestantes > 0 && naviosCPURestantes > 0) {

            limparTerminal.limparTerminal();
            System.out.println(espaço + "\u001B[38;5;46m=== SEU TURNO ===\u001B[0m");
            delay.delay(800);

            imprimir.imprimirtb(tabuPlayer);  // Mostra seu tabuleiro
            System.out.println(espaço + "TABULEIRO INIMIGO:");
            imprimir.imprimirtb(visuCPU);  // Mostra visão do inimigo (só hits/misses)

            atacarCPU(sc, tabuCPU, visuCPU, espaço);

            naviosCPURestantes = contarNaviosRestantes(tabuCPU);

            if (naviosCPURestantes == 0) {
                break;
            }

            delay.delay(1200);
            limparTerminal.limparTerminal();

            System.out.println(espaço + "\u001B[38;5;196m=== TURNO DA CPU ===\u001B[0m");
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
            System.out.println(espaço + "Escolha onde ATACAR (ex: B5): ");
            String pos = sc.nextLine().toUpperCase().trim();

            try {
                x = pos.charAt(0);
                y = Integer.parseInt(pos.substring(1)) - 1;
            } catch (Exception e) {
                x = 'p';
            }

            if (!isValidPosition(x, y)) {
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
                System.out.println(espaço + "\u001B[38;5;46m  ACERTOU UM NAVIO! 🔥\u001B[0m");
            } else {
                visuCPU[y][col] = 'O';
                tabuCPU[y][col] = 'O';
                System.out.println(espaço + "\u001B[38;5;39m  ÁGUA💦\u001B[0m");
            }

            delay.delay(1200);
            break;

        } while (true);
    }

    public static void atacarPlayer(Random random, char[][] tabuPlayer, char[][] visuPlayer, String espaço) {
        int row, col;
        do {
            row = random.nextInt(10);
            col = random.nextInt(10);
        } while (visuPlayer[row][col] == 'X' || visuPlayer[row][col] == 'O');

        if (tabuPlayer[row][col] == '═' || tabuPlayer[row][col] == '■') {
            visuPlayer[row][col] = 'X';
            tabuPlayer[row][col] = 'X';
            System.out.println(espaço + "\u001B[38;5;196mA CPU ACERTOU SEU NAVIO! 💥\u001B[0m");
        } else {
            visuPlayer[row][col] = 'O';
            tabuPlayer[row][col] = 'O';
            System.out.println(espaço + "\u001B[38;5;39mA CPU errou... 💦\u001B[0m");
        }

        delay.delay(1000);
    }

    public static int contarNaviosRestantes(char[][] tabu) {
        int count = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (tabu[i][j] == '═' || tabu[i][j] == '■') {
                    count++;
                }
            }
        }
        return count;
    }

    public static boolean isValidPosition(char x, int y) {
        return (x >= 'A' && x <= 'J') && (y >= 0 && y < 10);
    }

    public static int letterToCol(char x) {
        return x - 'A';
    }

    public static void vitoria() {
        String espaço = "                                                        ";
        System.out.println("\u001B[38;5;46m" + """
                
                ██████╗  ██████╗  ███████╗     ██╗   ██╗ ██████╗  ██╗
                ██╔══██╗██╔═══██╗██╔════╝     ██║   ██║██╔═══██╗███║
                ██████╔╝██║   ██║███████╗     ██║   ██║██║   ██║╚██║
                ██╔══██╗██║   ██║╚════██║     ╚██╗ ██╔╝██║   ██║ ██║
                ██║  ██║╚██████╔╝███████║      ╚████╔╝ ╚██████╔╝ ██║
                ╚═╝  ╚═╝ ╚═════╝ ╚══════╝       ╚═══╝   ╚═════╝  ╚═╝
                
                """ + "\u001B[0m");
        System.out.println(espaço + "VOCÊ VENCEU A BATALHA NAVAL! 🏆");
        delay.delay(3000);
    }

    public static void derrota() {
        String espaço = "                                                        ";
        System.out.println("\u001B[38;5;196m" + """
                
                ██████╗ ███████╗███████╗ █████╗ ████████╗ █████╗ 
                ██╔══██╗██╔════╝██╔════╝██╔══██╗╚══██╔══╝██╔══██╗
                ██║  ██║█████╗  █████╗  ███████║   ██║   ███████║
                ██║  ██║██╔══╝  ██╔══╝  ██╔══██║   ██║   ██╔══██║
                ██████╔╝███████╗███████╗██║  ██║   ██║   ██║  ██║
                ╚═════╝ ╚══════╝╚══════╝╚═╝  ╚═╝   ╚═╝   ╚═╝  ╚═╝
                
                """ + "\u001B[0m");
        System.out.println(espaço + "A CPU VENCEU... TENTE NOVAMENTE! 💀");
        delay.delay(3000);
    }
}
