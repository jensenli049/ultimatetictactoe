import java.util.Scanner;
import java.util.Random;

public class BigSquare {

	private final char p1 = 'x';
	private final char p2 = 'o';
	private final char tie = '-';

	private SmallSquare[] bigBoard;
	private SmallSquare smallBoard;
	private boolean isOver;
	private boolean AI;
	private char winner;
	private int turn;
	private AI computer;

	public BigSquare() {
		bigBoard = new SmallSquare[9];
		for (int i = 0; i < 9; i++) {
			bigBoard[i] = new SmallSquare();
		}
		smallBoard = new SmallSquare();
		isOver = false;
		AI = false;
		winner = '-';
		turn = 0;
		computer = new AI(bigBoard, smallBoard);
	}

	public SmallSquare[] getBigBoard() {
		return bigBoard;
	}

	public int getTurn() {
		return turn;
	}

	public char getPlayer() {
		turn++;
		if (turn % 2 == 1) {
			return p1;
		}
		else {
			return p2;
		}
	}

	public void setAI() {
		AI = true;
	}

	public SmallSquare getSmallBoard() {
		return smallBoard;
	}

	public boolean isOver() {
		return smallBoard.isOver();
	}

	public char getWinner() {
		return winner;
	}

	public SmallSquare getSmallSquare(int index) {
		return bigBoard[index];
	}

	// unclear
	public void setBigBoard(int index, char win) {
		smallBoard.setSquare(index, win);
	}

	public int freebie(char aiMode) {
		System.out.println("Current Board");
		printBoard();
		System.out.println("=====================================================");
		System.out.println("You have a freebie");
		smallBoard.printBoard();
		int temp = pickSquare(smallBoard, aiMode);
		return temp;
	}

	public int normalTurn(int index, char aiMode) {
		System.out.println("Current Board");
		bigBoard[index].populate();
		printBoard();
		bigBoard[index].unpopulate();
		int ans = pickSquare(bigBoard[index], aiMode);
		return ans;
	}

	public int pickSquare(SmallSquare tttBoard, char aiMode) {
		int[] unused = new int[9];
		tttBoard.populate();
		for (char x : tttBoard.getBoard()) {
			int tmp = x - '0';
			if (tmp < 10 && tmp > 0) {
				unused[tmp - 1] = tmp;
			}
		}
		Scanner reader = new Scanner(System.in);
		int num = 0;
		if (!AI) { // If 2p game
			while (!findVal(unused, num)) {
				System.out.print("Please enter a numbered square: ");
				while (!reader.hasNextInt()) {
					System.out.print("Please enter a numbered square: ");
					reader.next();
				}
				num = reader.nextInt();
			}
		}
		else { // AI Game
			if (turn % 2 == 1) { // If player's turn
				while (!findVal(unused, num)) {
					System.out.print("Please enter a numbered square: ");
					while (!reader.hasNextInt()) {
						System.out.print("Please enter a numbered square: ");
						reader.next();
					}
					num = reader.nextInt();
				}
			}
			else { // AI turn
//				int bestValue = 99999999;
//				for (int i = 0; i < 9; i++) {
//					if (tttBoard.getIndex(i) != p1 && tttBoard.getIndex(i) != p2 && tttBoard.getIndex(i) != tie) {
//						//printBoard();
//						char copy = tttBoard.getIndex(i); // keeps track of current character
//						tttBoard.setSquare(i, p2); // Minimax AI makes a move
//						int moveValue = computer.MiniMax(bigBoard[i], smallBoard, bigBoard, false, 0);
//						tttBoard.setSquare(i, copy); // undo the move
//						if (moveValue < bestValue){
//							bestValue = moveValue;
//							num = i+1;
//						}
//						if (moveValue == bestValue){
//							int random = new Random().nextInt(2);
//							if (random == 0) {
//								bestValue = moveValue;
//							}
//						}
//					}
//				}
				if (AI && turn % 2 == 1) {
					while (!findVal(unused, num)) {
						System.out.println("Please enter a numbered square");
						while (!reader.hasNextInt()) {
							System.out.println("Please enter a numbered square");
							reader.next();
						}
						num = reader.nextInt();
					}
				}
				else {
					num = computer.getBestMoves(tttBoard, bigBoard, unused);
				}
			}
		}
		tttBoard.unpopulate();
		return num - 1;
	}

	public boolean findVal(int[] arr, int val){
		for (int x : arr) {
			if (x == val && x != 0)
				return true;
		}
		return false;
	}

	public void determineWhoGoesFirst(int number) {
		if (number == 1) {
			turn = turn + 2;
		}
		if (number == 2) {
			turn = turn + 1;
		}
	}

	public void printBoard(){
		String DIVIDER1 = " ---+---+--- | ---+---+--- | ---+---+--- ";
		String DIVIDER2 = "-------------+-------------+-------------";

		String[] temp = new String[81];
		int counter = 0;
		for(int i = 0; i < 3; i++)
			for(int j = 0; j < 3; j++)
				for(int k = 0; k < 3; k++)
					for(int l = 0; l < 3; l++) {
						temp[counter] = bigBoard[i * 3 + k].addColor(bigBoard[i*3 + k].getIndex(j * 3 + l));
						counter++;
					}

		System.out.printf("  %s | %s | %s  |  %s | %s | %s  |  %s | %s | %s  \n", temp[0], temp[1], temp[2], temp[3], temp[4], temp[5], temp[6], temp[7], temp[8]);
		System.out.println(DIVIDER1);
		System.out.printf("  %s | %s | %s  |  %s | %s | %s  |  %s | %s | %s  \n", temp[9], temp[10], temp[11], temp[12], temp[13], temp[14], temp[15], temp[16], temp[17]);
		System.out.println(DIVIDER1);
		System.out.printf("  %s | %s | %s  |  %s | %s | %s  |  %s | %s | %s  \n", temp[18], temp[19], temp[20], temp[21], temp[22], temp[23], temp[24], temp[25], temp[26]);
		System.out.println(DIVIDER2);
		System.out.printf("  %s | %s | %s  |  %s | %s | %s  |  %s | %s | %s  \n", temp[27], temp[28], temp[29], temp[30], temp[31], temp[32], temp[33], temp[34], temp[35]);
		System.out.println(DIVIDER1);
		System.out.printf("  %s | %s | %s  |  %s | %s | %s  |  %s | %s | %s  \n", temp[36], temp[37], temp[38], temp[39], temp[40], temp[41], temp[42], temp[43], temp[44]);
		System.out.println(DIVIDER1);
		System.out.printf("  %s | %s | %s  |  %s | %s | %s  |  %s | %s | %s  \n", temp[45], temp[46], temp[47], temp[48], temp[49], temp[50], temp[51], temp[52], temp[53]);
		System.out.println(DIVIDER2);
		System.out.printf("  %s | %s | %s  |  %s | %s | %s  |  %s | %s | %s  \n", temp[54], temp[55], temp[56], temp[57], temp[58], temp[59], temp[60], temp[61], temp[62]);
		System.out.println(DIVIDER1);
		System.out.printf("  %s | %s | %s  |  %s | %s | %s  |  %s | %s | %s  \n", temp[63], temp[64], temp[65], temp[66], temp[67], temp[68], temp[69], temp[70], temp[71]);
		System.out.println(DIVIDER1);
		System.out.printf("  %s | %s | %s  |  %s | %s | %s  |  %s | %s | %s  \n", temp[72], temp[73], temp[74], temp[75], temp[76], temp[77], temp[78], temp[79], temp[80]);
	}
}