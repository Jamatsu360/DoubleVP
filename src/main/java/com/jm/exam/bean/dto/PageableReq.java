package com.jm.exam.bean.dto;

import lombok.Data;
import lombok.Builder;
import java.sql.Timestamp;

@Data
@Builder
public class PageableReq {
    int pagina;
    int tamanio;
    Timestamp fechaCreacionMinima;
    Timestamp fechaCreacionMaxima;
    TicketReq ticketReq;
}
