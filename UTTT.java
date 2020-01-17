import java.util.Scanner;

public class UTTT{ //main function to run game
	
	public static void main(String [] args){
		while (true){
			//initializing
			BigSquare board = new BigSquare(); //keeps track of main board
			int currIndex = 0, nextIndex = 0; //Keeps track of 
			char cPlayer; //used to keep track of player x or player o
			char mode = ' '; //used to determine if AI or 2p
			
			
			//play AI or 2 player
			Scanner s = new Scanner(System.in); //starts game selection
			System.out.print("Game Modes:\n1. 2 Player (2p)\n2. Computer (AI)\nPick a game mode: ");
			String ans = s.next(); //gets player response 
			while(!(ans.equals("2p") || ans.equals("AI"))){ //requires player to enter either 2p or AI
				System.out.println("Please enter 2p or AI!");
				System.out.print("Pick a game mode: ");
				ans = s.next();
			}
			if(ans.equals("AI")){ //case of AI
				System.out.println("=====================================================");
				System.out.print("Computer modes:\n1. Random (r)\n2. Blocking (b)\n3. Thinking (t)\nPick a computer mode: ");
				while(!(ans.equals("r") || ans.equals("b") || ans.equals("t") || ans.equals("f"))){ //requires player to enter one of the AI char
					System.out.println("Please enter r, b or t!");
					System.out.print("Pick a computer mode: ");
					ans = s.next();
				}
				mode = ans.charAt(0);
				board.setAI(true);
			}
			
			//run game
			while(!board.isOver()){ //while there is no winner
				cPlayer = board.getPlayer(); //begins at turn 1
				currIndex = nextIndex;
				System.out.println("=====================================================");
				//-------------------------------------------
				if(mode == ' ')
					System.out.println("It is Player " + cPlayer + "'s turn!");
				else
					System.out.println("Your move!");
				//-------------------------------------------
				if( (board.getTurn() == 1) || board.getSquare(currIndex).isOver())
					currIndex = board.freebie(mode);
				
				nextIndex = board.normalTurn(currIndex, mode);
				board.getSquare(currIndex).setSquare(nextIndex,cPlayer);
				
				if(board.getSquare(currIndex).isOver() && !(board.getSquare(currIndex).getIndex(0) == '-')){
					board.setBBoard(currIndex,cPlayer);
					board.getSquare(currIndex).setWinner(cPlayer);
				}
				else if(board.getSquare(currIndex).isOver())
					board.setBBoard(currIndex,'-');
				if(!(mode == ' '))
					board.setAI(!board.getAI());
			}
			System.out.println("=====================================================");
			System.out.println("=====================================================");
			if(board.getBBoard().getWinner() == '-')
				System.out.println("The game is over! You tied!");
			else if(mode == ' ') //2p game
				System.out.println("The game is over! Player " + board.getBBoard().getWinner() + " won the game!");
			else //figure out print if computer wins or player wins
				System.out.println("The game is over! Player " + board.getBBoard().getWinner() + " won the game!");
			board.printBoard();
			
			//play again
			System.out.print("Play again(y or n): ");
			ans = s.next();
			while(!(ans.equals("y") || ans.equals("n"))){
				System.out.println("Please enter a valid answer!");
				System.out.print("Play again(y or n): ");
				ans = s.next();
			}
			if(ans.equals("n"))
				break;
			
		}  
	}
}
