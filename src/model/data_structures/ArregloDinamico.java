package model.data_structures;

/**
 * 2019-01-23
 * Estructura de Datos Arreglo Dinamico de Strings.
 * El arreglo al llenarse (llegar a su maxima capacidad) debe aumentar su capacidad.
 * @author Fernando De la Rosa
 *
 */
public class ArregloDinamico <T extends Comparable<T>> implements IArregloDinamico <T> {
		/**
		 * Capacidad maxima del arreglo
		 */
        private int tamanoMax;
		/**
		 * Numero de elementos presentes en el arreglo (de forma compacta desde la posicion 0)
		 */
        private int tamanoAct;
        /**
         * Arreglo de elementos de tamaNo maximo
         */
        private T elementos[];

        /**
         * Construir un arreglo con la capacidad maxima inicial.
         * @param max Capacidad maxima inicial
         */
		public ArregloDinamico( int max )
        {
            elementos =(T[]) new Comparable [max];
               tamanoMax = max;
               tamanoAct = 0;
        }
		@Override
		public void agregar( T dato )
        {
               if ( tamanoAct == tamanoMax )
               {  // caso de arreglo lleno (aumentar tamaNo)
                    tamanoMax = 2 * tamanoMax;
                    T [ ] copia = elementos;
                    //elementos = new T [tamanoMax];
                    elementos =(T[]) new Comparable [tamanoMax];
                    for ( int i = 0; i < tamanoAct; i++)
                    {
                     	 elementos[i] = copia[i];
                    } 
            	    System.out.println("Arreglo lleno: " + tamanoAct + " - Arreglo duplicado: " + tamanoMax);
               }	
               elementos[tamanoAct] = dato;
               tamanoAct++;
       }
		@Override
		public int darCapacidad() {
			return tamanoMax;
		}
		@Override
		public int darTamano() {
			return tamanoAct;
		}
		@Override
		public T darElemento(int i) {
			// TODO HECHO implementar
			return (T) elementos[i];
		}
		@Override
		public T buscar(T dato) {
			// TODO HECHO implementar
			// Recomendacion: Usar el criterio de comparacion natural (metodo compareTo()) definido en Strings.
			for (int i =0; i<tamanoMax; i++)
			{
				if (((Comparable) elementos[i]).compareTo(dato)==0)
					return dato;
			}
			return null;
		}
		@Override
		public T eliminar(T dato) {
			// TODO HECHO implementar
			// Recomendacion: Usar el criterio de comparacion natural (metodo compareTo()) definido en Strings.
			T guardar=null;
			boolean encontrado = false;
			for (int i =0; i<tamanoMax && !encontrado; i++)
			{
				if (((Comparable) elementos[i]).compareTo(dato)==0)
				{
					encontrado=true; 
					guardar=elementos[i];	
					for (int j=0; j<tamanoMax-1;j++)
					{
						elementos[i]=elementos[j];
					}
				}
			}
			return guardar;
		}


}