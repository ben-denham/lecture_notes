Abstraction
===========

* Abstract & implemented methods.
* No objects, oref can be created.
* Attributes could be present.
* Constructor.
* The subclass should implement the signatures.
* The subclass can override.

::


  interface Beast {
    public void bite();
  }

  abstract class Animal implements Beast {

    String name;

    public Animal() {
      name = "Brumbie";
    }

    public abstract void eat();

    public void sleep() {
      System.out.println("Animal..sleep");
    }
    public void prt() {
      System.out.println(name);
    }

  }

  class Cow extends Animal {

    public Cow() {
      name = "butterCup";
    }

    public void eat() {
      System.out.println("Cow..eat");
    }

    public void bite() {
      System.out.println("Cow..bite");
    }

  }

  class Tester {

    public static void main(String[] args) {
      Animal a = new Cow();
      a.eat();
      a.sleep();
      a.bite();
      a.prt();
    }

  }

Connecting to a database
========================

::

   Class
     +(c)forName(..)

   DriverManager
     +(c)getConnection(..):Connection

   Connection
     +createStatement():Statement

   Statement
     +executeQuery(..):ResultSet

   (i)ResultSet
     +next():boolean
     +getString(..):String
     

1. Assume a database
2. Create a DSN (DataSet Name) and note the name.
3. Assume a table (e.g. Employe(id:int, fname:String, lname:String))


Our classes::

  Employee
    +st:Statement
    +(st:Statement)
    +getEmployee(int)
    +getEmployees()
