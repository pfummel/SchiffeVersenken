/**
Klasse Launcher, die main-Methode des Programms enthaelt.
*/
public class Launcher{

    /**
     main-Methode, die ein Objekt der Klasse Game erzeugt und die start()-Methode der Klasse Game aufruft.
    */
    public static void main(String args[]){
        Game game = new Game();
        game.start();
    }
}
