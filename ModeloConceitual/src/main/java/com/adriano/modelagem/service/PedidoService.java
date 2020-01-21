package com.adriano.modelagem.service;

import com.adriano.modelagem.domain.Categoria;
import com.adriano.modelagem.domain.Pedido;
import com.adriano.modelagem.repository.PedidoRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PedidoService {

  @Autowired
  private PedidoRepository pedidoRepository;

  public Pedido find(Integer id) {
    Optional<Pedido> ped = pedidoRepository.findById(id);
    return ped.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado :Id" + id,
        "Tipo: " + Categoria.class.getName()));
  }

}
