package org.rivera.webapp.jsf3.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "productos")
public class Producto {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "nombre")
  private String name;

  @Column(name = "precio")
  private Integer price;

  @Column(name = "fecha_registro")
  private LocalDate registerDate;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "categoria_id")  //Si no pongo el JoinColum toma valor por defecto con _id
  private Categoria category;

  private String sku;

  public Producto() {
  }

  public Producto(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Integer getPrice() {
    return price;
  }

  public void setPrice(Integer price) {
    this.price = price;
  }

  public LocalDate getRegisterDate() {
    return registerDate;
  }

  public void setRegisterDate(LocalDate registerDate) {
    this.registerDate = registerDate;
  }

  public String getSku() {
    return sku;
  }

  public void setSku(String sku) {
    this.sku = sku;
  }

  public Categoria getCategory() {
    return category;
  }

  public void setCategory(Categoria category) {
    this.category = category;
  }

  /*  Puedo usar esta forma para trabajar con las fechas, hago otra diferente en "form.xhtml" para registerDate
@PrePersist
  public void prePersist() {
    this.registerDate = LocalDate.now();
  }

  @PreUpdate
  public void preUpdate() {
    this.registerDate = LocalDate.now();
  }
  */

  @Override
  public String toString() {
    return "Producto{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", price=" + price +
            ", registerDate=" + registerDate +
            ", sku='" + sku + '\'' +
            '}';
  }
}
