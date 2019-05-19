package minimumMakespan;

import java.util.Arrays;

/**
 * In this class the algorithm for findig the best assignment for our minimum
 * makespan problem is implemented.
 * We measure the time for each iteration, the value of the assignment and the
 * number of iterations. The termination condition is defined by the time_limit.
 * @author Rosa, Emilia, Tula
 *
 */
public class GeneticAlgorithm {

	public static int duration;
	public static int iterations;
	public static int resultValue;

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
	 * for our problem.
	 * @return
	 */
	public int[] search(Problem p, int pop_size, int pool_size, double mutation_prob, long time_limit) {

		this.iterations = 0;
		this.duration = 0;

		long time_spent = 0;
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

			this.iterations ++;

		} while (time_spent < time_limit);

		this.duration = (int) time_spent;
		this.resultValue = getFitness(p, population[getFittest(p, population)]);

		//Main.printChromosome(population[getFittest(p, population)]);
		//System.out.println(" ");
		//System.out.println(resultValue);
		return population[getFittest(p, population)];
	}

	/**
	 * This method is the objective function of the minimum makespan problem.
	 * It goes through the population array and finds the minimum time of all chromosome assignments,
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
	 * @param machines
	 */
	private static int findMax(int[] a) {
		//System.out.println("Machines:");
		//Test.printChromosome(a);
		int max = a[0];
		for(int i = 1; i < a.length;i++)
		{
			if(a[i] > max)
			{
				max = a[i];
			}
		}
		//System.out.println(" ");

		//System.out.println("Maximum :" + max);
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
	public static int getFitness(Problem p, int[]chromosome) {
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
		//System.out.println("Fitness :" + findMax(machines));

		return findMax(machines);
	}
}
