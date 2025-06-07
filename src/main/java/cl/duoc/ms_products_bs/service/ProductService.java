package cl.duoc.ms_products_bs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.duoc.ms_products_bs.clients.ProductDbFeingClient;
import cl.duoc.ms_products_bs.model.ProductDTO;

@Service
public class ProductService {
    @Autowired
    ProductDbFeingClient productDbFeingClient;

    public ProductDTO getProductById(Long idProduct){
        ProductDTO productDTO = productDbFeingClient.findProductById(idProduct).getBody();

        return productDTO;
    }
}
