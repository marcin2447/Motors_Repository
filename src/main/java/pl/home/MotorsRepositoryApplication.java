package pl.home;
import pl.home.model.Motor;
import pl.home.repository.MotorRepository;

import java.util.ArrayList;
import java.util.List;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class MotorsRepositoryApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx =SpringApplication.run(MotorsRepositoryApplication.class, args);
		
		
		
		 List<Motor> motors = new ArrayList<>();
	        motors.add(new Motor("K1600GT", "BMW", 49500.0));
	        motors.add(new Motor("S1000", "BMW", 37000.0));
	        motors.add(new Motor("CB1000R", "Honda", 35000.0));
	        motors.add(new Motor("1200S", "Ducati", 55500.0));
	        motors.add(new Motor("XDiavel S", "Ducati", 28000.0));
	        motors.add(new Motor("Softail", "Harley-Davidson", 41000.0));
	        motors.add(new Motor("DL650", "Suzuki", 20500.0));
	        motors.add(new Motor("Boulevard", "Suzuki", 22500.0));
	        
	        MotorRepository motoRepo = ctx.getBean(MotorRepository.class);
	        motors.forEach(motoRepo::save); 
	        
	       
	        System.out.println("All BMW motors:");
	        List<Motor> allBMW = motoRepo.findByBrand("BMW");
	        allBMW.forEach(System.out::println);
	        
	       
	        Motor ducati = motoRepo.findFirstByBrand("Ducati");
	        System.out.println(ducati);
	        
	        
	        System.out.println("BMW for 37000: ");
	        motoRepo.findAllByBrandAndPrice("BMW", 37000).forEach(System.out::println);
	        System.out.println("Harley-Davidson or Suzuki:");
	        motoRepo.findAllByBrandOrBrand("Harley-Davidson", "Suzuki").forEach(System.out::println);
	        
	        
	        System.out.println("Motors with brand starting with A");
	        motoRepo.findAllByBrandLike("A%").forEach(System.out::println);
	        System.out.println("Motors with name ending with 'tra'");
	        motoRepo.findAllByNameEndingWith("tra").forEach(System.out::println);
	        
	      
	        System.out.println("Motors cheaper than 30000");
	        motoRepo.findAllByPriceLessThan(30000).forEach(System.out::println);
	        System.out.println("Motors with price between 30-40k");
	        motoRepo.findAllByPriceBetween(30000, 40000).forEach(System.out::println);
	        
	       
	        System.out.println("All BMW motors, price ascending");
	        motoRepo.findAllByBrandOrderByPriceAsc("BMW")
	            .forEach(System.out::println);
	        
	        
	        System.out.println("Motors with brand");
	        motoRepo.findAllByBrandNotNull().forEach(System.out::println);
	       

	        ctx.close();
		
		
		
	}
}
