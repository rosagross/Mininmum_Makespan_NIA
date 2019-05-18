package minimumMakespan;

/**
 * In the Main class we call the actual programm. We just have to set the problem filename,
 * specify the modules we want to use and set the parameters.
 * @author Rosa, Tula, Emilia
 *
 */
public class Main {
	
	public static void main(String[] args) {
		
		// specify problem
		Problem p = new Problem("benchmark1_20_300"); 		
		printChromosome(p.getJobs());
		
		// specify modules
		Initializer initializer = new RandomInit();
		Selector selector = new SelectFitnessProportionate();
		Recombiner recombiner = new Recombine_Template();
		Mutator mutator = new Mutation_Swap();
		Replacer replacer = new Replacer_Elitlist();
		
		// call GeneticAlgorithm
		GeneticAlgorithm genAlgorithm = new GeneticAlgorithm(initializer, selector, recombiner, mutator, replacer);
		
		// specify population size, the mating pool size and the time limit
		int pop_size = 20;
		int pool_size = 10;
		double mutation_prob = 0.5;
		int time_limit = 100;
		genAlgorithm.search(p, pop_size, pool_size, mutation_prob, time_limit);
		
	}
	
	/**
	 * Method prints a 2D Array
	 * @param pool
	 */
	public static void printPool(int[][] pool) {
		for (int i = 0; i < pool.length; i++) {
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


