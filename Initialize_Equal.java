package minimumMakespan;

public class Initialize_Equal implements Initializer{
	
	/**
	 * This method should implement the population in a way, that inside a chromosome all 
	 * print jobs are distributed equally.
	 */
	@Override
	public int[][] initializePopulation(Problem p, int populationSize) {
		
		// create the population array
		int[][] population = new int[populationSize][p.getNumberJobs()];
		
		// we have m machines, thus the values can be in this range
		
		
		return null;
	}

}
