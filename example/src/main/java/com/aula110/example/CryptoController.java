package com.aula110.example;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/crypto")
public class CryptoController {
    
    @Autowired
    private CryptoRepository repo;

    @PostMapping(value = "/new")
    public Crypto insert(@RequestBody Crypto crypto){
        return repo.save(crypto);
    }

    @GetMapping(value = "/all")
    public List<Crypto> listCrypto(){
        return repo.findAll();
    }

    @GetMapping(value = "/exchanges")
    public List<Crypto> listCryptoByExchange(){
        return repo.findByExchange("Binance");
    }

    @GetMapping(value = "/top")
    public List<Crypto> listCryptoByTop(){
        return repo.getAllHigh();
    }

}
