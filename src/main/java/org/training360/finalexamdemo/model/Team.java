package org.training360.finalexamdemo.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "teams")
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany(mappedBy = "team")
    private List<Player> players = new ArrayList<>();

    public Team(String name) {
        this.name = name;
    }

    public Team(String name, List<Player> players) {
        this.name = name;
        this.players = new ArrayList<>(players);
    }

    public void addPlayer(Player player) {
        player.setTeam(this);
        players.add(player);
    }

    public void removePlayer(Player player) {
        players.remove(player);
        player.setTeam(null);
    }

}
