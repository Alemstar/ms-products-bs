package cl.duoc.ms_products_bs.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import cl.duoc.ms_products_bs.model.ProductDTO;

@FeignClient(name="ms-products-db", url = "http://localhost:8280/api/products")
public interface ProductDbFeingClient {
    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> findProductById(@PathVariable(name = "idProduct") Long idProduct);
}
