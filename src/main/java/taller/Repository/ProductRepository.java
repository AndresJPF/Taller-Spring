package taller.Repository;

import taller.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

/*
    JpaRepository ya tiene los metodos basicos listos para usar:
    - findAll() trae todos los productos
    - findAll(pageable)  trae productos con paginacion
    - findById(id) busca por ID
    - save(product  guarda o actualiza
    - deleteById(id) elimina por ID
    - existsById(id)  verifica si existe

*/
public interface ProductRepository extends JpaRepository<Product, Long> {

}
