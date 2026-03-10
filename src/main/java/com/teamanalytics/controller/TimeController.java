
package com.teamanalytics.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teamanalytics.dto.TimeRequestDTO;
import com.teamanalytics.entity.Time;
import com.teamanalytics.service.TimeService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/times")
@RequiredArgsConstructor
public class TimeController {

    private final TimeService service;

    @PostMapping
    public Time criarTime(@RequestBody TimeRequestDTO dto){
        return service.criarTime(dto);
    }
}
