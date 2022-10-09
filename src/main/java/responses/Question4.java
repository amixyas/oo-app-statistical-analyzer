package responses;

import visitors.PackageVisitor;
import org.eclipse.jdt.core.dom.CompilationUnit;

import java.util.HashSet;
import java.util.Set;

public class Question4 {

    CompilationUnit parse;
    public static int totalClassesNbr = 0;
    public PackageVisitor packageVisitor = new PackageVisitor();
    public static Set<String> packages = new HashSet<>();

    public Question4 (CompilationUnit parse){
        this.parse = parse;
        parse.accept(packageVisitor);
        packages.add(parse.getPackage().getName().getFullyQualifiedName());
    }

    public int getTotalPackagesNbr(){
        packages.forEach(i -> System.out.println(i));
        return packages.size();
    }
}
