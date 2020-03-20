//import java.util.ArrayList;
//import java.util.List;
//import java.util.Random;

public class AI {

	//private BigSquare bigBoard;
	//private SmallSquare smallBoard;

	public AI() {
	}

	public int evaluateBoard(SmallSquare current, int depth) {
		int value = 0; // Unwon board
		
		if (current.isOver()) {
			value = 100; // Winning a board is worth 100
			if (depth % 2 == 1) { // AI has a negative value
				value *= -1;
			}
			if (current.getWinner() == '-') { // Case of a tie
				value = 0;
			}
		}
		return value; //
	}

	public int MiniMax(SmallSquare current, SmallSquare main, SmallSquare[] completeBoard , boolean aiTurn, int depth) {
		current.populate();
		int value = evaluateBoard(current, depth);
		
		// Base Cases
		if (current == main && value != 0){ // indicates someone won the game
			current.unpopulate();
			return value * 10;
		}
		if (current == main && current.isOver()) { // case of tie
			current.unpopulate();
			return 0;
		}
		if (depth > 2) { // limit depth so search doesn't take forever 
			current.unpopulate();
			return 0;
		}
		
		if (aiTurn) { // AI Turn
			value = 10000;
			for (int i = 0; i < 9; i++) {
				if (current.getIndex(i) != 'x' && current.getIndex(i) != 'o' && current.getIndex(i) != '-') {
					current.runningMiniMax();
					char copy = current.getIndex(i);
					current.setSquare(i, 'o');
					value = Math.min(value, MiniMax(completeBoard[i], main, completeBoard, !aiTurn, depth+1));
					current.setSquare(i, copy);
					current.runningMiniMax();
				}
			}
			current.unpopulate();
			return value;
		}
		else { // Player Turn
			value = -10000;
			for (int i = 0; i < 9; i++) {
				if (current.getIndex(i) != 'x' && current.getIndex(i) != 'o' && current.getIndex(i) != '-') {
					current.runningMiniMax();
					char copy = current.getIndex(i);
					current.setSquare(i, 'x');
					value = Math.max(value, MiniMax(completeBoard[i], main, completeBoard, !aiTurn, depth+1));
					current.setSquare(i, copy);
					current.runningMiniMax();
				}
			}
			current.unpopulate();
			return value;
		}
	}
	/*
		// Making a deep copy of current board for resetting
		SmallSquare copy = new SmallSquare();
		char[] boardCopy = new char[9];
		copy = current;
		for (int i = 0; i < 9; i++) {
			boardCopy[i] = current.getIndex(i);
		}
		
		// Resetting current board
		current = copy;
		for (int i = 0; i < 9; i++) {
			current.setSquare(i, boardCopy[i]);
		}
	*/
	/*
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

	}*/
}