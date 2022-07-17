package org.training360.finalexamdemo.controller;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.training360.finalexamdemo.service.TeamService;
import org.training360.finalexamdemo.dto.CreatePlayerCommand;
import org.training360.finalexamdemo.dto.CreateTeamCommand;
import org.training360.finalexamdemo.dto.TeamDto;
import org.training360.finalexamdemo.dto.UpdateExistingPlayerCommand;

import java.util.List;

@RestController
@RequestMapping("/api/teams")
public class TeamController {

    private TeamService teamService;

    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<TeamDto> getPlayers() {
        return teamService.getTeams();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TeamDto createTeam(@RequestBody CreateTeamCommand command) {
        return teamService.createTeam(command);
    }

    @PostMapping("{id}/players")
    @ResponseStatus(HttpStatus.CREATED)
    public TeamDto addNewPlayer(@PathVariable("id") Long id, @RequestBody CreatePlayerCommand command) {
        return teamService.addNewPlayer(id, command);
    }

    @PutMapping("{id}/players")
    @ResponseStatus(HttpStatus.OK)
    public TeamDto addExistingPlayer(@PathVariable("id") Long id, @RequestBody UpdateExistingPlayerCommand command) {
        return teamService.addExistingPlayer(id, command);
    }
}
