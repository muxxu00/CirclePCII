package View;

import View.Affichage;

public class Redessine extends Thread{
    private Affichage monAffichage ;
    private int DELAY = 50;

    public Redessine(Affichage a){
        monAffichage = a;
    }

    @Override
    public void run() {
        while (true) {
            monAffichage.revalidate();
            monAffichage.repaint();
            try {
                Thread.sleep(DELAY);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
