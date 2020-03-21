import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AI {

	private int depthLimit;


	public AI(SmallSquare[] bigBoard, SmallSquare smallBoard) {
		depthLimit = 3;
	}
	//	public int evaluateBoard(SmallSquare current, int depth) {
//		int value = 0; // Unwon board
//
//		if (current.isOver()) {
//			value = 100; // Winning a board is worth 100
//			if (depth % 2 == 1) { // AI has a negative value
//				value *= -1;
//			}
//			if (current.getWinner() == '-') { // Case of a tie
//				value = 0;
//			}
//		}
//		return value; //
//	}
//
//	public int MiniMax(SmallSquare current, SmallSquare main, SmallSquare[] completeBoard , boolean aiTurn, int depth) {
//		current.populate(); // Populates so the isOver function doesn't evaluate many blanks spots
//		int value = evaluateBoard(current, depth);
//
//		// Base Cases
//		if (current == main && value != 0){ // indicates someone won the game
//			current.unpopulate();
//			return value * 10;
//		}
//		if (current == main && current.isOver()) { // case of tie
//			current.unpopulate();
//			return 0;
//		}
//		if (depth > 2) { // limit depth so search doesn't take forever
//			current.unpopulate();
//			return 0;
//		}
//
//		// Main Minimax
//		if (aiTurn) { // AI Turn
//			value = 10000;
//			for (int i = 0; i < 9; i++) {
//				if (current.getIndex(i) != 'x' && current.getIndex(i) != 'o' && current.getIndex(i) != '-') {
//					current.runningMiniMax();
//					char copy = current.getIndex(i); // keeps track of current character
//					current.setSquare(i, 'o'); // Minimax AI makes a move
//					value = Math.min(value, MiniMax(completeBoard[i], main, completeBoard, !aiTurn, depth+1));
//					current.setSquare(i, copy); // undo the move
//					current.stoppedMiniMax();
//				}
//			}
//			current.unpopulate();
//			return value;
//		}
//		else { // Player Turn
//			value = -10000;
//			for (int i = 0; i < 9; i++) {
//				if (current.getIndex(i) != 'x' && current.getIndex(i) != 'o' && current.getIndex(i) != '-') {
//					current.runningMiniMax();
//					char copy = current.getIndex(i); // keeps track of current character
//					current.setSquare(i, 'x'); // Minimax player makes a move
//					value = Math.max(value, MiniMax(completeBoard[i], main, completeBoard, !aiTurn, depth+1));
//					current.setSquare(i, copy); // undo the move
//					current.stoppedMiniMax();
//				}
//			}
//			current.unpopulate();
//			return value;
//		}
//	}


	public int getBestMoves(SmallSquare tttBoard, SmallSquare[] bigBoard, int [] availableSpace) {
		if (2 == 1) {
			return completeRandomness(availableSpace);
		}
		else if (3 == 3) {
			return move(tttBoard, bigBoard);
		}
		else {
			return 3;
		}
	}

	public int completeRandomness(int[] availableSpace) {
		int random = new Random().nextInt(availableSpace.length);
		return random;
	}


	public int move(SmallSquare tttBoard, SmallSquare[] bigBoard) {
		if (true) {
			return minimax(tttBoard, bigBoard, 0, 0);
		}
		return 0;
	}

	public int minimax(SmallSquare tttBoard, SmallSquare[] bigTTT, int depth, int who) {
		if (depth == 15) {
			return staticEval(tttBoard, bigTTT);
		}
		if (who == 0) {
			makeStack(tttBoard, depth, who);

		}
		return 0;
	}

	public ArrayList<ArrayList<Integer>> makeStack(SmallSquare tttBoard, int depth, int whoseTurn) {
		ArrayList<ArrayList<Integer>> successors = new ArrayList<>();
		SmallSquare something = tttBoard;
		List<Integer> availableSpaces = tttBoard.availableSpaces();
		ArrayList<Integer> evaluation = new ArrayList<>();
		if (depth == 3) {
			int value = staticEval(smallBoard, bigBoard);
			evaluation.add(value);
		}
		if (depth < 3) {
			int who = whoseTurn;
			for (int index : availableSpaces) {
				mark(tttBoard, index, who);
				makeStack(bigBoard[index], depth + 1,1 - whoseTurn);
				unmark(tttBoard, index);
			}
		}
		return successors;
	}

	public void mark(SmallSquare tttBoard, int index, int who) {
		char player;
		if (who == 1) {
			player = 'x';
		}
		else {
			player = 'o';
		}
		tttBoard.setSquare(index, player);
	}

	public void unmark(SmallSquare tttBoard, int index) {
		tttBoard.setSquare(index, '-');
	}

	public int staticEval(SmallSquare tttBoard, SmallSquare[] bigTTT) {
		return 0;
	}

}