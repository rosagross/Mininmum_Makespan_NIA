package minimumMakespan;

/**
 * 
 * @author Tula
 *
 */
public interface Mutator {
	
	public int[][] mutate(Problem p, int[][] pool, double mutationRate);

}