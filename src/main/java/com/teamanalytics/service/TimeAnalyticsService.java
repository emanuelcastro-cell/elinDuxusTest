
package com.teamanalytics.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.teamanalytics.entity.*;
import com.teamanalytics.repository.*;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TimeAnalyticsService {

    private final TimeRepository timeRepository;
    private final ComposicaoTimeRepository composicaoRepository;

    private List<Time> filtrarPeriodo(LocalDate inicio, LocalDate fim){
        if(inicio == null || fim == null)
            return timeRepository.findAll();
        return timeRepository.findByDataBetween(inicio,fim);
    }

    public List<String> timeDaData(LocalDate data){

        Time time = timeRepository.findByData(data).orElseThrow();

        return composicaoRepository.findByTimeId(time.getId())
                .stream()
                .map(c -> c.getIntegrante().getNome())
                .toList();
    }

    public String integranteMaisUsado(LocalDate inicio, LocalDate fim){

        List<Time> times = filtrarPeriodo(inicio,fim);

        Map<String, Long> contagem =
                times.stream()
                .flatMap(t -> composicaoRepository.findByTimeId(t.getId()).stream())
                .map(c -> c.getIntegrante().getNome())
                .collect(Collectors.groupingBy(n -> n, Collectors.counting()));

        return contagem.entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null);
    }

    public String funcaoMaisComum(LocalDate inicio, LocalDate fim){

        List<Time> times = filtrarPeriodo(inicio,fim);

        Map<String,Long> contagem =
                times.stream()
                .flatMap(t -> composicaoRepository.findByTimeId(t.getId()).stream())
                .map(c -> c.getIntegrante().getFuncao())
                .collect(Collectors.groupingBy(f -> f, Collectors.counting()));

        return contagem.entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .get()
                .getKey();
    }

    public String franquiaMaisFamosa(LocalDate inicio, LocalDate fim){

        List<Time> times = filtrarPeriodo(inicio,fim);

        Map<String,Long> contagem =
                times.stream()
                .flatMap(t -> composicaoRepository.findByTimeId(t.getId()).stream())
                .map(c -> c.getIntegrante().getFranquia())
                .collect(Collectors.groupingBy(f -> f, Collectors.counting()));

        return contagem.entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .get()
                .getKey();
    }

    public Map<String,Long> contagemPorFranquia(LocalDate inicio, LocalDate fim){

        List<Time> times = filtrarPeriodo(inicio,fim);

        return times.stream()
                .flatMap(t -> composicaoRepository.findByTimeId(t.getId()).stream())
                .map(c -> c.getIntegrante().getFranquia())
                .collect(Collectors.groupingBy(f -> f, Collectors.counting()));
    }

    public Map<String,Long> contagemPorFuncao(LocalDate inicio, LocalDate fim){

        List<Time> times = filtrarPeriodo(inicio,fim);

        return times.stream()
                .flatMap(t -> composicaoRepository.findByTimeId(t.getId()).stream())
                .map(c -> c.getIntegrante().getFuncao())
                .collect(Collectors.groupingBy(f -> f, Collectors.counting()));
    }
}
