# Implementation


## `VariableScope` class
- I used a map to store the variables and their values. The map is used to store the variables and their values. The key is the variable name and the value is the variable value.
- Parent scopes is used to store the parent scope of the current scope. This is used to access the variables in the parent scope. 

## `Interpreter` class
- Parses and executes the list of commands.
- 'execute' method is used to execute the commands line by line.
- The other methods are used to execute the specific commands.

## `Main` class
- Reads the input from stardard input and calls the 'Interpreter' class to execute the program.
- To exit the program, the user must type 'ctrl + d'.

## Task #2 (Requirements of Assignment)
Imagine that there is some simple programming language that allows you to assign varaibles and perform some scoped operations. In this language there are the following operations allowrd:

x = 99 (syntax: <name> = <integer value>) -- assign a variable to some integer value.
x = y (syntax: <name> = <another name>) -- assign a variable to some other variable's value.
scope { -- open a scope
} -- exit the last opened scope.
print x (syntax: print <variable name>) -- prints the variable's name on the screen or prints "null" if the variable doesn't exist.
It is allowed to re-assign existing variables (you can write x = 5, and then x = 7).
All declarations and re-assignments of the variables inside any scope (including all nested scopes) disappear after you exit the scope. For example, if you write the following program:

x = 1
print x
scope {
x = 2
print x
scope {
x = 3
y = x
print x
print y
}
print x
print y
}
print x
Then the output of the program should be:

1
2
3
3
2
null
1
Your task is to write an interpreter for such programming language (it must take a program as an input, and execute it correctly, printing all the values).