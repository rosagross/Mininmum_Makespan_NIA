package minimumMakespan;
import java.util.Arrays;

public class Select_First_Best implements Selector{

	@Override
	public int[][] select(Problem p, int[][] population, int pool_size) {
		
		int[][] mating_pool = new int[pool_size][p.getNumberJobs()];
		int[] stored_fitness = new int[population.length];
		int highestNr = Arrays.stream(p.getJobs()).sum();
		
		// go through population and calculate the fitness and store it
		for (int i = 0; i < population.length; i++) {
			stored_fitness[i] = GeneticAlgorithm.getFitness(p, population[i]);
		}
		
		int indexBest;
		for (int j = 0; j < mating_pool.length; j++) {
			indexBest = GeneticAlgorithm.findMinIndex(stored_fitness);
			// go through the selected chromosome and copy it
			for (int i = 0; i < p.getNumberJobs(); i++) {
				mating_pool[j][i] = population[indexBest][i];
			}			
			
			// set the index that we already used to the highest number possible
			// such that we don't choose it again
			stored_fitness[indexBest] = highestNr;
		}
		return mating_pool;
	}
	
	
}
