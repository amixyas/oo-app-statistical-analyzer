package responses;

import visitors.PackageVisitor;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.TypeDeclaration;

public class Question1 {

    CompilationUnit parse;
    public static int totalClassesNbr = 0;
    public static PackageVisitor  packageVisitor = new PackageVisitor();

    public Question1 (CompilationUnit parse){
        this.parse = parse;
        parse.accept(packageVisitor);
    }

    public int getTotalClassesNbr(){
        for (TypeDeclaration Class : this.packageVisitor.getClasses()) {
            System.out.println("Class name: " + Class.getName());
            totalClassesNbr++;
        }
        return totalClassesNbr;
    }
}