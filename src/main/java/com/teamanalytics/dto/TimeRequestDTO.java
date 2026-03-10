
package com.teamanalytics.dto;

import lombok.Data;
import java.time.LocalDate;
import java.util.List;

@Data
public class TimeRequestDTO {

    private LocalDate data;
    private List<Long> integranteIds;
}
