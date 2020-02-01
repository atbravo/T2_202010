package model.data_structures;

public class Lista<T> implements ILista<T> {
	private Node cabeza;
	private Node actual;

	public Lista() {
		cabeza = null;
		actual = null;
	}

	/**
	 * Asigna el nodo dado por parametro como el primero de la lista y el actual
	 * 
	 * @param cabe
	 */
	public void crearLista(T cabe) {
		cabeza = new Node<T>(cabe);
		actual = cabeza;
	}

	/**
	 * Agrega el elemento dado por parametro al final de la lista
	 */
	public void agregarElemento(T elemento) {
		Node nuevo = new Node<T>(elemento);
		if (cabeza == null)
			crearLista(elemento);
		else {
			Node actual = cabeza;
			Node siguiente = cabeza.darSiguiente();
			while (siguiente != null) {
				actual = siguiente;
				siguiente = actual.darSiguiente();
			}
			actual.asignarSiguiente(nuevo);
		}
	}

	/**
	 * Elimina al elemento dado por parametro, si este no existe no hace nada
	 */
	public void eliminarElemento(T elemento) {
		Node act = cabeza;

		if (cabeza != null && cabeza.darElemento().equals(elemento)) {
			cabeza = cabeza.darSiguiente();
			return;
		}

		while (act != null && act.darSiguiente() != null) {
			if (actual.darSiguiente().darElemento().equals(elemento))
				actual.borrarSiguiente();
		}
	}

	@Override
	public int darTamaño() {
		Node act = cabeza;
		int i = 0;
		while (act != null) {
			i++;
			act = act.darSiguiente();
		}
		return i;
	}

	@Override
	public T darElementoPosicion(int pos) {
		Node act = cabeza;
		int i = 0;
		while (act != null && i < pos) {
			i++;
			act = act.darSiguiente();
		}
		if (act == null)
			return null;
		return (T) act.darElemento();
	}

	@Override
	public T recorrerActual(int i) {
		Node act = cabeza;
		while (act != null && i > 0) {
			act = act.darSiguiente();
			i--;
		}
		if (act == null && cabeza == null) {
			actual = null;
			return null;
		} else if (act == null)
			actual = cabeza;
		return (T) actual.darElemento();
	}

	@Override
	public T darElementoActual() {
		if (actual != null)
			return (T) actual.darElemento();
		return null;
	}

	public T avanzarActual() {
		if (actual != null)
			actual = actual.darSiguiente();
		if (actual == null && cabeza == null)
			return null;
		else if (actual == null)
			actual = cabeza;
		return (T) actual.darElemento();

	}

	@Override
	public T volverActual() {
		Node act = cabeza;
		boolean ya = false;

		if (cabeza == null)
			return null;
		else if (!actual.equals(cabeza)) {
			while (act != null && act.darSiguiente() != null && !ya) {
				if (act.darSiguiente().equals(actual)) {
					actual = act;
					ya = true;
				}

				actual = actual.darSiguiente();
			}
		}
		return (T) actual.darElemento();
	}

}
