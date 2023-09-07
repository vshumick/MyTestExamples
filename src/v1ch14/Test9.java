package v1ch14;

//import lombok.AllArgsConstructor;
//import lombok.Getter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test9 {
    public static void main(String[] args) {

        //List lst = Stream.of(VehicleBodyType.values()).map(e->e.getLabel()).collect(Collectors.toList());
        //List lst = Arrays.stream(VehicleBodyType.values()).map(e->e.getLabel()).collect(Collectors.toList());
        //List lst = Stream.concat(Arrays.stream(VehicleBodyType.values()), Arrays.stream(MetricCategory.values())).map(e-> e.).collect(Collectors.toList());
        List lst = Stream.concat( Stream.of(VehicleBodyType.values()).map(e->e.getLabel()),
                                  Stream.of(MetricCategory.values()).map(e->e.getLabel())
                                 ).collect(Collectors.toList());

        System.out.println(lst);

    }


    public enum VehicleBodyType {
        SEDAN("Sedan"),
        SUV("SUV"),
        TRUCK("Truck"),
        EMERGENCY("Emergency"),
        MOTORCYCLE("Motorcycle"),
        VAN("Van"),
        COMMERCIAL_TRUCK("Commercial Truck"),
        OTHER("Other");

        VehicleBodyType(String label) {
            this.label = label;
        }

        public String getLabel() {
            return label;
        }

        private final String label;
    }

    public enum MetricCategory {
        //MetricCategory
        MAX("max"),
        MIN("min"),
        ALL("all");

        MetricCategory(String label) {
            this.label = label;
        }

        public String getLabel() {
            return label;
        }

        private final String label;
    }

}
