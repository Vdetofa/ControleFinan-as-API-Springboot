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

    private String Descricao;
    private double valor;
    private String tipo;
    private LocalDateTime data;

    public ControleFinancasModel(){}
    
    public ControleFinancasModel(String Descricao,double valor, String tipo, LocalDateTime data){
        this.Descricao= Descricao;
        this.valor=valor;
        this.tipo=tipo;
        this.data=data;
    }
    
    public int getID(){return id;}
    public String getDescricao(){return Descricao;}
    public double getValor(){return valor;}
    public String getTipo(){return tipo;}
    public LocalDateTime getData(){return data;}
    
    

    
}