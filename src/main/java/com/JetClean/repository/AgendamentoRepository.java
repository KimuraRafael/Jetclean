package com.JetClean.repository;

import com.JetClean.entity.AgendamentoLavagens;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface AgendamentoRepository extends JpaRepository <AgendamentoLavagens, UUID> {

    @EntityGraph(attributePaths = {"veiculo", "lavagem"})
    List<AgendamentoLavagens> findAllByOrderByDataHoraLavagemAsc();
}
