package com.jm.exam.service.implement;

import java.sql.Timestamp;
import java.util.Optional;
import java.time.LocalDateTime;
import lombok.extern.slf4j.Slf4j;
import com.jm.exam.bean.dao.Ticket;
import com.jm.exam.bean.dto.TicketReq;
import com.jm.exam.service.TicketServ;
import lombok.RequiredArgsConstructor;
import com.jm.exam.repository.TicketRep;
import com.jm.exam.bean.dto.PageableReq;
import com.jm.exam.bean.dto.GeneralResponse;
import org.springframework.data.domain.Page;
import com.jm.exam.util.TicketSpecification;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;

@Slf4j
@Service
@RequiredArgsConstructor
public class TicketImpl implements TicketServ {


    private final TicketRep ticketRep;
    private static final String EXITO = "Exito";
    private static final String REGISTRO_NO_EXISTE = "El registro no existe";

    @Override
    public GeneralResponse crearTicket(TicketReq ticketReq) {

        Ticket ticket = Ticket.builder()
                .usuario(ticketReq.getUsuario())
                .fechaCreacion(Timestamp.valueOf(LocalDateTime.now()))
                .esAbierto(ticketReq.isEsAbierto()).build();

        return GeneralResponse.builder().respuesta(TicketImpl.EXITO).object(ticketRep.save(ticket)).build();

    }

    @Override
    public GeneralResponse actualizarTicket(TicketReq ticketReq) {
        Optional<Ticket> ticketOptional = ticketRep.findById(ticketReq.getId());
        if(ticketOptional.isPresent()){

            Ticket updTicket = ticketOptional.get();

            if(ticketReq.getUsuario() != null) updTicket.setUsuario(ticketReq.getUsuario());
            updTicket.setFechaActualizacion(Timestamp.valueOf(LocalDateTime.now()));
            updTicket.setEsAbierto(ticketReq.isEsAbierto());

            return GeneralResponse.builder().respuesta(TicketImpl.EXITO).object(ticketRep.save(updTicket)).build();
        }else{
            return GeneralResponse.builder().respuesta(TicketImpl.REGISTRO_NO_EXISTE).object("").build();
        }
    }

    @Override
    public GeneralResponse buscarTicket(Integer id) {
        Optional<Ticket> ticketOptional = ticketRep.findById(id);
        if(ticketOptional.isPresent()){
            return GeneralResponse.builder().respuesta(TicketImpl.EXITO).object(ticketOptional.get()).build();
        }else{
            return GeneralResponse.builder().respuesta(TicketImpl.REGISTRO_NO_EXISTE).object("").build();
        }
    }

    @Override
    public GeneralResponse eliminarTicket(Integer id) {
        Optional<Ticket> ticketOptional = ticketRep.findById(id);
        if(ticketOptional.isPresent()){
            ticketRep.delete(ticketOptional.get());
            return GeneralResponse.builder().respuesta(TicketImpl.EXITO).object("").build();
        }else{
            return GeneralResponse.builder().respuesta(TicketImpl.REGISTRO_NO_EXISTE).object("").build();
        }
    }

    @Override
    public Page<Ticket> listarTicket(PageableReq pageableReq) {
        Pageable pageable = PageRequest.of(pageableReq.getPagina(), pageableReq.getTamanio());

        Specification<Ticket> spec = Specification.where(
                TicketSpecification.idSpec(pageableReq.getTicketReq().getId()))
                .and(TicketSpecification.usuarioSpec(pageableReq.getTicketReq().getUsuario())
                        .and(TicketSpecification.fechaCreacionMinimaSpec(pageableReq.getFechaCreacionMinima()))
                        .and(TicketSpecification.fechaCreacionMaximaSpec(pageableReq.getFechaCreacionMaxima())));

        return ticketRep.findAll(spec, pageable);
    }
}
