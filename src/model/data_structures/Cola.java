package model.data_structures;

import model.logic.Node;

public class Cola<T> implements ICola<T>
{
	/**
	 * El primer elemento de la cola
	 */
	private Node<T> primero;
	/**
	 * El ultimo elemento de la cola
	 */
	private Node<T> ultimo;
	/**
	 * La cantidad de elementos de la cola
	 */
	private int tamaño;

	public Cola()
	{
		primero = null;
		ultimo = null;
		tamaño = 0;
	}
	public void agregarElemento(T elemento)
	{
		Node<T> nuevo = new Node<T>(elemento);
		if(primero == null)
			primero = nuevo;
		else
			ultimo.asignarSiguiente(nuevo);
		ultimo = nuevo;
		tamaño++;
	}
	public T eliminarElemento() throws Exception
	{
		Node<T> eliminado = null;
		if(tamaño == 0)
			throw new Exception("La pila esta vacia");
		else
		{
			if(ultimo.equals(primero))
			{
				eliminado = ultimo;
				ultimo = null;
				primero = null;
			}
			else
			{
				Node<T> nuevoPrimero = primero.darSiguiente();
				primero.asignarSiguiente(null);
				primero = nuevoPrimero;
				
			}
			tamaño--;
			return eliminado.darElemento();
		}
	}
	public T darElementoPosicion(int pos) throws Exception
	{
		if(pos == 0)
			return primero.darElemento();
		else if(pos == tamaño-1)
			return ultimo.darElemento();
		else if(pos >= tamaño)
			throw new Exception("La posicion buscada es mayor al tamaño de la pila");
		else
		{
			Node<T> actual = primero;
			for(int i = 0; i < pos; i++)
			{
				actual = actual.darSiguiente();
			}
			return actual.darElemento();
		}
					
	}
	public int darTamaño()
	{
		return tamaño;
	}

}
