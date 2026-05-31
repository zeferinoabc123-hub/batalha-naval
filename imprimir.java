
public class imprimir {

    public static void imprimirtb(char[][] tabela) {

        
        //-------------------------------------------
        String espaço = "                                                        ";
        System.out.println("\u001B[34m");
        System.out.println(espaço+"      A  B  C  D  E  F  G  H  I  J");
        System.out.println(espaço+"\u001B[32m    ════════════════════════════════\u001B[34m");

        for (int i = 0; i < tabela.length; i++) {

            if (i + 1 < 10) {
                System.out.print(espaço+"  " + (i + 1) + "\u001B[32m ║ \u001B[34m");
            }else{
                System.out.print(espaço+" " + (i + 1) + "\u001B[32m ║ \u001B[34m");
            }
//-------------------------
            for (int j = 0; j < tabela[i].length; j++) {

    if (tabela[i][j] == '■') {
        System.out.print("\u001B[93m■\u001B[34m  ");
    } else {
        System.out.print(tabela[i][j] + "  ");
    }

}
        //--------------------
            System.out.println("\u001B[32m║\u001B[34m");
        }

        System.out.println(espaço+"\u001B[32m    ════════════════════════════════\u001B[34m");
        System.out.println("\u001B[0m");

    }

}
