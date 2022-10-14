import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import GUI_Package.GUIManager;
import org.apache.commons.io.FileUtils;
import org.eclipse.jdt.core.dom.*;
import responses.*;

public class Parser {

    public static final String projectPath = "/home/ilyas/Documents/#Others/Univ-montpellier/Tps-um/ERL/oo-app-statistical-analyzer/src/main/resources/Calculator";
    //public static final String projectPath = "/home/ilyas/Documents/#Others/Univ-montpellier/Tps-um/ERL/tp1-part1/src/main/resources/Project";
    public static final String projectSourcePath = projectPath + "/src";
    public static final String jrePath = "/usr/lib/jvm/java-11-openjdk-amd64";

    static Question1 question1 = null;
    //Question2 question2 = null;
    static Question3_5_7 question3_5_7 = null;
    static Question4 question4 = null;
    static Question6 question6 = new Question6();
    static Question8To13 question8To13;
    static Question14 question14 = new Question14();

    public static void main(String[] args) throws IOException {

        Scanner sc= new Scanner(System.in);

        /**
        System.out.println("Before we start, please provide to system the next requirements : ");
        System.out.println("The project path you want to work on it : ");
        String projectPath = sc.next();
        String projectSourcePath = projectPath + "/src";
        System.out.println("JDK path : ");
        String jrePath = sc.next();
        */

        // read java files
        final File folder = new File(projectSourcePath);
        ArrayList<File> javaFiles = listJavaFilesForFolder(folder);
        for (File fileEntry : javaFiles) {
            String content = FileUtils.readFileToString(fileEntry);
            CompilationUnit parse = Config.createOwnParse(content.toCharArray(), projectSourcePath,jrePath);
            question1 = new Question1(parse); // fill package visitor
            //question2 = new Question2(parse);
            question3_5_7 = new Question3_5_7(parse); // fill class visitor
            question4 = new Question4(parse);
        }
        question8To13 = new Question8To13(question1.getTotalClassesNbr(), question3_5_7.getTotalMethodsNbr());
        menu();
    }

    static void menu(){

        Scanner sc= new Scanner(System.in);

        System.out.println("\nMenu : ");
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
        System.out.println("13 : The maximum number of method parameters compared to all methods of the app");
        System.out.println("14 : Methods call graph.");
        System.out.println("0 : Exit.");

        System.out.print("What do you choose : ");
        int input = sc.nextInt();
        
        while(input > 14 || input < 0 ){
            System.out.print("Wrong input, choose again : ");
            input = sc.nextInt();
        }

        if (input==0){
            System.exit(0);
        }
        if (input==1){
            System.out.println("");
            System.out.println("\nTotal classes = " + question1.printClasses());
        }
        else if (input==2){
            ///System.out.println("2 : " + question2.getTotalLines());
        }
        else if (input==3){
            System.out.println("\nTotal methods = " + question3_5_7.printMethods());
        }
        else if (input==4){
            System.out.println("\nTotal packages = " + question4.getTotalPackagesNbr());
        }
        else if (input==5){
            Double MoyMethodsPerClass = (question3_5_7.getTotalMethodsNbr() * 1.00 ) / question1.getTotalClassesNbr();
            System.out.println("\nAverage number of methods per class = " + MoyMethodsPerClass);
        }
        else if (input==6){
            System.out.println("\nAverage number of lines of code per method : " + question6.getMethodMoyLines());
        }
        else if (input==7){
            Double MoyAttributesPerClass = question3_5_7.getTotalVariablesNbr()* 1.00/question1.getTotalClassesNbr();
            System.out.println("\nAverage number of attributes per class = " + MoyAttributesPerClass);
        }
        else if (input==8){
            System.out.println("\nThe 10% of classes that have the most methods are : ");
            question8To13.getClasses10Methods(true);
        }
        else if (input==9){
            System.out.println("\nThe 10% of classes that have the most attributes are : ");
            question8To13.getClasses10Attirbutes(true);
        }
        else if (input==10){
            System.out.println("\nClasses which belong to the two preceding categories (8 and 9) at the same time are: ");
            question8To13.getClasses10methodsAttributes();
        }
        else if (input==11){
            System.out.print("Please, enter value of X : ");
            input = sc.nextInt();
            question8To13.getClassesXMethods(input);
        }
        else if (input==12){
            question8To13.getMethods10Lines();
        }
        else if (input==13){
            question8To13.getMaxParamsNbr();
        }
        else if (input==14){
            new GUIManager().startProcess();
            System.out.println(question14.callGraph());
        }

        System.out.print("\nDo you want to make another test (y/*): ");
        String response = sc.next();
        if (response.equals("y")) menu();

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
