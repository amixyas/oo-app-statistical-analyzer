package responses;

import visitors.ClassVisitor;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.MethodDeclaration;

public class Question3_5 {

    CompilationUnit parse;
    public static ClassVisitor classVisitor = new ClassVisitor();
    public static int totalMethodsNbr = 0;

    public Question3_5(CompilationUnit parse){
        this.parse = parse;
        parse.accept(classVisitor);
    }

    public static int getTotalMethodsNbr(){
        for (String key : classVisitor.getMethods().keySet())
            totalMethodsNbr +=  classVisitor.getMethods().get(key).length;
        for (var entry : classVisitor.getMethods().entrySet()) {
            // System.out.println("key : "+entry.getKey()+"\n");
            for (MethodDeclaration method : entry.getValue()) {
                // System.out.println(method.getName().toString());
            }
        }
        return totalMethodsNbr;
    }



}
