package designModes;

import java.util.ArrayList;

// component
abstract class Component {
	String name;
	
	public Component(String name){
		this.name = name;
	}
	
	public abstract void Add(Component c);
	public abstract void Remove(Component c);
	public abstract void Display(int depth);
}

// "composite"
class Composite extends Component {
	public Composite(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	private ArrayList<Component> children = new ArrayList<Component>();
	
	@Override
	public void Add(Component component) {
		children.add(component);
	}
	
	@Override 
	public void Remove(Component component) {
		children.remove(component);
	}
	
	public void Display(int depth) {
		String str = "";
		for(int i = 0; i < depth; i++)
			str += '-';
		System.out.println(str + name);
		for(Component component : children) {
			component.Display(depth + 2); 
		}
	}
}

// "Leaf"
class leaf extends Component {
	public leaf(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	private ArrayList<Component> children = new ArrayList<Component>();
	
	@Override
	public void Add(Component component) {
		System.out.println("cannot add to leaf");
	}
	
	@Override 
	public void Remove(Component component) {
		System.out.println("cannot remove from leaf");
	}
	
	public void Display(int depth) {
		String str = "";
		for(int i = 0; i < depth; i++)
			str += '-';
		System.out.println(str + name);
	}
}

public class CompositeMode {
	public static void main(String[] args) {
		Composite root = new Composite("root");
		root.Add(new leaf("Leaf A"));
		root.Add(new leaf("Leaf B"));
		
		Composite comp = new Composite("Composite X");
		comp.Add(new leaf("Leaf XA"));
		comp.Add(new leaf("leaf XB"));
		
		root.Add(comp);
		root.Add(new leaf("Leaf C"));
		
		root.Display(1);
	}
}
