import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AI {

	private int depthLimit;


	public AI() {
		depthLimit = 3;
	}
	
	public int evaluateBoard(SmallSquare current) {
		int value = 0; // Unwon board

		if (current.isOver()) {
			value = 100; // Winning a board is worth 100
			if (current.getWinner() == '-') { // Case of a tie
				value = 0;
			}
		}
		return value; //
	}

	public int MiniMax(SmallSquare current, SmallSquare main, SmallSquare[] completeBoard , boolean aiTurn, boolean freebie, int depth) {
		current.populate(); // Populates so the isOver function doesn't evaluate many blanks spots
		int value = evaluateBoard(current);

		// Base Cases
		if (current == main && value != 0){ // indicates someone won the game
			current.unpopulate();
			if (aiTurn) { // AI won
				return value * -10;
			}
			return value * 10; // Player won
		}
		if (current == main && current.isOver()) { // case of tie
			current.unpopulate();
			return 0;
		}
		if (depth > depthLimit) { // limit depth so search doesn't take forever
			//current.unpopulate();
			return 0;
		}
		if (freebie){ // If there is a freebie
			//System.out.println("5555555555555555555555555555555555555");
			for (int i = 0; i < 9; i++) { // Loop through empty spots in board
				if (current.getIndex(i) != 'x' && current.getIndex(i) != 'o' && current.getIndex(i) != '-') {
					completeBoard[i].runningMiniMax();
					MiniMax(completeBoard[i], main, completeBoard, aiTurn, false, depth);
					completeBoard[i].stoppedMiniMax();
				}
			}
		}

		// Main Minimax
		if (aiTurn) { // AI Turn
			value = 1000000;
			for (int i = 0; i < 9; i++) { // Normal AI Turn
				if (current.getIndex(i) != 'x' && current.getIndex(i) != 'o' && current.getIndex(i) != '-') {
					current.runningMiniMax();
					char copy = current.getIndex(i); // keeps track of current character
					current.setSquare(i, 'o'); // Minimax AI makes a move
					completeBoard[i].runningMiniMax();
					if (completeBoard[i].isOver()){ // If next board is won ==> freebie
						//System.out.println("11111111111111111111111111111111111111111111111111111111111111111");
						main.runningMiniMax();
						value = Math.min(200, MiniMax(main, main, completeBoard, false, true, depth+1));
						main.stoppedMiniMax();
					}
					else { // Next board is not won
						//System.out.println("222222222222222222222222222222222222222222222222222222222222222");
						value = Math.min(value, MiniMax(completeBoard[i], main, completeBoard, false, false, depth+1));
					}
					completeBoard[i].stoppedMiniMax();
					current.setSquare(i, copy); // undo the move
					current.stoppedMiniMax();
				}
			}
			current.unpopulate();
			return value;
		}
		else { // Player Turn
			value = -1000000;
			for (int i = 0; i < 9; i++) { // Normal Player Turn
				if (current.getIndex(i) != 'x' && current.getIndex(i) != 'o' && current.getIndex(i) != '-') {
					current.runningMiniMax();
					char copy = current.getIndex(i); // keeps track of current character
					current.setSquare(i, 'x'); // Minimax player makes a move
					completeBoard[i].runningMiniMax();
					if (completeBoard[i].isOver()){ // If next board is won ==> freebie
						//System.out.println("33333333333333333333333333333333333333333333333333333");
						main.runningMiniMax();
						value = Math.max(-200, MiniMax(main, main, completeBoard, true, true, depth+1));
						main.stoppedMiniMax();
					}
					else { // Next board is not won
						//System.out.println("444444444444444444444444444444444444444444444444");
						value = Math.max(value, MiniMax(completeBoard[i], main, completeBoard, true, false, depth+1));
					}
					completeBoard[i].stoppedMiniMax();
					current.setSquare(i, copy); // undo the move
					current.stoppedMiniMax();
				}
			}
			current.unpopulate();
			return value;
		}
	}


	// public int getBestMoves(SmallSquare tttBoard, SmallSquare[] bigBoard, int [] availableSpace) {
	// 	if (2 == 1) {
	// 		return completeRandomness(availableSpace);
	// 	}
	// 	else if (3 == 3) {
	// 		return move(tttBoard, bigBoard);
	// 	}
	// 	else {
	// 		return 3;
	// 	}
	// }

	// public int completeRandomness(int[] availableSpace) {
	// 	int random = new Random().nextInt(availableSpace.length);
	// 	return random;
	// }


	// public int move(SmallSquare tttBoard, SmallSquare[] bigBoard) {
	// 	if (true) {
	// 		return minimax(tttBoard, bigBoard, 0, 0);
	// 	}
	// 	return 0;
	// }

	// public int minimax(SmallSquare tttBoard, SmallSquare[] bigTTT, int depth, int who) {
	// 	if (depth == 15) {
	// 		return staticEval(tttBoard, bigTTT);
	// 	}
	// 	if (who == 0) {
	// 		makeStack(tttBoard, depth, who);

	// 	}
	// 	return 0;
	// }

	// public ArrayList<ArrayList<Integer>> makeStack(SmallSquare tttBoard, int depth, int whoseTurn) {
	// 	ArrayList<ArrayList<Integer>> successors = new ArrayList<>();
	// 	SmallSquare something = tttBoard;
	// 	List<Integer> availableSpaces = tttBoard.availableSpaces();
	// 	ArrayList<Integer> evaluation = new ArrayList<>();
	// 	if (depth == 3) {
	// 		int value = staticEval(smallBoard, bigBoard);
	// 		evaluation.add(value);
	// 	}
	// 	if (depth < 3) {
	// 		int who = whoseTurn;
	// 		for (int index : availableSpaces) {
	// 			mark(tttBoard, index, who);
	// 			makeStack(bigBoard[index], depth + 1,1 - whoseTurn);
	// 			unmark(tttBoard, index);
	// 		}
	// 	}
	// 	return successors;
	// }

	// public void mark(SmallSquare tttBoard, int index, int who) {
	// 	char player;
	// 	if (who == 1) {
	// 		player = 'x';
	// 	}
	// 	else {
	// 		player = 'o';
	// 	}
	// 	tttBoard.setSquare(index, player);
	// }

	// public void unmark(SmallSquare tttBoard, int index) {
	// 	tttBoard.setSquare(index, '-');
	// }

	// public int staticEval(SmallSquare tttBoard, SmallSquare[] bigTTT) {
	// 	return 0;
	// }

}