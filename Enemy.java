/**
Die Klasse Enemy, Erbe von Arena...
*/
public class Enemy extends Arena{

    /**
    Variable, in der die Anzahl der Treffer gespeichert werden.
    */
    public int numberOfHits = 0;
    
    /**
    Methode fuer das Markieren von Treffern und Fehlschuessen im gegenerischen Feld
    @param row Zeile, in die geschossen wird
    @param column Spalte, in die geschossen wird
    @param hit true: Treffer false: daneben
    */
    public void set(int row, int column, boolean hit){
        if (hit == true){
            this.grid[row][column] = 'X';
            this.numberOfHits += 1;
        }
        else {
            this.grid[row][column] = 'O';
        }
    }

    /**
    Methode, die die Anzahl der Treffer zurueckgibt
    @return gibt Anzahl der Treffer zurueck
    */
    public int numberOfHits(){
        return this.numberOfHits;
    }

}
