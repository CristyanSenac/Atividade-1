/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1.dao;


import com.mycompany.mavenproject1.model.Produto;
import com.mycompany.mavenproject1.util.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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


}
