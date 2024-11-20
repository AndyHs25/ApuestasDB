package com.Idat.AppApuestas.Services;

import com.Idat.AppApuestas.DTO.BetDTO;
import com.Idat.AppApuestas.Models.bet;
import com.Idat.AppApuestas.Models.match;
import com.Idat.AppApuestas.Models.user;
import com.Idat.AppApuestas.Repositories.BetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BetService {

    @Autowired
    private BetRepository betRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private MatchService matchService;

    public List<bet> getAllBets() {
        return this.betRepository.findAll();
    }

    public bet addBet(BetDTO betDTO) {
        user user = new user();
        match macth = new match();

        Optional<user> userOptional = userService.buscarUserId(betDTO.getUser());
        Optional<match> matchOptional = matchService.buscarMatchId(betDTO.getMatch());

        if ( userOptional.isPresent() && matchOptional.isPresent()) {
            user = userOptional.get();
            macth = matchOptional.get();
        }

        bet Bet = new bet(
                user,
                macth,
                betDTO.getTypeBet(),
                betDTO.getOdd(),
                betDTO.getAmount(),
                betDTO.getDateBet()
        );

        return this.betRepository.save(Bet);
    }

    public Optional<bet> buscarBetId(Long id) {
        return betRepository.findById(id);
    }

    public boolean deleteBet(Long id) {
        try {
            betRepository.deleteById(id);
            return true;
        }catch (Exception e) {
            return false;
        }
    }

    public bet updateBet(Long id, BetDTO betDTO) {

        user user = new user();
        match match = new match();

        if (betDTO.getUser() != null){
            Optional<user> userOptional = userService.buscarUserId(betDTO.getUser());
            if (userOptional.isPresent()) {
                user = userOptional.get();
            }
        }
        if (betDTO.getMatch() != null){
            Optional<match> matchOptional = matchService.buscarMatchId(betDTO.getMatch());
            if (matchOptional.isPresent()) {
                match matchDb = matchOptional.get();
            }
        }

        Optional<bet> betOptional = this.betRepository.findById(id);
        if (betOptional.isPresent()) {
            bet betDb = betOptional.get();
            if (betDTO.getUser() != null){
                betDb.setUser(user);
            }
            if (betDTO.getMatch() != null){
                betDb.setMatch(match);
            }
            if (betDTO.getTypeBet() != null){
                betDb.setTypeBet(betDTO.getTypeBet());
            }
            if (betDTO.getOdd() != null){
                betDb.setOdd(betDTO.getOdd());
            }
            if (betDTO.getAmount() != null){
                betDb.setAmount(betDTO.getAmount());
            }
            if (betDTO.getDateBet() != null){
                betDb.setDateBet(betDTO.getDateBet());
            }
            return betRepository.save(betDb);
        }else {
            return null;
        }
    }

}
