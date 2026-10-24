package com.JetClean.service;

import com.JetClean.dto.LavagemRequest;
import com.JetClean.dto.LavagemResponse;
import com.JetClean.entity.Lavagens;
import com.JetClean.repository.LavagensRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class LavagensService {

   private final LavagensRepository lavagensRepository;

   public List<Lavagens> findAll(){
       return lavagensRepository.findAll();
   }

   public Lavagens findById(UUID idLavagem){
       return lavagensRepository.findById(idLavagem)
               .orElseThrow(() -> new RuntimeException("Lavagem não encontrada"));
   }

   public LavagemResponse saveLavagem(LavagemRequest request){

       Lavagens lavagens = new Lavagens();
       lavagens.setDescricao(request.descricao());
       lavagens.setPreco(request.preco());

       return LavagemResponse.from(lavagensRepository.save(lavagens));
   }

   public LavagemResponse editLavagem(UUID id, LavagemRequest request){

       Lavagens lavagem = findById(id);
       lavagem.setDescricao(request.descricao());
       lavagem.setPreco(request.preco());
       return LavagemResponse.from(lavagensRepository.save(lavagem));
   }

   public void deleteById(UUID id){
       Lavagens lavagem = findById(id);
       lavagensRepository.delete(lavagem);
   }
}
