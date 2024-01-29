package Model;

public class Avance extends Thread {
    private int DELAY = 100;
    private Position POS;
    private  Parcours parc;

    public Avance(Position a, Parcours b){
        POS = a;
        parc = b;
    }

    @Override
    public void run() {
        while(true){
            POS.avance();
            parc.gen_pts();
            parc.supp_pts();
            System.out.println(parc.perdu());
            try {
                Thread.sleep(DELAY);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}


