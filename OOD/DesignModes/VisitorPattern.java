package designModes;

interface Element {
       // 1. accept(Visitor) interface
       public void accept( Visitor v ); // first dispatch
}

class This implements Element {
   // 1. accept(Visitor) implementation
   public void   accept( Visitor v ) {
     v.visit( this );
   } 
   public String thiss() {
     return "This";
   }
}

class That implements Element {
    
   public void   accept( Visitor v ) {
     v.visit( this );
   }
   public String that() {
     return "That";
   }
}

interface Visitor {
   public void visit( This e ); // second dispatch
   public void visit( That e );
}

class UpVisitor implements Visitor {                   
   public void visit( This e ) {
      System.out.println( "do Up on " + e.thiss() );
   }
   public void visit( That e ) {
      System.out.println( "do Up on " + e.that() );
   }
}

class DownVisitor implements Visitor {
   public void visit( This e ) {
      System.out.println( "do Down on " + e.thiss() );
   }
   public void visit( That e ) {
      System.out.println( "do Down on " + e.that() );
   }
}
    
public class VisitorPattern {
    
    public static Element[] list = { new This(), new That()};
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        UpVisitor    up   = new UpVisitor();
        DownVisitor  down = new DownVisitor();
        for (int i=0; i < list.length; i++) {
           list[i].accept( up );
        }
        for (int i=0; i < list.length; i++) {
           list[i].accept( down );
        }

    }

}
