package com.adriano.modelagem.service;

import com.adriano.modelagem.domain.Categoria;
import com.adriano.modelagem.repository.CategoriaRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public Categoria find(Integer id) {
        Optional<Categoria> cat = categoriaRepository.findById(id);
        return cat.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado :Id" + id,
                "Tipo: " + Categoria.class.getName()));
    }

    public Categoria insert(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    public Categoria update(Categoria categoria) {
        find(categoria.getId());
        return categoriaRepository.save(categoria);
    }
}
