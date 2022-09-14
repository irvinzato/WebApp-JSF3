package org.rivera.webapp.jsf3.controllers;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.context.FacesContext;
import jakarta.faces.event.ValueChangeEvent;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

@Named
@SessionScoped
public class LenguajeController implements Serializable {

  private static final long SERIAL_VERSION_UID = 12345L;

  private Locale locale;
  private String language;
  private Map<String, String> languagesSupport;

  @PostConstruct  //Para tener acceso a recursos que suelen no estar inicializados en el constructor normal
  public void init() {
    locale = FacesContext.getCurrentInstance().getViewRoot().getLocale();
    languagesSupport = new HashMap<>();
    languagesSupport.put("Ingles", "en");
    languagesSupport.put("Español", "es");
  }

  public void select(ValueChangeEvent event) {
    String newLanguage = event.getNewValue().toString();
    languagesSupport.values().forEach( v -> {
      if( v.equals(newLanguage) ) {
        this.locale = new Locale(newLanguage);
        FacesContext.getCurrentInstance().getViewRoot().setLocale(this.locale);
      }
    });
  }

  public Locale getLocale() {
    return locale;
  }

  public void setLocale(Locale locale) {
    this.locale = locale;
  }

  public String getLanguage() {
    return language;
  }

  public void setLanguage(String language) {
    this.language = language;
  }

  public Map<String, String> getLanguagesSupport() {
    return languagesSupport;
  }

  public void setLanguagesSupport(Map<String, String> languagesSupport) {
    this.languagesSupport = languagesSupport;
  }
}
