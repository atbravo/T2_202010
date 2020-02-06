package model.data_structures;

import model.logic.Node;

public class Pila<T> implements IPila<T>
{
	/**
	 * El primer elemento de la pila
	 */
	private Node<T> primero;
	/**
	 * El ultimo elemento de la pila
	 */
	private Node<T> ultimo;
	/**
	 * La cantidad de elementos de la pila
	 */
	private int tamaño;

	public Pila()
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
				Node<T> actual = primero;
				for(int i = 0; i < tamaño -1; i++ )
				{
					actual = actual.darSiguiente();
				}
				ultimo = actual;
				ultimo.borrarSiguiente();
				eliminado = ultimo;
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
