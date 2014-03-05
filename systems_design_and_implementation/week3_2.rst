Systems Design and Implementation - 05/03/2014
==============================================

The Counter Staff
-----------------

What will they use the system for?

* Entering orders for customers quickly and precisely.
* Registering customer accounts (taking repeat customer details) quickly.
* Receiving payment (in EFTPOS, Credit card, cash).
* Find order 
* View order details, incl. status, estimated time, customer details.
* Confirming large/special orders by phone, to confirm specific details and that
  they intended to make the special order.
* Amend orders, in the case of misunderstanding or changed mind, and
  notification of change time/status/cost.
* Amending repeat customer account details
* Manager can override pricing (in case of discount).
* Producing/accepting vouchers for orders.
* Producing complaint form for dissatisfied customers.
* Give cakes to customers, including locating completed cakes
* Manager processing refunds for dissatisfied customers efficiently

How will they use the system?
* Desktop terminal/workstation, intuitive form-based interface for managing
  orders, customers, vouchers, and payments.

  * Keyboard
  * Touch and mouse (counter staff preference)

* 
* Touchscreen/"3D space touchpad" for customer and counter staff to
  interactively build a cake from standard components as form is filled out.
* EFTPOS machine linked to computer payment system.
* (VOIP?) Phone, linked to computer so that they can click "call customer" on an
  order.
* Cash register linked to computer payment system.
* Receipt printer linked to computer payment system.

Inputs

* Customer details (name, phone, email, address)
* Order details (customer, delivery details, cake specs)
* Credit/EFTPOS card details
* Cash

Outputs

* Receipts
* Cakes
* Order/customer details (from query)
* Refunds

Tasks

* Enter an order
* Enter a new customer account
* Process payment for an order
* Print receipt
* Build a cake from stock standard components
* Amend order
* Amend customer account
* Confirm order
* Give cake
* Produce voucher
* Produce complaint form
* (Manager) Process refund
* (Manager) apply discount

What is the easiest way for them to interact with the system

* Interactive touch/air cake creator, with touchscreen+keyboard+mouse for other
  order/customer/etc. management tasks. Additional peripherals for payment
  processing will be required.
