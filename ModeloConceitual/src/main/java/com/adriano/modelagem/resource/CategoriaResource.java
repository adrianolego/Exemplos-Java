package com.adriano.modelagem.resource;

import com.adriano.modelagem.domain.Categoria;
import com.adriano.modelagem.dto.CategoriaDTO;
import com.adriano.modelagem.service.CategoriaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@Api(value = "API REST Categorias")
@RestController
@RequestMapping("/categorias")
public class CategoriaResource {

    @Autowired
    private CategoriaService categoriaService;

    @ApiOperation(value = "Consultar categorias")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Categoria> listar(@PathVariable Integer id) {
        Categoria cat = categoriaService.find(id);
        return ResponseEntity.ok().body(cat);
    }

    @ApiOperation(value = "Inserir categorias")
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> inserir(@RequestBody Categoria categoria) {
        categoria = categoriaService.insert(categoria);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequestUri()
                .path("/{id}")
                .buildAndExpand(categoria.getId())
                .toUri();
        return ResponseEntity.created(uri).build();
    }

    @ApiOperation(value = "Atualizar categorias")
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> atualizar(@RequestBody Categoria categoria, @PathVariable Integer id) {
        categoria = categoriaService.update(categoria);
        return ResponseEntity.noContent().build();
    }

    @ApiOperation(value = "Deletar categorias")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {
        categoriaService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @ApiOperation(value = "Consultar todas categorias")
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<CategoriaDTO>> listarTodasCategorias() {
        List<Categoria> listCat = categoriaService.findAll();
        List<CategoriaDTO> listDto = listCat.stream()
                .map(dto -> new CategoriaDTO(dto))
                .collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }
}