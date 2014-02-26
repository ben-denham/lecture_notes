Java
####

18/02/2014
==========

.. image:: images/week1_1.png

Week 1 Configuration:
---------------------
* Created a directory in my H: drive to store java code
  (``H:\java_course\java_code``).
* Added myconfig.bat into java_code, with the following environment variable
  configuration lines:

  * ``set path="C:\Program Files\Java\jdk1.7.0_45\bin"``
    * Which adds the java executables to the system path.
  * ``set classpath=h:\java_course\java_code``
    * Which sets my java code directory to the directory where java classes
      should be created.

* To test:

  * Run: ``cmd``
  * Move to H:\ drive (by running ``h:``)
  * Move to java_code (by running ``cd java_course\java_code``)
  * Run ``javac``
    * Confirm it cannot be found
  * Run ``myconfigb.bat``
  * Run ``javac``
    * Confirm usage is displayed, because we didn’t provide a java code file.

``javac`` compiles java source files (``.java``), and ``java`` runs java class
files (``.class``).

javac may encounter compilation errors, java runtime may encounter logic errors.

Java **keywords** are all **lowercase**.

**Standard**: All class names are upper camel case.`

No members should be outside a class; no code should be outside of methods.

UML
---

* Classes are rectangles with names on top; top division containing attributes,
  and bottom division containing behaviours.
* Attributes contain values or addresses (obj refs)
* Behaviours are methods containing code.

First program
-------------

::

   class Employee {
     public static void main(String[] args) {
       Employee emp = new Employee();
       emp.print();
     }

     public void print() {
       System.out.println("Hello World!");
     }
   }

* Put the code in ``ben1.java``
* Run ``javac ben1.java`` to compile the class in the file.
* Then, ``Employee.class`` has been created, so we can run ``java Employee`` to
  run the class with the java runtime (which invokes the main() method)
* **Explanation**:

  * ``Employee`` class containing a main method
  * ``main()`` must be:

    * **public** so it can be invoked from outside the class
    * **static** so that it does not need to be called on an instance
    * **void** because it returns nothing
    * and it must accept an array of strings (``String[] args``), which are the
      command line arguments.

  * We then use the System.out.println() method to print text to the console.
  * Making syntax errors will cause ``javac`` to complain (e.g. remove
    semi-colon)
  * Trying to call a non-static member from a static member will cause a
    compilation error, because the static member is not associated with an
    instance to call the non-static member on.
  * ``Employee emp = new Employee()`` explained

    * Declare a new variable in the stack (``emp``) to store a reference (memory
      address) to an Employee object.
    * Create a new ``Employee`` object in the heap, passing nothing to the
      constructor.
    * Assign (with =) the memory address of the new Employee to the emp
      variable.
    * The variable ``emp`` can now be used to reference the ``Employee`` object.

Question answers:
----------

1) Java is cross-platform, and strongly typed, which is useful for certain applications.
2) JVM = Java Virtual Machine: The runtime environment for compiled java code to run on any
   OS.
3) A class is a template for creating objects.
4) A class's main method is invoked when the class is run with ``java`` from the command
   line. Without a main method, a class cannot be run as a program.

20/02/2014
==========

.. image:: images/week1_2.png

Download Netbeans:
------------------
http://www.oracle.com/technetwork/java/javase/downloads/jdk-7-netbeans-download-432126.html

Diagram
-------

Tester
+----------+
|          |
+----------+
|C+main(..)|
+----------+

Employee
+----------+
|          |
+----------+
|+pay()    |
|+work()   |
|-eat()    |
|+workPay()|
+----------+

Staff
+----------+
|          |
+----------+
|+work()   |
|+jobWork()|
+----------+


Manager
+----------+
|          |
+----------+
|          |
+----------+

::

  class Tester {
      public static void main(String[] args) {
	  Employee emp1 = new Manager();
	  // Employee .. work
	  emp1.work();
	  // Employee .. pay
	  emp1.pay();

	  Employee emp2 = new Staff();
	  // Employee .. pay
	  emp2.pay();
	  // Staff .. work
	  emp2.work();

	  // Causes compilation error (Private member not visible outside of class).
	  //emp1.eat();

	  // Causes compilation error (Not visible from superclass ref).
	  //emp2.jobWork();

	  // Causes compilation error (Subclass ref cannot point to superclass obj).
	  // Staff emp3 = Employee();
      }
  }

  class Employee {
      public void work() {
	  System.out.println("Employee .. work");
      }

      public void pay() {
	  System.out.println("Employee .. pay");
      }

      private void eat() {
	  System.out.println("Employee .. eat");
      }

      public void workPay() {
	  System.out.println("Employee .. workPay");
	  work();
	  pay();
      }
  }

  class Staff extends Employee {
      public void work() {
	  System.out.println("Staff .. work");
      }

      public void jobWork() {
	  System.out.println("Staff .. jobWork");
      }
  }

  class Manager extends Employee {

  }

Application Development
  Creating an executable class with a main method; makes use of object libraries.

Object Engineering
  Creating classes that will be used to create objects in applications and other classes.

When a class is loaded from the disk into memory, only static methods are stored as part of
the class. Instance methods are stored with context as part of each instance.

When accessing an instance member from within an instance method, the keyword ``this`` can
ben used to access the current instance. If there is no name conflict, this can even be
omitted, and the member accessed directly (as showing in ``Employee.workPay()``)

OOP
---

Inheritance
  "Is-a" relationship. Closed, empty arrow pointing toward superclass in UML.

An object-reference of a parent type can point to an instance of child type, but only the
parent's members will be accessible. Try to use parent object-references as much as
possible.

An object-reference of child type cannot point towards an object of parent type, because
it will not be able to fulfil the specialised role.

In an OO-inheritance hierarchy, **specialization** is downward, **generalization** is
upward.

Even if a child class is empty, it can still be used in the same way as it's parent.

A private member cannot be accessed from outside of the same class (not even in child
classes).

25/02/2014
==========

.. image:: images/week2_1png

::

  class Employee {

      public int ecode;
      public String fname;
      public String lname;
      public double salary;

      public Employee(int ecode, String fname, String lname, double salary) {
	  System.out.println("Employee .. constructor");
	  this.ecode = ecode;
	  this.fname = fname;
	  this.lname = lname;
	  this.salary = salary;
      }

      public void pay() {
	  System.out.println("Employee .. pay");
      }

      public String work() {
	  System.out.println("Employee .. work");
	  return ecode + ": " + fname + " " + lname + "\nSalary: $" + salary;
      }

  }

  class Staff extends Employee {

      public Staff(int ecode, String fname, String lname, double salary) {
	  super(ecode, fname, lname, salary);
	  System.out.println("Staff .. constructor");
      }

      // Note how this method overrides work() in Employee for Staff objects.
      public String work() {
	  System.out.println("Staff .. work");
	  return ecode + ": " + lname + ", " + fname + "\nSalary: $" + salary;
      }

  }

  class Manager extends Employee {

      public Manager(int ecode, String fname, String lname, double salary) {
	  super(ecode, fname, lname, salary);
	  System.out.println("Manager .. constructor");
      }

  }

  class Tester {
      public static void main(String[] args) {
	  // Prints "Employee .. constructor" and "Staff .. constructor", as the constructor
	  // is fired.
	  Employee emp = new Staff(1001, "Ben", "Denham", 120000);
	  testEmp(emp);

	  // Prints "Employee .. constructor" and "Manager .. constructor", as the constructor
	  // is fired.
	  Employee mgr = new Manager(1001, "Ben", "Denham", 120000);
	  testEmp(mgr);
      }

      public static void testEmp(Employee emp) {
	  // Prints "{Class} .. work" as work() is fired. Also returns the employee
	  // description, which we store in our local String variable: fullName.
	  String description = emp.work();
	  // Prints the description that we stored in the last line.
	  System.out.println(description);
      }
  }


In Java, attributes are declared in a class with the following syntax::

  [public|private] type attributeName;

Constructors
------------

A special method that is automatically run when an instance of a class is created.

Constructors are useful for initializing variables, and for initializing other required
context (e.g. database connections).

The constructor must be public, must have no return value, and must have the same name as
the class.

Note how we pass arguments to the constructor when initializing an object with ``new`` (see
``Tester.main()``).

Method arguments and return values
----------------------------------

Note how Employee.work() returns a ``String`` instead of ``void``, by declaring the return
type and by using the ``return`` keyword.

We must return a value that matches the specified return data type (String).

Note how in the constructor of Employee, we accepted arguments by specifying the data type
and variable name of each argument.

Note: Because these local variables (fname, lname) conflict with the instance variables of
the same names, the local variables take preference when being referenced, and the instance
variables must be referenced with ``this``. When there is no conflict, instance variables
can be referenced without ``this``.

When an object reference is created of a reference type (E.g. String or another class), the
default value is null. (Primitive types have a default value, such as 0 for number types.)

Local and Instance variables
----------------------------

When local variables conflict with instance variables of the same names, the local
variables take preference when being referenced, and the instance variables must be
referenced with ``this``. When there is no conflict, instance variables can be referenced
without ``this``.

* A local variable is allocated when a method runs, and becomes innaccessible when the method
  finishes.
* An instance variable is allocated when an object is created, and becomes innaccessible when
  the object becomes innaccessible.
* A static variable is allocated when the class is loaded into memory, and becomes
  inaccessible when the class becomes innaccessible (usually when the program finishes).

Overriding
----------

When we declare a method in a class that has already been declared in a parent class with
the same signature (method name and arguments types and order), then that method is said to
**override** the method in the parent class.

Whenever the method is called for an object of the child type (even when the object reference is of parent type), the overriding definition is used instead of the original one.
