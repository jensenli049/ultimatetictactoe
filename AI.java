import java.util.Random;

public class AI{

    public boolean findVal(int[] arr, int val){
	for(int x : arr)
	    if(x == val && x != 0)
		return true;
	return false;
    }
    
    public int randomAI(int[] unused){
	Random rand = new Random();
	int n = rand.nextInt(9) + 1;
	while (!findVal(unused,n))
	    n = rand.nextInt(9) + 1;
	return n;
    }
    
    public int blockingAI(int[] unused){
	
	return 0;
    }

    public int readAheadAI(int[] unused){
	
	return 0;
    }
    
}
