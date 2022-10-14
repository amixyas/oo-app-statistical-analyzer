package responses;

import visitors.PackageVisitor;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.TypeDeclaration;

public class Question1 {

    CompilationUnit parse;
    public static PackageVisitor  packageVisitor = new PackageVisitor();

    public Question1 (CompilationUnit parse){
        this.parse = parse;
        parse.accept(packageVisitor);
    }

    public int printClasses(){
        int index = 1;
        for (TypeDeclaration Class : this.packageVisitor.getClasses()) {System.out.println("Class "+index+" name: "+Class.getName()); index++;}
        return this.packageVisitor.getClasses().size();
    }

    public int getTotalClassesNbr(){
        return this.packageVisitor.getClasses().size();
    }

}