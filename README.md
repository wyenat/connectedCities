Connected cities
================

#### About

Project done by Vivien MATTER in December 2021.

#### How to run

A Makefile is provided, you can enter `make` to compile, `make clean` to remove the bin folder
 and `make doc` to . However, this project is already compiled for convenience.
Several test cases are provided with the `make test` command, you can copy its command:  
`java -Xss3000k -cp bin com.cities.CommandParser <filename> <cityname1> <cityname2>`

Here is `help` of the `com.cities.CommandParser`:
```--Cities Connected help--
Required arguments: <filename> <cityname1> <cityname2> [verbose] where:
filename: File containing the cities nodes. Please consult documentation for accepted formats.
cityname: Name of a city. Must be present in filename.
verbose: optional, set to true to print the command line.
```
#### Documentation

You will find relevant javadoc in the doc folder. The entrypoint is doc/index.html

#### Note

- For large files, you may need to extend the allocated stack size.  Just run your normal
java command with a `-Xss2048k` or `-Xss4096k` argument.
- To avoid relying on outside package and dependencies versions with different jdk, this project 
relies as little as possible on external libraries. However, I want to emphasize that using gradle, junit, ... to do
proper unit testing is important.