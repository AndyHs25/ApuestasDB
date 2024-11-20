package com.Idat.AppApuestas.Services;

import com.Idat.AppApuestas.DTO.MatchDTO;
import com.Idat.AppApuestas.Models.match;
import com.Idat.AppApuestas.Models.team;
import com.Idat.AppApuestas.Repositories.MatchRepository;
import jakarta.persistence.Table;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MatchService {

    @Autowired
    private MatchRepository matchRepository;
    @Autowired
    private TeamService teamService;

    public List<match> getAllMatches() {
        return this.matchRepository.findAll();
    }

    public match addMatch(MatchDTO matchDTO){

        team Home = new team();
        team Away = new team();
        Optional<team> HomeOptional = teamService.buscarId(matchDTO.getTeamHome());
        Optional<team> AwayOptional = teamService.buscarId(matchDTO.getTeamAway());

        if(HomeOptional.isPresent() && AwayOptional.isPresent()) {
            Home = HomeOptional.get();
            Away = AwayOptional.get();
        }

        System.out.println(matchDTO.getDate());
        match Match = new match(
                Home,
                Away,
                matchDTO.getDate(),
                matchDTO.getStatus(),
                matchDTO.getGoalHome(),
                matchDTO.getGoalAway(),
                matchDTO.getResult()
        );
        System.out.println("FECHA ANTES DE GUARDAR" + Match.getDate());
        return matchRepository.save(Match);
    }

    public Optional<match> buscarMatchId(Long id) {
        return matchRepository.findById(id);
    }

    public boolean deleteMatchById(Long id) {
        try {
            matchRepository.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Transactional
    public match updateMatch( Long id,MatchDTO matchDTO) {
        System.out.println("id: "+id);
        team Home = new team();
        team Away = new team();

        if(matchDTO.getTeamHome() != null){
            Optional<team> HomeOptional = teamService.buscarId(matchDTO.getTeamHome());
            if(HomeOptional.isPresent()){
                Home = HomeOptional.get();
            }
        }
        if(matchDTO.getTeamAway() != null){
            Optional<team> AwayOptional = teamService.buscarId(matchDTO.getTeamAway());
            if(AwayOptional.isPresent()){
                Away = AwayOptional.get();
            }
        }

        Optional<match> matchOptional = this.matchRepository.findById(id);
        if (matchOptional.isPresent()) {
            match matchDb = matchOptional.get();
            if(matchDTO.getTeamHome() != null){
                matchDb.setTeamHome(Home);
            }
            if(matchDTO.getTeamAway() != null){
                matchDb.setTeamAway(Away);
            }
            if(matchDTO.getDate() != null){
                matchDb.setDate(matchDTO.getDate());
            }
            if(matchDTO.getStatus() != null){
                matchDb.setStatus(matchDTO.getStatus());
            }
            if(matchDTO.getGoalHome() != null){
                matchDb.setGoalHome(matchDTO.getGoalHome());
            }
            if(matchDTO.getGoalAway() != null){
                matchDb.setGoalAway(matchDTO.getGoalAway());
            }
            if(matchDTO.getResult() != null){
                matchDb.setResult(matchDTO.getResult());
            }
            return matchRepository.save(matchDb);
        }else {
            return null;
        }
    }
}

