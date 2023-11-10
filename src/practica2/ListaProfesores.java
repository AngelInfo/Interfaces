package practica2;

import java.util.ArrayList;
import java.util.Comparator;

//Clase que implementa la interfaz lista y crea una lista de profesores.
public class ListaProfesores implements Ilista<Profesor> {
	
	//Atributos
	private ArrayList<Profesor>listaProfesores;

	//Constructor con el array.
	public ListaProfesores() {
		this.listaProfesores = new ArrayList<>();
	}
	
	//Getters y setters.
	public ArrayList<Profesor> getListaProfesores() {
		return listaProfesores;
	}
	public void setListaProfesores(ArrayList<Profesor> listaProfesores) {
		this.listaProfesores = listaProfesores;
	}


	/**
	 * Agrega un nuevo profesor a la lista.
	 */
	@Override
	public void agregar(Profesor object) {
		listaProfesores.add(object);
		
	}
	
	/**
	 * Recorre la lsita de profesores y mediante un equals comprueba que los dos profesores tengan el 
	 * mismo DNI, posteriormente los muestra.
	 */
	@Override
	public Profesor buscar(String DNI) {
		for(Profesor p:listaProfesores) {
			if(p.getDNI().equalsIgnoreCase(DNI)) {
				return p;
			}
		}

        return null;
    }

	/**
	 * Elimina un profesor de la lista profesores.
	 */
	@Override
	public void eliminar(Profesor p) {
			listaProfesores.remove(p);


		
	}
	
	/**
	 * Recorre la lista mediante bucle, compara DNI y muestra profesor.
	 * @param DNI
	 */
	public void mostrarProfesor(String DNI) {
		for(Profesor p:listaProfesores) {
			if(p.getDNI().equals(DNI)) {
				System.out.println(p.toString());
			}
		}
	}
	
	/**
	 * Recorre la lista mediante bucle, compara DNI  y eliminar la asignatura, llamando al método de 
	 * la clase profesor,
	 * @param DNI
	 * @param asg
	 */
	public void eliminarAsignaturasProfesor(String DNI) {
		for(Profesor p:listaProfesores) {
			if(p.getDNI().equals(DNI)) {
				p.eliminarAsignaturas();
			}
		}
	}
	
	/**
	  * Recorre la lista mediante bucle, compara DNI  y agrega la asignatura, llamando al método de 
	 * la clase profesor,
	 * @param DNI
	 * @param asg
	 */
	public void añadirAsignaturasProfesor(String DNI,String asg) {
		for(Profesor p:listaProfesores) {
			if(p.getDNI().equals(DNI)) {
				p.agregarAsignatura(asg);
			}
		}
	}
	

	/**
	 * Recorre lista y muestra información de profesores.(Método de interfaz lista)
	 */
	@Override
	public void listar() {
		for(Profesor p:listaProfesores) {
				System.out.println(p.toString());
			}
		}
		
	/**
	 * Recorre lista y muestra profesores tutores, comprabando que no tienen curso mediante el constructor
	 * que he creado previamente en la clase profesor.
	 */
	public void listarTutores() {
		for(Profesor p: listaProfesores) {
			if(p.getCurso() != null	) {
				System.out.println(p.toString());	
			}
		}
	}
	
	/**
	 * Recorre la lista de profesores y la lista de sus asignaturas para comprobar mediante equals
	 * si tienen esa asignatura y listar esos profesores.
	 * @param Asignatura
	 */
	public void listarPorAsignatura(String Asignatura) {
		for(Profesor p: listaProfesores) {
			for(int i=0;i<p.getListaAsignaturas().size();i++) {
				if(p.getListaAsignaturas().get(i).equals(Asignatura)) {
					System.out.println(p.toString());
				}
			}
		}
	}
	
	/**
	 * Recorre lista y comprueba mediante el metodo buscarAsignatura que el profesor tiene esa asignatura
	 * @param asg
	 * @return
	 */
	public boolean buscarAsignaturaProfesor(String asg) {
		for(Profesor p: listaProfesores) {
			if(p.buscarAsignatura(asg)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Con este método ordeno alfabeticamente la lista de profesores, utilizo una clase comparator con
	 * la que ordenar los profesore por el nombre.
	 */
	public void ordenarAlfabeticamente() {
		listaProfesores.sort(new Comparator<Profesor>() {
			@Override
			public int compare(Profesor o1, Profesor o2) {
				return o1.getNombre().compareToIgnoreCase(o2.getNombre());
			}
		});
	}
	

	

}
