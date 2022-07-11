/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.proyecto.tda;

import java.util.Iterator;

/**
 *
 * @author saman
 */
public class ArrayList<E> implements List<E>{
    private E[] array;
    private int capacity;
    private int size;
    
    public ArrayList(){
        capacity = 10;
        array = (E[]) new Object[capacity];
        size = 0;
    }
    
    @Override
    public boolean addFirst(E e) {
        if(e == null) return false;
        if(size == capacity) addCapacity();
        for(int i = size-1;i>=0;i--)
            array[i+1] = array[i];
        array[0] = e;
        size++;
        return true;
    }

    @Override
    public boolean addLast(E e) {
        if(e == null) return false;
        if(size == capacity) addCapacity();
        array[size++] = e;
        return true;
    }
    private void addCapacity() {
        capacity = capacity * 2;
        E[] arreglo2 = (E[]) new Object[capacity];
        for (int i = 0; i < size; i++) {
            arreglo2[i] = array[i];
        }
        array = arreglo2;
    }

    @Override
    public E removeLast() {
        if(isEmpty()) return null;
        array[size-1] = null;
        size --;
        return null;
    }

    @Override
    public E removeFirst() {
        if (isEmpty()) return null;
        array[0] = null;
        for(int i=0; i<size-1;i++){
            array[i] = array[i+1];
        }
        removeLast();
        return null;
    }
    

    
    public boolean insert(int index, E e) {
        if(isEmpty() || e==null) return false;
        if(index>size-1 || index<0) throw new IndexOutOfBoundsException("Indice fuera del limite.");
        if(size == capacity) addCapacity();
        for(int i = index; i<size;i++ ){
            array[i+1] = array[i];
        }
        array[index]=e;
        size++;
        return true;
    }

    @Override
    public boolean set(int index, E e) {
        if(e==null || index >size-1) return false; 
        array[index] = e;
        return true;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public E get(int index) {
        if (index > size -1) throw new IndexOutOfBoundsException("El indice pedido supera la capacidad del arreglo");
        return array[index];
    }

    @Override
    public boolean contains(E e) {
        for(int i=0; i<size; i++)
        {
            if(array[i].equals(e))
                return true;
        }
        return false;
    }

    
    @Override
    public E remove(int index) {
        if (index > size -1) return null;
        if(index==0) return removeFirst();
        if(index == size -1) return removeLast();
        if(isEmpty()) return null;
        else{
            for (int i = index; i<=size-2;i++){
                array[i]= array[i+1];
            }
            return removeLast();
        }
    }
    
    public E getFirst(){
        if(isEmpty()) return null;
        return array[0];
    }
    
    public E getLast() {
        if(isEmpty()) return null;
        return array[size-1];
    }

    public int indexOf(E e) {
        if(isEmpty() || e==null) return -1;
        else{
            for(int i = 0;i<size-1; i++){
                if(array[i].equals(e)) return i;
            }
            return -1;
        }
    }

    @Override
    public int size() {
        return size;
    }
    
    @Override
    public String toString()
    {
        if(isEmpty()) return "[]";
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for(int i=0;i<size-1;i++)//hasta el penultimo elemento lleva coma
        {
            sb.append(array[i]);
            sb.append(",");
        }    
        sb.append(array[size-1]);//agrego el ultimo elemento sin coma
        sb.append("]");
        return sb.toString();
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void add(int indice, E e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Iterator<E> iterator() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
