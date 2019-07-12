package com.adriano.modelagem;

import com.adriano.modelagem.domain.Categoria;
import com.adriano.modelagem.domain.Produto;
import com.adriano.modelagem.repository.CategoriaRepository;
import com.adriano.modelagem.repository.ProdutoRepository;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ModelagemConceitualUmlApplication implements CommandLineRunner {

  @Autowired
  private CategoriaRepository categoriaRepository;

  @Autowired
  private ProdutoRepository produtoRepository;

  public static void main(String[] args) {
    SpringApplication.run(ModelagemConceitualUmlApplication.class, args);

  }

  @Override
  public void run(String... args) throws Exception {
    //Inserindo dados na base h2 em memória


    Categoria cat1 = new Categoria(null, "Informática");
    Categoria cat2 = new Categoria(null, "Escritório");

    Produto p1 = new Produto(null, "Computador", 2000.00);
    Produto p2 = new Produto(null, "Impressora", 800.00);
    Produto p3 = new Produto(null, "Mouse", 80.00);

    cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
    cat2.getProdutos().addAll(Arrays.asList(p2));

    p1.getCategorias().addAll(Arrays.asList(cat1));
    p2.getCategorias().addAll(Arrays.asList(cat1,cat2));
    p3.getCategorias().addAll(Arrays.asList(cat1));

    categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
    produtoRepository.saveAll(Arrays.asList(p1, p2, p3));
  }
}
