package cl.duoc.ms_products_bs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.duoc.ms_products_bs.model.ProductDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequestMapping ("/api/products")
public class ProductController {

    @Autowired
    ProductService productService;
    
    @GetMapping()
    public ResponseEntity<List<ProductDTO>> selectAllProduct(){
        ResponseEntity<List<ProductDTO>> listProductDTO = productService.selectAllProduct();
        return listaProductDTO;
    }

    @GetMapping("/GetProductById/{idProduct}")
    public ResponseIdentity<?> getProductById(@PathVariable("idProduct") Long idProduct){
        return productService.getProductById(idProduct);
    }
    
    @PostMapping()
    public ResponseEntity<String> insertProduct(@RequestBody ProductDTO productDTO){
        try{
        return productService.insertProduct(productDTO);}
        catch(FeignClientException feignClientException){
            return ResponseEntity.status(feignClientException.status()).body(feignClientException.contentUTF8());
        }
    }

    @DeleteMapping("/DeleteProductById/{idProduct}")
    public ResponseEntity<String> deleteProduct(@PathVariable("idProduct") Long idProduct){
        try{
        return productService.deleteProduct(idProduct);}
        catch(FeignClientException feignClientException){
            return ResponseEntity.status(feignClientException.status()).body(feignClientException.contentUTF8());
        }
    }

    @PutMapping("/UpdateProduct")
    public ResponseEntity<String> updateProduct(@RequestBody ProductDTO productDTO){
        try{
        return productService.updateProduct(productDTO);}
        catch(FeignClientException feignClientException){
            return ResponseEntity.status(feignClientException.status()).body(feignClientException.contentUTF8());
        }
    }
}



