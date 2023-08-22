/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1.dao;


import com.mycompany.mavenproject1.model.Produto;
import com.mycompany.mavenproject1.model.StatusPedido;
import com.mycompany.mavenproject1.util.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

/**
 *
 * @author Cristyan
 */
public class ProdutoDao {



    public void salvar(Produto produto) {
        
        
        EntityManager em = JPAUtil.getEntityManager();
        
        try{
            em.getTransaction().begin();
            em.persist(produto);
            em.getTransaction().commit();
        }catch(Exception e){
            em.getTransaction().rollback();
            System.out.println("Erro ao salvar dados: " + e.getMessage());

        }finally{
            JPAUtil.closeEtityManager();
        }
        
    }

    public StatusPedido getStatusPedido(Integer id){
        StatusPedido tipo = null;
        EntityManager em = JPAUtil.getEntityManager();
        String query = "SELECT sp FROM StatusPedido sp WHERE id = :id";


        

        try{
            TypedQuery<StatusPedido> typedQuery = em.createQuery(query, StatusPedido.class);
            typedQuery.setParameter("id", id );
            tipo = typedQuery.getSingleResult();

        }catch(Exception e){
            System.out.println("Erro ao buscar dados: " + e.getMessage());
        }finally{
            JPAUtil.closeEtityManager();
        }
        
        return tipo;
    }  
    
    public void venderProduto(String id){
        EntityManager em = JPAUtil.getEntityManager();
        
        Produto produto = getProduto(id);
        produto.setStatus(getStatusPedido(2));
        
        try{
            em.getTransaction().begin();
            em.persist(produto);
            em.getTransaction().commit();
        }catch(Exception e){
            em.getTransaction().rollback();
            System.out.println("Erro ao atualizar dados: " + e.getMessage());

        }finally{
            JPAUtil.closeEtityManager();
        }
    }

    public Produto getProduto(String id){
        Produto produto = null;
        EntityManager em = JPAUtil.getEntityManager();
        String query = "SELECT p FROM produto p WHERE p.id = :id";
        
        try{
            TypedQuery<Produto> typedQuery = em.createQuery(query, Produto.class);
            typedQuery.setParameter("id", id);
            produto = typedQuery.getSingleResult();

        }catch(Exception e){
            System.out.println("Erro ao buscar dados: " + e.getMessage());
        }finally{
            em.close();
            JPAUtil.closeEtityManager();
        }
        
        return produto;
       }
}
