Programming precepts - 12/03/2014
=================================

Practice Test notes.

1. (8, 4, 7, 6, 3, 9, 6) mean = 6.1 std_dev = 2.1 (AVERAGE and STDEV.S)
2. AE78 = 44664 (HEX2DEC, or
   mathsisfun.com/binary-decimal-hexadecimal-converter.html)
3. CSS color codes use hexadecimal numbers.
4. population matters, not sample
5. BUEDMAS = Division and multiplication from left to right come after exponents
6. Subtraction, when the values are very similar. E.g. when the difference is so
   minor that the number format (e.g. IEEE 32-bit floating point) cannot store
   that level of detail.


   Times subtraction can be bad::

       10000000
     - 0.000001

     1.00000000 * 2 ^ 7
     1.00000000 * 2 ^ -5
     --------------------
     1.11111111111 * 2 ^ 6

7. Mean and standard deviation for a normal distribution.
8. 3 * 2 + 4 / 2 != 5 (Should be 8)
9. 37.65 = 100101.10100110011001100110011001100110
10. 1.001100 * 2 ^ -5 (IEEE mantissa = 001100 characteristic = -5 = 127 - 5 = 122)
    Use decimal for characteristic, not binary.
11. x = 72.5, mean = 71.2, std_dev = 1.1, z = (x - mean) / std_dev = 1.182
12. 68% of the population is between -1 and 1 std deviations of the mean in a
    normal distribution.
13. 1011001110010.11010010011 = 1672.D26
14. Light bulb sample; 95% confidence of mean 5746 hours to 5813 hours.

    There is a 95% probability that the mean lifetime of the entire population
    of lightbulbs is between 5746 hours and 5813 hours.

    Statistically, 19/20 times we will be correct in stating that the mean of
    the population is between 5746 hours and 5813 hours, and 1/20 times the mean
    will fall outside that interval.
15. z = 1.875, proportion of the population between this value and the mean is:
    0.4697
16. In 9.3 * 10^7, 9.3 = mantissa
17. 11 - 4
    convert 11 and 4 to binary, with the same number of bits (pad out the
    shorter if the number of bits is not the same)
    get two's complement of 4 (flip the bit's (logical NOT, get's ones'
    complement), and add 1)
    add binary of 11 and two's complement of 4
    Drop the most significant bit / carry bit (left-most bit)
18. random sample's are best.
19. 101101 = 1.01101 * 2 ^ 5
20. sample size = 20; mean = 148; std dev = 5...
    150
