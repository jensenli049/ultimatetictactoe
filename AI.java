import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AI {

	private BigSquare bigBoard;
	private SmallSquare smallBoard;

	public AI() {
	}

	public int getBestMoves(SmallSquare tttBoard, int[] availableSpace) {
		if (1 == 1) {
			return completeRandomness(tttBoard, availableSpace);
		}
		else if (2 == 2) {
			return winBarely(tttBoard, availableSpace);
		}
	}

	public int completeRandomness(SmallSquare tttBoard, int[] availableSpace) {
		char[] boardState = tttBoard.getBoard();
		int random = new Random().nextInt(availableSpace.length);
		return random;
	}

	public int winBarely(SmallSquare tttBoard, int[] availableSpace) {
		int number = 0;
		List<Integer> corners = new ArrayList<>();
		corners.add(0);
		corners.add(2);
		corners.add(6);
		corners.add(8);
		if (availableSpace[4] == 0) {
			number = 4;
		}
		else if (getCorners(tttBoard)) {
			for (int i = 0; i < 4; i++) {
				if (availableSpace[corners.get(i)] == 0) {
					number = corners.get(i);
				}
			}
		}
		else if (canWin(tttBoard)) {

		}
		else {
			return number;
		}
		return number;
	}

	public boolean getCorners(SmallSquare tttBoard) {
		char[] board = tttBoard.getBoard();
		if (board[0] == '-') {
			return true;
		}
		return false;
	}

	public boolean canWin(SmallSquare tttBoard) {
		char[] board = tttBoard.getBoard();
		if (!diagonalWin(board) || verticalWin(board) || horizontalWin(board)) {
			return false;
		}
		return true;
	}

	public boolean diagonalWin(char[] board) {
		if (board[0] = "-"
	}

	public boolean verticalWin(char[] board) {

	}

	public boolean horizontalWin(char[] board) {

	}
}