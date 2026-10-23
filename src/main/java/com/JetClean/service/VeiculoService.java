package com.JetClean.service;

import com.JetClean.entity.Veiculo;
import com.JetClean.repository.VeiculoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class VeiculoService {

    private final VeiculoRepository veiculoRepository;

    public List<Veiculo> findAll(){
        return veiculoRepository.findAll();
    }
    public Veiculo findById(UUID idVeiculo){
        return veiculoRepository.findById(idVeiculo)
                .orElseThrow(() -> new RuntimeException("Veículo não encontrado"));
    }

    public void saveVeiculo(Veiculo veiculo){
        veiculoRepository.save(veiculo);
    }
}
