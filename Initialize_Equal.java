package minimumMakespan;
import java.util.Random;

public class Initialize_Equal implements Initializer{
	
	/**
	 * This method should implement the population in a way, that inside a chromosome all 
	 * print jobs are distributed equally.
	 */
	@Override
	public int[][] initializePopulation(Problem p, int populationSize) {
		
		// first we need to know how many digits we need
		// nr of jobs : nr of machines
		int nrJobsEach = p.getNumberJobs()/p.getNumberMachines(); 
		int machineID = 0;
		int[] machineBase = new int[p.getNumberJobs()];
		
		// creates the base array that we can shuffle later
		for (int m = 0; m < machineBase.length; m++) {
			machineBase[m] = machineID;
			// start assigning jobs to the next machine
			if ((m % nrJobsEach-1) == 0) {
				machineID++;
			}
		}
		
		// create the population array
		int[][] population = new int[populationSize][p.getNumberJobs()];
		
		// fill each chromosome of the population
		for (int i = 0; i < population.length; i++) {
			//shuffle the base array
			shuffleArray(machineBase);
			// assign shuffeled values to population chromosomes
			for (int j = 0; j < p.getNumberJobs(); j++) {
				population[i][j] = machineBase[j];
			}
		}
		return population;
	}
	
	/**
	 * Method for shuffeling the base array
	 * @param array
	 */
	private static void shuffleArray(int[] array)
	{
	    int index, temp;
	    Random random = new Random();
	    for (int i = array.length - 1; i > 0; i--)
	    {
	        index = random.nextInt(i + 1);
	        temp = array[index];
	        array[index] = array[i];
	        array[i] = temp;
	    }
	}
}
