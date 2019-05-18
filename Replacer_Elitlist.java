package minimumMakespan;

public class Replacer_Elitlist implements Replacer {
	
	
	@Override
	public int[][] replace(Problem p, int[][] population, int[][] offspring){
		
		int[][] newPopulation = new int[population.length][population[0].length];
		int fittestChromosome; 
		int stop = 0;

		if (offspring.length >= population.length/2) {
			//get best chromosomes from offspring
			for (int i = 0; i < population.length/2; i++) {
				fittestChromosome = GeneticAlgorithm.getFittest(p, offspring);
				for (int j = 0; j < offspring[0].length; j++) {
					newPopulation[i][j] = offspring[fittestChromosome][j];
					offspring[fittestChromosome][j] = 0;
				}
				stop = i;
			}
			
		} else {
			//get best chromosomes from offspring
			for (int i = 0; i < offspring.length; i++) {
				fittestChromosome = GeneticAlgorithm.getFittest(p, offspring);
				for (int j = 0; j < offspring[0].length; j++) {
					newPopulation[i][j] = offspring[fittestChromosome][j];
					offspring[fittestChromosome][j] = 0;
				}
				stop = i;
			}	
		}
		
		for (int i = stop + 1 ; i < population.length; i++) {
			fittestChromosome = GeneticAlgorithm.getFittest(p, population);
			for (int j = 0; j < population[0].length; j++) {
				newPopulation[i][j] = population[fittestChromosome][j];
				population[fittestChromosome][j] = 0;
			}
		}

	return newPopulation;	
	
	}
	
	

}
