package v1ch14;

public class BorderTag1 {
    private String tag;

    public Location1 getLocation() {
        return new Location1(111);
    }

    public String getTag() {
        return this.tag;
    }

    public enum ReservedBorderTags {
        ENTRANCE,
        EXIT
    }
}
