package responses;

import visitors.LineVisitor;
import org.eclipse.jdt.core.dom.CompilationUnit;

/**
 * TODO : Still have problem with this... :(
*/
public class Question2 {

    CompilationUnit parse;

    public static LineVisitor lineVisitor = new LineVisitor();

    public Question2 (CompilationUnit parse){
        this.parse = parse;
        parse.accept(lineVisitor);
    }

    public int getTotalLines(){
        return lineVisitor.getLinesNumber();
    }
}