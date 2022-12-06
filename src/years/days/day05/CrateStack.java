package years.days.day05;

import java.util.Stack;

public class CrateStack {

    public Stack<String> stack;

    public CrateStack(String[] crates) {
        this.stack = new Stack<String>();
        for (int i = 0; i < crates.length; i++) {
            this.stack.push(crates[i]);
        }
    }


    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int times = 0; times < stack.size(); times++) {
            builder.append(stack.elementAt(times) + " ");
        }
        return builder.toString();
    }


}
