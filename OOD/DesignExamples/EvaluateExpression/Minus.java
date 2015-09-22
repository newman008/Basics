package EvaluateExpression;

public class Minus extends Op{
	
	public Minus(){
		op = '-';
	}
	
	public Minus(Node l, Node r) {
		super(l, r);
		op = '-';
	}
	
	@Override
	public int process() {
		return left.process() - right.process();
	}

}
