package minimumMakespan;

public class Main {

	
	public static void main(String[] args) {
		
		Problem p = new Problem("benchmark1_20_300"); 
		printChromosome(p.getJobs());
		
		
		
	}
	
	/**
	 * Method prints a 2D Array
	 * @param pool
	 * 
	 */
	public static void printPool(int[][] pool) {
		for (int i = 0; i < pool.length; i++) {
			for (int j = 0; j < pool[0].length; j++) {
				
			}
		}	
	}
	
	/**
	 * Method prints a 1D Array
	 * @param chromosome
	 * 
	 */
	public static void printChromosome(int[] chromosome) {
		for (int i = 0; i < chromosome.length; i++) {
			System.out.print("|" + chromosome[i]);
			
		}
		System.out.print("|");
	}
} 


