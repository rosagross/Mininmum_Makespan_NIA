package minimumMakespan;


import java.io.FileWriter;
import java.io.IOException;


/**
 * In the Main class we call the actual programm. We just have to set the problem filename,
 * specify the modules we want to use and set the parameters.
 * @author Rosa, Tula, Emilia
 *
 */
public class Main {
	
	public static void main(String[] args) {
		
		// specify problem
		Problem p = new Problem("benchmark1_20_300"); 
		//System.out.println("Jobs: ");
		//printChromosome(p.getJobs());
		//System.out.println(" ");
		//System.out.println(" ");

		
		// specify modules
		Initializer initializer = new Initialize_random();
		Selector selector = new Select_First_Best();
		Recombiner recombiner = new Recombine_Template();
		Mutator mutator = new Mutation_Swap();
		Replacer replacer = new Replacer_Elitlist();
		
		// call GeneticAlgorithm
		GeneticAlgorithm genAlgorithm = new GeneticAlgorithm(initializer, selector, recombiner, mutator, replacer);
		
		// specify population size, the mating pool size and the time limit
		int pop_size = 20;
		int pool_size = 10;
		double mutation_prob = 0.5;
		int time_limit = 100;
		
		//save results
		String[][] results = new String[100][6];
		for (int i = 0; i < 100; i++) {
			
			genAlgorithm.search(p, pop_size, pool_size, mutation_prob, time_limit);
			
			//random and improved
			results[i][0] = "Improved";
			
			results[i][1] = "population_size 10";
			results[i][2] = String.valueOf(GeneticAlgorithm.duration);
			results[i][3] = String.valueOf(GeneticAlgorithm.iterations);

			results[i][4] = String.valueOf(GeneticAlgorithm.duration / GeneticAlgorithm.iterations);

			results[i][5] = String.valueOf(GeneticAlgorithm.resultValue);
			
			

		}
		
		
		FileWriter fileWriter = null;
        
        try {
            fileWriter = new FileWriter("data.csv");
            fileWriter.append("Algorithm Type, Changing Parameter, Time,Iterations,Time per Iteration,Value");
            fileWriter.append("\n");

 
            for (int i = 0; i < 100; i++) {
				for (int j = 0; j < 6; j++) {
	                fileWriter.append(results[i][j]);
	                if (j != 5) {
		                fileWriter.append(",");

					}

				}
                fileWriter.append("\n");

			}
              
            System.out.println("CSV file was created successfully !!!");
             
        } catch (Exception e) {
            System.out.println("Error in CsvFileWriter !!!");
            e.printStackTrace();
        } finally {
            
           try {
               fileWriter.flush();
               fileWriter.close();
           } catch (IOException e) {
               System.out.println("Error while flushing/closing fileWriter !!!");
               e.printStackTrace();
           }
        }
		
	}
	
	/**
	 * Method prints a 2D Array
	 * @param pool
	 */
	public static void printPool(int[][] pool) {
		for (int i = 0; i < pool.length; i++) {
			printChromosome(pool[i]);
		}	
	}
	
	/**
	 * Method prints a 1D Array
	 * @param chromosome
	 * 
	 */
	public static void printChromosome(int[] chromosome) {
		for (int i = 0; i < chromosome.length; i++) {
			System.out.print("|" + chromosome[i]);
			
		}
		System.out.print("|");
	}
} 


