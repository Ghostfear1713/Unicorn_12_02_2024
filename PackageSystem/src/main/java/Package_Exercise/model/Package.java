package Package_Exercise.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

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

    @OneToMany(mappedBy = "shipmentPackage", cascade = CascadeType.ALL)
    private Set<Shipment> shipments = new HashSet<>();

    public void addShipment(Shipment shipment){
        //Adding the shipment to our list "shipments" IF the shipment is not null
        if(shipment != null){
            shipments.add(shipment);
        }
    }


}
