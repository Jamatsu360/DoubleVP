package com.jm.exam.bean.dto;

import lombok.Data;
import lombok.Builder;

@Data
@Builder
public class TicketReq {

    private Integer id;
    private String usuario;
    private boolean esAbierto;
}
