
# Mininmum_Makespan_NIA
Homework for Nature inspired algorithms: Genetic Algorithm solving the Minimum Makespan Problem

Hey, überprüft/ergänzt bitte noch die Namen und Beschreibungen der Klassen falls nötig und ansonsten ändert ruhig, was euch noch nicht gefällt :) 

Problem to be solved
Assign jobs to equally designed machines such that the duration to complete all jobs (i.e. maximal working time of a machine) is minimal. The application is domain-general. You may think of the problem as assigning printing jobs to printers that operate simultaneously and equally fast. 
Solved by a genetic algorithm.

Representation
What is called "population" refers to a set of possible assignments of jobs to machines. The population is represented as 2d-int-array. Each column refers to one of the jobs to be done, each row is a possible solution. Entries are ints each of which refers to one of the machines, therefore they are in range of the number of machines that are provided. 



Genetic Algoritm Modules

The following five modules operate in order of reference on a current population (i. e. pool/mating_pool) of possible assignments of jobs to machines. All of them are designed as interfaces, each implemented by two classes that contain different approaches to solve their functionality. Those five modules contain all variables that can be manipulated as features of the algorithm, namely the size of the population, the size of the mating pool and the mutation rate. Those features influence the performance of the algorithm and are therefore crucial for evaluation and improvement.



Initializer 
(public interface Initializer, 
public class InitializeEqual, 
public class RandomInit)

InitializeEqual
Initializes randomly but pays attention to assign an equal number of jobs to every machine within a chromosome. (stimmt das? habe evtl deinen Kommentar nicht richtig verstanden)
RandomInit
Initializes by assigning machines to jobs randomly.



Selector 
(public interface Selector, 
public class SelectFitnessProportionate, 
public class )

SelectFitnessProportionate
Selects chromosomes that join in the mating pool (input for Recombiner methods) based on their fitness which is the quality of the solution.



Recombiner 
(public interface Recombiner, 
public class Recombine_Equal_Template, 
public class Recombine_Template)

Recombine_Equal_Template
Recombines two chromosomes from the current population (here: mating pool) by applying a template that contains equally many zeros and ones. Each pair of parents creates a second offspring by applying the negation of the template.
Recombine_Template
Operates similar to Equal_Template, but allows the case that the numbers of zeros and ones in the template differ (slightly).



Mutator 
(public interface Mutator, 
public class Mutation_RdmMachines, 
public class Mutation_Swap)

Mutation_RdmMachines
With a certain probability changes the machine that is assigned to a job to another random machine. 
Mutation_Swap
With a certain probability switches the assignment of two machines to jobs within one chromosome.



Replacer 
(public interface Replacer, 
public class Replacer_Delete_All, 
public class Replacer_Elitlist)

Replacer_Delete_All
Deletes almost everything from current population. Only the best solution that was found is taken to the offspring generation.
Replacer_Elitlist
Creates an offspring generation that contains the fitter half from the old and the fitter half from the new generation.




Frontend

public class Main

The program does not take input from the terminal. Instead, the Main class is most important for the user. Firstly, it allows you to parse a problem (csv file required). Furthermore, you can determine the above-mentioned performance features (plus a runtime limit) as well as the implementation you would like to operate for each of the interfaces.



Backend

public class GeneticAlgorithm

Main creates an object of the class GeneticAlgorithm. It contains the main loop of the program that iterates the genetic algorithm modules in the above-mentioned order until time limit is reached. 

public class Problem

An object of the class Problem specifies all relevant attributes of the problem to be solved. Those can be read from the name of the csv.


Authors
Emilia Arens
Rosa Grossmann
Tula Boeschen
