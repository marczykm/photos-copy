package pl.marczyk.logic;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FilesRetriever {

    private static List<File> files = new ArrayList<File>();

    public static List<File> getFilesInDirectory(File node){
        if (!node.isDirectory()) {
            files.add(new File(node.getAbsolutePath()));
        } else {
            String[] subNode = node.list();
            for (String filename : subNode){
                getFilesInDirectory(new File(node, filename));
            }
        }
        return files;
    }

}
