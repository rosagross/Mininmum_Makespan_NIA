package minimumMakespan;

import java.util.Arrays;

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
			offspring = recombiner.recombine(p, mating_pool);
			mutator.mutate(p, offspring, mutation_prob);
			population = replacer.replace(p, population, offspring);
			
			time_spent = System.currentTimeMillis() - startTime;
		
		} while (time_spent < time_limit);
		
		return population[getFittest(p, population)];
	}
	
	/**
	 * This method goes through the population array and finds the minimum time of all chromosome assignments,
	 * which is the max time of the printer. 
	 * @param p
	 * @param population
	 * @return index of the fittest chromosome
	 */
	public static int getFittest(Problem p, int[][] population){
		
		// create machine array to count the jobs of the machines
		int[] machines = new int[p.getNumberMachines()];
		int[] processingTimes = p.getJobs();
		int indexFittest = 0;
		// initialize with the worst number possible, the sum of all jobs
		int currentBestVal = Arrays.stream(processingTimes).sum();
		int maximumTime;
		
		// go through population
		for (int i = 0; i < population.length; i++) {
			maximumTime = getFitness(p,population[i]);
			if (maximumTime < currentBestVal) {
				indexFittest = i;
				currentBestVal = maximumTime;
			}
			Arrays.fill(machines, 0);
		}
		return indexFittest;
	}
	
	/**
	 * Find the maximum of an array. Needed to find the machine with the
	 * largest processing time.
	 * @param a
	 */
	public static int findMax(int[] a) {
		int max = a[0];
		for(int i = 1; i < a.length;i++)
		{
			if(a[i] > max)
			{
				max = a[i];
			}
		}
		return max;
	}
	
	/**
	 * Find the index of minimum of an array. Needed to find the fittest out of stored fittnessvalues.
	 * @param a
	 */
	public static int findMinIndex(int[] a) {
		int min = a[0];
		int indexMin = 0;
		for(int i = 1; i < a.length;i++) {
			if(a[i] < min) {
				min = a[i];
				indexMin = i;
			}
		}
		return indexMin;
	}
	
	/**
	 * Calculate the value of the objective function
	 * @param machines
	 */
	public static int getFitness(Problem p, int[] chromosome) {
		int[] machines = new int[p.getNumberMachines()];
		int machineID;
		int[] processingTimes = p.getJobs();
		for (int j = 0; j < p.getNumberJobs(); j++) {
			// read out entry in the chromosome
			machineID = chromosome[j];
			
			// add the processing time to the field of the correct machine ID
			machines[machineID] += processingTimes[j];			
		}
		// now we need to find the machine with the longest processing time		
		return findMax(machines);
	}
}
