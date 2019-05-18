package minimumMakespan;
import java.util.Arrays;

/**
 * In this class the Selector selects chromosomes out of a population,
 * based on the fitness. It chooses the first best half of chromosomesand makes two copies
 * of each in the mating_pool.
 * @author Rosa
 *
 */
public class SelectCopyFirstBest implements Selector {
	
	@Override
	public int[][] select(Problem p, int[][] population, int pool_size){
		int[][] mating_pool = new int[pool_size][p.getNumberJobs()];
		int[] stored_fitness = new int[population.length];
		int highestNr = Arrays.stream(p.getJobs()).sum();
				
		// go through population, calculate the fitness and store it
		for (int i = 0; i < population.length; i++) {
			stored_fitness[i] = GeneticAlgorithm.getFitness(p, population[i]);
		}
		
		// take the first pool_size/2 best ones
		int indexBest;
		int indexCopy = 0;
		do {
			indexBest = GeneticAlgorithm.findMinIndex(stored_fitness);
			// go through the selected chromosome and copy it
			// always make two copies of the selected chromosome unless the number is even
			for (int i = 0; i < p.getNumberJobs(); i++) {
				mating_pool[indexCopy][i] = population[indexBest][i];
				mating_pool[indexCopy+1][i] = population[indexBest][i];
			}
			
			// if the size of the mating pool is not even we have to do one extra step at the end
			if ((mating_pool.length%2 != 0) && indexCopy+1 == mating_pool.length-2) {
				indexCopy++;
			}else {
				indexCopy += 2;
			}
			
			// set the index that we already used to the highest number possible
			// such that we don't choose it again
			stored_fitness[indexBest] = highestNr;
		}while(indexCopy < mating_pool.length-1);
		return mating_pool;
	}
}