import java.util.Random;


public class MatTab {

	public static void main(int InMin, int InMax) {
		//definition d'un tableau décimale
		/*
		double TableauDecimale[] = { 1.5, 2.5 , 3.5, 5.0, 4.2, 0.3, 1.5, 3.8, 3.2, 1.4};
		int j =0;
		
		//parcours du tableau 
		for(double val : TableauDecimale) 
		{

			System.out.println("À l'emplacement " + j +" du tableau nous avons = " + val);
			//System.out.println("la valeur vaut :" + TableauDecimale[j]);
			
			
		   if(TableauDecimale[j] == 1.5 ) System.out.println("la valeur est :" + val);
		
			++j;
		}
		*/

	}
	private int min;
	private int max;
	public double getVal(){
		double val  = randInt(this.min,this.max);
		return val;	
	}
	public int randInt(int min, int max) {

	    // Usually this should be a field rather than a method variable so
	    // that it is not re-seeded every call.
	    Random rand = new Random();

	    // nextInt is normally exclusive of the top value,
	    // so add 1 to make it inclusive
	    int randomNum = rand.nextInt((max - min) + 1) + min;

	    return randomNum;
	}
		
	}

}
