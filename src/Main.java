import java.util.ArrayList;
import java.util.Random;

public class Main 
{
	//population
	public static ArrayList<ArrayList<Integer>> population;
	public static int populationLength = 10;
	public static void main(String[] args) 
	{
		//1. Generar la primera poblacion
		population = new ArrayList<ArrayList<Integer>>();
		Random rnd = new Random();
		for (int i = 0; i < populationLength; i++) 
		{
			//1.a - Generamos cada cromosoma
			ArrayList<Integer> chromosome = new ArrayList<Integer>(); 
			for (int j = 0; j < 10; j++)
			{
				//1.b - Rellenamos de genes al cromosoma
				chromosome.add(rnd.nextInt(10));
			}
			
			//1.c - Agregamos al cromosoma a la poblacion
			population.add(chromosome);
		}
		
		//2. Correr el loop de la simulacion
		while ( !solutionFound() )
		{
			selection(); 
			crossover();
			mutation();
			updatePopulation();
		}
	}
	
	public static boolean solutionFound()
	{
		//TODO: Chequear si algun individuo supera el fitness esperado
		return false;
	}
	
	public static ArrayList<ArrayList<Integer>> selectedParents;
	
	public static void selection()
	{
		//TODO: Elegimos a N individuos para reproducirse
		if(selectedParents == null)
			selectedParents = new ArrayList<ArrayList<Integer>> ();
		else
			selectedParents.clear();
		
		//1. Ordenar y seleccionar los individuos de population para reproducir
		//2. agregar estos individuos a "selectedParents".
	}
	
	public static ArrayList<ArrayList<Integer>> childrens;
	
	public static void crossover()
	{
		//TODO: Reproducimos a los N individuos seleccionados y creamos individuos para la proxima generacion
		if(childrens == null)
		   childrens = new ArrayList<ArrayList<Integer>> ();
		else
			childrens.clear();
		
		//1. Recorremos los padres y los reproducimos.
		//2. Los hijos resultado de la cruza van a "children".
	}
	
	public static void mutation()
	{
		//TODO: Modificamos los genes de los individuos hijos con un rate muy bajo
		//1. recorrer con un for todos "children"
		//2. Tiramos un random con un valor MUY chico, y en caso de caso de salir favorecido lo mutamos.
	}
	
	public static void updatePopulation()
	{
		//TODO: Descartar individuos de la poblacion y reemplazarlos con los hijos que creamos en crossover()
		//1. Seleccionar los individuos a eliminar
		//2. removemos estos individuos de "population"
		//3. Agregamos a population los elementos de children
	}
	
	
}
