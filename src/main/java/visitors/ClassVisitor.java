package visitors;

import org.eclipse.jdt.core.dom.*;

import java.util.*;

/** TODO :
 * Visiting Classes
 * Visiting Attributes
 * Make next relations : Class-Attributes and Class-Methods
*/

public class ClassVisitor extends ASTVisitor{

    /**  TODO : SOL-Variables-1
     public static Map<String, FieldDeclaration[]> variables = new HashMap<String, FieldDeclaration[]>();
     */

    public static Map<String, MethodDeclaration[]> methods = new HashMap<>();
    public  Map<String, MethodDeclaration[]> getMethods() {return methods;}

    public boolean visit(TypeDeclaration node) {
        if (!node.isInterface()) {
            methods.put(node.getName().toString(), node.getMethods());
        }
        return super.visit(node);
    }

}


