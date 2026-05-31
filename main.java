
import java.util.Random;
import java.util.Scanner;



public class main {                                                         //coloque no zoom 1
    public static void main(String[] args) {
        char[][] tabuleiroPlayer = new char[10][10];
                for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                tabuleiroPlayer[i][j] = '~';
            }
        }
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
  
            
        jogar.escolhendoNavil(sc, tabuleiroPlayer);
        delay.delay(1200);
        jogar.escolhendoPortaAviao(sc, tabuleiroPlayer);
        
        imprimir.imprimirtb(tabuleiroPlayer);

        


        
        
    }
}
