package Unicorn;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Unicorn {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int iD;
private String name;
private int age;
private double powerStrength;

    public Unicorn(String name, int age, double powerStrength) {
        this.name = name;
        this.age = age;
        this.powerStrength = powerStrength;
    }
}
