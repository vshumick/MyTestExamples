package v1ch14;

//import org.apache.commons.lang3.StringUtils;

import java.time.Duration;
import java.time.Instant;
import java.util.Collection;
import java.util.function.BiPredicate;
import java.util.stream.Stream;

public class Test8 {
    public static void main(String[] args) {

        Instant lastEntranceTimestamp1 = null;//Instant.parse("2022-07-01T09:00:00.00Z");
        Instant lastEntranceTimestamp2 = Instant.parse("2022-07-01T10:20:00.00Z");

        //var travelTimeInSeconds = Duration.between(lastEntranceTimestamp1, lastEntranceTimestamp2);




        System.out.println(lastEntranceTimestamp1.isBefore(lastEntranceTimestamp2));
        //System.out.println(travelTimeInSeconds);
    }
}
