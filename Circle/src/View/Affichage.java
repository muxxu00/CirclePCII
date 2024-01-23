package View;

import Model.Parcours;
import Model.Position;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Affichage extends JPanel {
    public static final int H = 400;
    public static final int W = 400;
    private Position POS;
    private Parcours parc;


    public Affichage(Position a, Parcours b){
        this.setPreferredSize(new Dimension(a.getBEFORE()+a.getAFTER(), 400));
        POS = a;
        parc = b;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        final int La = 30;
        final int Ha = 70;
        final int X = H/2-La/2;
        final int Y = W/2-Ha/2 - POS.getHauteur();

        g.drawOval(X, Y, La, Ha);

        ////////////////////////////

        ArrayList<Point> oui = parc.getTab();
        for(int i = 0; i < oui.size()-1; i++){
            g.drawLine(oui.get(i).x, oui.get(i).y, oui.get(i+1).x, oui.get(i+1).y);
        }

        g.drawString(String.valueOf(POS.getAvancement()/3),200 , 50);
    }




}

