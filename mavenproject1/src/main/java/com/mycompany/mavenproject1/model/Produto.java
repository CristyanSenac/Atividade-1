/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 *
 * @author Cristyan
 */
@Entity
@Table(name = "produtos")
public class Produto {
    
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private Double valor;
    
    @ManyToOne
    @JoinColumn(name = "status_pedido_id")
    private StatusPedido status;

    public Produto(String produto, double valor, StatusPedido status) {
        this.nome = produto;
        this.valor = valor;
        this.status = status;
    }

    public Produto() {
    }


    public String getNome() {
        return nome;
    }

    public Double getValor() {
        return valor;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setStatus(StatusPedido status) {
        this.status = status;
    }

    public StatusPedido getStatus() {
        return status;
    }
    
    
    
    
    
    
    
    
}
