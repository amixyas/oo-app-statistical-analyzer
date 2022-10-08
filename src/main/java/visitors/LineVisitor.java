package visitors;

import org.eclipse.jdt.core.dom.*;

public class LineVisitor extends ASTVisitor {
    private static int linesNumber;

    public LineVisitor() {
        this.linesNumber = 0;
    }

    public int getLinesNumber() {
        return linesNumber;
    }

    @Override
    public boolean visit(AssertStatement node) {
        System.out.println(linesNumber);
        linesNumber++;
        return super.visit(node);
    }

    @Override
    public boolean visit(BreakStatement node) {
        System.out.println(linesNumber);
        linesNumber++;
        return super.visit(node);
    }

    @Override
    public boolean visit(ConstructorInvocation node) {
        System.out.println(linesNumber);
        linesNumber++;
        return super.visit(node);
    }

    @Override
    public boolean visit(ContinueStatement node) {
        System.out.println(linesNumber);
        linesNumber++;
        return super.visit(node);
    }

    @Override
    public boolean visit(DoStatement node) {
        System.out.println(linesNumber);
        linesNumber++;
        return super.visit(node);
    }

    @Override
    public boolean visit(EmptyStatement node) {
        System.out.println(linesNumber);
        linesNumber++;
        return super.visit(node);
    }

    @Override
    public boolean visit(EnhancedForStatement node) {
        System.out.println(linesNumber);
        linesNumber++;
        return super.visit(node);
    }

    @Override
    public boolean visit(ExpressionStatement node){
        System.out.println(linesNumber);
        linesNumber++;
        return super.visit(node);
    }

    @Override
    public boolean visit(ForStatement node) {
        System.out.println(linesNumber);
        linesNumber++;
        return super.visit(node);
    }

    @Override
    public boolean visit(FieldDeclaration node) {
        System.out.println(linesNumber);
        linesNumber++;
        return true;
    }

    @Override
    public boolean visit(IfStatement node) {
        System.out.println(linesNumber);
        linesNumber++;
        return true;
    }



    @Override
    public boolean visit(ImportDeclaration node) {
        System.out.println(linesNumber);
        linesNumber++;
        return super.visit(node);
    }

    @Override
    public boolean visit(LabeledStatement node) {
        System.out.println(linesNumber);
        linesNumber++;
        return true;
    }

    @Override
    public boolean visit(MethodDeclaration node) {
        System.out.println(linesNumber);
        linesNumber++;
        return super.visit(node);
    }

    @Override
    public boolean visit(SuperConstructorInvocation node) {
        System.out.println(linesNumber);
        linesNumber++;
        return super.visit(node);
    }

    @Override
    public boolean visit(PackageDeclaration node) {
        System.out.println(linesNumber);
        linesNumber++;
        return super.visit(node);
    }

    @Override
    public boolean visit(ReturnStatement node) {
        System.out.println(linesNumber);
        linesNumber++;
        return true;
    }

    @Override
    public boolean visit(SwitchCase node) {
        System.out.println(linesNumber);
        linesNumber++;
        return true;
    }

    @Override
    public boolean visit(SwitchStatement node) {
        System.out.println(linesNumber);
        linesNumber++;
        return true;
    }

    @Override
    public boolean visit(ThrowStatement node) {
        System.out.println(linesNumber);
        linesNumber++;
        return true;
    }

    @Override
    public boolean visit(TryStatement node) {
        System.out.println(linesNumber);
        linesNumber++;
        return true;
    }

    @Override
    public boolean visit(TypeDeclaration node) {
        System.out.println(linesNumber);
        linesNumber++;
        return super.visit(node);
    }

    @Override
    public boolean visit(SynchronizedStatement node) {
        System.out.println(linesNumber);
        linesNumber++;
        return true;
    }

    @Override
    public boolean visit(TypeDeclarationStatement node) {
        System.out.println(linesNumber);
        linesNumber++;
        return true;
    }

    @Override
    public boolean visit(VariableDeclarationStatement node) {
        System.out.println(linesNumber);
        linesNumber++;
        return true;
    }

    @Override
    public boolean visit(WhileStatement node) {
        System.out.println(linesNumber);
        linesNumber++;
        return true;
    }
}