package responses;

import org.eclipse.jdt.core.dom.MethodDeclaration;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static responses.Question3_5_7.classVisitor;

/** TODO : Question : 8 9 10 11 12 13 */

public class Question8To13 {

    List<String> classes10methods;
    List<String> classes10attributes;
    List<String> classes10methodsAttributes =  new ArrayList<>();
    List<String> classesXmethods =  new ArrayList<>();
    List<String> methods10lines;    int maxClasses;
    int maxMethods;

    public Question8To13(int totalClassesNbr, int totalMethodsNbr) {
        double doubleNumber = totalClassesNbr*10.0/100;
        maxClasses = (int) doubleNumber;
        if (maxClasses == 0 || (doubleNumber - maxClasses) >= 0.5 ) maxClasses += 1;

        doubleNumber = totalMethodsNbr*10.0/100;
        maxMethods = (int) doubleNumber;
        if (maxMethods == 0 || (doubleNumber - maxMethods) >= 0.5 ) maxMethods += 1;
    }

    public List<String> getClasses10Methods() {
        classes10methods =  new ArrayList<>();
        Map<String, MethodDeclaration[]> methods = classVisitor.getMethods();

        int max = 0;
        String name = "";
        for (int i = 1; i <= maxClasses; i++) {
            for (var entry : methods.entrySet()) {
                if (max <= entry.getValue().length && !name.equals(entry.getKey()) ) {
                    max = entry.getValue().length;
                    name = entry.getKey();
                }
            }
            classes10methods.add(name);
            max = 0;
            methods.remove(name);
        }
        //classes10methods.forEach(classeName-> System.out.println(classeName));
        return classes10methods;
    }

    public List<String> getClasses10Attirbutes() {
        Map<String, List<String>> attributes = classVisitor.getParentVariables();
        classes10attributes =  new ArrayList<>();

        int max = 0;
        String name = "";
        for (int i = 1; i <= maxClasses; i++) {
            for (var entry : attributes.entrySet()) {
                if (max < entry.getValue().size()) {
                    max = entry.getValue().size();
                    name = entry.getKey();
                }
            }
            classes10attributes.add(name);
            max = 0;
            attributes.remove(name);
        }
        //classes10attributes.forEach(classeName-> System.out.println(classeName));

        return classes10attributes;
    }

    public List<String> getClasses10methodsAttributes() {
        getClasses10Methods();
        getClasses10Attirbutes();
        classes10methods.forEach(cm->{classes10attributes.forEach(ct->{if(cm.equals(ct))classes10methodsAttributes.add(cm);});});
        //classes10methodsAttributes.forEach(classeName-> System.out.println(classeName));
        return classes10methodsAttributes;
    }

    public List<String> getClassesXMethods(int x) {
        for (var entry : methods.entrySet()) if (x <= entry.getValue().length) classesXmethods.add(entry.getKey());
        //classesXmethods.forEach(classeName-> System.out.println(classeName));
        return classesXmethods;
    }

    public List<String> getMethods10Lines () {
        methods10lines =  new ArrayList<>();
        Map<String, MethodDeclaration[]> methods = classVisitor.getMethods();

        int max = 0;
        String name = "";
        for (int i = 1; i <= maxMethods; i++) {
            for (var entry : methods.entrySet()) {
                for (MethodDeclaration method : entry.getValue()) {
                    //System.out.println( method.getName().toString());
                    if (max <= method.getBody().toString().split("\n").length && ! name.equals(method.getName().toString())) {
                        max = method.getBody().toString().split("\n").length;
                        name = method.getName().toString();
                    }
                }
            }
            methods10lines.add(name);
            max = 0;
            methods.remove(name);
        }
        //methods10lines.forEach(methodName-> System.out.println(methodName));
        return methods10lines;
    }

    public int getMaxParamsNbr () {

        int max = 0;
        for (int i = 1; i <= maxMethods; i++)
            for (var entry : methods.entrySet())
                for (MethodDeclaration method : entry.getValue()) {
                    if (max <= method.parameters().size()) max = method.parameters().size();
                    method.parameters().forEach(p-> System.out.println(p.toString()));
                }
        return max;
    }

}
