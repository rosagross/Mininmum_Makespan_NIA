package minimumMakespan;
import java.util.Random;

//this class assures equal number of 0 and 1 in template
//@author Tula

public class Recombine_Equal_Template implements Recombiner {
  
  @Override
  public int[][] recombine(Problem p, int[][] mating_pool) {
    
    int[][] new_pool = new int[mating_pool.length][mating_pool[0].length];
    int[][] dummy_pool = mating_pool;
    boolean[] template = template(mating_pool);
  
    //dummy_pool is used to get the fittest members for each iteration
    for(int i = 0; i < mating_pool.length/2; i++) {
      int first_partner = GeneticAlgorithm.getFittest(p,dummy_pool);
      for(int j = 0; j < template.length; j++) {
        dummy_pool[first_partner][j] = 0;
      }

      int second_partner = GeneticAlgorithm.getFittest(p, dummy_pool);
      for(int j = 0; j < template.length; j++) {
        dummy_pool[second_partner][j] = 0;
      }
      
      //enter crossover data into new pool
      for(int j = 0; j < template.length; j++) {
        if (template[j]) {
          new_pool[i][j] = mating_pool[first_partner][j];
        } else {
          new_pool[i][j] = mating_pool[second_partner][j];
        }
      }
      
      for(int j = 0; j < template.length; j++) {
        if (template[j]) {
          new_pool[i + mating_pool.length/2][j] = mating_pool[second_partner][j];
        } else {
          new_pool[i + mating_pool.length/2][j] = mating_pool[first_partner][j];
        }
      }
    }
    return new_pool;

  }
  
  //construct a template with strictly same amount of 0/1
  public boolean[] template(int[][] mating_pool) {
    
    boolean[] template = new boolean[mating_pool.length];
    for(int i = 0; i < mating_pool.length; i++) {
      template[i] = false;
      if (i%2 == 0) {
    	int here;  
        do {
          here = new Random().nextInt(mating_pool.length);
        } while (template[here] = true);
        template[here] = true;
      }
    }
    return template;
  }

}