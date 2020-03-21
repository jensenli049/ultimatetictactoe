import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AI {

	private int depthLimit;

	public AI(SmallSquare[] bigBoard, SmallSquare smallBoard) {

		depthLimit = 3;
	}

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