package Package_Exercise.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer iD;
    private double latitude;
    private double longitude;
    private String address;

    //mappedBy is used to map the relationship between the two entities (Shipment and Location)
    // Location is the owner of the relationship and Shipment is the inverse side of the relationship (the one that is being mapped)
    @OneToMany(mappedBy = "sourceLocation")
    private Set<Shipment> sourceShipments = new HashSet<>();

    @OneToMany(mappedBy = "destinationLocation")
    private Set<Shipment> destinationShipments = new HashSet<>();



}
