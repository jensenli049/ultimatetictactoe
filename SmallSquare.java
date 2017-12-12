public class SmallSquare{
    
    private char[] _sttt;
    private char _winner;
    private boolean _gameover;
    private int state = 0;

    
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
    
    public char getIndex(int val){
	return _sttt[val];
    }

    public char getWinner(){
	return _winner;
    }
    
    public boolean isOver(){
	populate();
	if((_sttt[0] == _sttt[1] && _sttt[1] == _sttt[2]) ||
	   (_sttt[3] == _sttt[4] && _sttt[4] == _sttt[5]) ||
	   (_sttt[6] == _sttt[7] && _sttt[7] == _sttt[8]) ||
	   (_sttt[0] == _sttt[3] && _sttt[3] == _sttt[6]) ||
	   (_sttt[1] == _sttt[4] && _sttt[4] == _sttt[7]) ||
	   (_sttt[2] == _sttt[5] && _sttt[5] == _sttt[8]) ||
	   (_sttt[2] == _sttt[4] && _sttt[4] == _sttt[6]) ||
	   (_sttt[0] == _sttt[4] && _sttt[4] == _sttt[8])){
	    //setWinner(winner);
	    return _gameover = true;
	}
	unpopulate();
	for( char x : _sttt )
	    if( x == ' ')
		return false;
	setWinner('-');
	return _gameover = true;
    }

    public void setWinner(char player){
	if(_gameover)
	    _winner = player;
	for (int i = 0; i < _sttt.length; i++)
	    _sttt[i] = player;
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

    public String addColor (char z) {
	String ANSI_RED = "\u001B[31m";
	String ANSI_CYN = "\u001B[36m";
	String ANSI_GRN = "\u001B[33m";
	String ANSI_RST = "\u001B[0m";
	
	if (z == 'x') 
	    return ANSI_RED + z + ANSI_RST;
	if (z == 'o')
	    return ANSI_CYN + z + ANSI_RST;
	return ANSI_GRN + z + ANSI_RST;
    }

    public void printBoard(){
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
