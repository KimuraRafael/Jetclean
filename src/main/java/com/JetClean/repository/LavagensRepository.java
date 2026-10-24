package com.JetClean.repository;

import com.JetClean.entity.Lavagens;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface LavagensRepository extends JpaRepository<Lavagens, UUID> {
}
