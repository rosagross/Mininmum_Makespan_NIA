package minimumMakespan;

/**
 * 
 * @author Rosa, Emilia, Tula
 * 
 * If the population size is fixed, we can use array to save the chromosomes.
 * If the size is variable then we would use a Array List.
 *
 */
public class GeneticAlgorithm {

	private Initializer initializer;
	private Selector selector;
	private Recombiner recombiner;
	private Mutator mutator;
	private Replacer replacer;
	
	/**
	 * The Constructor of a genetic algorithm need all the following modules do execute the algorithm.
	 * @param initializer
	 * @param selector
	 * @param recombiner
	 * @param mutator
	 * @param replacer
	 */
	public GeneticAlgorithm(Initializer initializer, Selector selector, Recombiner recombiner, Mutator mutator, Replacer replacer) {
		this.initializer = initializer;
		this.selector = selector;
		this.recombiner = recombiner;
		this.mutator = mutator;
		this.replacer = replacer;
	}
	
	
	/**
	 * This method is called if we want to find the best (specfied by the getFittest() method) Assignment
	 * for our problem
	 * @return
	 */
	public int[] search(Problem p, int pop_size, int pool_size, double mutation_prob, long time_limit) {
		
		long time_spent = 0;
		long noIterations = 0;
		long startTime = System.currentTimeMillis();
		
		int[][] population = initializer.initializePopulation(p, pop_size);
		int[][] mating_pool;
		int[][] offspring;
		
		do {
			mating_pool = selector.select(p, population, pool_size);
			offspring = recombiner.recombine(mating_pool);
			mutator.mutate(p, offspring, mutation_prob);
			population = replacer.replace(p, population, offspring);
			
			time_spent = System.currentTimeMillis() - startTime;
		
		} while (time_spent < time_limit);
		
		
		return getFittest(p, population).getAssignment();
	}
}
