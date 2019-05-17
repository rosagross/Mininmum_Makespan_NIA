package minimumMakespan;

//not yet done! not yet constructed a template, deleated the fittest in every iteration
//and assigned the new pool
public class Recombine_Template implements Recombiner {
	
	public int[][] recombine(int[][] mating_pool) {
		
		int[][] new_pool = new int[mating_pool.length][mating_pool[0].length];
		boolean[] template = template(mating_pool);
	
		for(int i = 0; i < mating_pool.length/2; i++) {
			int[] first_partner = getFittest(mating_pool);
			//TODO delete fittest
			//mating_pool[first_partner][] = ;
			int[] second_partner = getFittest(mating_pool);
			for(int j = 0; j < template.length; j++) {
				
				if (template[j]) {
					new_pool[i][j] = first_partner[j];
				} else {
					new_pool[i][j] = second_partner[j];
				}
			}
			return new_pool;
		}
	}
	
	//construct a template
	public boolean[] template(int[][] mating_pool) {
		
		boolean[] template = new boolean[mating_pool.length];
		for(int i = 0; i < mating_pool.length; i++) {
			
		}
		
		return template;
	}

}
