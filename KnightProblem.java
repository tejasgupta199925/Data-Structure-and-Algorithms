// Knight Problem (Backtracking)
// At any point, knight has 8 different positions to move.

import java.util.*;
public class Main {
    // int d=8;
    public static void main(String args[]) {
        Scanner sc=new Scanner(System.in);
        int d=8;
        int n=sc.nextInt();                                // board dimension
        int[][] board=new int[n][n];                       // Initially all set to 0.
        
        
        // First Move (placing knight to (0,0))
        board[0][0]=1;
        solveKnightMove(board,n,1,0,0);                    // (board,dimension,last move taken,row and column of latest position)

    }

/* At any place, a knight has 8 options or possible cells that can be visited. Their rows and columns will be either +1,+2,-1,-2 from current 
   coords. Put all these in an order in 2 different sequences for row and col respectively. E.g. if we are standing at (2,3) and we want next 8 
   possible coords, then we can use both sequences and add respective values to current coords, e.g. (2,3)-->(4,4). So we can go from (2,2) to 
   (4,4) and if this is not visited previously and within the board, then we can go there.*/
    public static boolean solveKnightMove(int board[D][D],int n,int move_no,int curRow,int curCol){
        if(move_no==64){
            return true;
        }

        int[] rowDir = {2,1,-1,-2,-2,-1,1,2};
        int[] colDir = {1,2,2,1,-1,-2,-2,-1};
        for(int curDir=0;curDir<8;curDir++){
            int nextRow = curRow+rowDir[curDir];
            int nextCol = curCol+colDir[curDir];
            
            // If nextrow and col are within board and haven't been visited 
            if(canPlace(board,n,nextRow,nextCol)==true){
                // Place the knight
                board[nextRow][nextCol] = move_no+1;

                // Now we'll ask recursion to go ahead and find further solutions
                boolean isSuccessful = solveKnightMove(board,n,move_no+1,nextRow,nextCol);
                
                // If successful at further level, then we don't have to do anything at current level
                if(isSuccessful==true){
                    return true;
                }
                // If unsuccessful, then we will have to remove our current knight.
                board[nextRow][nextCol] = 0;                                 // Removing knight

            }
            // Till here, we're inside for loop, so if current position fails, then the loop moves forward and we test for next position.
        }
        return false;                                                      // Not possible, i.e., failing for all directions.
    }

    public static boolean canPlace(int board[D][D],int n,int r,int c){
        return r>=0 && r<n && c>=0 && c<n && board[r][c]==0;
    }
}