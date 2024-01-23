package Model;

public class Position {
    private int hauteur = 0;
    private int HauteurS = 10;
    private int speed = 1;
    private int avancement = 0;
    private int impulsion = 5;
    private int H_ovale = 35;
    private int Hauteur_min = -200 ;
    private int Hauteur_max = 200 ;
    private int BEFORE = 200;
    private int AFTER = 200;

    public int getHauteur(){
        return hauteur;
    }

    public void jump(){
        speed = impulsion;
    }

    public int getBEFORE(){
        return BEFORE;
    }

    public int getAvancement() {
        return avancement;
    }

    public int getAFTER(){
        return AFTER;
    }

    void antijump(){
        hauteur += speed;
        if(hauteur<Hauteur_min + H_ovale){
            hauteur = Hauteur_min + H_ovale;
        }else if(hauteur > Hauteur_max - H_ovale){
            hauteur = Hauteur_max - H_ovale;
            speed = 0;
        }
        speed--;
    }

    void avance(){
        avancement += 3;
    }
}
