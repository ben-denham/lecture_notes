Python 3.3.4 (v3.3.4:7ff62415e426, Feb 10 2014, 18:13:51) [MSC v.1600 64 bit (AMD64)] on win32
Type "copyright", "credits" or "license()" for more information.
>>> 27*3
81
>>> 2 ** 4
16
>>> (1/3) ** 1 * (2/3) ** 3
0.0987654320987654
>>> def combination(set_size, count):
	
KeyboardInterrupt
>>> def factorial(n):
	if (n <= 1):
		return 1
	return n* factorial(n-1)

>>> factorial(n)
Traceback (most recent call last):
  File "<pyshell#9>", line 1, in <module>
    factorial(n)
NameError: name 'n' is not defined
>>> factorial(5)
120
>>> def combination(set_size, count):
	return factorial(set_size) / (factorial(count) * factorial(set_size - count))

>>> combination(4, 4)
1.0
>>> def binomial_probability(num_trials, num_success, success_probability):
	return combination(num_trials, num_success) * (success_probability ** num_success) * ((1 - success_probability) ** (num_trials - num_success))

>>> binomial_probability(10, 6, 0.4)
0.11147673600000005
>>> binomial_probability(8, 6, 0.6) + binomial_probability(8, 6, 0.6) + binomial_probability(8, 6, 0.6)
0.6270566399999999
>>> binomial_probability(10, 8, 0.6) + binomial_probability(10, 9, 0.6) + binomial_probability(10, 10, 0.6)
0.16728975359999995
>>> binomial_probability(10, 8, 0.4) + binomial_probability(10, 9, 0.4) + binomial_probability(10, 10, 0.4)
0.012294553600000004
>>> 
