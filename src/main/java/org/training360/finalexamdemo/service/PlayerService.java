package org.training360.finalexamdemo.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.training360.finalexamdemo.dto.CreatePlayerCommand;
import org.training360.finalexamdemo.dto.PlayerDto;
import org.training360.finalexamdemo.exceptions.EntityNotFound;
import org.training360.finalexamdemo.model.Player;
import org.training360.finalexamdemo.model.PlayerPosition;
import org.training360.finalexamdemo.repository.PlayerRepository;

import java.util.List;

@Service
@Transactional
public class PlayerService {

    private PlayerRepository playerRepository;
    private ModelMapper modelMapper;

    public PlayerService(PlayerRepository playerRepository, ModelMapper modelMapper) {
        this.playerRepository = playerRepository;
        this.modelMapper = modelMapper;
    }

    public List<PlayerDto> getPlayers() {
        List<Player> players = playerRepository.findAll();
        return players.stream().map(p -> modelMapper.map(p, PlayerDto.class)).toList();
    }

    public PlayerDto createPlayer(CreatePlayerCommand command) {
        Player player = new Player(command.getName(), command.getDateOfBirth(), command.getPlayerPosition());
        playerRepository.save(player);
        return modelMapper.map(player, PlayerDto.class);
    }

    public void deletePlayer(Long id) {
        playerRepository.deleteById(id);
    }

    public Player findPlayerById(Long id) {
        return playerRepository.findById(id).orElseThrow(() -> new EntityNotFound("Player", id));
    }

    public List<Player> getPlayersByTeamAndPosition(Long id, PlayerPosition position) {
        return playerRepository.getPlayersByTeamAndPosition(id, position);
    }
}
