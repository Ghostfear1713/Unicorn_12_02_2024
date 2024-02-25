package Package_Exercise.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Shipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer iD;


    @ManyToOne
    private Package shipmentPackage;

    @ManyToOne
    private Location sourceLocation;

    @ManyToOne
    private Location destinationLocation;

    private LocalDateTime shipmentDate;


    public Shipment(Package shipmentPackage, Location sourceLocation, Location destinationLocation, LocalDateTime shipmentDate) {
        this.shipmentPackage = shipmentPackage;
        this.sourceLocation = sourceLocation;
        this.destinationLocation = destinationLocation;
        this.shipmentDate = shipmentDate;
    }

    public void setShipmentPackage(Package shipmentPackage) {
        this.shipmentPackage = shipmentPackage;
        if(shipmentPackage != null){
            shipmentPackage.addShipment(this);
        }
    }














}
