import java.util.Scanner;

/**
Die Klasse Game kuemmert sich um die Logik des Programms, den Programmablauf und die Interaktion mit dem Benutzer.
*/
public class Game{

    /**
    Objekt Player, das das Spielfeld des Spielers enhaelt.
    */
    private Player player;

    /**
    Objekt Enemy, das das Spielfeld des Gegeners enthaelt.
    */
    private Enemy enemy;

    /**
    Scanner fuer Nutzereingaben.
    */
    private static Scanner scan = new Scanner(System.in);


    /**
    Konstante fuer Anzahl der Schlachtschiffe
    */
    public static final int BATTLESHIP = 1; // 5 Kaestchen
    
    /**
    Konstante fuer Anzahl der Kreuzer
    */
    public static final int CRUISER = 0; // 4 Kaestchen
    
    /**
    Konstante fuer Anzahl der Zerstoerer
    */
    public static final int DESTROYER = 0; // 3 Kaestchen
    
    /**
    Konstante fuer Anzahl der U-Boote
    */
    public static final int SUBMARINE = 0; // 2 Kaestchen

    /**
    Konstruktor fuer Game, der die Objekte enemy und player erzeugt, falls die Spielkonfiguration gueltig ist.
    */
    public Game(){
        int BoxesWithShips = (BATTLESHIP * 5) + (CRUISER * 4) + (DESTROYER * 3) + (SUBMARINE * 2);

        if (BATTLESHIP < 0 || CRUISER < 0 || DESTROYER < 0 || SUBMARINE < 0){
            System.out.println("Ungueltige Spielkonfiguration! Das Spiel wird beendet.");
            System.exit(0);
        }
        else if (BoxesWithShips == 0){
            System.out.println("Ungueltige Spielkonfiguration! Das Spiel wird beendet.");
            System.exit(0);
        }
        else {
            enemy = new Enemy();
            player = new Player();
        }
    }

    /**
    Methode, die fuer den Programmablauf verantwortlich ist. Zuerst werden die Schiffe im Spielfeld gesetzt,
    anschließend koennen die Methoden attack, defend etc aufgerufen werden.
    */
    public void start(){
    
        //Scanner scan = new Scanner(System.in);
        int input;
        int counter = 0;
        
        setShips();

        System.out.print(player.toString());
        System.out.print(enemy.toString());
        
        while (true) {

            do {
                System.out.print("\nWas moechtest du tun?\n\n(1) Angreifen\n(2) Verteidigen\n(3) Print\n(4) Exit\n");
                input = checkInt();
                
                switch (input) {
                    case 1: attack();
                        counter = 0;
                        break;
                    case 2: defend();
                        counter = 0;
                        break;
                    case 3: System.out.print(player.toString());
                        System.out.print(enemy.toString());
                        counter = 0;
                        break;
                    case 4: System.exit(0);
                        break;
                    default: System.out.print("Bitte waehle aus den Optionen (1), (2), (3) oder (4) aus!");
                        counter = 1;
                        break;
                }
            } while (counter == 1);
        }   
    }
    /**
    Die Methode überprüft mithilfe der Methode numberOFHits() der Klasse Enemy,
    ob alle gegnerischenSchiffe versenkt wurden.
    */
    private void victory(){
        int hitsToWin = (BATTLESHIP * 5) + (CRUISER * 4) + (DESTROYER * 3) + (SUBMARINE * 2);
        
        if (hitsToWin == enemy.numberOfHits()){                     //Auswahl der Schiffe des Gegners muss gleich sein!
            System.out.println("Glueckwunsch du hast das Spiel gewonnen!");
            System.exit(0);
        }
        
    }

    /**
    Die Methode überprueft, mithilfe der Methode isAlive() der Klasse Player,
    ob der Spieler verloren hat.
    */
    private void defeat(){
    
        if (player.isAlive() == false) {
            System.out.println("Schade du hast das Spiel verloren!");
            System.exit(0);
        }
    
    }

    /**
    Methode, die dazu dient den Gegner anzgreifen und Markierungen
    im Feld des Gegners vorzunehmen.
    */
    private void attack(){
        //Scanner scan = new Scanner(System.in);
        int counter = 0;
        int input, row, col;
        boolean hit = false;
        
        /* 
        Abfrage der Zeile und Spalte des Ziels, abfangen ungueltiger Eingaben
        (Int von 0-9)
        */
        do {
            System.out.print("\nWohin moechtest du schiessen?\n");
            
            // Zeile
            System.out.print("Zeile: ");
            
            do {
                row = convertChar();
                if (!(row >= 0 && row <= 9)) {
                    System.out.print("Ungueltige Eingabe! \nNochmal: ");
                }
            } while (!(row >= 0 && row <= 9));     
            
            // Spalte
            System.out.print("Spalte: ");
            
            do {
                col = checkInt();
                if (!(row >= 0 && col <= 9)) {
                    System.out.print("Ungueltige Eingabe! \nNochmal: ");
                }
            } while (!(row >= 0 && col <= 9));

            do {
                System.out.println("\nWar der Schuss ein Treffer?\n(1) Ja\n(2) Nein");
                input = checkInt();

                switch (input) {
                    case 1: hit = true;
                            counter = 0;
                            enemy.set(row, col, hit);
                            System.out.print(enemy.toString());
                            victory();
                            break;
                    case 2: hit = false;
                            counter = 0;
                            enemy.set(row, col, hit);
                            System.out.print(enemy.toString());
                            break;
                    default: System.out.println("Keine gueltige Eingabe! Bitte wahle aus (1) oder (2) aus!");
                            counter = 1;
                }
            } while (counter == 1);            
        } while (hit == true);
    }

    /**
    Methode, die dazu dient einen gegnerischen Schuss zu erhalten.
    */
    private void defend(){
        
        int row = 0, col = 0;
        boolean counter;
        
        /*
        Eingabe des gegnerischen Angriffs als Zeile und Spalte, hochzaehlen
        der Variable strikesOpponent, Niederlage bei strikesOpponent = 30, 
        abfangen ungueltiger Eingaben
        */
        do {
            System.out.println("\nWohin wurde geschossen?");
            
            // Zeile
            System.out.print("Zeile: ");
            
            do {
                row = convertChar();
                if (!(row >= 0 && row <= 9)) {
                    System.out.println("Ungueltige Eingabe! \nNochmal: ");
                }
            } while (!(row >= 0 && row <= 9));
            
            //Spalte
            System.out.print("Spalte: ");
            
            do {
                col = checkInt();
                if (!(row >= 0 && col <= 9)) {
                    System.out.println("Ungueltige Eingabe! \nNochmal: ");
                }
            } while (!(row >= 0 && col <= 9));
            
            counter = player.takeHit(row,col);
            defeat();
            
        } while (counter);
    }

    /**
    Methode, die die Schiffe im Feld des Spielers plaziert.
    */
    private void setShips(){
        
        int counter = 1;
        int input;
        
        int battleshipCount, cruiserCount, destroyerCount, submarineCount;

        battleshipCount = BATTLESHIP;
        cruiserCount = CRUISER;
        destroyerCount = DESTROYER;
        submarineCount = SUBMARINE;

        System.out.print(player.toString());
        
        do {
            System.out.println("\nDu hast noch " + battleshipCount + " Schlachtschiff!");
            System.out.println("Du hast noch " + cruiserCount + " Kreuzer!");
            System.out.println("Du hast noch " + destroyerCount + " Zerstoerer!");
            System.out.println("Du hast noch " + submarineCount + " U-Boote!");
            
            do {
                System.out.print("\nWas moechtest du tun?\n(1) Schlachtschiff setzen\n(2) Kreuzer setzen\n"
                         + "(3) Zerstoerer setzen\n(4) U-Boote setzen\n");
                input = checkInt();
                
                switch (input) {
                    case 1: 
                        if (battleshipCount == 0) {
                            System.out.print("Es gibt keine Schlachtschiffe mehr!\n");
                            break;
                        }
                        player.setBattleshipsInArray(5);
                        battleshipCount--;
                        counter = 0;
                        break;
                    case 2: 
                        if (cruiserCount == 0) {
                            System.out.print("Es gibt keine Kreuzer mehr!\n");
                            break;
                        }
                        player.setBattleshipsInArray(4);
                        cruiserCount--;
                        counter = 0;
                        break;
                    case 3: 
                        if (destroyerCount == 0) {
                            System.out.print("Es gibt keine Zerstoerer mehr!\n");
                            break;
                        }
                        player.setBattleshipsInArray(3);
                        destroyerCount--;
                        counter = 0;
                        break;
                    case 4: 
                        if (submarineCount == 0) {
                            System.out.print("Es gibt keine U-Boote mehr!\n");
                            break;
                        }
                        player.setBattleshipsInArray(2);
                        submarineCount--;
                        counter = 0;
                        break;
                    default: System.out.print("Bitte waehle aus den Optionen (1), (2), (3) oder (4) aus!");
                        counter = 1;
                        break;
                }
            } while (counter == 1);
        
        } while (!(battleshipCount == 0 && cruiserCount == 0 && destroyerCount == 0 && submarineCount == 0));
    }   
    
    /**
    Die Methode ueberprueft ob eine Eingabe ein 
    Integer ist und verlangt sonst die Eingabe eines Integers.
    @return Gibt die Eingabe als Integer zurück.
    */
    public static int checkInt() {
    
        //Scanner check = new Scanner(System.in);
        //scan.nextLine();
        int input;
        
        // Ueberprueft ob die Eingabe ein Integer ist            
        while (!scan.hasNextInt()) {
            scan.next();
            System.out.print("Ungueltige Eingabe! Nochmal: ");
        }
        input = scan.nextInt();
        scan.nextLine();
        //Rueckgabe des Eingabewertes als Integer
        return input;
    }

    /**
    Die Methode ueberprueft, ob die Einegabe ein char zwischen A und J ist und verlangt
    sonst die Einabe eines chars, der Zwischen A und J liegt. Zudem konvertiert die Methode
    die Buchstaben in Integer in der Form a=0, A=0 -> j=9, J=9.
    @return gibt die char Eingabe als konvertierten Integer zurück.
    */
    public static int convertChar() {

        //Scanner scan = new Scanner(System.in);
        //scan.nextLine();
        String inputAsString;
        char inputAsChar;
        int inputAsInt, convertedInt = 0, counter = 0;

        do {
            inputAsString = scan.next();
            if (inputAsString.length() == 1) {                  //ueberprueft, ob ein einzelnes Zeichen eingegeben wurde
                inputAsChar = inputAsString.charAt(0);          //Konvertierung String->Char
                inputAsInt = (int) inputAsChar;                 //Konvertierung Char->Int

                if (inputAsInt >= 65 && inputAsInt <= 74) {         //Grossbuchstaben A bis J
                    convertedInt = inputAsInt - 65;
                    counter = 1;
                } else if (inputAsInt >= 97 && inputAsInt <= 106) {      //Kleinbuchstaben a bis j
                    convertedInt = inputAsInt - 97;
                    counter = 1;
                } else {
                    counter = 0;
                    scan.nextLine();
                    System.out.print("Ungueltige Eingabe! Bitte eine Zeile zwischen A und J waehlen. \nZeile: ");
                }
            } else {
                counter = 0;
                scan.nextLine();
                System.out.println("Unguelitge Eingabe! Bitte eine Zeile zwischen A und J waehlen. \nZeile: ");
            }
        } while (counter == 0);
        scan.nextLine();
        return convertedInt;
    }    
    
}
