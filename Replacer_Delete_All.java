package minimumMakespan;

public class Replacer_Delete_All implements Replacer {
	
	@Override
	public int[][] replace(Problem p, int[][] population, int[][] offspring){
		
		int[][] newPopulation = new int[population.length][population[0].length];
		int fitness; 
		
		if (population[getFittest(population)][getFitness(population)] < offspring[getFittest(offspring)][getFitness(population)]) {
			
			return offspring;
		} else {
			
			//get best chromosome from population and add to new pool
			for (int j = 0; j < offspring.length; j++) {
				newPopulation[0][j] = population[getFittest(population)][j];
	
			}
			//add all other chromosomes from offspring to new pool
			for (int i = 1; i < offspring[0].length; i++) {

				for (int j = 0; j < offspring.length; j++) {
					newPopulation[i][j] = offspring[i][j];
				}
			} 
			return newPopulation;		
		}
			
	}

}
