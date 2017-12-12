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
	    System.out.println("=====================================================");
	    System.out.println("It is Player " + cPlayer + "'s turn!");
	    if( (board.getTurn() == 1) || board.getSquare(currIndex).isOver())
		currIndex = board.freebie();
	    nextIndex = board.normalTurn(currIndex);
	    board.getSquare(currIndex).setSquare(nextIndex,cPlayer);

	    if(board.getSquare(currIndex).isOver() && !(board.getSquare(currIndex).getIndex(0) == '-')){
		board.setBBoard(currIndex,cPlayer);
		board.getSquare(currIndex).setWinner(cPlayer);
	    }
	    else if(board.getSquare(currIndex).isOver())
		board.setBBoard(currIndex,'-');
	}
	System.out.println("=====================================================");
	System.out.println("=====================================================");
	if(board.getBBoard().getWinner() == '-')
	    System.out.println("The game is over! Both Players tied!");
	else
	    System.out.println("The game is over! Player " + board.getBBoard().getWinner() + " won the game!");
	board.printBoard();
    }  
}
