package minimumMakespan;

import java.util.Arrays;

/**
 * The population size is fixed, we can use an array to save the chromosomes.
 *
 * @author Rosa, Emilia, Tula
 * 
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
	 * @return the fittest assigment
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
		return null;
		//return getFittest(p, population).getAssignment();
	}
	
	/**
	 * This method is the objective funtion of the minimum makespan problem.
	 * It goes through the population array and finds the minimum time of all chromosome assignments,
	 * which is the max time of the printer. 
	 * @param p
	 * @param population
	 * @return index of the fittest chromosome
	 */
	public static int getFittest(Problem p, int[][] population){
		
		// create machine array to count the jobs of the machines
		int[] machines = new int[p.getNumberMachines()];
		int machineID;
		int[] processingTimes = p.getJobs();
		int indexFittest = 0;
		// initialize with the worst number possible, the sum of all jobs
		int currentBestVal = Arrays.stream(processingTimes).sum();
		int maximumTime;
		
		// go through population
		for (int i = 0; i < population.length; i++) {
			// for each chromosome in population calculate the maximum time needed
			for (int j = 0; j < p.getNumberJobs(); j++) {
				// read out entry in the chromosome
				machineID = population[i][j];
				// add the processing time to the field of the correct machine ID
				machines[machineID] += processingTimes[j];			
			}
			// now we need to find the machine with the longest processing time
			// and if this time is less then the current fittest one
			maximumTime = findMax(machines);
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
	 * @param machines
	 */
	private static int findMax(int[] a) {
		System.out.println("Machines:");
		Test.printChromosome(a);
		int max = a[0];
		for(int i = 1; i < a.length;i++)
		{
			if(a[i] > max)
			{
				max = a[i];
			}
		}
		System.out.println(max);
		return max;
	}
}
