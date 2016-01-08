/**
Die Klasse Player, Erbe von Arena...
*/
public class Player extends Arena{

    public boolean isAlive(){
    
        int shipCount = 0;
        boolean isAlive = true;
        
        for(int i = 0; i<10; i++){
            for(int j = 0; j<10; j++){
                if (this.grid[i][j] == #) {
                    shipCount++;
                }
            }
        }
        if (shipCount == 0) {
            isAlive = false;
        }
        
        return isAlive;
    }

    //public boolean takeHit(int row, int column){}

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

}
