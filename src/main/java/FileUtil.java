
import java.io.*;
import java.util.*;

public class FileUtil {

    //=========================================================================================
    public static List<String> getFileList(String sourcePath) {
        System.out.println("REM -- "+sourcePath);
        File dir = new File(sourcePath);
        List<String> fileTree = new ArrayList<String>();
        for (File entry : dir.listFiles()) {
            if (entry.isFile())
                fileTree.add(entry.getAbsolutePath());
            else
                fileTree.addAll(getFileList(entry.getAbsolutePath()));
        }
        return fileTree;
    }
    //=========================================================================================
    public static void writeListToFile(String fileListLocation, List<String> fileList) throws Exception {
        FileOutputStream fos1 = new FileOutputStream(new File(fileListLocation));
        for (int i = 0; i < fileList.size(); i++) {
            fos1.write((fileList.get(i) + "\n").getBytes());
        }
        fos1.close();
    }
    //=========================================================================================
    public static ArrayList<String> readListFromFile(String fileName) throws Exception {
        ArrayList<String> returnArray = new ArrayList<String>();
        BufferedReader input = new BufferedReader(new FileReader(new File(fileName)));
        try {
            String line = null; // not declared within while loop
            while ((line = input.readLine()) != null) {
                returnArray.add(line);
            }
        } finally {
            input.close();
        }
        return returnArray;
    }
    //=========================================================================================

    //=========================================================================================
}
