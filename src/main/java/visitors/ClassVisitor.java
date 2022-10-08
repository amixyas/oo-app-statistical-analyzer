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

            /** TODO : SOL-Variables-1
             * The problem with [node.getFields] that there is a such cases like [public String firstName, lastName, city]
             it will consider it as one variable, so we need to make string treatment plus eliminating java reserved work
             like [static final int string ... etc].

             * The good thing here is that we can always make a relation between the variable and his class parent 'directly'.

             variables.put(node.getName().toString(), node.getFields());
             */
        }
        return super.visit(node);
    }

    /** TODO : SOL-Variables-1
     public Map<String, FieldDeclaration[]> getVariables() {
     return variables;
     }
     */

}


