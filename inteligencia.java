
import java.util.Random;

public class inteligencia {
    public static void InteligenciaArtificial(Random random, int a,int b, char[][] tabu ){
        int acertouX = 0;
        int acertouY = 0;
        int IA = 0;
        boolean acertou = false;

        if(tabu[acertouY][acertouX] != '~'){
            acertou = true;
            acertouX = a;
            acertouY = b;
        }
        if(acertou == true){
            IA = random.nextInt(4)+1;
                if(IA == 1){
                    tabu[acertouY + 1][acertouX] = 'X';
                        
                }
        }
    }
}
