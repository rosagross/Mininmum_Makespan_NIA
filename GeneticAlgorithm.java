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
	}
	
	
	/**
	 * This method is called if we want to find the best (specfied by the getFittest() method) Assignment
	 * for our problem
	 * @return
	 */
	public Assignment search(Problem p) {
		
		
	}
}
