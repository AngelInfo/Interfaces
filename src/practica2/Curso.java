package practica2;

import java.util.Objects;

//Creo la clase curso.
public class Curso {
	//Atributos de la clase.
	private String Codigo;
	private String nombre;
	
	//Constructor con los atributos.
	public Curso(String codigo, String nombre) {
		Codigo = codigo;
		this.nombre = nombre;
	}
	
	//Getters y setters.
	public String getCodigo() {
		return Codigo;
	}
	public void setCodigo(String codigo) {
		Codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
		
	/**
	 * Método que muestra la información del curso.
	 */
	@Override
	public String toString() {
		return "Curso [Codigo=" + Codigo + ", nombre=" + nombre + "]";
	}

	//Equals y hascode que me permitirán comparar cursos.
	@Override
	public int hashCode() {
		return Objects.hash(Codigo, nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Curso other = (Curso) obj;
		return Objects.equals(Codigo, other.Codigo) && nombre.equalsIgnoreCase(other.nombre);
	}
	
}
