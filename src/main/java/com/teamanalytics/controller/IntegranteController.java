
package com.teamanalytics.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teamanalytics.entity.Integrante;
import com.teamanalytics.service.IntegranteService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/integrantes")
@RequiredArgsConstructor
public class IntegranteController {

    private final IntegranteService service;

    @PostMapping
    public Integrante criar(@RequestBody Integrante integrante){
        return service.salvar(integrante);
    }

    @GetMapping
    public List<Integrante> listar(){
        return service.listar();
    }
}
