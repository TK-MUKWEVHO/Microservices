package com.teekay.inventoryservice;

import com.teekay.inventoryservice.model.Inventory;
import com.teekay.inventoryservice.repository.InventoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}

	@Bean
	public CommandLineRunner loadData(InventoryRepository inventoryRepository){
		return  args -> {
			Inventory inventory = new Inventory();
			inventory.setBarcode("iphone_13");
			inventory.setQuantity(50);

			Inventory inventory1 =new Inventory();
			inventory1.setBarcode("iphone_13_res");
			inventory1.setQuantity(0);

			inventoryRepository.save(inventory1);
			inventoryRepository.save(inventory);
		};
	}
}
