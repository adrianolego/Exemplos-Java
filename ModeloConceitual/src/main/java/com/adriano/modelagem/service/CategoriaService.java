package com.adriano.modelagem.service;

import com.adriano.modelagem.domain.Categoria;
import com.adriano.modelagem.repository.CategoriaRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {

  @Autowired
  private CategoriaRepository categoriaRepository;

  public Categoria find(Integer id){
    Optional<Categoria> cat =categoriaRepository.findById(id);
    return cat.orElse(null);
  }

}
