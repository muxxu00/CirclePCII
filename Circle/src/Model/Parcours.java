package Model;

import View.Affichage;

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
    private int Start = 0;
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
        while(tab.get(1).x < POS.getAvancement()){
            tab.remove(0);
        }
    }

    public void gen_pts(){
        if(tab.get(tab.size()-1).x <= 500+ POS.getAvancement()) {
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

    public int y_ligne(){

        int i = 1;
        while (i< tab.size() && tab.get(i).x<= POS.getBEFORE()+ POS.getLa()/2 + POS.getAvancement())
            i = i+1;
        if (i==tab.size())
            System.err.print("c'est n'importe quoi ce code");
//        else
//            System.out.println(i);
        int res = (POS.getBEFORE() + POS.getLa()/2) - (tab.get(i-1).x-POS.getAvancement());
        res = res * ((tab.get(i).y)-(tab.get(i-1).y));
        res = res / ((tab.get(i).x - POS.getAvancement())-(tab.get(i-1).x - POS.getAvancement()));
        res += (tab.get(i-1).y);
        return res;
    }

    public boolean perdu(){
        return(y_ligne() <= POS.getAFTER()- POS.getHa()/2 - POS.getHauteur()
        || y_ligne() >= POS.getAFTER()- POS.getHa()/2 - POS.getHauteur() + POS.getHa());
    }


}
