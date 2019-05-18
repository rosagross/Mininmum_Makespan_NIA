package minimumMakespan;

/**
 * Testklasse: nur zum testen, ob die einzelnen module funktionieren
 * @author Rosa
 *
 */
public class Test {
	
	public static void main(String[] args) {
		// specify problem
		Problem p = new Problem("benchmark1_20_300"); 		
		printChromosome(p.getJobs());
		// specify population size, the mating pool size and the time limit
				int pop_size = 20;
		testInitializer(p, pop_size);
		
	}

	private static void testInitializer(Problem p, int pop_size) {
		Initializer initializer = new RandomInit();
		
		int[][] pool = initializer.initializePopulation(p, pop_size);
		printPool(pool);
		
		System.out.println("\n THE FITTEST:");
		int the_fittest = GeneticAlgorithm.getFittest(p, pool);
		System.out.println(the_fittest);
	}
	
	/**
	 * Method prints a 2D Array
	 * @param pool
	 */
	public static void printPool(int[][] pool) {
		for (int i = 0; i < pool.length; i++) {
			System.out.println("\nChromosome " + i);
			printChromosome(pool[i]);
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
