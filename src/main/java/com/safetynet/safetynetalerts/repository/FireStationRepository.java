package com.safetynet.safetynetalerts.repository;

import com.safetynet.safetynetalerts.domain.FireStation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FireStationRepository extends JpaRepository<FireStation, Long> {

    FireStation findByStationNumber(String station);

    FireStation deleteByStationNumber(String station);
}
