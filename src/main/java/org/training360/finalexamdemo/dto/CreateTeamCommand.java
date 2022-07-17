package org.training360.finalexamdemo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.training360.finalexamdemo.model.Player;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateTeamCommand {

    private String name;
    private List<CreatePlayerCommand> players;
}
