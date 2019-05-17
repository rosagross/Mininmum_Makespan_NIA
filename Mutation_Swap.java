package minimumMakespan;
import java.util.Random;

public class Mutation_Swap implements Mutator {
	
	//This class implements one version to mutate the current mating pool.
	//Mutation rate determines the probability for each chromosome to change.
	
	//mutationRate is double [0, 1]
	//mutate by switching two jobs to different machines
	@Override
	public int[][] mutate(Problem p, int[][] pool, double mutationRate) {
		//round to int?
		int mutation_number = (int) (pool.length * mutationRate);
		for(int i = 0; i < mutation_number; i++) {
			int[] chromosome = getRandomChromosome(pool);
			int switch_1 = new Random().nextInt(pool.length);
			int switch_2 = new Random().nextInt(pool.length);
			int dummy = chromosome[switch_1];
			chromosome[switch_1] = chromosome[switch_2];
			chromosome[switch_2] = dummy;
		}
		return pool;
		
	}
	
	//This method returns a Chromosome to be changed. 
	public int[] getRandomChromosome(int[][] pool) {
		int bound = pool.length;
		int mutate_me = new Random().nextInt(bound);
		return pool[mutate_me];
	}

}
