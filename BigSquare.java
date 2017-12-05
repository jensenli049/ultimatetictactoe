public class BigSquare{

    private SmallSquare[] _STTT;
    private int _number;
    private boolean _isOver;
    private char _winner;

    public BigSquare(int number){
	_STTT = new SmallSquare[9];
	_number = number;
	_isOver = false;
	_winner = '-';
    }

    public SmallSquare[] getBoard(){
	return _STTT;
    }

    public int getIndex(){
	return _number;
    }

    public boolean isOver(){
	return _isOver;
    }

    public char getWinner(){
	return _winner;
    }

    public void setWinner(char player){
	_isOver = true;
	_winner = player;
    }
		     
}
