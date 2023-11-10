package practica2;

import java.util.ArrayList;
import java.util.Comparator;

//clase que crea un lista de cursos, implementa la interfaz curso.
public class ListaCursos implements Ilista<Curso> {
	//Atributos
	private ArrayList<Curso> listaCursos;

	//Constructor con array lista.
	public ListaCursos() {
		super();
		this.listaCursos = new ArrayList<>();
	}

	public ArrayList<Curso> getListaCursos() {
		return listaCursos;
	}

	//Agrega curso al array.
	@Override
	public void agregar(Curso object) {
		listaCursos.add(object);
		
	}

	/**
	 * Recorre lista, compara el codigo y muestra información del curso.
	 */
	@Override
	public Curso buscar(String codigo) {
		for(Curso c:listaCursos) {
			if(c.getCodigo().equalsIgnoreCase(codigo)) {
				return c;
			}
		}

        return null;
    }

	/**
	 * Recorre lista, compara codigo y eliminar curso.
	 */
	@Override
	public void eliminar(Curso curso) {
			listaCursos.remove(curso);

	}

	/**
	 * Recorre lista y muestra la información de los cursos
	 */
	@Override
	public void listar() {
		for(Curso c:listaCursos) {
			System.out.println(c.toString());
		}
		
	}
	public void ordenarAlfabeticamente() {
		listaCursos.sort(new Comparator<Curso>() {

			@Override
			public int compare(Curso o1, Curso o2) {
				return o1.getNombre().compareToIgnoreCase(o2.getNombre());
			}
		});
	}
	
}
