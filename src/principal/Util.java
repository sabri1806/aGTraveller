package principal;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

public class Util {
	
	public static void mostrarPoblacion(ArrayList<ArrayList<Integer>> population) {
		for (int i = 0; i< population.size(); i++){
			//float fitness = 
			System.out.println(population.get(i));
		}		
	}
	
	public static ArrayList<ArrayList<Integer>> orderPopulation(ArrayList<ArrayList<Integer>> population) {
		 		
		//Ordena los individuos de la poblacion implementando un sort
		//que en base al fitness de cada individuo los evalua desde el 
		//mejor al peor
		population.sort(new Comparator<ArrayList<Integer>>() {
			
			@Override
			public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
				
				float fitnessO1 = getFitness(o1);
				float fitnessO2 = getFitness(o2);
				
				//System.out.println(fitnessO1);
				//System.out.println(fitnessO2);
				
				if(fitnessO1 < fitnessO2){
					return 0;
				}else{
					return -1;
				}
			}

			private float getFitness(ArrayList<Integer> current) {
				
				float fitness = 0;
				
				for(Integer a : current){
					for(Integer b : current){
						if(a!=b){
							fitness += (a - b);
							break;//solo quiero q b avance un lugar mas adelante que a
						}
					}
					
				}
				
				// TODO Auto-generated method stub
				return fitness;
			}
				
		});
		
		
		return  population;
	}

	
	public static ArrayList<Integer> getParent(ArrayList<ArrayList<Integer>> population){
		
		ArrayList<Integer> parent = population.get(0);
		
		population.remove(0);
		
		return parent;
	}
	
	public static ArrayList<Integer> combine(ArrayList<Integer> f, ArrayList<Integer> m){
		
		ArrayList<Integer> chil1FirstHalf = ((ArrayList<Integer>)f.subList(0, 4));
		ArrayList<Integer> chil1SecondHalf =((ArrayList<Integer>)m.subList(5, 9));
		
		ArrayList<Integer> chil2FirstHalf = ((ArrayList<Integer>)m.subList(0, 4));
		ArrayList<Integer> chil2SecondHalf =((ArrayList<Integer>)f.subList(5, 9));

		 Random random = new Random();
		int selectedChild = random.nextInt(1);
		
		if(selectedChild==0){
			chil1FirstHalf.addAll(chil1SecondHalf);
			return chil1FirstHalf;
		}else{
			chil2FirstHalf.addAll(chil2SecondHalf);
			return chil2FirstHalf;
			
		}		
	}
}
