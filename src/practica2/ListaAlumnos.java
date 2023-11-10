package practica2;

import java.util.ArrayList;
import java.util.Comparator;

//En esta nueva clase  creo un  arraylist de alumnos e implementa la interfaz lista.
public class ListaAlumnos implements Ilista<Alumno>  {

	//Creo el atributo que declararé en el constructor.
	private ArrayList <Alumno> listaAlumnos;

	//Constructor con el array.
	public ListaAlumnos() {
		super();
		this.listaAlumnos = new ArrayList <>();
	}
	
	//Getters y setters
	public ArrayList<Alumno> getListaAlumnos() {
		return listaAlumnos;
	}
	public void setListaAlumnos(ArrayList<Alumno> listaAlumnos) {
		this.listaAlumnos = listaAlumnos;
	}


	/**
	 * Método que agrega un nuevo alumno a la lista.
	 */
	@Override
	public void agregar(Alumno object) {
		listaAlumnos.add(object);
	}

	/**
	 * En este método pido un String que mediante un bucle compara el DNI de los alumnos y cuando lo encuentra
	 * enseña su información con el toString.
	 * 
	 */
	@Override
	public Alumno buscar(String DNI) {
		for(Alumno a: listaAlumnos) {
			if(a.getDNI().equals(DNI)) {
				return a;
			}
		}

        return null;
    }

	/**
	 * Pido el DNI del alumno por parámetro y busco con un bucle en la lista de Alumnos, cuando lo encuentra,
	 * compara sus DNIs con el equals y elimina el alumno de la lista.
	 */
	@Override
	public void eliminar(Alumno a) {
		listaAlumnos.remove(a);
		
	}

	/**
	 * Metodo que recorre la lista y muestra la información de todos los alumnos con el toString.
	 */
	@Override
	public void listar() {
		for(Alumno a:listaAlumnos) {
			System.out.println(a.toString());
		}
		
	}
	
	/**
	 * Con este método ordeno alfabeticamente la lista de alumnos, utilizo una clase comparator con
	 * la que ordenar los alumnos por el nombre.
	 */
	public void ordenarAlfabeticamente() {
		listaAlumnos.sort(new Comparator<Alumno>() {

			@Override
			public int compare(Alumno o1, Alumno o2) {
				return o1.getNombre().compareToIgnoreCase(o2.getNombre());
			}
		});
	}
	
	/**
	 * Este método busca el alumno con el DNI que introducimos por parámetro y agrega un nota a su array de notas
	 * llamando al método de la clase alumno.
	 * @param DNI
	 * @param nota
	 */
	public void agregarNotaAlumno(String DNI,double nota) {
		for(Alumno a: listaAlumnos) {
			if(a.getDNI().equalsIgnoreCase(DNI)) {
				a.agregarNota(nota);
			}
		}
	}
	
	/**
	 * Para este metodo introduzco un DNI por parámetro que al encontrar al alumno mediante un bucle con el mismo DNI
	 * llama al metodo eliminar notas y elimnia todas sus notas.
	 * @param DNI
	 */
	public void eliminarNotasAlumno(String DNI) {
		for(Alumno a: listaAlumnos) {
			if(a.getDNI().equalsIgnoreCase(DNI)) {
				a.eliminarNotas();
			}
		}
	}
	
	/**
	 * Muestra los alumnos que tienen e mismo curso que se introduce por parámetro.
	 * @param c
	 */
	public void mostrarAlumnosCurso(Curso c) {
		
		for(Alumno a:listaAlumnos) {
			if(a.getCurso().equals(c)) {
				System.out.println(a.toString());
			}
		}
	}
	
	/**
	 * Este método recorre la lista de alumnos y llama al método mediaNota para mostrar solo alumnos
	 * con un nota superior a 5.
	 */
	public void listarAprobados() {
		for(Alumno a:listaAlumnos) {
			if(a.mediaNota()>=5) {
				System.out.println(a.toString());
			}
		}
	}
	
	/**
	 * Este método recorre la lista de alumnos y llama al método mediaNota para mostrar solo alumnos
	 * con un nota inferior a 5.
	 */
	public void listarSuspensos() {
		for(Alumno a:listaAlumnos) {
			if(a.mediaNota()<5) {
				System.out.println(a.toString());
			}
		}
	}
	
	
}
