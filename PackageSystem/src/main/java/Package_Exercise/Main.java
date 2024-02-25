package Package_Exercise;

import Package_Exercise.dao.PackageDAO;
import Package_Exercise.model.Package;

public class Main {
    public static void main(String [] args){

    PackageDAO packageDAO = new PackageDAO();
    Package p1 = new Package("1234", "John", "Jane", Package.DeliveryStatus.PENDING);
    Package p2 = new Package("5678", "Jane", "John", Package.DeliveryStatus.IN_TRANSIT);
    Package p3 = new Package("91011", "John", "Jane", Package.DeliveryStatus.DELIVERED);
    Package p4 = new Package("121314", "Oliver", "Tuupi", Package.DeliveryStatus.PENDING);


    //packageDAO.createPackage(p1);
    packageDAO.createPackage(p2);

    }

}
