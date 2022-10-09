package responses;

import visitors.ClassVisitor;
import org.eclipse.jdt.core.dom.MethodDeclaration;

public class Question6 {

    public ClassVisitor classVisitor = new ClassVisitor();
    public int totalMethodsNbr = 0;
    public int totalMethodsLine = 0;

    public double getMethodMoyLines(){
        for (String key : classVisitor.getMethods().keySet())
            totalMethodsNbr +=  classVisitor.getMethods().get(key).length;
        for (var entry : classVisitor.getMethods().entrySet()) {
            for (MethodDeclaration method : entry.getValue()) {
                //System.out.println(method.getName().toString());
                //System.out.println(method.getBody().toString());
                //System.out.println(method.getBody().toString().split("\n").length);
                //System.out.println("-----------------\n");
                totalMethodsLine += method.getBody().toString().split("\n").length;
            }
        }
        //System.out.println(totalMethodsLine);
        return totalMethodsLine * 1.00 / totalMethodsNbr;
    }

    /** TODO : EXAMPLE >>
     * We have :
     public static void main(String[] args) {
     Object object = new Object();

     object.KillAll();
     //  help me!!
     System.out.println("good bay");
     }

     * The body is :
     {
     Object object = new Object();
     object.KillAll();
     System.out.println("good bay");
     }

     * so in total for this method we have 5 lines in body
     * */

}
