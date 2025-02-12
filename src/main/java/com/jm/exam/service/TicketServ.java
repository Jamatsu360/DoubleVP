package com.jm.exam.service;

import com.jm.exam.bean.dao.Ticket;
import com.jm.exam.bean.dto.TicketReq;
import com.jm.exam.bean.dto.PageableReq;
import com.jm.exam.bean.dto.GeneralResponse;
import org.springframework.data.domain.Page;

public interface TicketServ {
    public GeneralResponse crearTicket(TicketReq ticketReq);

    public GeneralResponse actualizarTicket(TicketReq ticketReq);

    public GeneralResponse buscarTicket(Integer id);

    public GeneralResponse eliminarTicket(Integer id);

    public Page<Ticket> listarTicket(PageableReq pageableReq);
}
