package com.jm.exam.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import com.jm.exam.service.TicketServ;
import com.jm.exam.bean.dto.TicketReq;
import com.jm.exam.bean.dto.PageableReq;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/ticket-rest")
public class TicketRestController {

    private final TicketServ ticketServ;

    @PostMapping("/test")
    public String pruebaServicio(){
        log.info("Comunicacion exitosa !!!");
        return "Comunicacion exitosa !!!";
    }

    @PostMapping(value = "/crear", produces = "application/json")
    public String crearTicket (@RequestBody TicketReq ticketReq) throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(ticketServ.crearTicket(ticketReq));
    }

    @PostMapping(value = "/actualizar", produces = "application/json")
    public String actualizarTicket (@RequestBody TicketReq ticketReq) throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(ticketServ.actualizarTicket(ticketReq));
    }

    @GetMapping(value = "/buscar", produces = "application/json")
    public String buscarTicket (@RequestHeader HttpHeaders headers) throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(ticketServ.buscarTicket(Integer.parseInt(headers.getFirst("id"))));
    }

    @PutMapping(value = "/eliminar", produces = "application/json")
    public String eliminarTicket(@RequestHeader HttpHeaders headers) throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(ticketServ.eliminarTicket(Integer.parseInt(headers.getFirst("id"))));
    }

    @PostMapping(value = "/listar", produces = "application/json")
    public String listarTicket (@RequestBody PageableReq pageableReq) throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(ticketServ.listarTicket(pageableReq));
    }
}
