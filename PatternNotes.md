# Head First Design Patterns Study Notes

## Design Principles
>
1. Identify the aspects of your application that vary and separate them from what stays the saem.
2. Program to an interface, not an implementation.
3. Favor composition over inheritance.
4. Strive for loosely coupled designes between objects that interact.
5. Encapsulate what varies.
6. 

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

* 