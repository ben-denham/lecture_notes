Programming precepts - 26/02/2014
=================================

Binary
------

0b 101.01 = 1 * 2^2 + 0 * 2^1 + 1 * 2^0 + 0 * 2^(-1) + 1 * 2^(-2)

Base conversion in JS
---------------------

parseInt('F', 16) == 15
(15).toString(16) == 'f'

Two's Complement
----------------

Two's complement of x = (!x) + 1 (Working with a certain number of place
values).

Modulo of negative numbers
--------------------------

Modulo is always positive.

Modulo counts in the same direction on the number line.

E.g.

+---------+--+--+--+--+--+--+--+--+--+--+--+--+
|    N    |-5|-4|-3|-2|-1| 0| 1| 2| 3| 4| 5| 6|
+---------+--+--+--+--+--+--+--+--+--+--+--+--+
| N mod 4 | 3| 0| 1| 2| 3| 0| 1| 2| 3| 0| 1| 2|
+---------+--+--+--+--+--+--+--+--+--+--+--+--+

Scientific Notation
-------------------

5.34 * 10^7

Mantissa = 5.34
Base = 10
Exponenet = 7

Normalised Exponential Format
-----------------------------

0b10111.011 = 1.0111011 * 2^4

Mantissa = 1.0111011
Base = 2
Exponenet = 4
