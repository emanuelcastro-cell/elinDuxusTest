
package com.teamanalytics.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.teamanalytics.entity.Integrante;
import com.teamanalytics.repository.IntegranteRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class IntegranteService {

    private final IntegranteRepository repository;

    public Integrante salvar(Integrante integrante){
        return repository.save(integrante);
    }

    public List<Integrante> listar(){
        return repository.findAll();
    }
}
