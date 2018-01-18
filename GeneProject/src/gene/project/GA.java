package gene.project;

import java.util.Arrays;

public class GA {
	
	static private int geneSize = 20;
	static public int result[] = new int[geneSize];
	static final int NUMBER_INDIVIDUAL = 300;
	static final private int MAX_VALUE = 10;	
	static final private int MIN_VALUE = 1;

	public static void main(String[] args) {
		
		for(int i = 0; i < result.length;i++) {
			result[i] = MIN_VALUE + (int)(Math.random() * MAX_VALUE);
		}
		System.out.println(Arrays.toString(result));
		int maxStep = 200;
		Population pop = new Population(NUMBER_INDIVIDUAL);
		
		for(int i = 0; i < maxStep && !Arrays.equals(result,Algo.bestGene);i++ ) {
			pop = Algo.nextStep(pop,result);
			System.out.println(Arrays.toString(Algo.bestGene));
		}
		
		
	}

}
