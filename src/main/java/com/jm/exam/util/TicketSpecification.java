package com.jm.exam.util;

import com.jm.exam.bean.dao.Ticket;
import org.springframework.data.jpa.domain.Specification;

import java.sql.Timestamp;

public class TicketSpecification {

    public static Specification<Ticket> usuarioSpec(String usuario) {
        return (root, query, criteriaBuilder) -> {
            if (usuario == null || usuario.isEmpty()) {
                return null; // No filtro si el nombre es null o vacío
            }
            return criteriaBuilder.like(root.get("usuario"), "%" + usuario + "%");
        };
    }

    public static Specification<Ticket> idSpec(Integer id) {
        return (root, query, criteriaBuilder) -> {
            if (id == null || id == -1) {
                return null;
            }
            return criteriaBuilder.equal(root.get("id"),id);
        };
    }

    public static Specification<Ticket> fechaCreacionMinimaSpec(Timestamp fechaCreacionMinima) {
        return (root, query, criteriaBuilder) -> {
            if (fechaCreacionMinima == null) {
                return null;
            }
            return criteriaBuilder.greaterThanOrEqualTo(root.get("fechaCreacion"), fechaCreacionMinima);
        };
    }

    public static Specification<Ticket> fechaCreacionMaximaSpec(Timestamp fechaCreacionMaxima) {
        return (root, query, criteriaBuilder) -> {
            if (fechaCreacionMaxima == null) {
                return null;
            }
            return criteriaBuilder.lessThanOrEqualTo(root.get("fechaCreacion"), fechaCreacionMaxima);
        };
    }
}
