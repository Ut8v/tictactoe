import java.util.Scanner;
public class TicTacToe
{
    private static final int ROW= 3;
    private static final int COL = 3;
    private static String[][]board = new String[ROW][COL];
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        clearBoard();
        display();
        String player = "x";//player equals x when the board clears
        boolean move = true;
      while(move)
      {
          int rowMove=safeInput.getRangedInt(in, "Enter the Row", 0, 2);
          int colMove=safeInput.getRangedInt(in, "Enter the column", 0,2);
          if (!isValidMove(rowMove, colMove))//if it is not a valid move
          {
              System.out.println("Invalid move!!!!");
          }
          else//if it is a valid move
          {
              board[rowMove][colMove]=player;//sets board to player
              display();
              if(isWin(player))
              {
                  display();
                  boolean playAgain = safeInput.getYNConfirm(in,"Do you want to play again[Y/N]");
                  if(playAgain= true)
                  {
                      move=true;
                  }
                  else
                  {
                      move = false;
                  }
              }
              else if(isTie())
              {
                  System.out.println("Its a tie");
                  display();
                  boolean playAgain = safeInput.getYNConfirm(in, "Do you want to play again[Y/N]");
//                  if(playAgain)
//                  {
//                      move=true;
//                  }
//                  else
//                  {
//                      move = false;
//                  }

              }
              else
              {
                  if(player.equals("x"))//if player in the current board equals x, next move will be o
                  {
                      player ="O";
                      System.out.println("O next");
                  }else
                  {
                      player = "x";
                      System.out.println("X next");
                  }
              }
          }
      }

    }
    private static void clearBoard()//sets all the board element to space.
    {
        for(int row = 0; row<ROW; row++)
        {
            for(int col = 0; col<COL; col++)
            {
               board[row][col]="";
            }
        }
    }
    private static void display()//shows the game as well as prompts the user where they want to
            //play
        {

           for(int row = 0; row<ROW; row++) {
               for (int col = 0; col<COL; col++) {
                System.out.print( board[row][col]+" | ");
               }
               System.out.println();
           }
        }

    private static boolean isValidMove(int row, int col)//returns true if there is a space/if it's a valid move
    {
        boolean retVal= false;//sets the return value to false
        if (board[row][col].equals(""))
        {
            retVal=true;
        }
        return retVal;
    }
    private static boolean isRowWin(String player)//returns true id row wins
    {
       for(int row=0; row<ROW; row++){
           if (board[row][0].equals(player)&& board[row][1].equals(player)&board[row][2].equals(player))
           {
               System.out.println("wins by row, player  "+ player);
               return true;
           }
        }
        return false;
    }
    private static boolean isColWin(String player)//returns true if winner is the col
    {
        for(int col=0; col<COL; col++){
            if (board[0][col].equals(player)&& board[1][col].equals(player)&board[2][col].equals(player))
            {
                System.out.println("wins by col, player "+ player);
                return true;
            }
        }
        return false;
    }

    private static boolean isDiagonalWin(String player)
    {
        for(int row=0; row<ROW;row++)
        {
            if(board[0][0].equals(player)&&board[1][1].equals(player)&&board[2][2].equals(player))
            {
                System.out.println(player +" Diagonal win");
                return true;
            }
            else if(board[0][2].equals(player)&&board[1][1].equals(player)&&board[2][0].equals(player))
            {
                System.out.println(player + " Diagonal win");
                return true;
            }
        }
        return false;
    }

    // checks for diagonal win
    //{
//        if (board[0][0].equals(board[1][1]) && board[1][1].equals(board[2][2])) {
//            System.out.println(player + "Wins diagonal");
//            return true;
//
//        } else if (board[0][2].equals(board[1][1]) && board[1][1].equals(board[2][0])) {
//            System.out.println(player + "wins by diagonal");
//            return true;
//        } else {
//            return false;
//        }

    private static boolean isTie()//checks for a tie
    {
      for(int row =0; row<ROW;row++)
      {
          for(int col=0; col<COL; col++)
          {
              if(board[row][col].equals("")) {
                  return false;
              }
          }
      }
      return true;
    }
    private static boolean isWin(String player)//checks for the win
    {
        if(isRowWin(player) || isColWin(player) || isDiagonalWin(player))
        {
            return true;
        }
        return false;
    }

}