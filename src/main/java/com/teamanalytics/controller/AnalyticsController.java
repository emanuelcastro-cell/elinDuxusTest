
package com.teamanalytics.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import com.teamanalytics.service.TimeAnalyticsService;

import java.time.LocalDate;
import java.util.*;

@RestController
@RequestMapping("/analytics")
@RequiredArgsConstructor
public class AnalyticsController {

    private final TimeAnalyticsService service;

    @GetMapping("/time-da-data")
    public List<String> timeDaData(@RequestParam LocalDate data){
        return service.timeDaData(data);
    }

    @GetMapping("/integrante-mais-usado")
    public String integranteMaisUsado(
        @RequestParam(required=false) LocalDate inicio,
        @RequestParam(required=false) LocalDate fim){
        return service.integranteMaisUsado(inicio,fim);
    }

    @GetMapping("/funcao-mais-comum")
    public String funcaoMaisComum(
        @RequestParam(required=false) LocalDate inicio,
        @RequestParam(required=false) LocalDate fim){
        return service.funcaoMaisComum(inicio,fim);
    }

    @GetMapping("/franquia-mais-famosa")
    public String franquiaMaisFamosa(
        @RequestParam(required=false) LocalDate inicio,
        @RequestParam(required=false) LocalDate fim){
        return service.franquiaMaisFamosa(inicio,fim);
    }

    @GetMapping("/contagem-franquia")
    public Map<String,Long> contagemFranquia(
        @RequestParam(required=false) LocalDate inicio,
        @RequestParam(required=false) LocalDate fim){
        return service.contagemPorFranquia(inicio,fim);
    }

    @GetMapping("/contagem-funcao")
    public Map<String,Long> contagemFuncao(
        @RequestParam(required=false) LocalDate inicio,
        @RequestParam(required=false) LocalDate fim){
        return service.contagemPorFuncao(inicio,fim);
    }

}
