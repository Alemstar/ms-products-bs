package cl.duoc.ms_products_bs.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import cl.duoc.ms_products_bs.model.dto.ProductDTO;


@FeignClient(name="ms-products-db", url = "http://localhost:8280")
public interface ProductDbFeingClient {

    @GetMapping("/api/products")
    public ResponseEntity<List<ProductDTO>> selectAllProduct();

    @GetMapping("/api/products/GetProductById/{idProduct}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable(name = "idProduct") Long idProduct);

    @PostMapping("/api/products/insertProduct")
    public ResponseEntity<String> insertProduct(@RequestBody ProductDTO productDTO);
    
     @DeleteMapping("/api/products/DeleteProductById/{idProduct}")
    public ResponseEntity<String> deleteProduct(@PathVariable("idProduct") Long idProduct);

    @PutMapping("/api/products/UpdateProduct")
    public ResponseEntity<String> updateProduct(@RequestBody ProductDTO productDTO);

}
