/**
Die Klasse Arena vereint die gemeinsamen Aspekteder zwei Spielfelder und wird sowohl von der Klasse Player, als auch von Enemy beerbt.
*/
public class Arena{

    /**
    zweidimensionales Array, das als Spielfeld dient
    */
    public char[][] grid;

    /**
    Konstruktor, der ein Spielfeld der Groeße 10x10 erzeugt und mit Wasser initialisiert.
    */
    public Arena(){
        this.grid = new char[10][10];

        for(int i = 0; i<10; i++){
            for(int j = 0; j<10; j++){
            
                this.grid[i][j] = '0';
            }
        }
    }

    /**
    ...
    */
    public String toString(){

        char[] rowAlpha = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'};
        
        System.out.println("\n " + "0123456789");
        for (int i = 0; i < grid.length; i++) {
            //System.out.print(rowAlpha[i]);
            for (int n = 0; n < grid.length; n++) {
                //System.out.print(grid[i][n]);
            }
            //System.out.print("\n");
        }
    }
}
