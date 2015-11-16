package com.br.lp3.DAO;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author Faganello
 * @param <E>
 */
public interface GenericDAO<E> extends Remote {
    
    public void insert(E e) throws RemoteException;
    
    public void remove(E e) throws RemoteException;
    
    public List<E> readAll() throws RemoteException;
    
    public E read(E e) throws RemoteException;
    
    public void update(E e) throws RemoteException;
    
}
