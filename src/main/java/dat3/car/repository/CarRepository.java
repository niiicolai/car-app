package dat3.car.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import dat3.car.entity.Car;

@Repository
public interface CarRepository extends CrudRepository<Car, Long> {
}