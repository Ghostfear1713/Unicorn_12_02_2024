package Package_Exercise;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Package {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String trackingNumber;
    private String senderName;
    private String recieverName;
    @Enumerated(EnumType.STRING)
    private DeliveryStatus deliveryStatus;


    public Package(String trackingNumber, String senderName, String recieverName, DeliveryStatus deliveryStatus) {
        this.trackingNumber = trackingNumber;
        this.senderName = senderName;
        this.recieverName = recieverName;
        this.deliveryStatus = deliveryStatus;
    }

    public enum DeliveryStatus{
        PENDING,
        IN_TRANSIT,
        DELIVERED
    }





}
