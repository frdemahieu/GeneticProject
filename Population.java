package gene.project;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Population {

	List<Individual> population = new ArrayList<Individual>();
	
	static private int geneSize = 20;
	
	public Population(int numberOfPop) {
		for(int i = 0; i < numberOfPop; i++) {
			population.add(new Individual());
		}
	}
	
	public Population() {
		
	}
	
	public void addIndividual(Individual indiv) {
		population.add(indiv);
	}
	public Individual getIndividual(int index) {
		return population.get(index);
	}
	public int size() {
		return population.size();
	}
	public List<Individual>getIndividuals() {
		return population;
	}
}
