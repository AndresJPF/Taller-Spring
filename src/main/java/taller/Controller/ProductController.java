package taller.Controller;

import taller.Entity.Product;
import taller.Service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/*
    @RestController combina @Controller + @ResponseBody
    Hace que todos los metodos devuelvan JSON automaticamente

    @RequestMapping("/products") define la ruta base para todos los endpoints
*/
@RestController
@RequestMapping("/products")
@Tag(name = "Productos", description = "Operaciones del catalogo de productos")
public class ProductController {

    private final ProductService productService;

    // Spring inyecta el servicio automaticamente
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // ── GET /products?page=0&size=5 ───────────────────────────────
    // Trae todos los productos. Los parametros page y size son opcionales
    @GetMapping
    @Operation(summary = "Listar todos los productos")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Lista obtenida correctamente")
    })
    public ResponseEntity<Page<Product>> listarTodos(
            @RequestParam(defaultValue = "0")  int page,
            @RequestParam(defaultValue = "10") int size) {

        Pageable pageable = PageRequest.of(page, size);
        Page<Product> productos = productService.obtenerTodos(pageable);
        return ResponseEntity.ok(productos);
    }

    // ── GET /products/{id} ────────────────────────────────────────
    // Busca un producto por su ID
    @GetMapping("/{id}")
    @Operation(summary = "Obtener un producto por ID")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Producto encontrado"),
        @ApiResponse(responseCode = "404", description = "Producto no encontrado")
    })
    public ResponseEntity<Product> buscarPorId(@PathVariable Long id) {
        Product producto = productService.obtenerPorId(id);
        return ResponseEntity.ok(producto);
    }

    // ── POST /products ────────────────────────────────────────────
    // Crea un producto nuevo. @Valid activa las validaciones del Entity
    @PostMapping
    @Operation(summary = "Crear un producto nuevo")
    @ApiResponses({
        @ApiResponse(responseCode = "201", description = "Producto creado correctamente"),
        @ApiResponse(responseCode = "400", description = "Datos invalidos")
    })
    public ResponseEntity<Product> crear(@Valid @RequestBody Product product) {
        Product creado = productService.crear(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(creado);
    }

    // ── PUT /products/{id} ────────────────────────────────────────
    // Actualiza un producto existente
    @PutMapping("/{id}")
    @Operation(summary = "Actualizar un producto")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Producto actualizado correctamente"),
        @ApiResponse(responseCode = "404", description = "Producto no encontrado"),
        @ApiResponse(responseCode = "400", description = "Datos invalidos")
    })
    public ResponseEntity<Product> actualizar(
            @PathVariable Long id,
            @Valid @RequestBody Product product) {

        Product actualizado = productService.actualizar(id, product);
        return ResponseEntity.ok(actualizado);
    }

    // ── DELETE /products/{id} ─────────────────────────────────────
    // Elimina un producto por ID
    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar un producto")
    @ApiResponses({
        @ApiResponse(responseCode = "204", description = "Producto eliminado correctamente"),
        @ApiResponse(responseCode = "404", description = "Producto no encontrado")
    })
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        productService.eliminar(id);
        return ResponseEntity.noContent().build(); // devuelve 204 sin body
    }
}
