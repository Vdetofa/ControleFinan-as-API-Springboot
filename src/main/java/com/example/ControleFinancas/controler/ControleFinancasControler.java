package com.example.ControleFinancas.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ControleFinancas.model.ControleFinancasModel;
import com.example.ControleFinancas.service.ControleFinancasService;

@RestController
@RequestMapping("/financas")
public class ControleFinancasControler {
    @Autowired
    private ControleFinancasService service;

    @PostMapping
    public void registrar(@RequestBody ControleFinancasModel financas){
        service.registrar(financas);
    }

    @GetMapping
    public List<ControleFinancasModel>listar(){
    return service.listartodos();
    }
    
    @GetMapping("/saldo")
    public double getSaldo() {
     return service.consultarSaldo();
    }

}

