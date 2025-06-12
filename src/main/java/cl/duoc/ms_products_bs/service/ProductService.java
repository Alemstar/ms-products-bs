package cl.duoc.ms_products_bs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.duoc.ms_products_bs.clients.ProductDbFeingClient;
import cl.duoc.ms_products_bs.model.ProductDTO;

@Service
public class ProductService {
    @Autowired
    ProductDbFeingClient productDbFeingClient;

    public ResponseEntity<?> getProductById(Long idProduct){
        try {
            ResponseEntity>ProductDTO> answer = productDbFeingClient.getProductById(idProduct);

            if (answer.getBody()==null){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("This customer does not exist");
            }

            else {
                return answer;
            }
        } catch (FeignException feignException){
            return ResponseEntity.status(feignException.status()).body(feignException.contentUTF8());
            }   
    }
    
    public ResponseEntity<List<ProductDTO>> selectAllProduct(){
        List<ProductDTO> listProductDTO = productDbFeingClient.selectAllProduct().getBody();

        return (listProductDTO != null)? new ResponseEntity<>(listProductDTO, HttpStatus.OK):
                                         new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<String> insertProduct(ProductDTO productDTO){
        return productDbFeingClient.insertProduct(productDTO);
    }

    public ResponseEntity<String> updateProduct(ProductDTO productDTO){
        return productDbFeingClient.updateProduct(productDTO);
    }
}
