package com.adriano.modelagem.domain;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Cidade implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private String nome;

  @ManyToOne
  @JoinColumn(name = "estado_id")
  private Estado estado;

  public Cidade() {
  }

  public Cidade(Integer id, String nome, Estado estado) {
    this.id = id;
    this.nome = nome;
    this.estado = estado;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public Estado getEstado() {
    return estado;
  }

  public Cidade setEstado(Estado estado) {
    this.estado = estado;
    return this;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Cidade cidade = (Cidade) o;
    return id.equals(cidade.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }
}
