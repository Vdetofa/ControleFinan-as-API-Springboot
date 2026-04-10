package com.example.ControleFinancas.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ControleFinancasModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    private String descricao;
    private double valor;
    private String tipo;
    private LocalDateTime data;

    public ControleFinancasModel(){}
    
    public ControleFinancasModel(String descricao,double valor, String tipo, LocalDateTime data){
        this.descricao= descricao;
        this.valor=valor;
        this.tipo=tipo;
        this.data=data;
    }
    
    public int getID(){return id;}
    public String getDescricao(){return descricao;}
    public double getValor(){return valor;}
    public String getTipo(){return tipo;}
    public LocalDateTime getData(){return data;}
    
    public void setData(LocalDateTime data){
        this.data=data;
    }
    

    
}