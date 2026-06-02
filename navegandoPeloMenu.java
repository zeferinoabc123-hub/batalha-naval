
import java.util.Scanner;

public class navegandoPeloMenu {
    public static String opçoes(Scanner scanner){

         String espaço = "                                                                     ";
         String[] opcoes = {
             "Direita",
             "Esquerda",
             "Cima",
             "Baixo"
            };
            
            int escolha = 0;

            while (true) {
                
            for (int i = 0; i < 15; i++) {
                System.out.println();
            }
            
            System.out.println("                                                         Em que direçao deseja colocar o navio ?");
            System.out.println("                                                                     Use W/S e ENTER");
            
            // desenha menu
            for (int i = 0; i < opcoes.length; i++) {
                
                if (i == escolha) {
                    System.out.println(espaço +"\u001B[91m   >\u001B[0m " + opcoes[i]);
                } else {

                    System.out.println(espaço +"     " + opcoes[i]);
                }
            }

            String tecla = scanner.nextLine();

            if (tecla.equalsIgnoreCase("w")) {

                escolha--;

                if (escolha < 0) {
                    escolha = opcoes.length - 1;
                }
            }

            else if (tecla.equalsIgnoreCase("s")) {

                escolha++;

                if (escolha >= opcoes.length) {
                    escolha = 0;
                }
            }

            else if (tecla.isEmpty()) {
                return opcoes[escolha];
            }

            limparTerminal.limparTerminal();
        }


    
    }
}
