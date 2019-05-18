package minimumMakespan;

public class Replacer_Delete_All implements Replacer {
	
	@Override
	public int[][] replace(Problem p, int[][] population, int[][] offspring){
		
		int[][] newPopulation = new int[population.length][population[0].length];
		int fitnessPopulation = GeneticAlgorithm.getFitness(p, population[GeneticAlgorithm.getFittest(p, population)]);
		int fitnessOffspring = GeneticAlgorithm.getFitness(p, offspring[GeneticAlgorithm.getFittest(p, offspring)]);
		int fittestChromosome = 0;
		int stop = 0;

		if (fitnessPopulation > fitnessOffspring) {
			for (int i = 0; i < population[0].length; i++) {
				newPopulation[0][i] = population[fittestChromosome][i];	
				population[fittestChromosome][i] = 0;
			} 
		} else {
			for (int i = 0; i < offspring[0].length; i++) {
				newPopulation[0][i] = offspring[fittestChromosome][i];	
				offspring[fittestChromosome][i] = 0;
			} 
		}
		//get best chromosomes from offspring
		for (int i = 1; i < offspring.length; i++) {
			fittestChromosome = GeneticAlgorithm.getFittest(p, offspring);
			for (int j = 0; j < offspring[0].length; j++) {
				newPopulation[i][j] = offspring[fittestChromosome][j];
				offspring[fittestChromosome][j] = 0;
			}
			stop = i;
		}
		
		//add best chromosomes of population	
		for (int i = stop + 1 ; i < population.length - 1; i++) {
			fittestChromosome = GeneticAlgorithm.getFittest(p, population);
			for (int j = 0; j < population[0].length; j++) {
				newPopulation[i][j] = population[fittestChromosome][j];
				population[fittestChromosome][j] = 0;
			}
		}
		
		return newPopulation;	
			

	}
}
