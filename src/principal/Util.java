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
		//System.out.println("############################################3");
		//System.out.println(f);
		//System.out.println(m);
		ArrayList<Integer> hijo1 = new ArrayList<Integer>();
		ArrayList<Integer> hijo2 = new ArrayList<Integer>();
		
		for(int i=0; i<4; i++){
			hijo1.add(f.get(i));
			hijo2.add(m.get(i));
		}
		
		for(int i=4; i<10; i++){
			hijo1.add(m.get(i));
			hijo2.add(f.get(i));
		}		
		//System.out.println("-----------------------------------------");
		//System.out.println(hijo1);
		//System.out.println(hijo2);

		Random random = new Random();
		int selectedChild = random.nextInt(2);
		
		//System.out.println(selectedChild);
		
		if(selectedChild==0){
			return hijo1;
		}else{
			return hijo2;
			
		}		
	}
}
