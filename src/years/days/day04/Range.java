package years.days.day04;

public class Range {

    int lower;
    int upper;
    public Range (String range) {
        this.lower = Integer.parseInt(range.substring(0, range.lastIndexOf("-")));
        this.upper = Integer.parseInt(range.substring(range.lastIndexOf("-")+1, range.length()));
    }

    public String toString() {
        return "Lower:"+this.lower+ " Upper:"+this.upper;
    }

    public boolean fullyContains (Range range) {
        if (this.lower <= range.lower && this.upper >= range.upper) return true; else
            return false;
    }

    public boolean overlap (Range range) {
        if ((this.lower <= range.lower && this.upper >= range.lower) ||
                (this.lower <= range.upper && this.upper >= range.upper)) return true; else
                    return false;
    }

}
