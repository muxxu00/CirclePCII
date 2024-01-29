package View;

import Model.Parcours;
import Model.Position;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Affichage extends JPanel {
    public static final int H = 400;
    private Position POS;
    private Parcours parc;


    public Affichage(Position a, Parcours b){
        super();
        this.setPreferredSize(new Dimension(a.getBEFORE()+a.getAFTER(), H));
        POS = a;
        parc = b;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        if(!parc.perdu()){
            Graphics2D g2d = (Graphics2D) g;
            final int La = POS.getLa();
            final int Ha = POS.getHa();
            final int X = POS.getAFTER()-La/2;
            final int Y = POS.getAFTER()-Ha/2 - POS.getHauteur();

            BasicStroke stroke = new BasicStroke(2);
            g2d.setStroke(stroke);
            g.drawOval(X, Y, La, Ha);

            ////////////////////////////

            ArrayList<Point> oui = parc.getTab();
            for(int i = 0; i < oui.size()-1; i++){
                g.drawLine(oui.get(i).x, oui.get(i).y, oui.get(i+1).x, oui.get(i+1).y);
            }

            g.drawString(String.valueOf(POS.getAvancement()/3),200 , 50);

            g.setColor(Color.RED);
            g.drawOval(X+(La)/2, Y, 10, 10);
            g.drawOval(X+(La)/2, parc.y_ligne(), 10, 10);
            g.drawOval(X+(La)/2, Y+Ha, 10, 10);


            g.drawString(String.valueOf(parc.y_ligne()),200, 60);
            g.drawString(String.valueOf(Y),200, 70);
            g.drawString(String.valueOf(Y+POS.getHa()),200, 80);
        }else{
            g.drawString("GAME OVER", 175, 100);
            JButton oui = new JButton("Rejouer");
            oui.setBounds(100, 200, 200, 100);
            this.add(oui);

        }
    }




}

