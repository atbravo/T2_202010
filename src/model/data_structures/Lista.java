package model.data_structures;

public class Lista<T>
{
	private Node cabeza;
	private Node actual;
	
	public Lista()
	{
		cabeza = null;
		actual = null;
	}
	
	public void asignarCabeza(T cabe)
	{
		cabeza = new Node<T>(cabe);
		actual = cabeza;
	}
	public void agregarElemento(T elemento)
	{
		Node nuevo = new Node<T>(elemento);
		if(cabeza == null)
			asignarCabeza(elemento);
		else
		{
			Node actual = cabeza;
			Node siguiente = cabeza.darSiguiente();
			while(siguiente !=null)
			{
				actual = siguiente;
				siguiente = actual.darSiguiente();
			}
			actual.asignarSiguiente(nuevo);
		}
	}
	public void eliminarElemento(T elemento)
	{
		Node act = cabeza;
		
		while(act != null)
		{
			if(cabeza != null && cabeza.darElemento().equals(elemento))
				cabeza = cabeza.darSiguiente();
			else if(actual.darSiguiente().darElemento().equals(elemento))
				actual.borrarSiguiente();
		}
	}
}
