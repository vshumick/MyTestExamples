package v1ch14;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Border1 {

    public Set<BorderTag1> getTags() {
        return tags;
    }

    Set<BorderTag1> tags = new HashSet(Arrays.asList("Entrance", "Exit"));;


}
