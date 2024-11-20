package com.Idat.AppApuestas.Services;

import com.Idat.AppApuestas.DTO.OddDTO;
import com.Idat.AppApuestas.Models.match;
import com.Idat.AppApuestas.Models.odd;
import com.Idat.AppApuestas.Repositories.OddRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OddService{

    @Autowired
    private OddRepository oddRepository;
    @Autowired
    private MatchService matchService;

    public List<odd> getAllOdds(){
        return this.oddRepository.findAll();
    }

    public odd addOdd(OddDTO oddDTO){
        match Match = new match();

        Optional<match> MatchOptional = matchService.buscarMatchId(oddDTO.getMatch());
        if(MatchOptional.isPresent()){
            Match = MatchOptional.get();
        }

        odd Odd = new odd(
                Match,
                oddDTO.getHomeOdd(),
                oddDTO.getAwayOdd(),
                oddDTO.getDrawOdd()
        );
        return oddRepository.save(Odd);
    }

    public Optional<odd> buscarOddId(Long id){
        return oddRepository.findById(id);
    }

    public boolean deleteOddById(Long id){
        try {
            oddRepository.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Transactional
    public odd updateOdd(Long id,OddDTO oddDTO){
        match Match = new match();

        if (oddDTO.getMatch() != null){
            Optional<match> MatchOptional = matchService.buscarMatchId(oddDTO.getMatch());
            if (MatchOptional.isPresent()){
                Match = MatchOptional.get();
            }
        }
        Optional<odd> oddOptional = oddRepository.findById(id);
        if (oddOptional.isPresent()){
            odd oddDB = oddOptional.get();
            if (oddDB.getMatch() != null){
                oddDB.setMatch(Match);
            }
            if (oddDB.getHomeOdd() != null){
                oddDB.setHomeOdd(oddDTO.getHomeOdd());
            }if(oddDB.getAwayOdd() != null){
                oddDB.setAwayOdd(oddDTO.getAwayOdd());
            }if(oddDB.getDrawOdd() != null){
                oddDB.setDrawOdd(oddDTO.getDrawOdd());
            }

            return oddRepository.save(oddDB);
        }else {
            return null;
        }
    }

}
