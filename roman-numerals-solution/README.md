Hi,


## Implementation plan

* Create java main class with ability to read input from cmd pipe
* Implement convert algorithm
* Catch all possible exceptions
* Make some refac/add test/finally review

## User guide

1. Compile java source file:

	G:>javac RomanNumeralsConvert.java

2. Run java application with cmd pipe:

	G:>echo "1 12 103" | java RomanNumeralsConvert
	I
	XII
	CIII

3. Add "-test" flag to run application in test mode:

	G:>echo "1 12 103" | java RomanNumeralsConvert -test
	1 => I passed.
	12 => XII passed.
	103 => CIII passed.
	10char3 => 10char3, illegal argument error - is not valid digital number. passed.
	10399911 => 10399911, range bound error - number should be in the range [1 - 3999]. passed.