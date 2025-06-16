package cl.duoc.ms_products_bs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.duoc.ms_products_bs.model.dto.ProductDTO;
import cl.duoc.ms_products_bs.service.ProductService;
import feign.FeignException.FeignClientException;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping ("/api/products")
public class ProductController {

    @Autowired
    ProductService productService;
    
    @GetMapping()
    public ResponseEntity<List<ProductDTO>> selectAllProduct(){
        ResponseEntity<List<ProductDTO>> listProductDTO = productService.selectAllProduct();
        return listProductDTO;
    }

    @GetMapping("/GetProductById/{idProduct}")
    public ResponseEntity<?> getProductById(@PathVariable("idProduct") Long idProduct){
        return productService.getProductById(idProduct);
    }
    
    @PostMapping("/insertProduct")
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



