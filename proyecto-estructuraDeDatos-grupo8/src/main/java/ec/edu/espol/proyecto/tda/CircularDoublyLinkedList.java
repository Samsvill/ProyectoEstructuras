/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.proyecto.tda;

import java.util.Iterator;


public class CircularDoublyLinkedList<E> implements List<E> {
    
    private Node<E> last;
    private int size;
    
    public CircularDoublyLinkedList() {
        last = null;
        size = 0;        
    }
    
    private Node<E> getFirst(){
        return last.getNext();
    }
    
    private void setFirst(final Node<E> n) {
        last.setNext(n);
    }
    
    private Node<E> getLast() {
        return last;
    }
    
    private void setLast(final Node<E> n) {
        last = n;
    }
    
    @Override
    public int size() {
        return size;
    }
    
    @Override
    public boolean isEmpty() {
        return getLast() == null;
    }
    
    @Override
    public void clear() {
        if (isEmpty()) {
            return;
        }
        
        for (Node<E> n = getFirst(); n != getLast(); n = n.getNext()) {
            final Node<E> nextNode = n.getNext();
            n.setData(null);
            n.setPrev(null);
            n.setNext(null);
            n = nextNode;
        }
        last = null;
    }
    
    
    private void checkRange(final int indice) {
        if (indice >= size) {
            throw new ArrayIndexOutOfBoundsException(indice);
        }
    }
    
    private Node<E> node(final int indice) {
        checkRange(indice);
        
        if (isEmpty()) return null;
        else if (indice == 0) return getFirst();
        else if (indice == (size - 1)) return getLast();
        
        Node<E> n;
        if (indice < (size >> 1)) {
            n = getFirst();
            for (int i = 0; i < indice; ++i) {
                n = n != null ? n.getNext() : null;
            }
        } else {
            n = getLast();
            for (int i = (size - 1); i > indice; --i) {
                n = n != null ? n.getPrev() : null;
            }
        }
        return n;
    }
    
    @Override 
    public final boolean addFirst(final E e) {
        if (e == null) return false;
        
        final Node<E> newNode = new Node<>(e);
        
        if (isEmpty()) {
            setLast(newNode);
            setFirst(newNode);
            ++size;
            return true;
        }

        newNode.setPrev(getLast());
        newNode.setNext(getFirst());
        getFirst().setPrev(newNode);
        setFirst(newNode);

        ++size;
        return true;
    }
    
    @Override
    public final boolean addLast(final E e) {
        if (e == null) return false;
        
        final Node<E> newNode = new Node<>(e);
        
        if (isEmpty()) {
            setLast(newNode);
            setFirst(newNode);
            ++size;
            return true;
        }

        newNode.setPrev(getLast());
        newNode.setNext(getFirst());
        getFirst().setPrev(newNode);
        setFirst(newNode);
        setLast(newNode);

        ++size;
        return true;
    }
    
    @Override 
    public final void add(final int indice, final E e) {
        checkRange(indice);

        if (e == null) return;
       
        if (indice == 0) {
            addFirst(e);
        } else if (indice == (size - 1)) {
            addLast(e);
        }

        final Node<E> newNode = new Node<>(e);
        Node<E> p = getFirst();
        for (int i = 1; i < indice; i++) {
            p = p.getNext();
        }

        newNode.setPrev(p);
        newNode.setNext(p.getNext());
        p.setNext(newNode);
        newNode.getNext().setPrev(newNode);

        ++size;
    }
    
    @Override 
    public final E removeFirst() {
        if (isEmpty()) return null;
        
        else if (getFirst() == getLast()) {
            final E oldValue = getFirst().getData();
            getFirst().setData(null);
            setFirst(null);
            setLast(null);

            --size;

            return oldValue;
        }

        final E oldValue = getFirst().getData();
        final Node<E> newFirst = getFirst().getNext();
        getFirst().setData(null);
        getFirst().setNext(null);
        setFirst(newFirst);
        getLast().setNext(newFirst);
        newFirst.setPrev(getLast());

        --size;

        return oldValue;
    }
    
    @Override
    public final E removeLast() {
        if (isEmpty()) return null;
        
        else if (getFirst() == getLast()) {
            final E oldValue = getLast().getData();
            getLast().setData(null);
            setFirst(null);
            setLast(null);

            --size;

            return oldValue;
        }

        final E oldValue = getLast().getData();
        final Node<E> newLast = getLast().getPrev();
        newLast.setNext(getLast().getNext());
        getLast().getNext().setPrev(newLast);
        getLast().setData(null);
        getLast().setNext(null);
        getLast().setPrev(null);
        setLast(newLast);

        --size;

        return oldValue;
    }
    
    @Override
    public final E remove(final int indice) {
        checkRange(indice);

        if (isEmpty()) return null;
        
        else if (indice == 0) removeFirst();
        
        else if (indice == (size - 1)) removeLast();

        Node<E> p = getFirst();
        for (int i = 0; i < indice; ++i) {
            p = p.getNext();
        }
        p.getPrev().setNext(p.getNext());
        p.getNext().setPrev(p.getPrev());

        final E oldValue = p.getData();
        p.setData(null);
        p.setPrev(null);
        p.setNext(null);

        --size;

        return oldValue;
    }
    
    @Override
    public final E get(final int indice) {
        return node(indice).getData();
    }
    
    @Override
    public E set(final int indice, final E e) {
        return null;
    }

    @Override
    public boolean contains(final E elem) {
        return false;
    }
    
    @Override
    public Iterator<E> iterator() {

        return new Iterator<E>() {
            private Node<E> firstNode = getFirst();
            private boolean isStarted;

            @Override
            public boolean hasNext() {
                isStarted = (!isEmpty() && !isStarted) || firstNode != getFirst();

                return isStarted;
            }
            
            @Override
            public E next() {
                final E elem = firstNode.getData();
                firstNode = firstNode.getNext();

                return elem;
            }
        };
    }
}
