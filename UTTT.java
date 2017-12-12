public class UTTT{

    public static void main(String [] args){
	//initializing
	BigSquare board = new BigSquare();
	int currIndex = 0, nextIndex = 0;
	char cPlayer;

	//run game
	while(!board.isOver()){
	    cPlayer = board.getPlayer(); //begins at turn 1
	    currIndex = nextIndex;
	    if( (board.getTurn() == 1) || board.getSquare(currIndex).isOver())
		currIndex = board.freebie();
	    nextIndex = board.normalTurn(currIndex);
	    board.getSquare(currIndex).setSquare(nextIndex,cPlayer);
	    if(board.getSquare(currIndex).isOver() && !(board.getSquare(currIndex).getIndex(0) == '-')){
		board.setBBoard(currIndex,cPlayer);
		board.getSquare(currIndex).setWinner(cPlayer);
		continue;
	    }
	    else
		board.setBBoard(currIndex,'-');
	    

	}	

    }  
}
/*testing
  board.getSquare(2).setSquare(3,'x');
  board.getSquare(2).setSquare(7,'o');
  board.getSquare(2).setSquare(4,'x');
  board.getSquare(2).setSquare(1,'o');
  board.getSquare(2).populate();
  board.printBoard();
  System.out.println("User places 'x' in 6");
  board.getSquare(2).setSquare(5,'x');
  System.out.println(board.getSquare(2).isOver());
  board.getSquare(2).setWinner('x');
  System.out.println();
  System.out.println("=====================================================");
  System.out.println();
  board.getSquare(2).unpopulate();
  board.getSquare(5).setSquare(2,'x');
  board.getSquare(7).setSquare(8,'o');
  board.printBoard();
  System.out.println("=====================================================");
  board.getBBoard().printBoard();
	
  System.out.println("=====================================================");
  System.out.println("Index return: " + board.freebie());
*/
