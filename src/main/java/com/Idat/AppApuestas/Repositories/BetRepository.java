package com.Idat.AppApuestas.Repositories;

import com.Idat.AppApuestas.Models.bet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BetRepository extends JpaRepository<bet,Long> {
    @Query(value = "SELECT * FROM TEAMS id =: idBet", nativeQuery = true)
    List<bet> listarBets(@Param("idBet") Long idBet);
}
