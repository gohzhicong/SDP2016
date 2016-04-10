/**
  * Created by gohzh on 10/04/2016.
  */

//Week 3 Exercise
//Short form Questions
//question 1
An abstract class would be more appropriate when there is a strong relationship between the abstract class and the classes that will derive from it. 
Again, this is because an abstract class is very closely linked to inheritance, which implies a strong relationship. 
But, with interfaces there need not be a strong relationship between the interface and the classes that implement the interface.

So, one major difference is that a Java class can inherit from only one abstract class, but can implement multiple interfaces.

An abstract class may provide some methods with definitions – so an abstract class can have non-abstract methods with actual implementation details. 
An abstract class can also have constructors and instance variables as well. 
An interface, can not provide any method definitions – it can only provide method headings. 
Any class that implements the interface is responsible for providing the method definition/implementation.

//question 2
a) false. interface cannot have methods only method headings
b) false. fields declared in an interface will be a public static final field thus constant.
c) false  it's not possible to define a constructor in an interface

//question 3

//question 4
increases flexbility when implementing the interface as only required methods are extended/overrided

//qustion 5
private constructors

//qestion 6

//7
//8
//9
//10
//11
