package org.rivera.webapp.jsf3.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "categorias")
public class Categoria {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name="nombre")
  private String name;

  public Categoria() {
  }

  public Categoria(String name) {
    this.name = name;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return "Categoria{" +
            "id=" + id +
            ", name='" + name + '\'' +
            '}';
  }
}
