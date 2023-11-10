package practica2;

import java.util.ArrayList;

//Creo una nueva clase profesor que hereda de persona.
public class Profesor extends Persona {
	
	//Incluye 2 atributos nuevos a aparte de los heredados por la clase padre.
	private Curso curso;
	private ArrayList <String> listaAsignaturas;

	//Constructor con los atributos heredados.
	public Profesor(String nombre, String dNI, int tlf, int edad, Curso curso) throws CursoNoEncontrado {
		super(nombre, dNI, tlf, edad);
		if (curso == null){
			throw new CursoNoEncontrado("El curso no existe, escoge un curso existente o crea uno nuevo");
		}
		this.curso = curso;
		this.listaAsignaturas = new ArrayList<>();
	}
	
	
	//Creo un nuevo constructor pero esta vez sin curso que lo utilizaré más adelante para comprobar si un profesor es tutor.
	public Profesor(String nombre, String dNI, int tlf, int edad) {
		super(nombre, dNI, tlf, edad);
		this.listaAsignaturas =  new ArrayList<>();
	}


	//Getters y setters.
	public Curso getCurso() {
		return curso;
	}
	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	public ArrayList<String> getListaAsignaturas() {
		return listaAsignaturas;
	}
	public void setListaAsignaturas(ArrayList<String> listaAsignaturas) {
		this.listaAsignaturas = listaAsignaturas;
	}
	
	/**
	 * Añado una asignatura al array previamente creado de asignaturas y para ello pido que se le pase un 
	 * curso por parametro.
	 * @param curso
	 */
	public void agregarAsignatura(String curso) {
		listaAsignaturas.add(curso);
	}
	
	/**
	 * Elimino todas las asginaturas del array listaAsignaturas.
	 */
	public void eliminarAsignaturas() {
		listaAsignaturas.clear();
	}
	
	/**
	 * En este metodo le paso un string por parámetro el cual será buscado mediante un bucle en el
	 * array listaAsignaturas y devolverá true o false.
	 * @param asg
	 * @return
	 */
	public boolean buscarAsignatura(String asg) {
		for(int i = 0;i<listaAsignaturas.size();i++) {
			if(listaAsignaturas.get(i).equalsIgnoreCase(asg)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Método que muestra la información del profesor.
	 */
	@Override
	public String toString() {
		return super.toString() + "Profesor [curso=" + curso + ", listaAsignaturas=" + listaAsignaturas + "]";
		
	}
	
		
	

}
