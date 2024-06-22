package com.example.at_springboot.model.service;

import org.springframework.stereotype.Component;

@Component
public class UtilitarioValidacao {
    public boolean verificarVazioString (String dado){
        return dado != null || !dado.isEmpty();
    }
    public boolean verificarId (Long dado){
        try{
            return dado != null || dado < 0;
        }
        catch (Exception e){
            return false;
        }
    }
}
