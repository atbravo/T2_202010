package model.logic;

public class Node<T> 
{
	/**
	 * Elemento de tipo T que se pude guardar en el nodo
	 */
	private T elemento;
	/**
	 * Siguiente nodo 
	 */
	private Node siguiente;
	
	/**
	 * Creacion de un nuevo nodo para la estructura de datos 
	 * @param elem elemento que se desea colocar en el nodo
	 */
	public Node(T elem)
	{
		elemento = elem;
		siguiente = null;
	}
	/**
	 * Retorna el elemento del nodo
	 * @return elemento 
	 */
	public T darElemento()
	{
		return elemento;
	}
	/**
	 * Retorna el Nodo siguiente
	 * @return siguiente 
	 */
	public Node darSiguiente()
	{
		return siguiente;
	}
	/**
	 * Realiza el cambio al nodo siguiente 
	 * @param sig nodo por el cual se desea cambiar el nodo siguiente.
	 */
	public void asignarSiguiente(Node sig)
	{
		siguiente = sig;
	}
	/**
	 * elimina el nodo siguiente de la estructura de datos 
	 */
	public void borrarSiguiente()
	{
		if(siguiente !=null)
		{
			siguiente = siguiente.darSiguiente();
		}
		else
			siguiente = null;
	}
}
