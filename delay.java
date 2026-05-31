
public class delay {

    public static void delay(int miliSeg) {

        try {
            Thread.sleep(miliSeg);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
