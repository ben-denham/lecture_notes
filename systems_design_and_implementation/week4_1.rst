Systems Design and Implementation - 10/03/2014
==============================================

How they will use the system?
  What device will they use

What is the easiest way for them to interact with the system?
  
Steps in design

* The principle of user profiling
* The principle of metaphor - borrow behaviours from similar systems, and the
  real world.
* The principle of feature exposure - Let the user clearly see what features
  are available.
* The principle of coherence - same interface components should always mean the
  same thing.
* The principle of state visualization - Each behaviour should be reflected in
  the appearance of the program. E.g. A button press should have an animation 
  to show that the button was pressed
* The principle of shortcuts.
* The principle of focus - understand where the human eye likes to look.
  Hotpoint = centre of screen.
* The principle of grammar - Always use a subject and a verb: action->object
  when describing button labels for example.
* The principle of help
* The principle of safety - Don't let the user make catastrophic mistake.
* The principle of context - Context sensitive design
* The principle of aesthetics - make it look appelaing
* The principle of user testing - make sure users like the interface

Exam questions will come with usability requirements.

Interaction Design - Counter Staff
----------------------------------

What are the user's goals:

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
* Give cakes to customers, including locating completed cakes
* Manager processing refunds for dissatisfied customers efficiently

Overarching goal: Order and customer management.

  Login with employee id * functional

User's skills and experiences:

* Very basic IT knowledge - use software
* Customer interaction - people skills
* Use a till/EFTPOS
* Understanding of cakes provided

User's needs:

CRUD = Create, Read, Update, Delete

* CRUD Orders forms
* CRUD Customers forms
* Get customer from order, get orders from customer
* View customer and orders at the same time
* Start with login, so permissions are recognised
* EFTPOS/Till to charge customers with
* Receipt/invoice printer
* Go to payment form an order
* Notification of new "special orders" placed online
* Ability to call customer quickly

Understand the interaction

* Login - fingerprint scanner / access code fallback
* Open the new order form
  * Fill in details about order
    * Date
    * Delivery details
    * Cakes
      * Interactive cake designer
      * Give helpful suggestions
    * Customer
      * Search for existing customer by name/phone/email
      * Open a new form for a new customer
  * Confirmation page
* Find order with search
  * View order
    * View customer
    * Amend order
    * Add payment to order
      * New payment form
      * Automatically trigger devices (Till/EFTPOS/Receipt printer)
* Find customer with search
  * View customer
    * Call customer automatically
    * Amend customer
    * View list of orders
      * View order
* Popup when a new "special" order is made online, click through to view order
