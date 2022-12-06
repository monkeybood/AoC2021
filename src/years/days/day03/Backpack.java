package years.days.day03;

public class Backpack {


    private String compartment1;
    private String compartment2;


    public Backpack (String contents) {
        this.compartment1 = contents.substring(0, contents.length()/2);
        this.compartment2 = contents.substring(contents.length()/2, contents.length());
    }

    public String duplicateItem() {
        for (int times = 0; times < this.compartment1.length(); times++) {
            if (this.compartment2.contains(this.compartment1.substring(times, times+1)))
                return this.compartment1.substring(times, times+1);
        }
        return null;
    }


    public String toString() {
        return "Comparment 1:"+this.compartment1+" comparment2:"+compartment2;
    }

}
