Matrix basics
=============

Matrix dimensions = rows x columns.

E.g. [1, 2, 3] is a "1 x 3" matrix.

Indices work the same way.

E.g. if A = [1, 2, 3], then A13 = 3 (Where 13 is a subscript).

Matrix multiplication
=====================
A = [a, b; d, e] B = [f, g; h, i]

AB = [af + bh, ag + bi; df + eh, dg + ei]

Magnitude = (rows in A) x (columns in B)

Matrix multiplication is not commutative. AB != BA

For each position in the resulting matrix, let the row position = r, and the
column position = c. Then, the value at that position is the "r"th row of A
dot-multiplied by the "c"th column of B.

AB = C

C12 = The first row of A (dot product) the second column of B.

The number of columns in A must equal the number of rows in B.

Transposition
=============

B = Transposition of A

A12 = B21

Determinant
===========

Can only be calculated for a square matrix.

Identity
========

Identity matrix (of correct magnitude) multiplied by any matrix = that matrix.

Inverse
=======

Useful to cancel a matrix:

A * (Inverse of A) = Identity matrix

ALSO COMMUTATIVE

(Inverse of A) * A = Identity matrix

Solving system of equations with inverse matrix
===============================================

4x + 2y = 7
x + y = -2

A = [4, 2; 1, 1]
B = [x; y]
C = [7; -2]

AB = C

(Inverse of A)AB = A-1C
B = (Inverse of A)C
