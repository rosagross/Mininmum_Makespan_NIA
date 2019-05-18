package minimumMakespan;

public class Replacer_Elitlist implements Replacer {
	
	
	@Override
	public int[][] replace(Problem p, int[][] population, int[][] offspring){
		
		int[][] newPopulation = new int[population.length][population[0].length];
		int fittestChromosome; 
		
		//get best chromosomes from population
		for (int i = 0; i < population[0].length/2; i++) {
			fittestChromosome = GeneticAlgorithm.getFittest(p, population);

			for (int j = 0; j < population.length; j++) {
				newPopulation[i][j] = population[fittestChromosome][j];
				population[fittestChromosome][j] = 0;
			}
			
		}
		
		//get best chromosomes from offspring
		for (int i = 0; i < offspring[0].length/2; i++) {
			fittestChromosome = GeneticAlgorithm.getFittest(p, offspring);

			for (int j = 0; j < population.length; j++) {
				newPopulation[i + population[0].length/2 ][j] = offspring[fittestChromosome][j];
				offspring[fittestChromosome][j] = 0;

			}
			
		}
		
		

	return newPopulation;	
	}
	
	

}
