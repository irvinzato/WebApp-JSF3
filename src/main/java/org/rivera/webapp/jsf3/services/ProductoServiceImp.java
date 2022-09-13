package org.rivera.webapp.jsf3.services;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import org.rivera.webapp.jsf3.entities.Producto;
import org.rivera.webapp.jsf3.repositories.CrudRepository;

import java.util.List;
import java.util.Optional;

@Stateless
public class ProductoServiceImp implements ProductoService{

  @Inject
  private CrudRepository<Producto> repository;

  @Override
  public List<Producto> toListProducts() {
    return repository.toList();
  }

  @Override
  public Optional<Producto> productById(Long id) {
    try{
      return Optional.of(repository.byId(id));
    } catch (Exception e) {
      return Optional.empty();
    }
  }

}
