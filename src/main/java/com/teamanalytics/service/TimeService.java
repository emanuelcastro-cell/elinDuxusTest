
package com.teamanalytics.service;

import org.springframework.stereotype.Service;

import com.teamanalytics.dto.TimeRequestDTO;
import com.teamanalytics.entity.ComposicaoTime;
import com.teamanalytics.entity.Integrante;
import com.teamanalytics.entity.Time;
import com.teamanalytics.repository.ComposicaoTimeRepository;
import com.teamanalytics.repository.IntegranteRepository;
import com.teamanalytics.repository.TimeRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TimeService {

    private final TimeRepository timeRepository;
    private final IntegranteRepository integranteRepository;
    private final ComposicaoTimeRepository composicaoRepository;

    public Time criarTime(TimeRequestDTO dto){

        Time time = new Time();
        time.setData(dto.getData());

        Time salvo = timeRepository.save(time);

        for(Long id : dto.getIntegranteIds()){

            Integrante integrante = integranteRepository.findById(id).orElseThrow();

            ComposicaoTime ct = new ComposicaoTime();
            ct.setTime(salvo);
            ct.setIntegrante(integrante);

            composicaoRepository.save(ct);
        }

        return salvo;
    }
}
