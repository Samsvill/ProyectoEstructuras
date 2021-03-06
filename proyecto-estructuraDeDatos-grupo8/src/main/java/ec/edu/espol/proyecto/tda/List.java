/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ec.edu.espol.proyecto.tda;


public interface List<E> extends Iterable<E> {

    /**
     * Retorna el número de elementos en la colección.
     *
     * @return el número de elementos de la colección
     */
    int size();

    /**
     * Comprueba si la colección no contiene elementos.
     *
     * @return {@code true} si la colección no contiene elementos
     */
    boolean isEmpty();

    /**
     * Remueve todos los elementos de la colección.
     */
    void clear();

    /**
     * Agrega el elemento especificado al inicio de la colección
     *
     * @param e es el elemento que será agregado a la colección
     * @return {@code true} si el elemento se agregó correctamente
     */
    boolean addFirst(final E e);

    /**
     * Agrega el elemento especificado al final de la colección
     *
     * @param e es el elemento que será agregado a la colección
     * @return {@code true} si el elemento se agregó correctamente
     */
    boolean addLast(final E e);

    /**
     * Inserta el elemento enviado en la llamada del método en la posición
     * indicada, desplazando los elementos existentes hacia la derecha.
     *
     * @param indice es el índice al cual el elemento será insertado
     * @param e es el elemento que será insertado en la colección
     */
    void add(final int indice, final E e);

    /**
     * Elimina el primer elemento de la colección, desplazando hacia la izquierda los 
     * elementos mayores al índice.
     *
     * @return retorna el elemento eliminado
     */
    E removeFirst();

    /**
     * Elimina el útlimo elemento de la colección
     * 
     * @return  retirna el elemento eliminado
     */
    E removeLast();

    /**
     * Remueve el elemento de la colección en el índice indicado, desplazando
     * hacia la izquierda los elementos mayores al índice
     *
     * @param indice es el índice del elemento a remover
     * @return retorna el elemento eliminado
     */
    E remove(final int indice);

    /**
     * Retorna el elemento de la colección que se encuentra en el índice
     * indicado
     *
     * @param indice es el índice del elemento a retonar
     * @return retorna el elemento que se encuentra en el índice indicado
     */
    E get(final int indice);

    E set(final int indice, final E e);

    /**
     * Comprueba que el elemento enviado como argumento en nuestro método se
     * encuentre en la colección
     *
     * @param e es el elemento que deseamos comprobar que se encuentre en la
     * colección
     * @return {@code true} si el elemento indicado se encuentra en la colección
     */
    boolean contains(E e);
}
