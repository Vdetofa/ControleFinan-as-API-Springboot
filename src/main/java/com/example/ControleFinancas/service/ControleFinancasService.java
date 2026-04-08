package com.example.ControleFinancas.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ControleFinancas.model.ControleFinancasModel;
import com.example.ControleFinancas.repository.ControleFinancasRepository;

@Service
public class ControleFinancasService {
    @Autowired
    private ControleFinancasRepository repository;

    public void registrar(ControleFinancasModel financas){
        if(financas.getValor()>0){
            if (financas.getData() != null) {
                 repository.save(financas);
            }else{
                financas.setData(LocalDateTime.now());
                 repository.save(financas);
            }
        }else{
            System.out.println("Erro: O valor deve ser maior que zero.");
        }
    }
    
    public List<ControleFinancasModel> listartodos(){
        return repository.findAll();
    }


}
