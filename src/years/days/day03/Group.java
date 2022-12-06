package years.days.day03;

public class Group {

    String elf1;
    String elf2;
    String elf3;


    public Group(String elf1, String elf2, String elf3) {
        this.elf1 = elf1;
        this.elf2 = elf2;
        this.elf3 = elf3;
    }

    public String duplicateItem() {
        for (int times = 0; times < this.elf1.length(); times++) {
            if (this.elf2.contains(this.elf1.substring(times, times+1)))
                for (int times2 = 0; times2 < this.elf1.length(); times2++) {
                    if (this.elf3.contains(this.elf1.substring(times, times+1)))
                        return this.elf1.substring(times, times + 1);
                }
        }
        return null;
    }
}
