import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.commons.io.FileUtils;
import org.eclipse.jdt.core.dom.*;
import responses.*;

public class Parser {

    public static final String projectPath = "/home/ilyas/Documents/#Others/Univ-montpellier/Tps-um/ERL/oo-app-statistical-analyzer/src/main/resources/Calculator";
    //public static final String projectPath = "/home/ilyas/Documents/#Others/Univ-montpellier/Tps-um/ERL/tp1-part1/src/main/resources/Project";

    public static final String projectSourcePath = projectPath + "/src";

    public static void main(String[] args) throws IOException {

        Question1 question1 = null;
        Question2 question2 = null;
        Question3_5_7 question3_5_7 = null;
        Question4 question4 = null;
        Question6 question6 = new Question6();
        Question8To13 question8To13 = null;
        Question14 question14 = new Question14();

        // read java files
        final File folder = new File(projectSourcePath);
        ArrayList<File> javaFiles = listJavaFilesForFolder(folder);
        for (File fileEntry : javaFiles) {
            String content = FileUtils.readFileToString(fileEntry);
            CompilationUnit parse = Config.createOwnParse(content.toCharArray(), projectSourcePath);

            question1 = new Question1(parse);
            //question2 = new Question2(parse);
            question3_5_7 = new Question3_5_7(parse);
            //question4 = new Question4(parse);

        }

        /**
         System.out.println("1 : " + question1.getTotalClassesNbr());
        */

        //System.out.println("2 : " + question2.getTotalLines());

        /**
         System.out.println("3 : " + question3_5_7.getTotalMethodsNbr());
        */

        /**
         System.out.println("4 : " + question4.getTotalPackagesNbr());
        */

        /**
         Double MoyMethodsPerClass = (question3_5_7.getTotalMethodsNbr() * 1.00 ) / question1.getTotalClassesNbr();
         System.out.println("5 : " + MoyMethodsPerClass);
        */

        /**
         System.out.println("6 : " + question6.getMethodMoyLines());
        */

        /**
         Double MoyAttributesPerClass = question3_5_7.getTotalVariablesNbr()* 1.00/question1.getTotalClassesNbr();
         System.out.println("7 : " + MoyAttributesPerClass);
        */


        /**
         System.out.println("8 : ");
         question8_13 = new Question8_13(question1.getTotalClassesNbr());
         question8_13.getClasses10Methods();



         System.out.println("9 : ");
         question8_13 = new Question8_13(question1.getTotalClassesNbr());
         question8_13.getClasses10Attirbutes();



         System.out.println("10 : ");
         question8_13 = new Question8_13(question1.getTotalClassesNbr());
         question8_13.getClasses10methodsAttributes();



         System.out.println("11 : ");
         question8_13 = new Question8_13(question1.getTotalClassesNbr());
         question8_13.getClassesXMethods(2);


         System.out.println("12 : ");
         question8_13 = new Question8_13(question1.getTotalClassesNbr(), question3.getTotalMethodsNbr());
         question8_13.getMethods10Lines();


         System.out.println("13 : ");
         question8_13 = new Question8_13(question1.getTotalClassesNbr(), question3.getTotalMethodsNbr());
         System.out.println(question8_13.getMaxParamsNbr());
         */
        System.out.println(question14.callGraph());
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
