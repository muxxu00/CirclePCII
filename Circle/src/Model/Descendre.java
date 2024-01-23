package Model;

public class Descendre extends Thread {
    private int DELAY = 100;
    private Position POS;

    public Descendre(Position a){
        POS = a;
    }

    @Override
    public void run() {
        while(true){
            POS.antijump();
            try {
                Thread.sleep(DELAY);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
