/*
  Main Big Square

*/
public class BigSquare{

    private SmallSquare[] _STTT;
    private SmallSquare _BTTT;
    private boolean _isOver;
    private char _winner;
    private int _player;

    private final char p1 = 'x';
    private final char p2 = 'o';
    private final char tie = '-';
    
    public BigSquare(){
	_STTT = new SmallSquare[9];
	for(int i = 0; i < 9; i++)
	    _STTT[i] = new SmallSquare();
	_BTTT = new SmallSquare();
	_isOver = false;
	_winner = '-';
	_player = 1;
    }

    public SmallSquare[] getSBoard(){
	return _STTT;
    }

    public char getPlayer(){
	_player++; //increments turn before returning current player
	if(_player % 2 == 1) //since turn is incremented, p1 will be 1
	    return p1;
	else //and p2 would be 0 instead of the opposite
	    return p2;
    }
    
    public SmallSquare getBBoard(){
	return _BTTT;
    }
    
    public boolean isOver(){
	return _BTTT.isOver();
    }

    public char getWinner(){
	return _winner;
    }

    public SmallSquare getSquare(int index){
	return _STTT[index];
    }
    
    public void setBBoard(int index, char win){
	_BTTT.setSquare(index, win);
    }

    public void freebie(){ //need to figure out


    }

    public void printBoard(){
	String DIVIDER1 = "---+---+--- | ---+---+--- | ---+---+---";
	String DIVIDER2 = "------------+-------------+------------";

	char[] temp = new char[81];
	int counter = 0;
	for(int i = 0; i < 3; i++) 
	    for(int j = 0; j < 3; j++) 
		for(int k = 0; k < 3; k++) 
		    for(int l = 0; l < 3; l++) {
			temp[counter] = _STTT[i*3 + k].getIndex(j * 3 + l);
			counter++;
		    }
	
	System.out.printf(" %c | %c | %c  |  %c | %c | %c  |  %c | %c | %c \n", temp[0], temp[1], temp[2], temp[3], temp[4], temp[5], temp[6], temp[7], temp[8]);
	System.out.println(DIVIDER1);
	System.out.printf(" %c | %c | %c  |  %c | %c | %c  |  %c | %c | %c \n", temp[9], temp[10], temp[11], temp[12], temp[13], temp[14], temp[15], temp[16], temp[17]);
	System.out.println(DIVIDER1);
	System.out.printf(" %c | %c | %c  |  %c | %c | %c  |  %c | %c | %c \n", temp[18], temp[19], temp[20], temp[21], temp[22], temp[23], temp[24], temp[25], temp[26]);
	System.out.println(DIVIDER2);
	System.out.printf(" %c | %c | %c  |  %c | %c | %c  |  %c | %c | %c \n", temp[27], temp[28], temp[29], temp[30], temp[31], temp[32], temp[33], temp[34], temp[35]);
	System.out.println(DIVIDER1);
	System.out.printf(" %c | %c | %c  |  %c | %c | %c  |  %c | %c | %c \n", temp[36], temp[37], temp[38], temp[39], temp[40], temp[41], temp[42], temp[43], temp[44]);
	System.out.println(DIVIDER1);
	System.out.printf(" %c | %c | %c  |  %c | %c | %c  |  %c | %c | %c \n", temp[45], temp[46], temp[47], temp[48], temp[49], temp[50], temp[51], temp[52], temp[53]);
	System.out.println(DIVIDER2);
	System.out.printf(" %c | %c | %c  |  %c | %c | %c  |  %c | %c | %c \n", temp[54], temp[55], temp[56], temp[57], temp[58], temp[59], temp[60], temp[61], temp[62]);
	System.out.println(DIVIDER1);
	System.out.printf(" %c | %c | %c  |  %c | %c | %c  |  %c | %c | %c \n", temp[63], temp[64], temp[65], temp[66], temp[67], temp[68], temp[69], temp[70], temp[71]);
	System.out.println(DIVIDER1);
	System.out.printf(" %c | %c | %c  |  %c | %c | %c  |  %c | %c | %c \n", temp[72], temp[73], temp[74], temp[75], temp[76], temp[77], temp[78], temp[79], temp[80]);
    }
}
