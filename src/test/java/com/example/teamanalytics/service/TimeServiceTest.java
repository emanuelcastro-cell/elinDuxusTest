
package com.example.teamanalytics.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.teamanalytics.dto.TimeRequestDTO;
import com.teamanalytics.entity.Integrante;
import com.teamanalytics.entity.Time;
import com.teamanalytics.repository.ComposicaoTimeRepository;
import com.teamanalytics.repository.IntegranteRepository;
import com.teamanalytics.repository.TimeRepository;
import com.teamanalytics.service.TimeService;

public class TimeServiceTest {

    @Mock
    private TimeRepository timeRepository;

    @Mock
    private IntegranteRepository integranteRepository;

    @Mock
    private ComposicaoTimeRepository composicaoRepository;

    @InjectMocks
    private TimeService service;

    public TimeServiceTest(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void deveCriarTime(){

        TimeRequestDTO dto = new TimeRequestDTO();
        dto.setData(LocalDate.now());
        dto.setIntegranteIds(List.of(1L));

        Time time = new Time();
        time.setId(1L);

        Integrante integrante = new Integrante();

        when(timeRepository.save(any())).thenReturn(time);
        when(integranteRepository.findById(1L)).thenReturn(Optional.of(integrante));

        Time resultado = service.criarTime(dto);

        assertNotNull(resultado);
        verify(composicaoRepository,times(1)).save(any());
    }
}
