package EvaluateExpression;

public class Op extends Node{
	
	char op;
	Node left;
	Node right;
	
	public Op() {
		
	}
	
	public Op(Node l, Node r) {
		left = l;
		right = r;
	}

	@Override
	public int process() {
		// TODO Auto-generated method stub
		return 0;
	}

}
