
import java.util.Random;
import java.util.Scanner;

public class main {                                                         //coloque no zoom 1

    public static void main(String[] args) {

        Random random = new Random();
        char[][] tabuleiroPlayer = new char[10][10];
        char[][] tabuleiroCPU = new char[10][10];
        
        
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                tabuleiroPlayer[i][j] = '~';
            }
        }
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                tabuleiroCPU[i][j] = '~';
            }
        }


        mainTeste.navioCPU(tabuleiroCPU, random);
        mainTeste.portaAvioesCPU(tabuleiroCPU, random);
        imprimir.imprimirtbCPU(tabuleiroCPU);
        Scanner sc = new Scanner(System.in);
        Random CPU = new Random();
        sc.nextLine();
        limparTerminal.limparTerminal();

        System.out.println("\u001B[38;5;226m" + """





                                                    ██████╗  █████╗ ████████╗ █████╗ ██╗     ██╗  ██╗ █████╗
                                                    ██╔══██╗██╔══██╗╚══██╔══╝██╔══██╗██║     ██║  ██║██╔══██╗
                                                    ██████╔╝███████║   ██║   ███████║██║     ███████║███████║
                                                    ██╔══██╗██╔══██║   ██║   ██╔══██║██║     ██╔══██║██╔══██║
                                                    ██████╔╝██║  ██║   ██║   ██║  ██║███████╗██║  ██║██║  ██║
                                                    ╚═════╝ ╚═╝  ╚═╝   ╚═╝   ╚═╝  ╚═╝╚══════╝╚═╝  ╚═╝╚═╝  ╚═╝

                                                    ███╗   ██╗ █████╗ ██╗   ██╗ █████╗ ██╗
                                                    ████╗  ██║██╔══██╗██║   ██║██╔══██╗██║
                                                    ██╔██╗ ██║███████║██║   ██║███████║██║
                                                    ██║╚██╗██║██╔══██║╚██╗ ██╔╝██╔══██║██║
                                                    ██║ ╚████║██║  ██║ ╚████╔╝ ██║  ██║███████╗
                                                    ╚═╝  ╚═══╝╚═╝  ╚═╝  ╚═══╝  ╚═╝  ╚═╝╚══════╝



                                                                       PRESSIONE ENTER







""" + "\u001B[0m");

        sc.nextLine();
        limparTerminal.limparTerminal();

        mainTeste.escolhendoNavil(sc, tabuleiroPlayer);
        delay.delay(1200);
        mainTeste.escolhendoPORTAAVIOES(sc, tabuleiroPlayer);

        imprimir.imprimirtb(tabuleiroPlayer);

    }
}
