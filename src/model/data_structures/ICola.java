package model.data_structures;

import model.logic.Node;

public interface ICola<T>
{
	/**
	 * agrega un elemento al final de la cola
	 */
	public void agregarElemento(T elemento);
	/**
	 * elimina el primer elemento de la cola
	 * @return el elemento eliminado
	 * @throws Exception 
	 */
	public T eliminarElemento() throws Exception;

	/**
	 * Retorna el elemento en la posicion i
	 * @param pos la posicion, inicia desde 0
	 * @return elemento en posicion dada
	 * @throws Exception 
	 */
	public T darElementoPosicion(int pos) throws Exception;
	
	/**
	 * retorna el total de elementos en la cola
	 * @return cantidad de elementos en cola 
	 */
	public int darTamaño();
}
