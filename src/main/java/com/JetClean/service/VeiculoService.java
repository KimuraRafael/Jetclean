package com.JetClean.service;

import com.JetClean.entity.Veiculo;
import com.JetClean.repository.VeiculoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VeiculoService {

    private final VeiculoRepository veiculoRepository;

    public List<Veiculo> findAll(){
        return veiculoRepository.findAll();
    }
//
//    public void saveVeiculo(Veiculo veiculo){
//        veiculoRepository.save(veiculo);
//        retur
//    }
}
