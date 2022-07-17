package org.training360.finalexamdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.training360.finalexamdemo.model.Player;
import org.training360.finalexamdemo.model.PlayerPosition;

import java.util.List;

public interface PlayerRepository extends JpaRepository<Player, Long> {

    @Query("select p from Player p where (p.team.id = :id and p.playerPosition = :position)")
    public List<Player> getPlayersByTeamAndPosition(Long id, PlayerPosition position);
}
