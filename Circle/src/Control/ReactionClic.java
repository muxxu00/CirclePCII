package Control;

import Model.Position;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ReactionClic implements MouseListener {
    private Position POS;

    public ReactionClic (Position a){
        POS = a;
    }


    @Override
    public void mouseClicked(MouseEvent e) {
        POS.jump();
    }
    @Override
    public void mousePressed(MouseEvent e) {}
    @Override
    public void mouseReleased(MouseEvent e) {}
    @Override
    public void mouseEntered(MouseEvent e) {}
    @Override
    public void mouseExited(MouseEvent e) {}
}
