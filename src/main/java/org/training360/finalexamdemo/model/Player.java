package org.training360.finalexamdemo.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "players")
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;
    @Column(name = "player_position")
    @Enumerated(value = EnumType.STRING)
    private PlayerPosition playerPosition;
    @ManyToOne
    private Team team;

    public Player(String name, LocalDate dateOfBirth, PlayerPosition playerPosition) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.playerPosition = playerPosition;
    }
}
