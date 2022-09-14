package org.rivera.webapp.jsf3;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.inject.Produces;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;

import java.util.Locale;
import java.util.ResourceBundle;

//Clase utilizada para mostrar mensajes Flash en los HTTP, solo duran un request
@ApplicationScoped
public class ProducerResources {

  @Produces
  @RequestScoped
  public FacesContext beanFacesContext() {  //Configuración para mensajes flash
    FacesContext facesContext = FacesContext.getCurrentInstance();
    facesContext.getExternalContext().getFlash().setKeepMessages(true);
    return facesContext;
  }

  @Produces
  @Named("msg")
  public ResourceBundle beanBundle() {  //Configuración para añadir idiomas personalizados en las páginas, cambio los values en archivos .xhtml
    Locale locale = FacesContext.getCurrentInstance().getViewRoot().getLocale();
    return ResourceBundle.getBundle("messages", locale);  //Nombre del archivo por defecto ubicado en "resources" del main
  }

}
