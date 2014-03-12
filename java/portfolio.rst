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

27/02/2014
==========

``javap class_name`` inspects a class.

Assignment
----------

1. UI
2. Vector
3. Hashtable

Java UI
--------

Earliest form: AWT. AWT had classes for ``Frame``, ``Textfield``,`` Button``,
etc. Problem: the screens were not as good as VB user interfaces.
Namespace: ``java.awt``

Swing extends AWT (through inheritance). Swing classes always start with "J" (e.g.
``JFrame``, ``JButton``). Namespace: ``javax.swing``

To create our own form, we create our own class that inherits from ``JFrame``. Our
custom form will then contain other controls like buttons and textfields.

Using ``import java.awt.*`` will import all class, abstract classes, interfaces, etc.
inside ``java.awt``, but not any sub-namespaces.

Action Listening
----------------

We must have a class that implements ``ActionListener`` by including the method
``public void actionPerformed(ActionEvent ae)``. This class can be our Frame.

We must also add the instance of our ``ActionListener`` as a listener for a control. For
example, if I want the current frame I am constructing to listen to btnOkay, I use:
``btnOkay.addActionListener(this); // this is my frame that implements ActionListener``.

::
  import java.awt.*;
  import javax.swing.*;
  import java.awt.event.*;

  class MainFrame extends JFrame implements ActionListener {

      JTextField txtCustomerName;

      public MainFrame() {

	  setTitle("My First UI");
	  // Don't use any automatic layout. If we used a layout, we wouldn't need to
	  // specify all of bounds.
	  setLayout(null);
	  // Use setBounds(posX, posY, width, height) to position the Frame.
	  setBounds(10, 10, 400, 600);

	  // Create our form controls.
	  JLabel lblCustomerName = new JLabel("Customer Name");
	  txtCustomerName = new JTextField();
	  JButton btnOkay = new JButton("Okay");
	  JButton btnGet = new JButton("Get");

	  // Use setBounds(posX, posY, width, height) to position the controls.
	  lblCustomerName.setBounds(20, 20, 100, 20);
	  txtCustomerName.setBounds(120, 20, 200, 20);
	  btnOkay.setBounds(20, 60, 80, 20);
	  btnGet.setBounds(120, 60, 80, 20);

	  // Subscribe our Frame to the actions of the button.
	  btnOkay.addActionListener(this);
	  btnGet.addActionListener(this);

	  // We add the items to the container instead of this object in order to avoid
	  // conflicts with the JFrame superclass?
	  Container con = getContentPane();
	  con.add(lblCustomerName);
	  con.add(txtCustomerName);
	  con.add(btnOkay);
	  con.add(btnGet);

	  // Show the frame.
	  setVisible(true);
      }

      // Implements the ActionListener interface. Handles actions this Frame is listening to.
      public void actionPerformed(ActionEvent ae) {
	  String msg = ae.getActionCommand();
	  txtCustomerName.setText(msg);
      }

  }

  class Tester {

      public static void main(String[] args) {
	  // Create a new frame object.
	  JFrame f = new MainFrame();
      }

  }

Basic ideas of Swing Frame
--------------------------

* Extend ``javax.swing.JFrame``, and implement ``java.awt.event.ActionListener``
* Use instance variables for controls that need to be shared between methods.
* In the constructor:

  * Configure the Frame (Set title, bounds, no layout)
  * Create controls (in local variables, and setting instances of instance variables)
  * Configure controls (Sset bounds, etc.)
  * Set up Frame to listen to controls (``control.addActionListener(this);``)
  * Add the controls to the Frame's container.
  * Set the Frame to be visible

* In actionPerformed(ActionEvent ae):

  * Handle control actions (events) based on the contents of ae.
  * ``java.awt.event.ActionEvent`` stores information about an action that fired.

04/03/2014
==========

.. image:: images/week3_1.png

::

  import java.awt.*;
  import javax.swing.*;
  import java.awt.event.*;

  class ProductFrame extends JFrame {

      public ProductFrame() {
	  setTitle("Product");
	  setLayout(null);
	  setBounds(10, 10, 400, 220);

	  JLabel lblPcode = new JLabel("Pcode:");
	  JLabel lblDescription = new JLabel("Description:");
	  JLabel lblPrice = new JLabel("Price:");
	  JTextField txtPcode = new JTextField();
	  JTextField txtDescription = new JTextField();
	  JTextField txtPrice = new JTextField();
	  JButton btnAdd = new JButton("Add");
	  JButton btnChange = new JButton("Change");
	  JButton btnDelete = new JButton("Delete");

	  lblPcode.setBounds(20, 20, 100, 20);
	  lblDescription.setBounds(20, 60, 100, 20);
	  lblPrice.setBounds(20, 100, 100, 20);
	  txtPcode.setBounds(130, 20, 100, 20);
	  txtDescription.setBounds(130, 60, 230, 20);
	  txtPrice.setBounds(130, 100, 100, 20);
	  btnAdd.setBounds(20, 140, 100, 20);
	  btnChange.setBounds(140, 140, 100, 20);
	  btnDelete.setBounds(260, 140, 100, 20);

	  ActionListener listener = new ProductFrameListener();
	  btnAdd.addActionListener(listener);
	  btnChange.addActionListener(listener);
	  btnDelete.addActionListener(listener);

	  Container container = getContentPane();
	  container.add(lblPcode);
	  container.add(txtPcode);
	  container.add(lblDescription);
	  container.add(txtDescription);
	  container.add(lblPrice);
	  container.add(txtPrice);
	  container.add(btnAdd);
	  container.add(btnChange);
	  container.add(btnDelete);

	  setVisible(true);
      }

  }

  class ProductFrameListener implements ActionListener {

      public void actionPerformed(ActionEvent ae) {
	  System.out.println("ProductListener: '" + ae.getActionCommand() + "' button was clicked.");
      }

  }

  class Tester {

      public static void main(String[] args) {
	  JFrame frame = new ProductFrame();
      }

  }


Above is code similar to last week's, but with more fields and buttons.

Also, we use a separate ``ProductFrameListener`` to listen to our button events,
rather than making the ``ProductFrame`` act as a listener.

HOMEWORK: CREATE UML FROM THE ABOVE CODE.

Collections Framework
---------------------

Vector
``````

Can have a generic type, but doens't have to: ``Vector<E>``

Hashtable
`````````

06/03/2014
==========

Don't classify a class (e.g. ``+String type``), use subtyping.


::

  Object a = null;
  a.toString();

The above code causes a null pointer exception.

Try to avoid using ``instanceof`` and typecasting.

11/03/2014
==========

Vectors are serial, because their items must be referred to by an index, not by
a key.

We do not need to state the size of a vector when we create it; it is dynamic.

Vectors can store any type of object at the same time, by being a vector of
objects.

When working with an object reference of parent type, we must typecast to a
child type in order to access the public members of the child type::

  import java.util.*;

  class Tester {

    public static void main(String[] args) {
	Vector v = new Vector();
	v.add("A");
	v.add("B");
	v.add("C");

	int si = v.size();
	for (int i=0; i < si; i++) {
	    String cc = (String) v.elementAt(i);
	    System.out.println(cc);
	}
    }

  }

When do not need to explicitly typecast a child type to a parent type object
reference: the conversion is implicit::

  Object myObject = "Hello World";

Try not to use ``instanceof`` and typecasting at all costs, by using common
parent class (normal or abstract) or interface ojbect references::

  import java.util.*;

  abstract class Person {

      abstract public void prt();

  }

  class Customer extends Person {

      String id;

      public Customer(String id) {
	  this.id = "C" + id;
      }

      public void prt() {
	  System.out.println("Customer: " + id);
      }

  }

  class Employee extends Person {

      String id;

      public Employee(String id) {
	  this.id = "E" + id;
      }

      public void prt() {
	  System.out.println("Employee: " + id);
      }

  }

  class Tester {

      public static void main(String[] args) {
	  Vector v = new Vector();
	  //Vector<Person> v = new Vector<Person>();

	  Employee e = new Employee("1001");
	  v.add(e);
	  e = new Employee("1002");
	  v.add(e);

	  Customer c = new Customer("1001");
	  v.add(c);

	  System.out.println("Number of elements: " + v.size());

	  int si = v.size();
	  for (int i = 0; i < si; i++) {
	      /*
	      Object obj = v.elementAt(i);
	      if (obj instanceof Employee) {
		  e = (Employee) obj;
		  e.prt();
	      }
	      else if (obj instanceof Customer) {
		  c = (Customer) obj;
		  c.prt();
	      }
	      */

	      Person p = (Person) v.elementAt(i);

	      //Person p = v.elementAt(i);

	      p.prt();
	  } 
      }

  }

Hashtable
---------

Advantages:

* Can be used as a serial device (like a vector).
* Supports random access (by key, not index).

``Hashtable.put(key, value)``
  Stores a new value.

``Hashtable.get(key)``
  Gets a value stored for a given key.

``Hashtable.keys()`` and ``Hastable.elements()`` return Enumerations of the keys
and elements respectively. There is no guarantee as to the order of the
objects in the enumeration.

We can go through an enumeration using ``hasMoreElements()`` and
``nextElement()``::

  Enumeration en = h.elements();
  while (en.hasMoreElements()) {
    c = (Customer) en.nextElement();
    c.prt();
  }

Hashtables can take generics: ``HashTable<Key, Value>``.

Full example::

  import java.util.*;

  abstract class Person {

      abstract public void prt();

  }

  class Customer extends Person {

      String id;
      String name;

      public Customer(String id, String name) {
	  this.id = "C" + id;
	  this.name = name;
      }

      public void prt() {
	  System.out.println("Customer: " + id + " - " + name);
      }

  }

  class Employee extends Person {

      String id;

      public Employee(String id) {
	  this.id = "E" + id;
      }

      public void prt() {
	  System.out.println("Employee: " + id);
      }

  }

  class Tester {

      public static void main(String[] args) {
	  String[] ccode = {"1001", "1002", "1003"};
	  String[] cname = {"Sam", "Mona", "Mark"};

	  Customer c = null;
	  Hashtable h = new Hashtable();
	  // Hashtable<String, Person> h = new Hashtable<String, Person>();

	  // Store customers in the Hashtable.
	  for (int i=0; i < ccode.length; i++) {
	      c = new Customer(ccode[i], cname[i]);
	      h.put(ccode[i], c);
	  }

	  // Retrieve customers from the Hashtable.
	  for (int i=0; i < ccode.length; i++) {
	      c = (Customer) h.get(ccode[i]);
	      c.prt();
	  }

	  System.out.println("-----------------------------");

	  Enumeration en = h.keys();
	  String code;
	  while (en.hasMoreElements()) {
	      code = (String) en.nextElement();
	      c = (Customer) h.get(code);
	      c.prt();
	  }

	  System.out.println("-----------------------------");

	  en = h.elements();
	  while (en.hasMoreElements()) {
	      c = (Customer) en.nextElement();
	      c.prt();
	  }
      }

  }

13/03/2014
==========

.. image:: images/week4_2.png


Employee (ecode, fname, lname)
Customer (ccode, name, ecode)

Note: In UML 2, an object can be represented like a class, but with a name like:
``objectName:ClassName`` that is underlined (object name is optional, but the
colon must be used).

Collection is slower than Enumeration, but safer when multithreading.

Example::

  import java.util.*;

  class Customer {

      String ccode;
      String name;
      Employee employee;

      public Customer(String ccode, String name, Employee employee) {
	  this.ccode = ccode;
	  this.name = name;
	  this.employee = employee;
      }

      public void print() {
	  System.out.println("Customer: " + ccode + " - " + name);
      }

  }

  class Employee {

      String ecode;
      String firstName;
      String lastName;
      Hashtable<String, Customer> customers;
      //Vector<Customer> customers;

      public Employee(String ecode, String firstName, String lastName) {
	  this.ecode = ecode;
	  this.firstName = firstName;
	  this.lastName = lastName;
	  customers = new Hashtable<String, Customer>();
	  //customers = new Vector<Customer>();
      }

      public void createCustomer(String ccode, String name) {
	  customers.put(ccode, new Customer(ccode, name, this));
	  //customers.add(new Customer(ccode, name, this));
      }

      public void listCustomers() {
	  /*
	  // Collection is slower than Enumeration, but safer when multithreading.
	  for (Customer customer : customers.values()) {
	      customer.print();
	  }
	  */
	  Customer customer;
	  Enumeration<Customer> customersEnum = customers.elements();
	  while (customersEnum.hasMoreElements()) {
	      customer = customersEnum.nextElement();
	      customer.print();
	  }
	  /*
	  // Alternative approach, so that we have access to each key.
	  String ccode;
	  Enumeration<String> ccodes = customers.keys();
	  while (ccodes.hasMoreElements()) {
	      ccode = ccodes.nextElement();
	      customer = customers.get(ccode);
	      customer.print();
	  }
	  */
	  /*
	  // For a Vector.
	  int size = customers.size();
	  for (int i = 0; i < size; i++) {
	      customer = customers[i];
	      customer.print();
	  }
	   */
      }

      public void print() {
	  System.out.println("Employee: " + ecode + " - " + firstName + " " + lastName);
      }

  }

  class Customers extends Hashtable<String, Customer> {

  }

  class Tester {

      public static void main(String[] args) {
	  // Use of arrays.
	  String[] ecode = {"E1001", "E1002", "E1003"};
	  String[] firstName = {"John", "Eric", "Michael"};
	  String[] lastName = {"Cleese", "Idle", "Palin"};

	  Employee[] employees = new Employee[3];
	  for(int i = 0; i < employees.length; i++) {
	      employees[i] = new Employee(ecode[i], firstName[i], lastName[i]);
	  }

	  for(int i = 0; i < employees.length; i++) {
	      employees[i].print();
	  }

	  // Demonstrate customers in employee.
	  Employee e = new Employee("E1001", "Ben", "Denham");
	  e.print();
	  e.createCustomer("C1001", "Datacom");
	  e.createCustomer("C1002", "Telecom");
	  e.listCustomers();

	  // Demonstrate extended Hashtable with set generics.
	  Customers test = new Customers();
	  test.put("abc", new Customer("123", "a", e));
	  Customer c = test.get("abc");
	  c.print();
      }

  }

You should extend swing controls. E.g. ``JTextField <|-- CustomerField``.

This means that you can reuse specific components.

Homework: Look up other collections in collections framework.
