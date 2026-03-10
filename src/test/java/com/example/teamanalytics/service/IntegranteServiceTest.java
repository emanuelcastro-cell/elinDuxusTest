
package com.example.teamanalytics.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.teamanalytics.entity.Integrante;
import com.teamanalytics.repository.IntegranteRepository;
import com.teamanalytics.service.IntegranteService;

public class IntegranteServiceTest {

    @Mock
    private IntegranteRepository repository;

    @InjectMocks
    private IntegranteService service;

    public IntegranteServiceTest(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void deveSalvarIntegrante(){

        Integrante integrante = new Integrante();
        integrante.setNome("Iron Man");

        when(repository.save(any())).thenReturn(integrante);

        Integrante salvo = service.salvar(integrante);

        assertEquals("Iron Man",salvo.getNome());
        verify(repository,times(1)).save(integrante);
    }

    @Test
    void deveListarIntegrantes(){

        when(repository.findAll()).thenReturn(List.of(new Integrante()));

        List<Integrante> lista = service.listar();

        assertEquals(1,lista.size());
    }
}
