AND = ∧ = conjuction
OR = ∨ = disjunction
NOT = ~ = negation

AND and OR are binary operations (2 operators), but NOT is a unary operation (1
operator)

Each Truth table will have 4 rows for 2 inputs (2^2 permutations for 2 
combinations of boolean values).

When writing it, in the first column, the first half of the rows should be true,
the second half should be false. Each subdivision should be halved in this
manner.

*Implication* = If p then q = p -> q
  If p is TRUE, then q should also be TRUE. If p is FALSE, q could be anything.
*Converse* = If q then p = q -> q
  Implication with arguments swapped around. Q implies P, not P implies Q.
*Equivalience* = p if and only if q = p <-> q
  p should only be true of q is true.
  Basically checks that they are the same boolean value.

Precedence:
(), !, DMAS, (> >= < <=), (== !=), AND, OR, =
