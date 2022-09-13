package org.rivera.webapp.jsf3.controllers;

import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.inject.Model;
import jakarta.enterprise.inject.Produces;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.rivera.webapp.jsf3.entities.Producto;
import org.rivera.webapp.jsf3.services.ProductoService;

import java.util.List;

@Model  //Estereotipo que incluye @Named y @RequestScoped
public class ProductoController {

  @Inject
  private ProductoService service;

  private Producto product;

  @Produces //Para pasar datos a la vista(creación en el contexto)
  @Model    //Por defecto toma el nombre del método/clase
  public String tittle() {
    return "Aprendamos JavaServerFaces 3";
  }

  @Produces
  @RequestScoped
  @Named("listado")   //Con Model no se puede personalizar el nombre, se debe hacer asi
  public List<Producto> findAll() {
    return service.toListProducts();
  }

  @Produces
  @Model  //Por alguna razón con "getProduct" tomaba también "product"
  public Producto product() {
    this.product = new Producto();
    return this.product;
  }

  public String save() {
    System.out.println(product);
    // service.save(product);
    return "index.xhtml?faces-redirect=true"; //Para poder redireccionar(Navegación en JSF)
  }

}
