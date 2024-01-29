package Main;

import Control.ReactionClic;
import Model.Avance;
import Model.Descendre;
import Model.Parcours;
import Model.Position;
import View.Affichage;
import View.Redessine;

import javax.swing.*;

public class Main {
    public static void main(String [] args) {
        JFrame maFenetre = new JFrame("Exercice 1");
        maFenetre.setResizable(false);
        maFenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Position POS = new Position();
        Parcours parc = new Parcours(POS);
        Affichage b = new Affichage(POS, parc);
        Redessine a = new Redessine(b, parc);
        Descendre c = new Descendre(POS);
        Avance d = new Avance(POS, parc);

        maFenetre.add(b);
        b.addMouseListener(new ReactionClic(POS));
        a.start();
        c.start();
        d.start();

        maFenetre.pack();
        maFenetre.setVisible(true);
    }
}
