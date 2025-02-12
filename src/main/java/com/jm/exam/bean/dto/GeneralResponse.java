package com.jm.exam.bean.dto;

import lombok.Data;
import lombok.Builder;

@Data
@Builder
public class GeneralResponse {
    String respuesta;
    Object object;
}
