# Head First Design Patterns Study Notes

## Design Principles
>
1. Identify the aspects of your application that vary and separate them from what stays the same.
2. Program to an interface, not an implementation.
3. Favor composition over inheritance.
4. Strive for loosely coupled designes between objects that interact.
5. Encapsulate what varies.
6. Classes should be open for extension, but closed for modification.
7. Depend upon abstractions, do not depend upon conrete classes.
8. Principle of Least Knowledge talk only to your immediate friends. (When designing a system, for any object be careful of the numbter of classes it interacts with and also how it comes to interact with those classes)
9. Don't call us, we'll call you. (High-level components give the low-level components this principle)
10. A class should have only one reason to change.
11. A Pattern is a solution to a problem in a context.

## Design Patterns

### `Strategy`

* The Strategy Pattern defines a family of algorithms, encapsulates each one, and makes them interchangeable. Strategy lets the algorithm vary independently from clients that use it. (Encapsulate interchangeable behaviors and use delegation to decide which behavior to use)

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

* The Factory Method Pattern defines an interface for creating an object, but lets subclasses decide which class to instantiate. Factory Method lets a class defer instantiation to subclasses. (Use this to decouple your client code from the concrete classes you need to instantiate, or you don't know ahead of time all the concrete classes you are going to need. Just subclass Factory Method and implement the factory method) (Subclasses decide which concrete classes to create)

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

```java

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
```

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


### `Command`

* The Command Pattern encapsulates a request as an object, thereby letting you parameterize other objects with different requests, queue or log requests, and support undoable operations.

* An example of a `Null Object`:

```java
public interface Command{
    public void execute(){
        //To do something
    }
}

public class NoCommand implements Command{
    public void execute(){
        //Nothing
    }
}

```


### `Adapter`

* The Adapter Patten converts the interface of a class into another interface the clients expect. Adapter lets classes work together that counldn't otherwise because of incompatible interfaces.

* The Facade Pattern provides a unified interface to a set of interfaces in a subsystem. Facade defines a higher level interface that makes the subsystem easier to use.

* The Adapter Pattern’s role is to convert one interface into another, how the client uses the Adapter:
> The client makes a request to the
adapter by calling a method on it using
the target interface.

> The adapter translates the request into
one or more calls on the adaptee using
the adaptee interface.

> The client receives the results of the
call and never knows there is an adapter
doing the translation.

* There are actually two kinds of adapters: object adapters(using composition) and class adapters(using multiple inheritance to implement, very rare in Java).

* Example: Duck-Turkey, Enumeration(no remove() method)-Iterator(with remove() method)


### `Template`

* The Template Method Pattern defines the skeleton of an algorithm in a method, deferring some steps to subclasses. Template Method lets subclasses redefine certain steps of an algorithm without changing the algorithm's structure. (Subclasses decide how to implement steps in an algorithm)

* Example: Coffee/Tea preparing, Most Frameworks(gets something done and leave others to be specified by you)

### `Iterator`

* The Iterator Pattern provides a way to access the elements of an aggregate object sequentially without exposing its underlying representation. 

* Start from Java 5, there is an improved loop statement to iterate over a collection or an array without creating an iterator explicitly:

```java
for (Object obj: collection){
    // Do something about obj
    ...
}
```

* The NULL Iterator: handle that a collection has nothing to iterate over:

```java
import java.util.Iterator

public class NullIterator implements Iterator{
    public Object next(){
        return null;
    }
    public boolean hasNExt(){
        return false;
    }
    public void remove(){
        throw new UnsupportedOperationException();
    }
}
```


* Example: Waitress iterates Menu, java.util.Iterator

### `Composite`

* The Composite Pattern allows you to compose objects into tree structures to represent part-whole hierarchies. Composite lets clients treat individual objects and compositions of objects uniformly.

* Use this pattern means you have a collections of objects with whole-part relationships and you want to treat those objects uniformly, with 'transparency'.

### `State`

* The State Pattern allows an object to alter its behavior when its internal state changes. The object will appear to change its class.

### `Proxy`

* The Proxy Pattern provides a surrogate or placeholder for another object to control access to it.

### `Compound`

* A Compound Pattern combines two or more patterns into a solution that solves a recurring or general problem.

* MVC is the most popular compound pattern (Involved with Strategy, Observer and Composite)
