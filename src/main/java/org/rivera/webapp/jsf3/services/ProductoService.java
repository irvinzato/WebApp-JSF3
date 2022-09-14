package org.rivera.webapp.jsf3.services;

import jakarta.ejb.Local;
import org.rivera.webapp.jsf3.entities.Categoria;
import org.rivera.webapp.jsf3.entities.Producto;

import java.util.List;
import java.util.Optional;

@Local
public interface ProductoService {
  List<Producto> toListProducts();
  Optional<Producto> productById(Long id);
  void saveProduct(Producto producto);
  void deleteProduct(Long id);
  List<Categoria> toListCategories();
  Optional<Categoria> categoryById(Long id);
}
