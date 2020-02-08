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
	private int tama�o;	

	public Pila()	
	{	
		primero = null;	
		ultimo = null;	
		tama�o = 0;	
	}	
	
	/**
	 * Retorna el ultimo elemento de la pila
	 * @return ultimo
	 */
	public T darUltimo()
	{
		return ultimo.darElemento();
	}
	public void agregarElemento(T elemento)	
	{	
		Node<T> nuevo = new Node<T>(elemento);	
		if(primero == null)	
			primero = nuevo;	
		else	
			ultimo.asignarSiguiente(nuevo);	
		ultimo = nuevo;	
		tama�o++;	
	}	
	public T eliminarElemento() throws Exception	
	{	
		Node<T> eliminado = null;	
		if(tama�o == 0)	
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
				for(int i = 0; i < tama�o -1; i++ )	
				{	
					actual = actual.darSiguiente();	
				}	
				ultimo = actual;	
				ultimo.borrarSiguiente();	
				eliminado = ultimo;	
			}	
			tama�o--;	
			return eliminado.darElemento();	
		}	
	}	
	public T darElementoPosicion(int pos) throws Exception	
	{	
		if(pos == 0)	
			return primero.darElemento();	
		else if(pos == tama�o-1)	
			return ultimo.darElemento();	
		else if(pos >= tama�o)	
			throw new Exception("La posicion buscada es mayor al tama�o de la pila");	
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
	public int darTama�o()	
	{	
		return tama�o;	
	}	

}
