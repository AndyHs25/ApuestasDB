package com.Idat.AppApuestas.Controllers;

import com.Idat.AppApuestas.DTO.MatchDTO;
import com.Idat.AppApuestas.Models.match;
import com.Idat.AppApuestas.Services.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("api/match")
public class MatchController {

    @Autowired
    private MatchService matchService;

    @GetMapping
    public List<match> getAllMatches() {
        return matchService.getAllMatches();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public match addMatch(@RequestBody MatchDTO matchDTO) {
        System.out.println(matchDTO.getDate().toString());
        return matchService.addMatch(matchDTO);
    }

    @GetMapping("/{id}")
    public Optional<match> getMatchById(@PathVariable Long id) {
        return matchService.buscarMatchId(id);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<match> updateMatch(@PathVariable Long id, @RequestBody MatchDTO matchDTO) {
        match match = matchService.updateMatch(id, matchDTO);
        if (match != null) {
            return ResponseEntity.ok(match);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping(path = "{id}")
    public void deleteMatch(@PathVariable Long id) {
        matchService.deleteMatchById(id);
    }


}
