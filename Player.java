/**
Die Klasse Player, Erbe von Arena...
*/
public class Player extends Arena{

    public boolean isAlive(){
    
        int shipCount = 0;
        boolean isAlive = true;
        
        for(int i = 0; i<10; i++){
            for(int j = 0; j<10; j++){
                if (this.grid[i][j] == '#') {
                    shipCount++;
                }
            }
        }
        if(shipCount == 0) {
            isAlive = false;
        }
        
        return isAlive;
    }

    public boolean takeHit(int row, int col){
        
        boolean hit = false;
        
        /*
        Abfrage ob der Angriff ein Treffer war, markieren der Treffer 
        und Nieten
        */        
        if ((this.grid[row][col] == '#') == true) {
            this.grid[row][col] = 'X';
            System.out.print(this.toString());
            System.out.println("\nDu wurdest getroffen!");
            hit = true;
        } else {
            this.grid[row][col] = 'O';
            System.out.print(this.toString());
            System.out.println("\nDu wurdest nicht getroffen!");
            hit = false;
        }
        return hit;
    }

    /**
    Setzt das vom Spieler gewaehlte Schiff in das spielereigene Array und ueberprueft ob die Platzierung 
    konfliktfrei (ueberstehende Schiffe, ueberschneidende Schiffe) ist.
    @param shipLength Die Laenge des zu setzenden Schiffes.
    */

    public void setBattleshipsInArray(int shipLength) {
            
            boolean conflict;
            int input, row, col, failedRow, failedCol;
            char failedRowAlpha;
        
            System.out.print("Die Schiffe werden horizontal oder vertikal von der gewaehlten Koordinate aus platziert!\n");
            do {
                System.out.print("Soll das Schiff (1) horizontal oder (2) vertikal platziert werden?\n");
                input = Game.checkInt();
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
                        row = Game.convertChar();
                        if (!(row >= 0 && row <= 9 )) {
                            System.out.print("Ungueltige Eingabe! Dein Schiff ragt ueber den Spielfeldrand!\nNochmal: ");
                        }
                    } while (!(row >= 0 && row <= 9));     
                    
                    // Spalte
                    System.out.print("Spalte: ");
                    
                    do {
                        col = Game.checkInt();
                        if (!(row >= 0 && col <= 10 - shipLength)) {
                            System.out.print("Ungueltige Eingabe! Dein Schiff ragt ueber den Spielfeldrand!\nNochmal: ");
                        }
                    } while (!(row >= 0 && col <= 10 - shipLength));
                    
                    // Ueberpruefung auf bereits gesetzte Schiffe.
                    for (int i = col; i <= col + shipLength - 1; i++) {
                        if (this.grid[row][i] == '#') {
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
                            this.grid[row][i] = '#';
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
                        row = Game.convertChar();
                        if (!(row >= 0 && row <= 10 - shipLength)) {
                            System.out.print("Ungueltige Eingabe! Dein Schiff ragt ueber den Spielfeldrand!\nNochmal: ");
                        }
                    } while (!(row >= 0 && row <= 10 - shipLength));     
                    
                    // Spalte
                    System.out.print("Spalte: ");
                    
                    do {
                        col = Game.checkInt();
                        if (!(row >= 0 && col <= 9)) {
                            System.out.print("Ungueltige Eingabe! Dein Schiff ragt ueber den Spielfeldrand!\nNochmal: ");
                        }
                    } while (!(row >= 0 && col <= 9));
                    
                     // Ueberpruefung auf bereits gesetzte Schiffe.
                    for (int i = row; i <= row + shipLength - 1; i++) {

                        if (this.grid[i][col] == '#') {
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
                            this.grid[i][col] = '#';
                        } 
                    }
                } while (conflict == true);
                            
            }
            System.out.print(this.toString());
        }

}
