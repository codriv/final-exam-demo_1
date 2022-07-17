package org.training360.finalexamdemo.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class TeamDto {

    private Long id;
    private String name;
    private List<PlayerDto> players = new ArrayList<>();
}
