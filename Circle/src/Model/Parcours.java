package Model;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;


public class Parcours {
    private int Hauteur = 400;
    private int Largeur = 400;
    private int Y_min = 150;
    private int Y_max = 250;
    private int X_min = 20;
    private int X_max = 50;
    private Random generateur = new Random();
    private Position POS;

    private ArrayList<Point> tab = new ArrayList<Point>();

    public Parcours(Position a){
        POS = a;
        int i = 0;
        while(i<=11){
            tab.add(new Point(i*(Largeur/10), Hauteur/2));
            i++;
        }
    }

    public void supp_pts(){
        while(tab.get(1).x < 50 + POS.getAvancement()){
            tab.remove(0);
        }
    }

    public void gen_pts(){
        if(tab.get(tab.size()-1).x < 350+ POS.getAvancement()) {
            Point last_p = tab.get(tab.size() - 1);
            int new_x = last_p.x + X_min + generateur.nextInt(X_max - X_min);
            int new_y = Y_min + generateur.nextInt(Y_max - Y_min);
            tab.add(new Point(new_x, new_y));
        }
    }

    public ArrayList<Point> getTab(){
        int i = POS.getAvancement();
        ArrayList<Point> oui = new ArrayList<Point>();
        for(int y = 0; y < tab.size()-1; y++){
            oui.add(new Point(tab.get(y).x - i, tab.get(y).y));
        }
        return oui;
    }
}
