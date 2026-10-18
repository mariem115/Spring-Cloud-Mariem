package com.mariem.agence.repos;

import com.mariem.agence.entities.Agence;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgenceRepository extends JpaRepository<Agence, Long> {

    Agence findByCode(String code);
}