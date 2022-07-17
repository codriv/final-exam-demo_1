package org.training360.finalexamdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.training360.finalexamdemo.model.Team;

public interface TeamRepository extends JpaRepository<Team, Long> {


}
