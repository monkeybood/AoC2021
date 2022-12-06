package years.days.day05;

import utils.FileToVector;

import java.io.IOException;
import java.util.Iterator;
import java.util.Vector;

public class Day5 {



    public static void main(String[] args) {
        try {
            Vector<String> input = (new FileToVector()).toVector("/Users/richard.davidson/IdeaProjects/AoC2021/input/2022/Day5.txt");

            Vector<CrateStack> crateStacks = new Vector();


//            String[] a = {"Z","N"};
//            CrateStack stack = new CrateStack(a);
//
//            System.out.println("Stack created:"+stack.stack.size());
//
//            crateStacks.add(stack);
//
//            String[] b = {"M","C","D"};
//            stack = new CrateStack(b);
//            System.out.println("Stack created:"+stack.stack.size());
//
//            crateStacks.add(stack);
//
//            String[] c = {"P"};
//            stack = new CrateStack(c);
//            System.out.println("Stack created:"+stack.stack.size());
//
//            crateStacks.add(stack);


            String[] a = {"R","G","H","Q","S","B","T","N"};
            CrateStack stack = new CrateStack(a);

            System.out.println("Stack created:"+stack.stack.size());

            crateStacks.add(stack);

            String[] b = {"H","S","F","D","P","Z","J"};
            stack = new CrateStack(b);
            System.out.println("Stack created:"+stack.stack.size());

            crateStacks.add(stack);

            String[] c = {"Z","H","V"};
            stack = new CrateStack(c);
            System.out.println("Stack created:"+stack.stack.size());

            crateStacks.add(stack);


            String[] d = {"M","Z","J","F","G","H"};
            stack = new CrateStack(d);
            System.out.println("Stack created:"+stack.stack.size());

            crateStacks.add(stack);


            String[] e = {"T","Z","C","D","L","M","S","R"};
            stack = new CrateStack(e);
            System.out.println("Stack created:"+stack.stack.size());

            crateStacks.add(stack);


            String[] f = {"M","T","W","V","H","Z","J"};
            stack = new CrateStack(f);
            System.out.println("Stack created:"+stack.stack.size());

            crateStacks.add(stack);


            String[] g = {"T","F","P","L","Z"};
            stack = new CrateStack(g);
            System.out.println("Stack created:"+stack.stack.size());

            crateStacks.add(stack);


            String[] h = {"Q","V","W","S"};
            stack = new CrateStack(h);
            System.out.println("Stack created:"+stack.stack.size());

            crateStacks.add(stack);

            String[] i = {"W","H","L","M","T","D","N","C"};
            stack = new CrateStack(i);
            System.out.println("Stack created:"+stack.stack.size());

            crateStacks.add(stack);


            Iterator<String> iter = input.iterator();
            while (iter.hasNext()) {
                String moves = iter.next();
                String[] moveSplit = moves.split(" ");
                int cratesToMove = Integer.parseInt (moveSplit[1]);
                int from = Integer.parseInt (moveSplit[3]) - 1;
                int to = Integer.parseInt (moveSplit[5]) - 1;

                System.out.println ("Moving "+cratesToMove+ " from stack:"+from+" to stack:"+to);

                CrateStack fromStack = crateStacks.elementAt(from);
                CrateStack toStack = crateStacks.elementAt(to);

                System.out.println ("before move:"+fromStack.stack.size()+ " and:"+toStack.stack.size());
                Vector<String> crane9001 = new Vector<String>();
                for (int times = 0; times < cratesToMove; times++) {
//                     part 1
//                    toStack.stack.push(fromStack.stack.pop());
                    crane9001.add(fromStack.stack.pop());

                }

                for (int times2 = crane9001.size()-1; times2 >= 0; times2--) {
                    toStack.stack.push(crane9001.elementAt(times2));
                }

                System.out.println ("After move:"+fromStack.stack.size()+ " and:"+toStack.stack.size());

            }

            Iterator<CrateStack> printIter = crateStacks.iterator();
            while (printIter.hasNext()) {
                System.out.print(printIter.next().stack.peek());
            }

        } catch (
                IOException e) {
            System.out.println("File Bad:" + e);
        }

    }

}
