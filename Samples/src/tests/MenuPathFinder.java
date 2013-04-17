package tests;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * Will look for a file within a directory. Criteria used is file name eg. GT.MENU or MENU
 * @author gmendons
 *
 */
public class MenuPathFinder {

    /**
     * @param args
     * 
     * 
     */
    public static void main(String args[]) {
        try {
            Path startPath = Paths.get("c:/navteq/GT_drives");
            Files.walkFileTree(startPath, new SimpleFileVisitor<Path>() {
                //@Override
                /*public FileVisitResult preVisitDirectory(Path dir,
                        BasicFileAttributes attrs) {
                    System.out.println("Dir: " + dir.toString());
                    return FileVisitResult.CONTINUE;
                }
                 */
                @Override
                public FileVisitResult visitFile(Path file,
                        BasicFileAttributes attrs) {
                    
                    //if (file.getFileName().endsWith("MENU")){
                      //  System.out.println("Menu File: " + file.toString());    
                    //}
                    if ((file.toString().contains("UK")) && (file.getFileName().endsWith("GT.MENU"))){
                        System.out.println("GT File: " + file.toString());
                       // System.out.println("GT Filename: " + file.getFileName());
                    }
                    
                    if ((file.toString().contains("UK")) && (file.getFileName().endsWith("MENU"))){
                        System.out.println("Menu File: " + file.toString());    
                    }
                    
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult visitFileFailed(Path file, IOException e) {
                    return FileVisitResult.CONTINUE;
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}