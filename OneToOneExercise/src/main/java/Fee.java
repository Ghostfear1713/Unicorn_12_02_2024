import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Fee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer iD;

    private int amount;
    private LocalDate payDate;

    public Fee(int amount, LocalDate payDate) {
        this.amount = amount;
        this.payDate = payDate;
    }

    //Relation 1:many
    @ManyToOne
    private Person person;






}
