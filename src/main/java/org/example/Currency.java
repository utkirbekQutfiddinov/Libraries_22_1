package org.example;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Currency {
    private Integer id;
    private String Code;
    private String CcyNm_EN;
    private Double Rate;
}
