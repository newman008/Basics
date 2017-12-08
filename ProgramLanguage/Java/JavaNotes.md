Java notes:

1. Static Import

// Before
double r = Math.cos(Math.PI * theta);

// After
import static java.lang.Math.PI;
double r = cos(PI * theta);

The static import declaration is analogous to the normal import declaration. Where the normal import declaration imports classes from packages, allowing them to be used without package qualification, the static import declaration imports static members from classes, allowing them to be used without class qualification.   

2. Final Parameter
Use the keyword final when you want the compiler to prevent a variable from being re-assigned to a different object

void doSth(String arg) {
  final String x = arg;
  x = "elephant"; // Compile error: The final local variable x cannot be assigned
  arg = "fdadf";
}

void doSth(final String arg) {
  String x = arg;
  x = "elephant";
  arg = "fdafa"; // Compile error: The passed argument variable arg cannot be re-assigned
}

Good Practice: never reassign arguments

// Another case
public class MyClass {
  private int x;
}

void doSth(final MyClass arg) {
  arg = new MyClass(); // Compile error
  arg.setX(20);  // allowed, we can re-assign properties of argument which is marked as final
}

3. Varargs
Varargs are useful for any method that needs to deal with an indeterminate number of objects. One good example is String.format. The format string can accept any number of parameters, so you need a mechanism to pass in any number of objects.

String.format("This is an integer: %d", myInt);
String.format("This is an integer: %d and a string: %s", myInt, myString);

public static String format(String pattern,
                                Object... arguments);

BTW: Varargs can be used only in the final argument position
