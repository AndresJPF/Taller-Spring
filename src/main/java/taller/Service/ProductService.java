package taller.Service;

import taller.Entity.Product;
import taller.Exception.ProductNotFoundException;
import taller.Repository.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/*
    @Service marca esta clase como la capa de logica de negocio.
    Aqui se procesa la informacion antes de guardarla o devolverla.
*/
@Service
public class ProductService {

    // El repositorio es el que habla con la base de datos
    private final ProductRepository productRepository;

    // Spring inyecta el repositorio automaticamente por el constructor
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // Trae todos los productos con paginacion
    public Page<Product> obtenerTodos(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    // Busca un producto por ID, lanza excepcion si no existe
    public Product obtenerPorId(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));
    }

    // Guarda un producto nuevo en la base de datos
    public Product crear(Product product) {
        return productRepository.save(product);
    }

    // Actualiza los datos de un producto existente
    public Product actualizar(Long id, Product productoNuevo) {

        // Primero verificamos que el producto exista
        Product productoExistente = obtenerPorId(id);

        // Actualizamos los campos con los nuevos valores
        productoExistente.setName(productoNuevo.getName());
        productoExistente.setDescription(productoNuevo.getDescription());
        productoExistente.setPrice(productoNuevo.getPrice());
        productoExistente.setStock(productoNuevo.getStock());
        productoExistente.setCategory(productoNuevo.getCategory());

        // Guardamos y devolvemos el producto actualizado
        return productRepository.save(productoExistente);
    }

    // Elimina un producto por ID
    public void eliminar(Long id) {
        // Verificamos que exista antes de eliminar
        obtenerPorId(id);
        productRepository.deleteById(id);
    }
}
