package com.adriano.modelagem.resource;

import com.adriano.modelagem.domain.Categoria;
import com.adriano.modelagem.service.CategoriaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
@Api(value = "API REST Categorias")
@RestController
@RequestMapping("/categorias")
public class CategoriaResource {

  @Autowired
  private CategoriaService categoriaService;

  @ApiOperation(value = "Operações de categorias")
  @RequestMapping(value = "/{id}",method = RequestMethod.GET)
  public ResponseEntity<?> listar(@PathVariable Integer id) {
    Categoria cat = categoriaService.find(id);
    return ResponseEntity.ok().body(cat);
  }

}
