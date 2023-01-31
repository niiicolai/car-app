package dat3.car.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
public class Car {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Getter private int id;

  @Column(name = "car_brand", length = 50)
  @Getter @Setter private String brand;

  @Column(name = "car_model", length = 60)
  @Getter @Setter private String model;

  @Column(name = "rental_price_day")
  @Getter @Setter private double pricePrDay;

  @Column(name = "max_discount")
  @Getter @Setter private int bestDiscount;

  @CreationTimestamp
  @Getter @Setter private LocalDateTime created;

  @UpdateTimestamp
  @Getter @Setter private LocalDateTime lastEdited;

  public Car() {}

  public Car(String brand, String model, double pricePrDay, int bestDiscount) {
    this.brand = brand;
    this.model = model;
    this.pricePrDay = pricePrDay;
    this.bestDiscount = bestDiscount;
  }
}
