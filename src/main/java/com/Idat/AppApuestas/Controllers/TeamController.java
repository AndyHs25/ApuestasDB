package com.Idat.AppApuestas.Controllers;


import com.Idat.AppApuestas.Models.match;
import com.Idat.AppApuestas.Models.team;
import com.Idat.AppApuestas.Services.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("api/team")
public class TeamController {

    @Autowired
    private TeamService teamService;

    @GetMapping
    public ResponseEntity<List<team>> getAllTeams() {
        List<team> teams = teamService.getAllTeams();
        return ResponseEntity.ok(teams);
    }

    @PostMapping
    public ResponseEntity<?> insert(@RequestBody team team, BindingResult result) {
        if (result.hasFieldErrors()) {
            return validation(result);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(teamService.addTeam(team));
    }

    @GetMapping("api/team/{id}")
    public Optional<team> getMatchById(@PathVariable Long id) {
        return this.teamService.buscarId(id);
    }

    private ResponseEntity<?> validation(BindingResult result) {
        Map<String, String> errors = new HashMap<>();

        result.getFieldErrors().forEach(err -> {
            errors.put(err.getField(), "El campo " + err.getField() + " " + err.getDefaultMessage());
        });
        return ResponseEntity.badRequest().body(errors);
    }
}
