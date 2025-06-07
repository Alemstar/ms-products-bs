package cl.duoc.ms_products_bs.controller;

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
    cl.duoc.ms_products_bs.service.ProductService ProductService;

    @GetMapping("{/id}")
    public ResponseEntity<ProductDTO> findProductById(@PathVariable("idProduct") Long idProduct) {
        ProductDTO productDTO = ProductService.getProductById(idProduct);

        return (productDTO != null)? new ResponseEntity<>(productDTO, HttpStatus.OK) :
                                     new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
}



