public class SmallSquare{
	
	private char[] _sttt;
	private char _winner;
	private boolean _gameover;
	private int state = 0;
	
	
	public SmallSquare(){ //initializing function
		_sttt = new char[9];
		for(int i = 0; i < 9; i++) //creates a char array and sets them to blank
			_sttt[i] = ' ';
		_gameover = false;
		_winner = '-';
	}
	
	public char[] getBoard(){
		return _sttt;
	}
	
	public char getIndex(int val){
		return _sttt[val];
	}
	
	public char getWinner(){
		return _winner = _sttt[0];
	}
	
	public boolean isOver(){ //checks if the board is won
		populate(); //makes sure unfilled squares are distinct
		if((_sttt[0] == _sttt[1] && _sttt[1] == _sttt[2]) ||
		(_sttt[0] == _sttt[3] && _sttt[3] == _sttt[6]) ||
		(_sttt[0] == _sttt[4] && _sttt[4] == _sttt[8]))
			return setWinner(_sttt[0]);
		if((_sttt[3] == _sttt[4] && _sttt[4] == _sttt[5]) ||
		(_sttt[1] == _sttt[4] && _sttt[4] == _sttt[7]) ||
		(_sttt[2] == _sttt[4] && _sttt[4] == _sttt[6]))
			return setWinner(_sttt[4]);
		if((_sttt[6] == _sttt[7] && _sttt[7] == _sttt[8]) ||
		(_sttt[2] == _sttt[5] && _sttt[5] == _sttt[8]))
			return setWinner(_sttt[8]);
		
		unpopulate(); //changes board back
		for( char x : _sttt ) //since setwinner makes all squares the same, returns false if board isn't won or drawn
			if( x == ' ')
				return false;
		setWinner('-'); //case of drawn game
		return _gameover = true;
	}
	
	public boolean setWinner(char player){
		if(_gameover)
			_winner = player;
		for (int i = 0; i < _sttt.length; i++) //changes all the squares in a won board to the winner
			_sttt[i] = player;
		return _gameover = true;
	}
	
	public void setSquare(int index, char player){
		_sttt[index] = player;
	}
	
	public void populate(){ //adds numbers to unfilled squares 
		for(int i = 0; i < 9; i++)
			if(!(_sttt[i] == 'x' || _sttt[i] == 'o' || _sttt[i] == '-'))
				_sttt[i] = (char)(i+'1');
	}
	public void unpopulate(){ //removes numbers from the board
		for(int i = 0; i < 9; i++)
			if(!(_sttt[i] == 'x' || _sttt[i] == 'o' || _sttt[i] == '-'))
				_sttt[i] = ' ';
	}
	
	public String addColor (char z) { //adds colors to certain characters... big surprise
		String ANSI_RED = "\u001B[31m";
		String ANSI_CYN = "\u001B[36m";
		String ANSI_YLW = "\u001B[33m";
		String ANSI_RST = "\u001B[0m";
		
		if (z == 'x') 
			return ANSI_RED + z + ANSI_RST;
		if (z == 'o')
			return ANSI_CYN + z + ANSI_RST;
		return ANSI_YLW + z + ANSI_RST;
	}
	
	public void printBoard(){ //prints out the board into the terminal
		populate();
		String s1 = "             |             |            \n";
		String s2 = " ------------+-------------+------------\n";
		System.out.print(s1+s1);
		System.out.printf("      %s      |      %s      |      %s      \n",addColor(_sttt[0]),addColor(_sttt[1]),addColor(_sttt[2]));
		System.out.print(s1+s1+s2+s1+s1);
		System.out.printf("      %s      |      %s      |      %s      \n",addColor(_sttt[3]),addColor(_sttt[4]),addColor(_sttt[5]));
		System.out.print(s1+s1+s2+s1+s1);
		System.out.printf("      %s      |      %s      |      %s      \n",addColor(_sttt[6]),addColor(_sttt[7]),addColor(_sttt[8]));
		System.out.print(s1+s1);
		unpopulate();
	}
}
