import java.util.Scanner;


public class UTTT {

	public static void main(String[] args) {

		while (true) {
			//initializing
			BigSquare board = new BigSquare();
			int currIndex = 0;
			int nextIndex = 0;
			char cPlayer;
			char mode = ' ';


			//play AI or 2 player
			Scanner s = new Scanner(System.in);
			System.out.print("Game Modes:\n1. 2 Player (2p)\n2. Computer (AI)\nPick a game mode: ");
			String ans = s.next();
			while (!(ans.equals("2p") || ans.equals("AI"))) {
				System.out.println("Please enter 2p or AI!");
				System.out.print("Pick a game mode: ");
				ans = s.next();
			}
			if (ans.equals("AI")) {
				System.out.println("=====================================================");
				board.setAI();
			}

			while (!board.isOver()) {
				cPlayer = board.getPlayer();
				currIndex = nextIndex;
				System.out.println("=====================================================");
				if (mode == ' ') {
					System.out.println("It is Player " + cPlayer +"'s turn");
				}
				else {
					System.out.println("Your move");
				}
				if ((board.getTurn() == 1 || board.getSmallSquare(currIndex).isOver())) {
					currIndex = board.freebie(mode);
				}
				nextIndex = board.normalTurn(currIndex, mode);
				board.getSmallSquare(currIndex).setSquare(nextIndex, cPlayer);

				if (board.getSmallSquare(currIndex).isOver() && !(board.getSmallSquare(currIndex).getIndex(0) == '-')){
					board.setBigBoard(currIndex, cPlayer);
					board.getSmallSquare(currIndex).setWinner(cPlayer);
				}
				else if (board.getSmallSquare(currIndex).isOver()) {
					board.setBigBoard(currIndex, '-');
				}
			}

			System.out.println("=====================================================");
			System.out.println("=====================================================");
			if (board.getSmallBoard().getWinner() == '-') {
				System.out.println("The game is over! You tied!");
			}
			else if (mode == ' ') { //2p game
				System.out.println("The game is over! Player " + board.getSmallBoard().getWinner() + " won the game!");
			}
			else { //figure out print if computer wins or player wins
				System.out.println("The game is over! Player " + board.getSmallBoard().getWinner() + " won the game!");
			}
			board.printBoard();

			System.out.print("Play again(y or n): ");
			ans = s.next();
			while (!(ans.equals("y") || ans.equals("n"))) {
				System.out.println("Please enter a valid answer!");
				System.out.print("Play again(y or n): ");
				ans = s.next();
			}
			if (ans.equals("n")) {
				break;
			}
		}
	}
}