package practica2;

//Interfaz que se usara en las clases profesor, alumno y curso. Los métodos agregar y eliminar permiten
//varias clases.
 interface Ilista<T> {
	 void agregar(T object);
	 T buscar(String object);
	 void eliminar(T object);
	 void listar();
	 
}
