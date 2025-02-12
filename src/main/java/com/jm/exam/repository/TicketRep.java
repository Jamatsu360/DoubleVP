package com.jm.exam.repository;

import com.jm.exam.bean.dao.Ticket;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
@Repository
public interface TicketRep extends JpaSpecificationExecutor<Ticket>, JpaRepository<Ticket, Integer> {
}
