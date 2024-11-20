package com.Idat.AppApuestas.Repositories;

import com.Idat.AppApuestas.Models.user;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<user, Long> {
    @Query(value = "SELECT * FROM USERS name =: userName", nativeQuery = true)
    List<user> listarUsers(@Param("userName") String userName);
}
