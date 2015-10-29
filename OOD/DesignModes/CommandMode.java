package designModes;

class Receiver {
    public void action() {
        System.out.println("called action");
    }
}

abstract class Command {
    Receiver receiver;
    
    public Command(Receiver re) {
        receiver = re;
    }
    
    public abstract void Execute();
}

class ConcreteCommand extends Command {

    public ConcreteCommand(Receiver re) {
        super(re);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void Execute() {
        // TODO Auto-generated method stub
        receiver.action();
    }
    
}

class Invoker {
    private Command command;
    public void setCommand(Command com) {
        command = com;
    }
    public void ExecuteCommand() {
        command.Execute();
    }
}

public class CommandMode {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Receiver receiver = new Receiver();
        Command command = new ConcreteCommand(receiver);
        Invoker invoker = new Invoker();
        
        invoker.setCommand(command);
        invoker.ExecuteCommand();
    }

}
