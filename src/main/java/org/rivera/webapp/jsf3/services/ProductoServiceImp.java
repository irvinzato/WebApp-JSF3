package org.rivera.webapp.jsf3.services;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import org.rivera.webapp.jsf3.entities.Categoria;
import org.rivera.webapp.jsf3.entities.Producto;
import org.rivera.webapp.jsf3.repositories.CrudRepository;

import java.util.List;
import java.util.Optional;

@Stateless
public class ProductoServiceImp implements ProductoService{

  @Inject
  private CrudRepository<Producto> repository;

  @Inject
  private CrudRepository<Categoria> repositoryCategory;

  @Override
  public List<Producto> toListProducts() {
    return repository.toList();
  }

  @Override
  public Optional<Producto> productById(Long id) {
    return Optional.ofNullable(repository.byId(id));
  }

  @Override
  public void saveProduct(Producto producto) {
    repository.save(producto);
  }

  @Override
  public void deleteProduct(Long id) {
    repository.delete(id);
  }

  @Override
  public List<Categoria> toListCategories() {
    return repositoryCategory.toList();
  }

  @Override
  public Optional<Categoria> categoryById(Long id) {
    return Optional.ofNullable(repositoryCategory.byId(id));
  }

}
