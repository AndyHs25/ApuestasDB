package com.Idat.AppApuestas.Repositories;

import com.Idat.AppApuestas.Models.odd;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OddRepository extends JpaRepository<odd,Long> {

    @Query(value = "SELECT * FROM ODDS id_match =: idMatch", nativeQuery = true)
    List<odd> listarOdds(@Param("idMatch") Long idMatch);

}
