package com.adriano.modelagem.resource;

import com.adriano.modelagem.domain.Cliente;
import com.adriano.modelagem.service.ClienteService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "API REST Clientes")
@RestController
@RequestMapping("/clientes")
public class ClienteResource {

    @Autowired
    private ClienteService clienteService;

    @ApiOperation("Consultar Clientes")
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public ResponseEntity<Cliente> listar(@PathVariable Integer id) {
        Cliente cli = clienteService.find(id);
        return ResponseEntity.ok().body(cli);
    }

}
