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
        Question8To13 question8To13;
        Question14 question14 = new Question14();


        // read java files
        final File folder = new File(projectSourcePath);
        ArrayList<File> javaFiles = listJavaFilesForFolder(folder);
        for (File fileEntry : javaFiles) {
            String content = FileUtils.readFileToString(fileEntry);
            CompilationUnit parse = Config.createOwnParse(content.toCharArray(), projectSourcePath);
            question1 = new Question1(parse);
            question2 = new Question2(parse);
            question3_5_7 = new Question3_5_7(parse);
            question4 = new Question4(parse);
        }

        System.out.println("Menu : ");
        System.out.println("1 : Number of classes in the application.");
        System.out.println("2 : Number of application code lines.");
        System.out.println("3 : Total number of methods in the application..");
        System.out.println("4 : Total number of application packages.");
        System.out.println("5 : Average number of methods per class.");
        System.out.println("6 : Average number of lines of code per method.");
        System.out.println("7 : Average number of attributes per class.");
        System.out.println("8 : The 10% of classes that have the most methods.");
        System.out.println("9 : The 10% of classes that have the most attributes.");
        System.out.println("10 : Classes which belong to the two preceding categories at the same time.");
        System.out.println("11 : Classes that have more than X methods (the value of X is given).");
        System.out.println("12 : The 10% of methods that have the largest number of lines of code (per class).");
        System.out.println("13 : The maximum number of parameters compared to all methods of the app");
        System.out.println("14 : Methods call graph.");

        int x = 0;
        if (x==1){
            System.out.println("1 : " + question1.getTotalClassesNbr());
        }
        else if (x==2){
            System.out.println("2 : " + question2.getTotalLines());
        }
        else if (x==3){
            System.out.println("3 : " + question3_5_7.getTotalMethodsNbr());
        }
        else if (x==4){
            System.out.println("4 : " + question4.getTotalPackagesNbr());
        }
        else if (x==5){
            Double MoyMethodsPerClass = (question3_5_7.getTotalMethodsNbr() * 1.00 ) / question1.getTotalClassesNbr();
            System.out.println("5 : " + MoyMethodsPerClass);
        }
        else if (x==6){
            System.out.println("6 : " + question6.getMethodMoyLines());
        }
        else if (x==7){
            Double MoyAttributesPerClass = question3_5_7.getTotalVariablesNbr()* 1.00/question1.getTotalClassesNbr();
            System.out.println("7 : " + MoyAttributesPerClass);
        }
        else if (x==8){
            question8To13 = new Question8To13(question1.getTotalClassesNbr(), question3_5_7.getTotalMethodsNbr());
            question8To13.getClasses10Methods();
        }
        else if (x==9){
            question8To13 = new Question8To13(question1.getTotalClassesNbr(), question3_5_7.getTotalMethodsNbr());
            question8To13.getClasses10Attirbutes();

        }
        else if (x==10){
            question8To13 = new Question8To13(question1.getTotalClassesNbr(), question3_5_7.getTotalMethodsNbr());
            question8To13.getClasses10methodsAttributes();
        }
        else if (x==11){
            question8To13 = new Question8To13(question1.getTotalClassesNbr(), question3_5_7.getTotalMethodsNbr());
            question8To13.getClassesXMethods(2);
        }
        else if (x==12){
            question8To13 = new Question8To13(question1.getTotalClassesNbr(), question3_5_7.getTotalMethodsNbr());
            question8To13.getMethods10Lines();
        }
        else if (x==13){
            question8To13 = new Question8To13(question1.getTotalClassesNbr(), question3_5_7.getTotalMethodsNbr());
            System.out.println(question8To13.getMaxParamsNbr());
        }
        else if (x==14){
            System.out.println(question14.callGraph());
        }

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
