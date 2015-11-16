/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp3.DAO;

import com.br.lp3.model.entities.Membro;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class MembroDAO implements GenericDAO<Membro> {

    private final String PU = "LP3_BancoPU";
    EntityManagerFactory emf;
    EntityManager em;

    public MembroDAO() throws RemoteException {
        emf = Persistence.createEntityManagerFactory(PU);
        em = emf.createEntityManager();
    }

    @Override
    public void insert(Membro m) throws RemoteException {
        em.getTransaction().begin();
        em.persist(m);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void remove(Membro m) throws RemoteException {
        em.getTransaction().begin();
        Membro membro = read(m);
        em.remove(membro);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public List<Membro> readAll() throws RemoteException {
        List<Membro> membros = new ArrayList<>();
        Query query = em.createNamedQuery("Membro.findAll");
        membros = query.getResultList();
        return membros;
    }

    @Override
    public void update(Membro m) throws RemoteException {
        em.getTransaction().begin();
        Membro atualizado = readById(m.getIdMembro());
        atualizado.setEmail(m.getEmail());
        atualizado.setJogoList(m.getJogoList());
        atualizado.setNascimento(m.getNascimento());
        atualizado.setNome(m.getNome());
        atualizado.setSobrenome(m.getSobrenome());
        //TODO
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private Membro readById(int id) {
        return em.find(Membro.class, id);
    }
    
    @Override
    public Membro read(Membro e) throws RemoteException {
        return em.find(Membro.class, e.getIdMembro());
    }

}
