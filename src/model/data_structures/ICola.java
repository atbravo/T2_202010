package model.data_structures;

import model.logic.Node;

public interface ICola<T>
{
	/**
	 * agrega un elemento al final de la cola
	 */
	public void agregarElemento();
	/**
	 * elimina el primer elemento de la cola
	 * @return el elemento eliminado
	 */
	public Node<T> eliminarElemento();

	/**
	 * Retorna el elemento en la posicion i
	 * @param pos la posicion, inicia desde 0
	 * @return elemento en posicion dada
	 */
	public Node<T> darElementoPosicion(int pos);
	
	/**
	 * retorna el total de elementos en la cola
	 * @return cantidad de elementos en cola 
	 */
	public int darTamaño();
}
