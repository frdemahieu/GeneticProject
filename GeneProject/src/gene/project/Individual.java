package gene.project;


public class Individual {

	static public int geneSize = 20;
	final private int MAX_VALUE = 10;	
	final private int MIN_VALUE = 1;
	private int genes[] = new int[geneSize];
	
	public Individual(){	
		for(int i = 0; i < geneSize; i++){
			genes[i] = MIN_VALUE + (int)(Math.random() * MAX_VALUE);
		}
	}
	public Individual(int[] gene) {
		this.genes = gene;
	}
	public void setGene(int index,int gene) {
		if(index >= 0 && index < geneSize) {
			this.genes[index] = gene;
		}	
	}
	public int[] getGenes() {
		return genes;
	}
	public int getGene(int index) {
		if(index < 0 && index > geneSize) 
			throw new IllegalArgumentException("index must be between 0 and "+geneSize);
		
		return this.genes[index];
	}
	public int getDistanceToResult(int[] result) {
		int returnNumber = 0;
		for(int i = 0; i < geneSize; i++){
			if(genes[i] == result[i]) returnNumber++;
		}
		return returnNumber;
	}
}
