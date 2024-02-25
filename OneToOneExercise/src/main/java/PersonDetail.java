import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter
@Getter
@NoArgsConstructor
@ToString
public class PersonDetail {

    @Id
    private Integer iD;
    private String Address;
    private String City;
    private int zipCode;
    private int age;

    public PersonDetail(String address, String city, int zipCode, int age) {
        Address = address;
        City = city;
        this.zipCode = zipCode;
        this.age = age;
    }

    //Relation 1:1
    // 1 person has 1 person detail
    @OneToOne
    //MapsID is used to map the primary key of the parent entity - So the ID in Person class is mapped to the ID in PersonDetail class
    @MapsId
    private Person person;


}
