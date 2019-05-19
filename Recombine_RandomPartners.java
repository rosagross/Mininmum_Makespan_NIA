package minimumMakespan;
import java.util.Random;

//this class assigns pairs of individuals for recombination randomly 
//@author Tula


public class Recombine_RandomPartners implements Recombiner {
  
	 @Override
	  public int[][] recombine(Problem p, int[][] mating_pool) {
	    
	    int[][] new_pool = new int[mating_pool.length][mating_pool[0].length];
	    int[][] dummy_pool = mating_pool;
	    boolean[] template = template(mating_pool);
	    int first_partner;
	    int second_partner;
	    //dummy_pool is used to get random partners for each iteration
	    for(int i = 0; i < mating_pool.length/2; i++) {
	      do {
	        first_partner = new Random().nextInt(dummy_pool.length);
	      } while (dummy_pool[first_partner][0] == -1);
	      for(int j = 0; j < template.length; j++) {
	        dummy_pool[first_partner][j] = -1;
	      }
	      
	      do {
	        second_partner = new Random().nextInt(dummy_pool.length);
	      } while (dummy_pool[second_partner][0] == -1);
	      for(int j = 0; j < template.length; j++) {
	        dummy_pool[second_partner][j] = -1;
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
	      int here = 0;
	      boolean[] template = new boolean[mating_pool.length];
	      for(int i = 0; i < mating_pool.length; i++) {
	        template[i] = false;
	        if (i%2 == 0) {
	          do {
	            here = new Random().nextInt(mating_pool.length);
	          } while (template[here] = true);
	          template[here] = true;
	        }
	      }
	      return template;
	  /*
	  //construct a template with not necessarily same amount of 0/1
	  //might be more zeros; but 0/1 is ambiguous since we take into account
	  //also the negation of the template
	  public boolean[] template(int[][] mating_pool) {
	    
	    boolean[] template = new boolean[mating_pool.length];
	    for(int i = 0; i < mating_pool.length; i++) {
	      template[i] = false;
	      if (i%2 == 0) {
	        int here = new Random().nextInt(mating_pool.length);
	        template[here] = true;
	      }
	    }
	    return template;
	  */
	  }


}