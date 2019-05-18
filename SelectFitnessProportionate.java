package minimumMakespan;
import java.util.Random;

/**
 * In this class the Selector selects chromosomes out of a population,
 * based on the fitness-proportionate. It chooses the chromosomes with probability of their fitness proportionate s times,
 * where s is the size of the mating pool.
 * @author Rosa
 *
 */
public class SelectFitnessProportionate implements Selector {
	
	@Override
	public int[][] select(Problem p, int[][] population, int pool_size){
		Random random = new Random();
		int[][] mating_pool = new int[pool_size][p.getNumberJobs()];
		int totalFitness = 0;
		double[] storeProb = new double[population.length];
		int fitness;
		
		// go through the population, calculate the Fitness and the proportinate
		// and put the proportionate into an array, to save it for the next step
		// otherwise we would have to calculate all fitnessvalues again
		// choose the current chromosome with the just calculated proportionate
		for (int i = 0; i < population.length; i++) {
			fitness = GeneticAlgorithm.getFitness(p, population[i]);
			totalFitness += fitness;
			storeProb[i] = (double)fitness/totalFitness;
		}
		
		int currentChrom = 0;
		int counter = 0;
		boolean fullPool = false;
		do {
			
			// check if the current chromosome is selected
			if (random.nextFloat() < storeProb[currentChrom]) {
				for (int i = 0; i < p.getNumberJobs(); i++) {
					mating_pool[counter][i] = population[currentChrom][i];
				}
				counter++;
				if (counter == mating_pool.length) {
					fullPool = true;
				}
			}
			// if we are already at the end of the population, we need to start at the beginning again
			if (currentChrom == population.length-1) {
				currentChrom = 0;
			}else {
				currentChrom++;
			}
		
		} while (fullPool);
		
		return mating_pool;
	}
}