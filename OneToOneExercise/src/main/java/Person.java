import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@ToString
@Getter
@Setter
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer iD;
    private String name;

    public Person(String name) {
        this.name = name;
    }

    //Relation 1:1 - 1 person has 1 person detail
    @OneToOne(mappedBy = "person", cascade = CascadeType.ALL)
    //mappedby is used to map the relationship between the two entities
    private PersonDetail personDetail;

    //Relation 1:many - 1 person has many fees
    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
    //Making a Set list to prevent duplicates
    private Set<Fee> fees = new HashSet<>();

    //Bi-directional update

    //This method is used to update the personDetail object in the Person class and also update the person object in the PersonDetail class
    public void setPersonDetail(PersonDetail personDetail) {
        this.personDetail = personDetail;
        if(personDetail != null){
            personDetail.setPerson(this);
        }
    }

    public void addFee(Fee fee){
        if(fee != null){
            fee.setPerson(this);
        }
    }



}
