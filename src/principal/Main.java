package principal;

import java.util.ArrayList;
import java.util.Random;

public class Main {
	// population
	public static ArrayList<ArrayList<Integer>> population;
	public static int currentGeneration = 0;
	public static int populationLength = 20;

	public static void main(String[] args) {
		// 1. Generar la primera poblacion
		population = new ArrayList<ArrayList<Integer>>();
		Random rnd = new Random();
		for (int i = 0; i < populationLength; i++) {
			// 1.a - Generamos cada cromosoma
			ArrayList<Integer> chromosome = new ArrayList<Integer>();
			for (int j = 0; j < 10; j++) {
				
				// 1.b - Rellenamos de genes al cromosoma
				chromosome.add(rnd.nextInt(10));
			}

			// 1.c - Agregamos al cromosoma a la poblacion
			population.add(chromosome);
		}

		// 2. Correr el loop de la simulacion
		while (!solutionFound()) {
			selection();
			crossover();
			mutation();
			updatePopulation();
		}
	}

	public static boolean solutionFound() {
		// TODO: Chequear si algun individuo supera el fitness esperado
		if (population.size() == 1) {
			System.out.println("###########Mejor Camino###################");
			System.out.println(population);
			System.out.println("##########################################");
			return true;
		} else {
			return false;
		}

	}

	public static ArrayList<ArrayList<Integer>> selectedParents;

	public static void selection() {
		// TODO: Elegimos a N individuos para reproducirse
		if (selectedParents == null)
			selectedParents = new ArrayList<ArrayList<Integer>>();
		else
			selectedParents.clear();

		// 1. Ordenar y seleccionar los individuos de population para reproducir
		Util.orderPopulation(population);
		// 2. agregar estos individuos a "selectedParents".
		selectedParents.addAll(population);

	}

	public static ArrayList<ArrayList<Integer>> childrens;

	public static void crossover() {
		// TODO: Reproducimos a los N individuos seleccionados y creamos
		// individuos para la proxima generacion
		if (childrens == null) {
			childrens = new ArrayList<ArrayList<Integer>>();
		} else {
			childrens.clear();
		}
		// 1. Recorremos los padres y los reproducimos.
		while (selectedParents.size() >= 2) {
			ArrayList<Integer> father = Util.getParent(selectedParents);
			ArrayList<Integer> mother = Util.getParent(selectedParents);

			// 2. Los hijos resultado de la cruza van a "children".
			ArrayList<Integer> childrenSeleccionado = Util.combine(father, mother);
			childrens.add(childrenSeleccionado);
		}

	}

	public static void mutation() {

		// TODO: Modificamos los genes de los individuos hijos con un rate muy
		// bajo
		//cambia los valores del array según su posición
		for (ArrayList<Integer> child : childrens) {
			Integer temp = child.get(3);
			child.set(3, child.get(7));
			child.set(7, temp);
		}
	}

	public static void updatePopulation() {
		// TODO: Descartar individuos de la poblacion y reemplazarlos con los
		// hijos que creamos en crossover()
		population = childrens;
	}

}
