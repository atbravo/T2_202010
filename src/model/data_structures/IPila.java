package model.data_structures;

import model.logic.Node;

public interface IPila<T>
{
	/**
	 * agrega un elemento al final de la pila
	 */
	public void agregarElemento();
	/**
	 * elimina el ultimo elemento de la pila
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
	 * retorna el total de elementos en la pila
	 * @return cantidad de elementos en pila
	 */
	public int darTamaño();
	
	
}
