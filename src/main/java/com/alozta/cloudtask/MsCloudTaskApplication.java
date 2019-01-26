package com.alozta.cloudtask;

import java.util.Date;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.task.configuration.EnableTask;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableTask				//this allows application to start and finish like a normal program
public class MsCloudTaskApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsCloudTaskApplication.class, args);
	}
	
	@Bean		//indicates that a method produces a bean to be managed by the Spring container
	public CustomerTask customerTask() {
		return new CustomerTask();
	}
	
	//fyi: CommandLineRunner takes arguments as String [] where ApplicationRunner takes arguments as ApplicationArguments, both valid
	public class CustomerTask implements CommandLineRunner {

		//expected parameters: customerId, customerName, date
		@Override
		public void run(String... args) throws Exception {

			if(args != null) {
				System.out.println("Parameter length is: " + args.length);
				String customerId = args[1];
				String customerName = args[2];
				String date = args[3];
				System.out.println("CustomerId: " + customerId + ", Customer name: " + customerName + ", Date: " + date);
			}
		}
		
	}

}

