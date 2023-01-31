package dat3.car.entity;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.MapKeyColumn;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
public class Member {

  @Id
  @Getter private String username;

  @Getter @Setter private String password;
  @Getter @Setter private String email;
  @Getter @Setter private String firstName;
  @Getter @Setter private String lastName;
  @Getter @Setter private String street;
  @Getter @Setter private String city;
  @Getter @Setter private String zip;

  @Getter @Setter private boolean approved;

  @Getter @Setter private int ranking;

  @ElementCollection
  @Getter @Setter private List<String> favoriteCarColors = new ArrayList<>();

  @ElementCollection
  @MapKeyColumn(name = "Description")
  @Column(name = "phoneNumber")
  @Getter @Setter private Map<String, String> phones = new HashMap<>();

  @CreationTimestamp
  @Getter @Setter private LocalDateTime created;

  @UpdateTimestamp
  @Getter @Setter private LocalDateTime lastEdited;

  public Member() {}

  public Member(
    String user,
    String password,
    String email,
    String firstName,
    String lastName,
    String street,
    String city,
    String zip
  ) {
    this.username = user;
    this.password = password;
    this.email = email;
    this.firstName = firstName;
    this.lastName = lastName;
    this.street = street;
    this.city = city;
    this.zip = zip;
  }
}
