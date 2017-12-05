public class SmallSquare{
    
    private char[] _sttt;
    private char _winner;
    private boolean _gameover;

    public SmallSquare(){
	_sttt = new char[9];
	for(int i = 0; i < 9; i++)
	    _sttt[i] = ' ';
	_gameover = false;
	_winner = '-';
    }

    public char[] getBoard(){
	return _sttt;
    }

    public char getWinner(){
	return _winner;
    }
    
    public boolean isOver(){
	return _gameover;
    }

    public void setWinner(char player){
	_gameover = true;
	_winner = player;
    }

    public void setSquare(int index, char player){
	_sttt[index] = player;
    }

    public void populate(){
	for(int i = 0; i < 9; i++)
	    if(!(_sttt[i] == 'x' || _sttt[i] == 'o'))
		_sttt[i] = (char)(i+'1');
    }
    public void unpopulate(){
	for(int i = 0; i < 9; i++)
	    if(!(_sttt[i] == 'x' || _sttt[i] == 'o'))
		_sttt[i] = ' ';
    }

    public void printBoard(){
	System.out.print("[ ");
	for(char x : _sttt)
	    System.out.print(x + " ");
	System.out.println("}");
    }
}
