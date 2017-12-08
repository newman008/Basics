package Annotations;

import java.lang.annotation.*;

/**
 * annotation defination look a lot like interface definitions except for @
 * @Target defines where you can apply this annotation
 * @Retention defines whether the annotations are avaiable in the source code (SOURCE), in the class file (CLASS) or at run time (RUNTIME).
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface definition {}
