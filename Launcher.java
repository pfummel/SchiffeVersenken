/**
Klasse Launcher, die main-Methode des Programms enthaelt.
@author David Nancekievill Matrikelnummer Gruppe C
@author Markus Berning Matrikelnummer Gruppe C
*/
public class Launcher {

    /**
     main-Methode, die ein Objekt der Klasse Game erzeugt und die start()-Methode der Klasse Game aufruft.
     @param args Standard-Eingabeparameter
    */
    public static void main(String[] args) {
        Game game = new Game();
        game.start();
    }
}
