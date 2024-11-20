package com.Idat.AppApuestas.Repositories;

import com.Idat.AppApuestas.Models.match;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MatchRepository extends JpaRepository<match, Long> {
    @Query(value = "SELECT * FROM MATCHES id =: matchId", nativeQuery = true)
    List<match> listarMatches(@Param("matchId") Long matchId);
}
