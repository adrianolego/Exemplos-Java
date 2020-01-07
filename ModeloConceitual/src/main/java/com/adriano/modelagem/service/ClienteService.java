package com.adriano.modelagem.service;

import com.adriano.modelagem.domain.Cliente;
import com.adriano.modelagem.repository.ClienteRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente find(Integer id) {
        Optional<Cliente> cat = clienteRepository.findById(id);
        return cat.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado :Id" + id,
                "Tipo: " + Cliente.class.getName()));
    }

}
