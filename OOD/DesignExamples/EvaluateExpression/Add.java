package EvaluateExpression;

public class Add extends Op{
    
    public Add() {
        op = '+';
    }
    
    public Add(Node l, Node r) {
        super(l, r);
        // TODO Auto-generated constructor stub
        op = '+';
    }

    @Override
    public int process() {
        return left.process() + right.process();
    }
}
