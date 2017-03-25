# Head First Design Patterns Study Notes

## Design Principles
>
1. Identify the aspects of your application that vary and separate them from what stays the saem.
2. Program to an interface, not an implementation.
3. Favor composition over inheritance.
4. Strive for loosely coupled designes between objects that interact.
5. Encapsulate what varies.
6. Classes should be open for extension, but closed for modification.
7. Depend upon abstractions, do not depend upon conrete classes.

## Design Patterns

### `Strategy`

* The Strategy Pattern defines a family of algorithms, encapsulates each one, and makes them interchangeable. Strategy lets the algorithm vary independently from clients that use it.

* Example: Duck Simulator

### `Observer`

* The Observer Pattern defines a one-to-many (one subject to many observers) dependency between objects so that when one object changes state, all of its dependents are notified and updated automatically.

* Example: Weather Displayer / Newspaper Subscribers

* Bad things of `java.util.Observable` and `java.util.Observer`:
    * Observable is a class not an interface, you can't add on the Observable behavior to an existing class which already extends another superclass.

    * Observable is not an interface, so you can't use that built-in API with ease.

    * `setChanged()` is protected, unless subclass the Observable, you cannot use it.

### `Decorator`

* The Decorator Pattern attahches additional respnsibilities to an object dynamically. Decorators provide a flexible alternative to subclassing for extending functionality.

* Example: StarBuzz Coffee/ Java I/Os

### `Factory`

* The Factory Method Pattern defines an interface for creating an object, but lets subclasses decide which class to instantiate. Factory Method lets a class defer instantiation to subclasses. (Use this to decouple your client code from the concrete classes you need to instantiate, or you don't know ahead of time all the concrete classes you are going to need. Just subclass Factory Method and implement the factory method)

* In design patterns, the phrase "implement an interface" does NOT alsways mean "write a class that implements a Java interface, by using the 'implements' keyword in the class declaration". In the general use of this phrase, a conrete class implementing a smethod from a supertype(which could be a class OR interface) is still considered to be "implementing the interface" of that supertype.

* The Abstract Factory Pattern provides an interface for creating families of related or dependent objects without specifying their concrete classes. (Use this whenever you have families of products you need to create and you want to make sure your clients cerate products that belong together)

### `Singleton`

* The Singelton Patten ensures a class has only one instnce, and provides a global point of access to it.

* A very smart example to get familiar with Singleton:

For a class like this:

```java

public class Chicken {
    String description;

    private Chicken(){
        description = "This is a chick!"
    }
}

public class Main {
    public static void main(String args[]){
        Chicken chicken1 = new Chicken();
        System.out.println(chicken1.description);
    }
}
```

The class "Chicken" cannot be instantiated because it has a private constructor. Private means the code in class "Chicken" is the only code that could call it, and we'd have to have an instance "the chicken1" to call it, but we can't have that instance because no other class can instantiate it. It's a chicken and egg problem: we can use the constructor from an object of type Chicken, but we can never instantiate a Chicken because no other object (including Main) can use "new Chicken".

To solve it, we can do this:

```java

public class Chicken {
    String description;

    private Chicken(){
        description = "This is a chick!"
    }

    public static Chicken getInstance(){
        return new Chicken();
    }
}

public class Main {
    public static void main(String args[]){
        Chicken chicken2 = Chicken.getInstance();
        System.out.println(chicken2.description);
    }
}
```
By using the class method `getInstance()`, we can access the private constructor then. To modify it to a singleton demo, just need to do like below:

```java

public class Chicken {
    String description;

    private static Chicken uniqueInstance;

    private Chicken(){
        description = "This is a chick!"
    }

    public static Chicken getInstance(){
        if (uniqueInstance == null){
            uniqueInstance = new Chicken();
        }
        return uniqueInstance;
    }
}

public class Main {
    public static void main(String args[]){
        Chicken chicken3 = Chicken.getInstance();
        System.out.println(chicken3.description);
    }
}
```

* To deal with **multi-thread-trap of Singleton**, we have three ways:

I. Use Synchronization:

public class Chicken {
    String description;

    private static Chicken uniqueInstance;

    private Chicken(){
        description = "This is a chick!"
    }

    public static synchronized Chicken getInstance(){
        if (uniqueInstance == null){
            uniqueInstance = new Chicken();
        }
        return uniqueInstance;
    }
}

II. Move to an eagerly created instance ranther than a lzily created one by:

```java

public class Chicken {
    String description;

    private static Chicken uniqueInstance = new Chicken();

    private Chicken(){
        description = "This is a chick!"
    }

    public static Chicken getInstance(){
        return uniqueInstance;
    }
}
```

III. Use "double-checked locking" to reduce the use(cost) of synchronization, in this case the synchronization will happen just for once (**volatile keyword's JVM implementations are not stable in Java 4 and earlier editions!**):

```java

public class Chicken {
    String description;

    private volatile static Chicken uniqueInstance;

    private Chicken(){
        description = "This is a chick!"
    }

    public static Chicken getInstance(){
        if (uniqueInstance == null){
            synchronized (Singleton.class){
                if (uniqueInstance == null){
                    uniqueInstance = new Chicken();
                }
            }
        }
        return uniqueInstance;
    }
}
```

* Also, be careful about classloaders when using Singleton.

* In Java 1.2 JVM, the bugs of garbage collector will "eat" the reference of Singleton!
