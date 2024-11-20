package com.Idat.AppApuestas.Services;
import com.Idat.AppApuestas.Models.team;
import com.Idat.AppApuestas.Repositories.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeamService {
    @Autowired
    private TeamRepository teamRepository;

    public List<team> getAllTeams() {
        return this.teamRepository.findAll();
    }

    public Optional<team> buscarId(Long id) {
        System.out.println(id);
        return this.teamRepository.findById(id);
    }

    public team addTeam(team team) {
        return this.teamRepository.save(team);
    }

    //Update
    public Optional<team> updateTeam(Long id, team team) {
        Optional<team> teamOptional = this.teamRepository.findById(id);
        if (teamOptional.isPresent()) {
            team teamDb = teamOptional.orElseThrow();
            teamDb.setName(team.getName());
            teamDb.setLogo(team.getLogo());
            return Optional.of(teamRepository.save(teamDb));
        }

        return teamOptional;
    }

}
