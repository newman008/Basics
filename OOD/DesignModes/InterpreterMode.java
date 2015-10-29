package designModes;

import java.util.ArrayList;

class Context{
    
}

abstract class AbstractExpression{
    public abstract void Interpret(Context context); 
}

class TerminalExpression extends AbstractExpression{

    @Override
    public void Interpret(Context context) {
        // TODO Auto-generated method stub
        System.out.println("called by TerminalExpression");
    }
    
}

class NonterminalExpression extends AbstractExpression{

    @Override
    public void Interpret(Context context) {
        // TODO Auto-generated method stub
        System.out.println("called by NonterminalExpression");
    }
    
}

public class InterpreterMode {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Context context = new Context();

          // Usually a tree 
          ArrayList list1 = new ArrayList(); 

          // Populate 'abstract syntax tree' 
          list1.add(new TerminalExpression());
          list1.add(new NonterminalExpression());
          list1.add(new TerminalExpression());
          list1.add(new TerminalExpression());
          
          for(int i = 0; i < list1.size(); i++) {
                ((AbstractExpression) list1.get(i)).Interpret(context);
          }

    }

}
