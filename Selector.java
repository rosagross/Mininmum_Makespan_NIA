package minimumMakespan;

/**
 * @author Rosa
 *
 */
public interface Selector {
	
	public int[][] select(Problem p, int[][] population, int pop_size);
}