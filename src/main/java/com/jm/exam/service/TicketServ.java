package com.jm.exam.service;

import com.jm.exam.bean.dto.TicketReq;
import com.jm.exam.bean.dto.GeneralResponse;

public interface TicketServ {
    public GeneralResponse crearTicket(TicketReq ticketReq);

    public GeneralResponse actualizarTicket(TicketReq ticketReq);

    public GeneralResponse buscarTicket(Integer id);

    public GeneralResponse eliminarTicket(Integer id);

    public GeneralResponse listarTicket(TicketReq ticketReq);
}
