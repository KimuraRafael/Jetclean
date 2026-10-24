package com.JetClean.service;

import com.JetClean.dto.VeiculoRequest;
import com.JetClean.dto.VeiculoResponse;
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

    public List<Veiculo> findAll() {
        return veiculoRepository.findAll();
    }

    public Veiculo findById(UUID idVeiculo) {
        return veiculoRepository.findById(idVeiculo)
                .orElseThrow(() -> new RuntimeException("Veículo não encontrado"));
    }

    public VeiculoResponse saveVeiculo(VeiculoRequest request) {
        Veiculo veiculo = new Veiculo();


        if (veiculoRepository.existsByPlaca(request.placa())) {
            throw new RuntimeException("Já existe um veículo com a placa " + request.placa());
        }
        veiculo.setTipoVeiculo(request.tipoVeiculo());
        veiculo.setCor(request.cor());
        veiculo.setPlaca(request.placa());
        veiculo.setModelo(request.modelo());

        return  VeiculoResponse.from(veiculoRepository.save(veiculo));
    }

    public VeiculoResponse editVeiculo(UUID id, VeiculoRequest request) {

        Veiculo veiculo = findById(id);

        if (veiculoRepository.existsByPlacaAndIdNot(request.placa(),id)) {
            throw new RuntimeException("Já existe um veículo com a placa" + request.placa());
        }

        veiculo.setTipoVeiculo(request.tipoVeiculo());
        veiculo.setCor(request.cor());
        veiculo.setPlaca(request.placa());
        veiculo.setModelo(request.modelo());

        return VeiculoResponse.from(veiculoRepository.save(veiculo));
    }

    public void deleteById(UUID id) {
        Veiculo veiculo = findById(id);
        veiculoRepository.delete(veiculo);
    }

}
