package com.Idat.AppApuestas.Repositories;

import com.Idat.AppApuestas.Models.team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeamRepository extends JpaRepository<team,Long> {
    @Query(value = "SELECT * FROM TEAMS name =: teamName", nativeQuery = true)
    List<team> listarTeams(@Param("teamName") String teamName);
}
