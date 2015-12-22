import java.util.Scanner;

/**
Die Klasse Game kuemmert sich um die Logik des Programms, den Programmablauf und die Interaktion mit dem Benutzer.
*/
public class Game{

    /**
    Objekt Player, das das Spielfeld des Spielers enhaelt.
    */
    private Player player = new Player();

    /**
    Objekt Enemy, das das Spielfeld des Gegeners enthaelt.
    */
    private Enemy enemy = new Enemy();

    /**
    Scanner fuer Nutzereingaben.
    */
    private Scanner scan = new Scanner(System.in);


    /**
    Konstante fuer Anzahl der Schlachtschiffe
    */
    public static final int BATTLESHIP = 1; // 5 Kaestchen
    
    /**
    Konstante fuer Anzahl der Kreuzer
    */
    public static final int CRUISER = 2; // 4 Kaestchen
    
    /**
    Konstante fuer Anzahl der Zerstoerer
    */
    public static final int DESTROYER = 3; // 3 Kaestchen
    
    /**
    Konstante fuer Anzahl der U-Boote
    */
    public static final int SUBMARINE = 4; // 2 Kaestchen

    public Game(){}

    public void start(){
        //System.out.println("Das Objekt Game wurde erzeugt");
        
    }
    /**
    Die Methode überprüft mithilfe der Methode numberOFHits() der Klasse Enemy,
    ob alle gegnerischenSchiffe versenkt wurden.
    */
    private void victory(){}

    /**
    Die Methode überprueft, mithilfe der Methode isAlive() der Klasse Player,
    ob der Spieler verloren hat.
    @return boolean-Wert, der true ist, wenn der Spieler besiegt wurde.
    */
    //private boolean defeat(){}

    /**
    Methode, die dazu dient den Gegner anzgreifen und Markierungen
    im Feld des Gegners vorzunehmen.
    */
    private void attack(){}

    /**
    Methode, die dazu dient einen gegnerischen Schuss zu erhalten.
    */
    private void defend(){}

    /**
    Methode, die die Schiffe im Feld des Spielers plaziert.
    */
    private void setShips(){}

    
    
}
