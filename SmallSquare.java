public class SmallSquare {

	private char[] smallBoard;
	private char winner;
	private boolean gameOver;
	private int state = 0;

	public SmallSquare() {
		smallBoard = new char[9];
		for (int i = 0; i < 9; i++) {
			smallBoard[i] = ' ';
		}
		gameOver = false;
		winner = '-';
	}

	public char[] getBoard() {
		return smallBoard;
	}

	public char getIndex(int val) {
		return smallBoard[val];
	}

	public char getWinner() {
		return winner = smallBoard[0];
	}

	public void populate() {
		for (int i = 0; i < 9; i++) {
			if(!(smallBoard[i] == 'x' || smallBoard[i] == 'o' || smallBoard[i] == '-'))
				smallBoard[i] = (char) (i + '1');
		}
	}

	public void unpopulate() {
		for (int i = 0; i < 9; i++) {
			if(!(smallBoard[i] == 'x' || smallBoard[i] == 'o' || smallBoard[i] == '-'))
				smallBoard[i] = ' ';
		}
	}

	public boolean setWinner(char player) {
		if (gameOver) {
			winner = player;
		}
		for (int i = 0; i < smallBoard.length; i++) {
			smallBoard[i] = player;
		}
		return gameOver = true;
	}


	public boolean isOver() {
		populate();
		if ((smallBoard[0] == smallBoard[1] && smallBoard[1] == smallBoard[2]) ||
				(smallBoard[0] == smallBoard[3] && smallBoard[3] == smallBoard[6]) ||
				(smallBoard[0] == smallBoard[4] && smallBoard[4] == smallBoard[8]))
			return setWinner(smallBoard[0]);
		if ((smallBoard[3] == smallBoard[4] && smallBoard[4] == smallBoard[5]) ||
				(smallBoard[1] == smallBoard[4] && smallBoard[4] == smallBoard[7]) ||
				(smallBoard[2] == smallBoard[4] && smallBoard[4] == smallBoard[6]))
			return setWinner(smallBoard[4]);
		if ((smallBoard[6] == smallBoard[7] && smallBoard[7] == smallBoard[8]) ||
				(smallBoard[2] == smallBoard[5] && smallBoard[5] == smallBoard[8]))
			return setWinner(smallBoard[8]);
		unpopulate();
		for (char x : smallBoard) {
			if (x == ' ') {
				return false;
			}
		}
		setWinner('-');
		return gameOver = true;
	}

	public void setSquare(int index, char player) {
		smallBoard[index] = player;
	}

	public String addColor (char z) {
		String ANSI_RED = "\u001B[31m";
		String ANSI_CYN = "\u001B[36m";
		String ANSI_YLW = "\u001B[33m";
		String ANSI_RST = "\u001B[0m";

		if (z == 'x') {
			return ANSI_RED + z + ANSI_RST;
		}
		if (z == 'o') {
			return ANSI_CYN + z + ANSI_RST;
		}
		return ANSI_YLW + z + ANSI_RST;
	}

	public void printBoard() {
		populate();
		String s1 = "             |             |            \n";
		String s2 = " ------------+-------------+------------\n";
		System.out.print(s1+s1);
		System.out.printf("      %s      |      %s      |      %s      \n",addColor(smallBoard[0]),addColor(smallBoard[1]),addColor(smallBoard[2]));
		System.out.print(s1+s1+s2+s1+s1);
		System.out.printf("      %s      |      %s      |      %s      \n",addColor(smallBoard[3]),addColor(smallBoard[4]),addColor(smallBoard[5]));
		System.out.print(s1+s1+s2+s1+s1);
		System.out.printf("      %s      |      %s      |      %s      \n",addColor(smallBoard[6]),addColor(smallBoard[7]),addColor(smallBoard[8]));
		System.out.print(s1+s1);
		unpopulate();
	}
}