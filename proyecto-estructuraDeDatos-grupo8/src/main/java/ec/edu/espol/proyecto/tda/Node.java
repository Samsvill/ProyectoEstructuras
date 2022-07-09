/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.proyecto.tda;

/**
 * Esta clase Node es para Doubly LinkedList
 * 
 * @param <E> es el tipo de dato para el Node
 */
public class Node<E> {

    private E data;
    private Node<E> next;
    private Node<E> prev;

    public Node() {
        this(null, null, null);
    }

    public Node(final E data) {
        this(null, data, null);
    }

    public Node(final Node<E> prev, final E data, final Node<E> next) {
        this.prev = prev;
        this.data = data;
        this.next = next;
    }

    public final E getData() {
        return data;
    }

    public final void setData(final E data) {
        this.data = data;
    }

    public final Node<E> getNext() {
        return next;
    }

    public final void setNext(final Node<E> next) {
        this.next = next;
    }

    public final Node<E> getPrev() {
        return prev;
    }

    public final void setPrev(final Node<E> prev) {
        this.prev = prev;
    }
}
