package pl.home.repository;
import pl.home.model.Motor;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MotorRepository extends JpaRepository<Motor, Long> {

    List<Motor> findByBrand(String brand);
    
    
    Motor findFirstByBrand(String brand);
    
   
    Motor findFirstByPrice(double price);
   
    
    List<Motor> findFirst3ByBrand(String brand);
    
  
    List<Motor> findAllByBrandAndPrice(String brand, double price);
    
    List<Motor> findAllByBrandOrBrand(String brand1, String brand2);

   
    List<Motor> findAllByBrandLike(String pattern);
    
    List<Motor> findAllByNameEndingWith(String pattern);
    
    
    List<Motor> findAllByPriceLessThan(double price);
    
    List<Motor> findAllByPriceBetween(double low, double high);
    
     
    List<Motor> findAllByBrandOrderByPriceAsc(String brand);
    
     
    List<Motor> findAllByBrandNotNull();
     
 
}