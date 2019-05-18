package minimumMakespan;
import java.util.Random;

public class RandomInit implements Initializer{

	@Override
	public int[][] initializePopulation(Problem p, int populationSize) {
		
		// create array for the population
		int[][] population = new int[populationSize][p.getNumberJobs()];
		Random rand = new Random(); 
		
		for (int i = 0; i < population.length; i++) {
			
			for (int j = 0; j < p.getNumberJobs(); j++) {
				// initialize random the chromosome array with values of the correct nr of Machines in the problem
				population[i][j] = rand.nextInt(p.getNumberMachines());
			}
		} 
		
		return population;
	}
	
	
	
	
}
