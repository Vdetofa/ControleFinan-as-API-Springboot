package com.example.ControleFinancas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ControleFinancas.model.ControleFinancasModel;

@Repository
public interface ControleFinancasRepository extends JpaRepository<ControleFinancasModel, Integer> {
    
}
