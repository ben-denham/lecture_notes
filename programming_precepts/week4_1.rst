===================================
 Programming Precepts - 10/03/2014
===================================

Confidence Intervals
====================

The mean of the population (μ) does not equal the mean of the sample (x̄).

But, there is a good chance they are close together. The larger our sample,
the more sure that they are closer together.

The mean of the sample can be used as an estimate of the mean of the population.

How close is called the confidence interval.

Standard error is the standard deviation of the means from all samples, but
there is a shortcut formula::

  standard error = s / sqrt(n)

Emperical rule
  68% of the population is within 1 standard deviation of the mean.

* 68% of all data is within 1σ of the mean
* 95% of all data is within 2σ of the mean
* 99.7% of all data is within 3σ of the mean

We can therefore say, that 68% of the sample means, are within 1 standard error
of our sample's mean.

E.g.

* Sample size 100
* Mean = 0
* Std Deviation = 10
* Std Error = 1
* Therefore, there is a 68% probability that the true population mean is 0 plus
  or minus 1. i.e. 

Confidence interval = sample mean +- z * (s / sqrt(n))

* z = 1.96 for 95% confidence interval.
* z = 2.58 for 95% confidence interval.

The number after the +- is called the **margin of error**
