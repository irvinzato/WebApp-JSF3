package org.rivera.webapp.jsf3;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.inject.Produces;
import jakarta.faces.context.FacesContext;

//Clase utilizada para mostrar mensajes Flash en los HTTP, solo duran un request
@ApplicationScoped
public class ProducerResources {

  @Produces
  @RequestScoped
  public FacesContext beanFacesContext() {  //Configuración
    FacesContext facesContext = FacesContext.getCurrentInstance();
    facesContext.getExternalContext().getFlash().setKeepMessages(true);
    return facesContext;
  }

}
