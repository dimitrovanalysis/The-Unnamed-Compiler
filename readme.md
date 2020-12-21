# Unnamed programming language
### Compile Source
run `build_grammar.sh`
make sure your CLASSPATH environment variable is set up right to compile grammar

compile `src/` to `bin/production/compiler-unnamed`

---
### Compile File from Example
run `build.sh [optional program name of examples]`

current examples are: ```FizzBuzz, print, functions, errors, immutability, ternary```

### Compile File from Example in steps
```
./compile.sh [optional path to file.unnamed]
./assemble.sh [optional path to file.j]
```

### Run
`run.sh [optional program name] [optional path to .class file directory (default is output/jasmin/bin)]`

---
### Generate Tree
run `build_tree.sh [optional filepath]`
##### Required Components
- imagemagick (convert PostScript to png)

---
### TODO
##### Grammar
- [x] Ternary operator
- [x] Constants
- [x] Custom Type definitions
- [x] Functions
    - [x] Function Calls
    - [x] Function Declaration
##### Intermediate Code
- [x] Predefined char
- [x] Predefined long
- [x] Predefined double
##### Backend
- [x] Import files
- [x] Function declaration
- [x] If statements
- [x] Loop statement
    - [x] loop while() {}
- [x] Predefined function calls
    - [x] write/writeln
    - [x] read
- [x] Function calls
    - [x] Pass1
    - [x] Pass2
- [x] Error Messages
