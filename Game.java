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
    
        //Scanner scan = new Scanner(System.in);
        int input;
        int counter = 0;
        
        placeBattleships();

        print(player);
        print(opponent);
        
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
                    case 3: print(player);
                        print(opponent);
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
    private void setShips(){
        
        int counter = 1;
        int input;
        
        int battleshipCount, cruiserCount, destroyerCount, submarineCount;

        battleshipCount = BATTLESHIP;
        cruiserCount = CRUISER;
        destroyerCount = DESTROYER;
        submarineCount = SUBMARINE;

        print(player);
        
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
                        setBattleshipsInArray(5);
                        battleshipCount--;
                        counter = 0;
                        break;
                    case 2: 
                        if (cruiserCount == 0) {
                            System.out.print("Es gibt keine Kreuzer mehr!\n");
                            break;
                        }
                        setBattleshipsInArray(4);
                        cruiserCount--;
                        counter = 0;
                        break;
                    case 3: 
                        if (destroyerCount == 0) {
                            System.out.print("Es gibt keine Zerstoerer mehr!\n");
                            break;
                        }
                        setBattleshipsInArray(3);
                        destroyerCount--;
                        counter = 0;
                        break;
                    case 4: 
                        if (submarineCount == 0) {
                            System.out.print("Es gibt keine U-Boote mehr!\n");
                            break;
                        }
                        setBattleshipsInArray(2);
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
    Setzt das vom Spieler gewaehlte Schiff in das spielereigene Array und ueberprueft ob die Platzierung 
    konfliktfrei (ueberstehende Schiffe, ueberschneidende Schiffe) ist.
    @param shipLength Die Laenge des zu setzenden Schiffes.
    */
    public static void setBattleshipsInArray(int shipLength) {
        
        boolean conflict;
        int input, row, col, failedRow, failedCol;
        char failedRowAlpha;
    
        System.out.print("Die Schiffe werden horizontal oder vertikal von der gewaehlten Koordinate aus platziert!\n");
        do {
            System.out.print("Soll das Schiff (1) horizontal oder (2) vertikal platziert werden?\n");
            input = checkInt();
        } while (!(input >= 1 && input <= 2));
        
        // Fragt nach Koordinaten fuer horizontal zu setzende Schiffe 
        // und ueberpreuft ob das Schiff auf das Spielfeld passt.
        if (input == 1) {
            do {
                System.out.print("Wo moechtest du das Schiff platzieren?\n");
                conflict = false;
                
                // Zeile
                System.out.print("Zeile: ");
                
                do {
                    row = convertChar();
                    if (!(row >= 0 && row <= 9 )) {
                        System.out.print("Ungueltige Eingabe! Dein Schiff ragt ueber den Spielfeldrand!\nNochmal: ");
                    }
                } while (!(row >= 0 && row <= 9));     
                
                // Spalte
                System.out.print("Spalte: ");
                
                do {
                    col = checkInt();
                    if (!(row >= 0 && col <= 10 - shipLength)) {
                        System.out.print("Ungueltige Eingabe! Dein Schiff ragt ueber den Spielfeldrand!\nNochmal: ");
                    }
                } while (!(row >= 0 && col <= 10 - shipLength));
                
                // Ueberpruefung auf bereits gesetzte Schiffe.
                for (int i = col; i <= col + shipLength - 1; i++) {
                    if (player[row][i] == '#') {
                        conflict = true;
                        failedRow = row;
                        failedCol = i;
                        failedRowAlpha = (char) (failedRow + 65);
                        System.out.println("Es liegt bereits ein Schiff in Zeile " + failedRowAlpha 
                                + " und Spalte " + failedCol + ".");
                    }
                }
                if (conflict == false) {
                    for (int i = col; i <= col + shipLength - 1; i++) {
                        player[row][i] = '#';
                    } 
                }
            } while (conflict == true); 
            
        // Fragt nach Koordinaten fuer vertikal zu setzende Schiffe 
        // und ueberpreuft ob das Schiff auf das Spielfeld passt.
        } else {
            do {
                System.out.print("Wo moechtest du das Schiff platzieren?\n");
                conflict = false;
                
                // Zeile
                System.out.print("Zeile: ");
                
                do {
                    row = convertChar();
                    if (!(row >= 0 && row <= 10 - shipLength)) {
                        System.out.print("Ungueltige Eingabe! Dein Schiff ragt ueber den Spielfeldrand!\nNochmal: ");
                    }
                } while (!(row >= 0 && row <= 10 - shipLength));     
                
                // Spalte
                System.out.print("Spalte: ");
                
                do {
                    col = checkInt();
                    if (!(row >= 0 && col <= 9)) {
                        System.out.print("Ungueltige Eingabe! Dein Schiff ragt ueber den Spielfeldrand!\nNochmal: ");
                    }
                } while (!(row >= 0 && col <= 9));
                
                 // Ueberpruefung auf bereits gesetzte Schiffe.
                for (int i = row; i <= row + shipLength - 1; i++) {

                    if (player[i][col] == '#') {
                        conflict = true;
                        failedRow = i;
                        failedCol = col;
                        failedRowAlpha = (char) (failedRow + 65);
                        System.out.println("Es liegt bereits ein Schiff in Zeile " + failedRowAlpha 
                                + " und Spalte " + failedCol + ".");
                    }
                }
                if (conflict == false) {
                    for (int i = row; i <= row + shipLength - 1; i++) {
                        player[i][col] = '#';
                    } 
                }
            } while (conflict == true);
                        
        }
        print(player);
    }
    
    /**
    Die Methode ueberprueft ob eine Eingabe ein 
    Integer ist und verlangt sonst die Eingabe eines Integers.
    @return Gibt die Eingabe als Integer zurück.
    */
    public static int checkInt() {
    
        //Scanner check = new Scanner(System.in);
        scan.nextLine();
        int input;
        
        // Ueberprueft ob die Eingabe ein Integer ist            
        while (!scan.hasNextInt()) {
            scan.next();
            System.out.print("Ungueltige Eingabe! Nochmal: ");
        }
        input = scan.nextInt();
        
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
        scan.nextLine();
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

        return convertedInt;
    }    
    
}
