package years.days.day07;

import utils.FileToVector;

import java.io.IOException;
import java.util.Iterator;
import java.util.Vector;

public class Day7 {

    public Directory root;

    public Day7 () {
        this.root = new Directory("/", null);
    }

    public static void main(String[] args) {
        try {

            Day7 day7 = new Day7();

            Directory currentDir = day7.root;

            Vector<String> input = (new FileToVector()).toVector("/Users/richard.davidson/IdeaProjects/AoC2021/input/2022/Day7.txt");
            Iterator<String> instructions = input.iterator();

            while (instructions.hasNext()) {
                String instruction = instructions.next();


                if (instruction.equalsIgnoreCase("$ cd /")) {
                    currentDir = day7.root;
                } else {
                    // command starting $

                    if (instruction.startsWith("$")) {
                        if (instruction.startsWith("$ cd")) {
                            if (instruction.equalsIgnoreCase("$ cd ..")) {
                                currentDir = currentDir.parentDir;
                            } else {
                                currentDir = currentDir.getSubDir(instruction.substring(5, instruction.length()));
                            }
                        }

                    } else {
                        if (instruction.startsWith("dir")) {
                            Directory dir = new Directory(instruction.substring(4, instruction.length()), currentDir);
                            currentDir.addDirectory(dir);
                        } else {
                            // must be a file
                            File file = new File(instruction.substring(instruction.indexOf(" ") + 1, instruction.length()), Long.parseLong(instruction.substring(0, instruction.indexOf(" "))));
                            currentDir.addFile(file);
                        }
                    }
                }

            }

            Vector<Directory> smallDirs = new Vector<Directory>();
            day7.findDirsSmallerThan(smallDirs, day7.root, 30000000);

            int smallSize = 0;
            for (int times = 0; times < smallDirs.size(); times++) {
                smallSize += smallDirs.elementAt(times).size();
            }


            System.out.println ("Total small Size:"+smallSize);

            //   part 2 ------------------------------
            long diskSize = 70000000;
            long spaceUsed = day7.root.size();
            long freeSpace = diskSize - spaceUsed;
            long spaceNeeded = 30000000 - freeSpace;
            System.out.println ("space needed:"+spaceNeeded);

            Vector<Directory> bigDirs = new Vector<Directory>();
            day7.findDirsBiggerThan(bigDirs, day7.root, spaceNeeded);

            int bigSize = day7.root.size();


            for (int times = 0; times < bigDirs.size(); times++) {
                if (bigDirs.elementAt(times).size() < bigSize) bigSize = bigDirs.elementAt(times).size();
            }

            System.out.println ("Delete Dir Size:"+bigSize);


        } catch (IOException e) {
            System.out.println("File Bad:" + e);
        }
    }


    public void findDirsSmallerThan (Vector<Directory> smallDirs,
                                                   Directory dirToCheck, long target) {
        if (dirToCheck.size() <= target) {
            smallDirs.add(dirToCheck);
        }
        Iterator<Directory> subDirs = dirToCheck.directories.values().iterator();

        while (subDirs.hasNext()) {
            Directory subDir = subDirs.next();
            this.findDirsSmallerThan(smallDirs, subDir,target);
        }
    }


    public void findDirsBiggerThan (Vector<Directory> bigDirs,
                                     Directory dirToCheck, long target) {
        if (dirToCheck.size() >= target) {
            bigDirs.add(dirToCheck);
        }
        Iterator<Directory> subDirs = dirToCheck.directories.values().iterator();

        while (subDirs.hasNext()) {
            Directory subDir = subDirs.next();
            this.findDirsBiggerThan(bigDirs, subDir,target);
        }
    }




}
