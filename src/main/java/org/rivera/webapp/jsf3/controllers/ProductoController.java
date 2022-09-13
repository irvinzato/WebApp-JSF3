package org.rivera.webapp.jsf3.controllers;

import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.inject.Model;
import jakarta.enterprise.inject.Produces;
import jakarta.inject.Named;
import org.rivera.webapp.jsf3.entities.Producto;

import java.util.Arrays;
import java.util.List;

@Model  //Estereotipo que incluye @Named y @RequestScoped
public class ProductoController {

  @Produces //Para pasar datos a la vista
  @Model    //Por defecto toma el nombre del método/clase
  public String tittle() {
    return "Aprendamos JavaServerFace 3";
  }

  @Produces
  @RequestScoped
  @Named("listado")   //Con Model no se puede personalizar el nombre, se debe hacer asi
  public List<Producto> findAll() {
    return Arrays.asList(new Producto("pera"), new Producto("durazno"), new Producto("sandia"));
  }


}