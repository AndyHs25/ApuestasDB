package com.Idat.AppApuestas.Controllers;

import com.Idat.AppApuestas.DTO.BetDTO;
import com.Idat.AppApuestas.Models.bet;
import com.Idat.AppApuestas.Services.BetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/bet")
public class BetController {

    @Autowired
    private BetService betService;

    @GetMapping
    public List<bet> getAllBets() {
        return betService.getAllBets();
    }

    @PostMapping
    public bet addBet(@RequestBody BetDTO betDTO) {
        return betService.addBet(betDTO);
    }

    @GetMapping("/{id}")
    public Optional<bet> getBet(@PathVariable Long id) {
        return betService.buscarBetId(id);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<bet> updateBet(@PathVariable Long id, @RequestBody BetDTO betDTO) {
        bet bet = betService.updateBet(id, betDTO);
        if (bet != null) {
            return ResponseEntity.ok(bet);
        }else {
            return ResponseEntity.noContent().build();
        }
    }

    @DeleteMapping(path = "{id}")
    public void deleteBet(@PathVariable Long id) {
       betService.deleteBet(id);
    }

}
