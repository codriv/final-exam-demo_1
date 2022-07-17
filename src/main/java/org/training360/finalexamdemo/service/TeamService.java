package org.training360.finalexamdemo.service;


import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.training360.finalexamdemo.dto.*;
import org.training360.finalexamdemo.exceptions.EntityNotFound;
import org.training360.finalexamdemo.exceptions.PlayerHasTeamException;
import org.training360.finalexamdemo.exceptions.TooManyPlayerOnPositionException;
import org.training360.finalexamdemo.model.Player;
import org.training360.finalexamdemo.model.Team;
import org.training360.finalexamdemo.repository.TeamRepository;

import java.util.List;

@Service
@Transactional
public class TeamService {

    private TeamRepository teamRepository;
    private PlayerService playerService;
    private ModelMapper modelMapper;

    public TeamService(TeamRepository teamRepository, PlayerService playerService, ModelMapper modelMapper) {
        this.teamRepository = teamRepository;
        this.playerService = playerService;
        this.modelMapper = modelMapper;
    }

    public List<TeamDto> getTeams() {
        List<Team> teams = teamRepository.findAll();
        return teams.stream().map(t -> modelMapper.map(t, TeamDto.class)).toList();
    }

    public TeamDto createTeam(CreateTeamCommand command) {
        Team team = teamRepository.save(new Team(command.getName()));
        for (CreatePlayerCommand player: command.getPlayers()) {
            addNewPlayer(team.getId(), new CreatePlayerCommand(
                    player.getName(), player.getDateOfBirth(), player.getPlayerPosition()
            ));
        }
        return modelMapper.map(team, TeamDto.class);
    }

    public TeamDto addNewPlayer(Long id, CreatePlayerCommand command) {
        PlayerDto playerDto = playerService.createPlayer(command);
        Player player = playerService.findPlayerById(playerDto.getId());
        Team team = findTeamById(id);
        team.addPlayer(player);
        return modelMapper.map(team, TeamDto.class);
    }

    public Team findTeamById(Long id) {
        return teamRepository.findById(id).orElseThrow(() -> new EntityNotFound("Team", id));
    }

    public TeamDto addExistingPlayer(Long id, UpdateExistingPlayerCommand command) {
        Player player = playerService.findPlayerById(command.getId());
        List<Player> players = playerService.getPlayersByTeamAndPosition(id, player.getPlayerPosition());
        if (players.size() >= 2) {
            throw new TooManyPlayerOnPositionException(player.getPlayerPosition());
        }
        if (player.getTeam() != null) {
            throw new PlayerHasTeamException(player.getTeam().getName());
        }
        Team team = findTeamById(id);
        team.addPlayer(player);
        return modelMapper.map(team, TeamDto.class);
    }
}
