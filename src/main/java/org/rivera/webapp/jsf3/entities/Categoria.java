package org.rivera.webapp.jsf3.entities;

import jakarta.persistence.*;
import java.util.Objects;

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

  @Override //Util para cuando quiero editar un Producto me muestre su categoria seleccionada
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Categoria categoria = (Categoria) o;
    return Objects.equals(id, categoria.id);
  }

  @Override
  public String toString() {
    return "Categoria{" +
            "id=" + id +
            ", name='" + name + '\'' +
            '}';
  }
}
