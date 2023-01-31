package dat3.car.config;

import dat3.car.entity.Car;
import dat3.car.entity.Member;
import dat3.car.repository.CarRepository;
import dat3.car.repository.MemberRepository;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DeveloperData implements ApplicationRunner {

  private MemberRepository memberRepository;
  private CarRepository carRepository;

  public DeveloperData(
    MemberRepository memberRepository,
    CarRepository carRepository
  ) {
    this.memberRepository = memberRepository;
    this.carRepository = carRepository;
  }

  @Override
  public void run(ApplicationArguments args) throws Exception {
    
    // Add Test members
    memberRepository.save(new Member("John", "Doe", "john.doe@email.com", "123 Main St.", "123456789", "1/1/2000", "M", "Premium"));
    memberRepository.save(new Member("Jane", "Smith", "jane.smith@email.com", "456 Elm St.", "987654321", "12/25/1995", "F", "Standard"));
    memberRepository.save(new Member("Bob", "Johnson", "bob.johnson@email.com", "789 Oak St.", "456789123", "7/4/1985", "M", "Premium"));
    memberRepository.save(new Member("Emily", "Davis", "emily.davis@email.com", "246 Pine St.", "135791113", "3/12/1990", "F", "Standard"));
    memberRepository.save(new Member("Michael", "Brown", "michael.brown@email.com", "369 Maple St.", "246810124", "6/6/1975", "M", "Premium"));

    // Test colors
    String[] favoriteCarColors = {"green", "red", "blue"};

    // Test phone numbers
    Map<String,String> phones = new HashMap<>();
    phones.put("work", "555-555-5555");
    phones.put("home", "555-555-1234");
    phones.put("mobile", "555-555-4321");

    // Update colors and phone numbers
    Iterable<Member> members = memberRepository.findAll();

    for (Member member : members) {
        member.setFavoriteCarColors(Arrays.asList(favoriteCarColors));
        member.setPhones(phones);
    }

    memberRepository.saveAll(members);

    // Add Test cars
    carRepository.save(new Car("Toyota", "Camry", 2020, 40000));
    carRepository.save(new Car("Honda", "Civic", 2019, 35000));
    carRepository.save(new Car("Tesla", "Model 3", 2021, 55000));
    carRepository.save(new Car("Ford", "Mustang", 2018, 32000));
    carRepository.save(new Car("Chevrolet", "Corvette", 2022, 75000));
  }
}
