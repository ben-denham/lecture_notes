Programming precepts - 05/03/2014
=================================

Normal Distribution
-------------------

The normal distribution is a bell shaped curve.

Mean
  Centre of the bell curve.

  x̄ in sample statistics

  μ as population parameter

  x̄ = sum(x)/n

Standard deviation
  A measure of the spread. A larger standard deviation means
  the curve is spread out further.

  s in sample statistics

  σ as population parameter

  s = sqrt((sum(x[i] - x̄) ^ 2) / (n - 1)) (Not in the test)

  σ = sqrt((sum(x[i] - μ) ^ 2) / n) (Not in the test)

Sample statistics can help us estimate a value for the population.

Features of a Normal Distribution
`````````````````````````````````

* 68% of all data is within 1σ of the mean
* 95% of all data is within 2σ of the mean
* 99.7% of all data is within 3σ of the mean

Standardising Normal Distributions
``````````````````````````````````

Say we want to find the probability that a light bulb will last < 1250 hours,
where the mean lifetime is 1000, and the std_deviation is 100::

P(x < 1250) = 0.5 + P(z < 2.5)

# We add the 0.5, because that represents one half of the distribution before
# the mean, since 1250 is after the mean.

z = (X - μ) / σ
# Where x is the value we want to determine a probability related to.
# We can then look up z on a *Normal Probability* table.
