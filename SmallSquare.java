public class SmallSquare{
    
    private char _letter;
    private int _number;

    public SmallSquare(char letter, int number){
	_letter = letter;
	_number = number;
    }
    
    public char getLetter(){
	return _letter;
    }

    public int getIndex(){
	return _number;
    }

    public boolean used(){
	if( _letter == 'x' || _letter == 'o' )
	    return true;
	return false;
    }
    
}
