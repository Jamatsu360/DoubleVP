package com.jm.exam.bean.dao;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.Builder;
import java.sql.Timestamp;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@Entity
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
@Table(name = "TICKET")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column Integer id;
    @Column String usuario;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column Timestamp fechaCreacion;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column Timestamp fechaActualizacion;
    @Column boolean esAbierto;

}
