import java.util.Scanner;

public class UTTT{

    public static void main(String [] args){
	//initializing
	BigSquare board = new BigSquare();
	int currIndex = 0, nextIndex = 0;
	char cPlayer;
	boolean _2p = true;

	//play AI or 2 player
	Scanner s = new Scanner(System.in);
	System.out.print("Game Modes:\n1. 2 Player (2p)\n2. Computer (AI)\nPick a game mode: ");
	String ans = s.next();
	while(!(ans.equals("2p") || ans.equals("AI"))){
	    System.out.println("Please 2p or AI!");
	    System.out.print("Pick a game mode: ");
	    ans = s.next();
	}
	if(ans.equals("AI"))
	    _2p = false;
	
	//run game
	if(_2p)
	    while(!board.isOver()){
		cPlayer = board.getPlayer(); //begins at turn 1
		currIndex = nextIndex;
		System.out.println("=====================================================");
		System.out.println("It is Player " + cPlayer + "'s turn!");
		if( (board.getTurn() == 1) || board.getSquare(currIndex).isOver())
		    currIndex = board.freebie(_2p);
		nextIndex = board.normalTurn(currIndex, _2p);
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
