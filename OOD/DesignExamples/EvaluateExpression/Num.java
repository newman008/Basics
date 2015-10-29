package EvaluateExpression;

public class Num extends Node{
    
    int value;
    
    public Num(int v) {
        value = v;
    }
    
    @Override
    public int process() {
        // TODO Auto-generated method stub
        return value;
    }

}
