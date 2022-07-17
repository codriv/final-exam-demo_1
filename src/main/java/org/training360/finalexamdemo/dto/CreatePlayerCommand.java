package org.training360.finalexamdemo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.training360.finalexamdemo.model.PlayerPosition;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreatePlayerCommand {

    private String name;
    private LocalDate dateOfBirth;
    private PlayerPosition playerPosition;
}
