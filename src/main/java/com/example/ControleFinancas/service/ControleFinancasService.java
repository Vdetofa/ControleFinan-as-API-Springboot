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
        // 1. Validação básica de valor
        if (financas.getValor() <= 0) {
            
            System.out.println("Valor inválido");
            return; // Sai do método e não faz mais nada
        }

        // 2. DESAFIO: Coloque aqui sua validação de saldo insuficiente
        // Dica: Use o seu método consultarSaldo() e compare com financas.getValor()

        // 3. Preparação dos dados (Data)
        if (financas.getData() == null) {
            financas.setData(LocalDateTime.now());
        }

        if (financas.getTipo().equalsIgnoreCase("SAIDA")) {
           double valorSaldoSaida=0.0;
           valorSaldoSaida +=  financas.getValor();
            consultarSaldo();
            if (valorSaldoSaida> consultarSaldo()) {
                System.out.print("saldo insuficiente");
                return;
            }
        }

        // 4. Salva uma única vez
        repository.save(financas);
        return ;
                
    }
    
    public List<ControleFinancasModel> listartodos(){
        return repository.findAll();
    }

    public double consultarSaldo(){
        List<ControleFinancasModel> todasAsFinancas = repository.findAll();
        double saldoTotal =0.0;
        for(ControleFinancasModel financa : todasAsFinancas){
            if (financa.getTipo().equalsIgnoreCase("ENTRADA")) {
            saldoTotal += financa.getValor();
        } else {
            saldoTotal -= financa.getValor();
        }
        }
        return saldoTotal;
    }


}
