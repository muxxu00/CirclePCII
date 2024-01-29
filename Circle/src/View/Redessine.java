package View;

import Model.Parcours;
import View.Affichage;

public class Redessine extends Thread{
    private Affichage monAffichage ;
    private int DELAY = 50;
    private Parcours parc;

    public Redessine(Affichage a, Parcours b){
        parc = b;
        monAffichage = a;
    }

    @Override
    public void run() {
        while (true) {
            monAffichage.revalidate();
            monAffichage.repaint();
            if(parc.perdu()){
                break;
            }
            try {
                Thread.sleep(DELAY);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
