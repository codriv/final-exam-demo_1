package org.training360.finalexamdemo.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.training360.finalexamdemo.model.PlayerPosition;
import org.training360.finalexamdemo.model.Team;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class PlayerDto {

    private Long id;
    private String name;
    private LocalDate dateOfBirth;
    private PlayerPosition playerPosition;
    @JsonBackReference
    private Team team;
}
