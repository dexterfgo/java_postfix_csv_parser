# evaluatePostFix

A litte java app that reads from a CSV file and does a postfix operation on each (comma-separated) postfix expressions (if valid)

## Description

### Structure

1. EvaluatePostfix()

- Takes as input a string with a postfix expression
- Returns the evaluated result (in float) if the input is correct.
- If the result cannot be evaluated, it SHOULD return #ERR. (Not implemented)
- Stack pushes each operand as they are read from the string (spaces ignored).
- If no operators are read, it should return #ERR. (Not implemented).


2. main()

- Reads the CSV file as input.
- Converts the file into a matrix (2-dimensional array) of strings.
- Writes a CSV output file of the evaluated results. (Not implemented)
- References other cells using LETTER,NUMBER notation. (Not implemented)

### Limitations

1. As the calculations are done in float, most will not be able to flag invalid results as #ERR. Zero divisions currently evaluate to infinity and letter inputs evaluate to zero.

2. Left some functionalities not implemented - I ran out of time. :(

3. A better way to do this is by recursion but by the time I realized that, I also ran out of time. :(

4. I had to patch the solution for whether the function could handle a single operand with no operator. That could have been addressed by #3.