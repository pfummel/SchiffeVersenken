/**
Die Klasse Arena vereint die gemeinsamen Aspekte der 
zwei Spielfelder und wird sowohl von der Klasse Player, 
als auch von Enemy beerbt.
@author David Nancekievill Matrikelnummer Gruppe C
@author Markus Berning Matrikelnummer Gruppe C
*/
public class Arena {

    /**
    zweidimensionales Array, das als Spielfeld dient
    */
    protected char[][] grid;

    /**
    Konstruktor, der ein Spielfeld der Groeße 10x10 erzeugt und mit Wasser initialisiert.
    */
    public Arena() {
        this.grid = new char[10][10];

        for (int i = 0; i < 10; i++) {
        
            for (int j = 0; j < 10; j++) {
            
                this.grid[i][j] = '.';
            }
        }
    }

    /**
    Die Methode ueberschreibt die vorhandene toString Methode 
    und gibt das Spielfeld in Form eines Stringes zurueck.
    @return Spielfeld als String
    */
    public String toString() {

        char[] rowAlpha = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'};
        
        String arenaToString;
        arenaToString = "\n " + "0123456789" + "\n";
        for (int i = 0; i < grid.length; i++) {
            arenaToString += rowAlpha[i];
            for (int n = 0; n < grid.length; n++) {
                arenaToString += grid[i][n];
                if (n == grid.length - 1) {
                    arenaToString += "\n";
                }
            }
        }
        arenaToString += "\n";
        return arenaToString;
    }
}
