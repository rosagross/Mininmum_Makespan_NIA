package minimumMakespan;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * The class Problem defines the problem that we have to solve.
 * It can read out the details from the filename.
 * The 
 * @author Rosa, Emilia, Tula
 */
public class Problem {

	private String name;
	private int numberMachines;
	private int numberJobs;
	private int[] jobs;
	
	
	public Problem(String filename) {
		parseProblemDetails(filename);
		this.name = getProblemName();
		this.numberMachines = getNumberMachines();
		this.numberJobs = getNumberJobs();
		this.jobs = getJobs();
	}
	
	/**
	 * This method takes the filename (called in main programm) and reads out the name, the
	 * number of machine and the number of jobs we have to process.
	 * It saves the details in the attributes of the problem
	 * @param fileName
	 */
	public void parseProblemDetails(String fileName) {
		String[] ProblemArray = fileName.split("_");
		this.name = ProblemArray[0];
		this.numberMachines = Integer.parseInt(ProblemArray[1]);
		this.numberJobs = Integer.parseInt(ProblemArray[2]);		
	}
	
	/**
	 * This method takes the filename (called in main programm) and stores the values in a 2d 
	 * @param fileName
	 */
	public int[] getJobs() {
		this.jobs = new int[this.numberJobs];
		
		String[] values = new String[numberJobs]; 

		try (BufferedReader br = new BufferedReader(new FileReader("benchmark1_20_300.csv"))) {
			
		   
			String line;
			int j = 0;
			while ((line = br.readLine()) != null) {
				jobs[j] = Integer.parseInt(line);
				j++;
			} 
		   
		} catch (FileNotFoundException e) {
			System.out.println("The file doesn't exist, make sure that it is in your directory.. Stop programm");
			System.exit(-1);
		} catch (IOException e) {
			System.out.println("Error IOException.. Stop programm");
			System.exit(-1);
		}	
		return this.jobs;
	}
	
	
	/**
	 * Getter method for the name of the problem
	 * @return the name of the problem
	 */
	public String getProblemName() {
		return this.name;
	}
	
	/**
	 * Getter method for the nr. of machines
	 * @return the nr. of machines
	 */
	public int getNumberMachines() {
		return this.numberMachines;
	}
	
	/**
	 * Getter method for the nr. of jobs
	 * @return the number of the jobs
	 */
	public int getNumberJobs() {
		return this.numberJobs;
	}
}
