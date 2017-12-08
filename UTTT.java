public class UTTT{

    public static void main(String [] args){
	//initializing
	BigSquare board = new BigSquare();

	/*testing*/
	board.getSquare(2).setSquare(3,'x');
	board.getSquare(2).setSquare(7,'o');
	board.getSquare(2).setSquare(4,'x');
	board.getSquare(2).setSquare(1,'o');
	board.getSquare(2).populate();
	board.printBoard();
	System.out.println("User places 'x' in 6");
	board.getSquare(2).setSquare(5,'x');
	System.out.println(board.getSquare(2).isOver());
	board.getSquare(2).setWinner('x');
	System.out.println();
	System.out.println("=====================================================");
	System.out.println();
	board.getSquare(2).unpopulate();
	board.getSquare(5).setSquare(2,'x');
	board.getSquare(7).setSquare(8,'o');
	board.printBoard();
	System.out.println("=====================================================");
	board.getBBoard().printBoard();
	

	
    }
	
}
