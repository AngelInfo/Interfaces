package practica2;

import java.util.ArrayList;

//Creo la clase alumno que hereda de persona.
public class Alumno extends Persona {
	
	//Le añado dos atributos nuevos.
	private Curso curso;
	private ArrayList <Double> listaNotas;
	
	//Heredo los atributos del constructor de persona y añado 2 atributos nuevos.
	public Alumno(String nombre, String dNI, int tlf, int edad, Curso curso) throws CursoNoEncontrado {
		super(nombre, dNI, tlf, edad);
		if (curso == null){
			throw new CursoNoEncontrado("El curso no existe, escoge un curso existente o crea uno nuevo");
		}
		this.curso = curso;
		this.listaNotas = new ArrayList<>();
		
	}
	
	
	
	
	//Getters y setters
	public Curso getCurso() {
		return curso;
	}
	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	public ArrayList<Double> getListaNotas() {
		return listaNotas;
	}
	public void setListaNotas(ArrayList<Double> listaNotas) {
		this.listaNotas = listaNotas;
	}

	//Con este método agrego una nota al arraylist listaNotas y pido la nota por parámetro.
	public void agregarNota(double nota) {
		listaNotas.add(nota);
	}
	
	//Con este método elimino todas las notas del arraylist listaNotas.
	public void eliminarNotas() {
		listaNotas.clear();
	}
	
	/**
	 * En este método mediante un bucle recorro toda la lista de asignaturas, sumo y guardo las notas en una variable
	 * y consigo la media dividiendolo por un contador que me cuenta cuantas asignaturas hay en el array.
	 * @return
	 */
	public double mediaNota() {
		double total = 0;
		double contador = 0;
		for(int i=0;i<listaNotas.size();i++) {
			total = total + listaNotas.get(i);
			contador++;
		}
		
		double media = total/contador;
		
		return media;
	}


	/**
	 * Metodo tu string para mostrar información del alumno.
	 */
	@Override
	public String toString() {
		
		return super.toString() +  "Alumno [curso=" + curso + ", listaNotas=" + listaNotas + "]";
		
	}




	
	
	
	
}
