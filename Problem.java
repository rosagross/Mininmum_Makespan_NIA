package minimumMakespan;

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
