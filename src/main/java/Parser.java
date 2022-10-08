import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.commons.io.FileUtils;
import org.eclipse.jdt.core.dom.*;
import responses.Question1;

public class Parser {

    public static final String projectPath = "/home/ilyas/Documents/#Others/Univ-montpellier/Tps-um/ERL/oo-app-statistical-analyzer/src/main/resources/Calculator";
    public static final String projectSourcePath = projectPath + "/src";

    public static void main(String[] args) throws IOException {

        Question1 question1 = null;
        Question1 question2 = null;

        // read java files
        final File folder = new File(projectSourcePath);
        ArrayList<File> javaFiles = listJavaFilesForFolder(folder);
        for (File fileEntry : javaFiles) {
            String content = FileUtils.readFileToString(fileEntry);
            CompilationUnit parse = Config.createOwnParse(content.toCharArray(), projectSourcePath);

            //question1 = new Question1(parse);
            //question2 = new Question2(parse);

        }

        /**
         System.out.println("1 : " + question1.getTotalClassesNbr());
        */
        
        //System.out.println("2 : " + question2.getTotalLines());

    }

    // read all java files from specific folder
    public static ArrayList<File> listJavaFilesForFolder(final File folder) {
        ArrayList<File> javaFiles = new ArrayList<File>();
        for (File fileEntry : folder.listFiles()) {
            if (fileEntry.isDirectory()) {
                javaFiles.addAll(listJavaFilesForFolder(fileEntry));
            } else if (fileEntry.getName().contains(".java")) {
                javaFiles.add(fileEntry);
            }
        }
        return javaFiles;
    }

}
