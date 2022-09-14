package org.rivera.webapp.jsf3.converters;

import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.rivera.webapp.jsf3.entities.Categoria;
import org.rivera.webapp.jsf3.services.ProductoService;

import java.util.Optional;

//Un convertidor por cada campo de dependencia que tengamos, ejemplo - Producto depende de Categoria
@RequestScoped
@Named("categoriaConverter")
public class CategoriaConverter implements Converter<Categoria> {

  @Inject
  private ProductoService service;

  //Convertir un String a un Objeto y de Objeto a String
  @Override
  public Categoria getAsObject(FacesContext facesContext, UIComponent uiComponent, String id) {
    if( id == null ) {
      return null;
    }
    Optional<Categoria> categoryOptional = service.categoryById(Long.valueOf(id));  //Equivalente a "parseLong()"
    if( categoryOptional.isPresent() ) {
      return categoryOptional.get();
    }
    return null;
  }

  //Si existe el objeto Categoria devuelvo su id como String
  @Override
  public String getAsString(FacesContext facesContext, UIComponent uiComponent, Categoria categoria) {
    if( categoria == null ) {
      return "0";
    }
    return categoria.getId().toString();
  }
}
