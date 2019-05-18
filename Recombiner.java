package minimumMakespan;

//recombines using two different templates
//@author Tula
public interface Recombiner {

  public int[][] recombine(Problem p, int[][] mating_pool);
}