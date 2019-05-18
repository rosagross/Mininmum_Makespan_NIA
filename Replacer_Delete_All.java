package minimumMakespan;

public class Replacer_Delete_All implements Replacer {
	
	@Override
	public int[][] replace(Problem p, int[][] population, int[][] offspring){
		
		int[][] newPopulation = new int[population.length][population[0].length];
		int fitness; 
		
		if (getFitness(getFittest(population)) < getFitness(getFittest(offspring))) {
			
			return offspring;
		} else {
			for (int i = 0; i < offspring.length; i++) {
				
			}
		}
		
		
		

	return newPopulation;	
	}

}
