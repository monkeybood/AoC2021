package years.days.day07;

import java.util.Iterator;
import java.util.HashMap;
import java.util.Vector;

public class Directory {

    public String name;

    public Directory parentDir;
    public HashMap<String, Directory> directories;
    public Vector<File> files;

    public Directory(String name, Directory parentDir) {
        this.parentDir = parentDir;
        this.name = name;
        this.directories = new HashMap<String, Directory>();
        this.files = new Vector<File>();
    }



    public void addFile(File file) {
        this.files.add(file);
    }

    public void addDirectory(Directory directory) {
        this.directories.put(directory.name, directory);
    }

    public Directory getSubDir(String name) {
        return this.directories.get(name);
    }


    public int size() {
        int size=  0;

        Iterator<Directory> dirIter = this.directories.values().iterator();
        while (dirIter.hasNext()) {
            Directory currentDir = dirIter.next();
            size += currentDir.size();
        }

        Iterator<File> fileIterator = this.files.iterator();
        while (fileIterator.hasNext()) {
            File currentFile = fileIterator.next();
            size += currentFile.size;
        }
        return size;
    }

}
