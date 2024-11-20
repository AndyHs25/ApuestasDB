package com.Idat.AppApuestas.Controllers;

import com.Idat.AppApuestas.DTO.MatchDTO;
import com.Idat.AppApuestas.Services.MatchService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
@Transactional
public class MatchControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private MatchService matchService;

    // Utilidad para convertir objetos a JSON
    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void createMatchAndAffectDatabase() throws Exception {
        MatchDTO match = new MatchDTO();
        match.setTeamHome(1L);
        match.setTeamAway(2L);
        match.setDate("2024-11-21");
        match.setStatus("No Iniciado");
        match.setGoalHome("0");
        match.setGoalAway("0");
        match.setResult("");

        // Crea el partido mediante la API
        mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/match")
                        .content(asJsonString(match))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isCreated());
    }

    @Test
    public void listMatches() throws Exception {
        // Listar partidos debería devolver un status OK
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/match")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void deleteMatchById() throws Exception {
        // Primero, crea un partido
        MatchDTO match = new MatchDTO(1L, 2L, "2024-11-21", "No Iniciado", "0", "0", "");
        matchService.addMatch(match); // Agrega el partido a la base de datos

        // Simula la eliminación por ID
        mockMvc.perform(MockMvcRequestBuilders
                        .delete("/api/match/{id}", 1) // Asegúrate de usar un ID válido
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void updateMatch() throws Exception {
        // Datos actualizados del partido
        MatchDTO updatedMatch = new MatchDTO(1L, 2L, "2024-11-22", "En progreso", "1", "0", "1-0");

        // Simula la actualización por ID
        mockMvc.perform(MockMvcRequestBuilders
                        .put("/api/match/edit/{id}", 1L) // Asegúrate de usar un ID válido
                        .content(asJsonString(updatedMatch))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }
}
