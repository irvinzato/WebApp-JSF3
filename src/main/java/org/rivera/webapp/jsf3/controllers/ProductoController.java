package org.rivera.webapp.jsf3.controllers;

import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.inject.Model;
import jakarta.enterprise.inject.Produces;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.rivera.webapp.jsf3.entities.Categoria;
import org.rivera.webapp.jsf3.entities.Producto;
import org.rivera.webapp.jsf3.services.ProductoService;

import java.util.List;
import java.util.ResourceBundle;

@Model  //Estereotipo que incluye @Named y @RequestScoped
public class ProductoController {
  @Inject
  private ProductoService service;

  @Inject //Para mensajes Flash
  private FacesContext facesContext;

  @Inject //Para selección de idiomas
  private ResourceBundle bundle;

  private Producto product;
  private Long id;

  @Produces //Para pasar datos a la vista(creación en el contexto)
  @Model    //Por defecto toma el nombre del método/clase
  public String tittle() {
    return bundle.getString("product.text.tittle"); //Por la inyección del "ResourceBundle" puedo ocuparlo
  }

  @Produces
  @RequestScoped
  @Named("listado")   //Con Model no se puede personalizar el nombre, se debe hacer asi
  public List<Producto> findAll() {
    return service.toListProducts();
  }

  @Produces
  @RequestScoped
  @Named("listCategories")
  public List<Categoria> findCategories() {
    return service.toListCategories();
  }

  @Produces
  @Model  //Por alguna razón con "getProduct" tomaba también "product", lo ocupo en "form.xhtml"
  public Producto product() {
    this.product = new Producto();
    if( id != null && id > 0 ) {
     service.productById(id).ifPresent( p -> {
       this.product = p;
     });
    }
    return this.product;
  }

  public String save() {
    System.out.println(product);
    service.saveProduct(product);
    if( product.getId() != null && product.getId() > 0 ) {
      facesContext.addMessage(null, new FacesMessage(String.format(bundle.getString("product.msg.edit"), product.getName())));  //Puedo pasarle más parámetros a la instancia, dependiendo si es error, alerta, etc.
    } else {
      facesContext.addMessage(null, new FacesMessage(String.format(bundle.getString("product.msg.create"), product.getName())));
    }
    return "index.xhtml?faces-redirect=true"; //Para poder redireccionar(Navegación en JSF)
  }

  public String edit(Long id) {
    this.id = id;
    return "form.xhtml";
  }

  public String delete(Producto product) {
    service.deleteProduct(product.getId());
    facesContext.addMessage(null, new FacesMessage(String.format(bundle.getString("product.msg.delete"), product.getName())));
    return "index.xhtml?faces-redirect=true";
  }

  //Los get y set no los llamo explícitamente pero al llamar "id" desde mis "xhtml" hace uso de ellos
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }
}
