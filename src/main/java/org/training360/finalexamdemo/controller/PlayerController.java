package org.training360.finalexamdemo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.training360.finalexamdemo.service.PlayerService;
import org.training360.finalexamdemo.dto.CreatePlayerCommand;
import org.training360.finalexamdemo.dto.PlayerDto;

import java.util.List;

@RestController
@RequestMapping("/api/players")
public class PlayerController {

    private PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<PlayerDto> getPlayers() {
        return playerService.getPlayers();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PlayerDto createPlayer(@RequestBody CreatePlayerCommand command) {
        return playerService.createPlayer(command);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePlayer(@PathVariable ("id") Long id) {
        playerService.deletePlayer(id);
    }
}
