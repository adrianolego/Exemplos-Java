package com.adriano.modelagem.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
public class Produto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private double preco;

    @ManyToMany
    @JoinTable(name = "PRODUTO_CATEGORIA",
            joinColumns = @JoinColumn(name = "PRODUTO_ID"),
            inverseJoinColumns = @JoinColumn(name = "CATEGORIA_ID")
    )
    private List<Categoria> categorias = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "id.produto")
    private Set<ItemPedido> itens = new HashSet<>();

    @JsonIgnore
    public List<Pedido> getPedidos() {
        List<Pedido> lista = new ArrayList<>();
        for (ItemPedido p : itens) {
            lista.add(p.getPedido());
        }
        return lista;
    }

    public Set<ItemPedido> getItens() {
        return itens;
    }

    public void setItens(Set<ItemPedido> itens) {
        this.itens = itens;
    }

    public Produto() {

    }

    public Produto(Integer id, String nome, double preco) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
    }

    public Integer getId() {
        return id;
    }

    public Produto setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public Produto setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public double getPreco() {
        return preco;
    }

    public Produto setPreco(double preco) {
        this.preco = preco;
        return this;
    }

    public List<Categoria> getCategorias() {
        return categorias;
    }

    public Produto setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Produto produto = (Produto) o;
        return Objects.equals(id, produto.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
