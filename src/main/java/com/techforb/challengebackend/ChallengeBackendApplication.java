package com.techforb.challengebackend;

import com.techforb.challengebackend.models.*;
import com.techforb.challengebackend.repositories.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootApplication
public class ChallengeBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChallengeBackendApplication.class, args);
	}


	@Bean
	public CommandLineRunner initData(ClientRepository clientRepository, ProductRepository productRepository, ProviderRepository providerRepository, ProviderProductRepository providerProductRepository, SaleRepository saleRepository, SaleProductRepository saleProductRepository){
		return args -> {
			Client client1 = new Client("Matias", "Gonzalez", 12345, 11112, "quilmes");
			Client client2 = new Client("Nahuel", "Ayala", 115114, 41415, "avellaneda");
			Client client3 = new Client("Manuel", "Belgrano", 55123, 51523, "lanus");

			clientRepository.save(client1);
			clientRepository.save(client2);
			clientRepository.save(client3);





			Provider provider = new Provider("enzo proveedor", "20-145124-5", 14155, "cabildo 1200 caba");
			Provider provider2 = new Provider("ipxstore prov", "20-562324-2", 51231, "mitre 2000 avellaneda");
			Provider provider3 = new Provider("iShop prov", "20-325152-5", 15123, "constitucion 141, caba");

			providerRepository.save(provider);
			providerRepository.save(provider2);
			providerRepository.save(provider3);

			Product product1 = new Product("macbook pro 2022", "16gb ram 1tb silver", 2000, 50, provider);
			Product product2 = new Product("iphone 13", "256gb Silver", 1100, 45,provider);
			Product product3 = new Product("iphone 14", "500gb White", 1700, 55,provider2);
			Product product4 = new Product("apple tv", "serie 1451", 800, 70,provider2);
			Product product5 = new Product("macbook air 2022", "16gb ram 500gb gold", 1500, 50,provider3);
			Product product6 = new Product("headset hyperx ", "model cloud flight s", 500, 25, provider3);

			productRepository.save(product1);
			productRepository.save(product2);
			productRepository.save(product3);
			productRepository.save(product4);
			productRepository.save(product5);
			productRepository.save(product6);

			ProviderProduct providerProduct1 = new ProviderProduct(provider, product1);
			ProviderProduct providerProduct2 = new ProviderProduct(provider, product2);
			ProviderProduct providerProduct3 = new ProviderProduct(provider2, product3);
			ProviderProduct providerProduct4 = new ProviderProduct(provider2, product4);
			ProviderProduct providerProduct5 = new ProviderProduct(provider3, product5);
			ProviderProduct providerProduct6 = new ProviderProduct(provider3, product6);

			providerProductRepository.save(providerProduct1);
			providerProductRepository.save(providerProduct2);
			providerProductRepository.save(providerProduct3);
			providerProductRepository.save(providerProduct4);
			providerProductRepository.save(providerProduct5);
			providerProductRepository.save(providerProduct6);




			SaleProduct saleProduct1 = new SaleProduct(3, product2);
			SaleProduct saleProduct2 = new SaleProduct(2, product3);
			SaleProduct saleProduct3 = new SaleProduct(1, product5);
			SaleProduct saleProduct4 = new SaleProduct(1, product6);



			List<SaleProduct> products = new ArrayList<>();
			products.add(saleProduct1);
			products.add(saleProduct2);

			List<SaleProduct> products1 = new ArrayList<>();
			products1.add(saleProduct3);
			products1.add(saleProduct4);

			Sale sale1 = new Sale(LocalDate.of(2022,12,10), products ,client1);
			Sale sale2 = new Sale(LocalDate.now(), products1,client2);


			sale1.addSale(saleProduct1);
			sale1.addSale(saleProduct2);
			sale2.addSale(saleProduct3);
			sale2.addSale(saleProduct4);

			saleRepository.save(sale1);
			saleRepository.save(sale2);

			saleProductRepository.save(saleProduct1);
			saleProductRepository.save(saleProduct2);
			saleProductRepository.save(saleProduct3);
			saleProductRepository.save(saleProduct4);







//			saleProduct1.setSale(sale1);
//			saleProduct2.setSale(sale1);
//			saleProduct3.setSale(sale2);
//			saleProduct4.setSale(sale2);








		};
	}


}
