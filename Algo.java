package gene.project;

import java.util.Comparator;

public class Algo {
	
	static private int geneSize = 20;
	static final private int MAX_VALUE = 10;	
	static final private int MIN_VALUE = 1;
	static final int NUMBER_RANDED_VALUE = 5;
	static final float crossRate = 0.5f;
	static final float mutationRate = 0.15f;
	static public int []bestGene;

	
	public static Population nextStep(Population popToEvolve,int []result) {
	

		Population newPopulation = new Population();
		Individual bestIndividual = chooseTheBestInThePopulation(popToEvolve, result);
		bestGene = bestIndividual.getGenes();
		newPopulation.addIndividual(bestIndividual);
		
		for(int i = 0; i < (popToEvolve.size()-1) ;i++) {
			Individual ind1 = randBestIndividual(popToEvolve, result);
			Individual ind2 = randBestIndividual(popToEvolve, result);
			Individual newIndividual = crossIndividual(ind1, ind2);
			mutate(newIndividual);
			newPopulation.addIndividual(newIndividual);
		}
		
		return newPopulation;
	}
	
	private static Individual randBestIndividual(Population popToEvolve,int []result) {
		Population randPop = new Population();
		for(int i = 0; i < NUMBER_RANDED_VALUE;i++) {
			randPop.addIndividual(popToEvolve.getIndividual((int)Math.random()*popToEvolve.size()));
		}
		return chooseTheBestInThePopulation(randPop, result);
	}
	
	private static Individual crossIndividual(Individual ind1,Individual ind2) {
		Individual newInd = new Individual();
		for(int i = 0; i < Individual.geneSize;i++ ) {
			if(Math.random() > crossRate) {
				newInd.setGene(i, ind1.getGene(i));
			}else {
				newInd.setGene(i, ind2.getGene(i));
			}
		}
		
		return newInd;
	}
	
	private static void mutate(Individual indiv) {
		for(int i = 0;i < indiv.geneSize;i++) {
			if(Math.random() < mutationRate) {
				int gene = MIN_VALUE +  (int)(Math.random() * MAX_VALUE);
				indiv.setGene(i, gene);
			}
		}
	}

	private static Individual chooseTheBestInThePopulation(Population population,int[] result) {
		final Comparator<Individual> comp =
				(i1,i2) -> Integer.compare(i1.getDistanceToResult(result), i2.getDistanceToResult(result));
	
		return population.getIndividuals().stream().max(comp).get();
	}
	
}
