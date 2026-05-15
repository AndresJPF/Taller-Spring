package taller.Exception;

// Excepcion para cuando no se encuentra un producto
// Extiende RuntimeException para no swa necesario declararla en cada metodo
public class ProductNotFoundException extends RuntimeException {

    public ProductNotFoundException(Long id) {
        // Llama al constructor de RuntimeException
        super("No se encontro el producto con ID: " + id);
    }
}
