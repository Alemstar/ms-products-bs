package cl.duoc.ms_products_bs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MsProductsBsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsProductsBsApplication.class, args);
	}

}
