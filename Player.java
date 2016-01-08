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

}
