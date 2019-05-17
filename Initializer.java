package minimumMakespan;

/**
 * @author Rosa
 * In this class the initializer operations are defined. We have two options on how to 
 * initialize the cromosomes: 
 * 1. Random 
 * 2. each machine has an equal number of jobs
 */
public interface Initializer {
	
	/**
	 * Method that shows that the Initializer should have the method initializePopulation().
	 * That could be the random initialization or the equal initialization that implement this interface.
	 * @param nrGenes
	 * @param populationSize
	 * @return a population of chromosomes
	 */
	public int[][] initializePopulation(Problem p, int populationSize);
	
}
