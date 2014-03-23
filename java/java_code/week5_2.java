import java.util.*;

abstract class Employee {

    private Customers customers;

    public Customers getCustomers() {
	return customers;
    }

    public void setCustomers(Customers customers) {
	this.customers = customers;
    }

}

class SalesPerson extends Employee {

    public SalesPerson(Customers customers) {
	setCustomers(customers);
    }

}
class OtherStaff extends Employee {}

class Customers extends Hashtable {}
abstract class Customer {}
class CashCustomer extends Customer {}
class CreditCustomer extends Customer {}

class Tester {

    public static void main(String[] args) {

    }

}
