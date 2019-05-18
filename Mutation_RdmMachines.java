package minimumMakespan;
import java.util.Random;

public class Mutation_RdmMachines implements Mutator {
	
	//mutate by assigning random machines to some entries of some chromosomes
	@Override
	public int[][] mutate(Problem p, int[][] pool, double mutationRate) {
		int mutation_number = (int) (pool.length * mutationRate);
		for(int i = 0; i < mutation_number; i++) {
			int[] chromosome = getRandomChromosome(pool);
			for(int j = 0; j < pool.length/2; j++) {
				int rand = new Random().nextInt(pool.length);
				chromosome[rand] = new Random().nextInt(p.getNumberMachines());
			}
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
