package EvaluateExpression;

import java.util.*;

public class Evaluate {
    
    public static int evaluate(String expression) {
        char[] tokens = expression.toCharArray();
        Stack<Integer> values = new Stack<Integer>();
        Stack<Character> ops = new Stack<Character>();
        
        for(int i = 0; i < tokens.length; i++) {
            if(tokens[i] == ' ') continue;
            
            if(tokens[i] >= '0' && tokens[i] <= '9') {
                StringBuffer sb = new StringBuffer();
                sb.append(tokens[i]);
                while(i+1< tokens.length && tokens[i+1] >= '0' && tokens[i+1] <= '9') {
                    sb.append(tokens[++i]);
                }
                values.push(Integer.parseInt(sb.toString()));
            } else if(tokens[i] == '(') {
                ops.push(tokens[i]);
            } else if(tokens[i] == ')') {
                while(ops.peek() != '(') {
                    values.push(applyOp(ops.pop(), values.pop(), values.pop()));
                }
                ops.pop();
            } else {
                while(!ops.isEmpty() && order(tokens[i]) <= order(ops.peek())){
                    values.push(applyOp(ops.pop(), values.pop(), values.pop()));
                }
                ops.push(tokens[i]);
            }
        }
        
        while (!ops.empty())
            values.push(applyOp(ops.pop(), values.pop(), values.pop()));
        
        return values.pop();
    }
    
    public static int applyOp(char op, int b, int a)
    {
        switch (op)
        {
        case '+':
            return a + b;
        case '-':
            return a - b;
        case '*':
            return a * b;
        case '/':
            if (b == 0)
                throw new
                UnsupportedOperationException("Cannot divide by zero");
            return a / b;
        }
        return 0;
    }
    
    private static int order(char a) {  
        if (a == '*' || a == '/') {  
            return 2;  
        } else if (a == '+' || a == '-') {  
            return 1;  
        } else {  
            return 0;  
        }  
    } 
    
    public static Node buildExpressTree(String expression) {
        char[] tokens = expression.toCharArray();
        Stack<Character> ops = new Stack<Character>();
        Stack<Node> nodes = new Stack<Node>();
        
        for(int i = 0; i < tokens.length; i++) {
            if(tokens[i] == ' ') continue;
            if(tokens[i] >= '0' && tokens[i] <= '9') {
                StringBuffer sb = new StringBuffer();
                sb.append(tokens[i]);
                while(i+1< tokens.length && tokens[i+1] >= '0' && tokens[i+1] <= '9') {
                    sb.append(tokens[++i]);
                }
                Node node = new Num(Integer.parseInt(sb.toString()));
                nodes.push(node);
            } else if(tokens[i] == '(') {
                ops.push(tokens[i]);
            } else if(tokens[i] == ')') {
//              while(ops.peek() != '(') {
//                  Node node = new 
//                  values.push(applyOp(ops.pop(), values.pop(), values.pop()));
//              }
//              ops.pop();
            } else {
                while(!ops.isEmpty() && order(tokens[i]) <= order(ops.peek())){
                    Op op = null;
                    switch (ops.pop()) {
                        case '+' :
                            op = new Add();
                            break;
                        case '-' :
                            op = new Minus();
                            break;
                    }
                    
                    op.right = nodes.pop();
                    op.left = nodes.pop();
                    nodes.push(op);
                }
                ops.push(tokens[i]);
            }
        }
        
        while (!ops.empty()) {
            Op op = null;
            switch (ops.pop()) {
                case '+' :
                    op = new Add();
                    break;
                case '-' :
                    op = new Minus();
                    break;
            }
            op.right = nodes.pop();
            op.left = nodes.pop();
            nodes.push(op);
        }
        
        return nodes.pop();
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
//      int res = Evaluate.evaluate("3 + 4 + 6 - 6 + 1");
//      System.out.println(res);
        // 3 * 4 + 5
        Num n1 = new Num(3);
        Num n2 = new Num(4);
        Add a = new Add(new Num(3), new Num(4));
        Node res = new Add(new Add(new Num(3), new Num(4)), new Add(new Num(6), new Num(5)));
        Node root = Evaluate.buildExpressTree("3 + 4 + 6 + 8 - 7");
        System.out.println(root.process());
    }

}
