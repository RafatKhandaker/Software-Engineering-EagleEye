# Software-Engineering-OverView

        Rafat's Software Engineering Notes:

                           PROGRAMMING INTRODUCTION:

-The first computer used vaccuum tubes. manually changed by hand, in order to store bits & data information.
<-- Process is long and tedious. 

-Punch cards were introduced to store source code, in order to run onto the main computer. 
The process of creating punch-cards & management was tedious.

-A terminal was introduced to execute code onto a computer in simple text format.

			         BYTE BY BYTE

(The most basic instruction in order to run code is to use a text editor and write each binary 
 into Hex command to be executed by the processor using 
-> address of the pin and the hex code you want to compile.  
<-- highly, impractical)

			        ASSEMBLY LANGUAGE

(Solution is to use an Assembly language, which is a more humanely readable language to write code, other 
than to write each process byte by byte.)
	
	{
		ex: section .text

			global main          ; Assembly code written to display hello world

			main: 
				mov eax, 4
				mov ebx, 1
				mov ecx, msg
				mov edx, 1en
				int 0x80

				mov eax, 1
				mov ebx, 0
				int 0x80

		section .data
				
				msg db   "Hello, world!", 0xa
				len equ   $ msg						 

	}	
			
There are different ASSEMBLY Language for different processors, 
collectively they are reffered as ASSEMBLY LANGUAGE.  

Ex: microsoft uses source code written in:   [ .asm  ]

<- A language written into text is known as a source code, this source code needs to be compiled 
into machine code by a programm called, an assembler ( byte by byte, before these instructions can 
be read into the processor)			


An assembler converts a source file into an object file before it can be executable:

                assembler                   linker
hello.asm (source)  --> hello.o (Object file) --> hello (executable)

          assembler    linker
	  
foo.asm -> foo.o  
                    -->     baz
bar.asm -> bar.o 

(This process minimize work when making code changes by executing source code into different threads, 
within the process)                 


	Dynamic Linking:  (linking during execution)

		.so  (linux)
		.dll ( windows)

shared libraries. 

--> creating a shared library files allow programs to execute different threads 
from the same library at runtime. Dynamically Saving memory rather than to program a link into each 
sourcecode. Static linking can produce large executable files and memory usage, loading large amount 
of memory into process.

 ASSEMBLY LANGUAGE --> Low-Level programming : 
                               --ratio of source code to  instruction to : 1:1
                      (precise control & efficiency - programming byte by byte.)

 		 high-level :  
  -- ratio of source code to instruction  1 to many
     (expressiveness & portability)

[ allows you to execute more work per line of code, for ease and convenience, but takes away precision 
and control. High level language, allows execution of multiple processors or OS or Platforms. rather 
than rewriting instructions for different processors or OS or platforms]

            What is a Compiler? :

 The Conversion of high level programming language to low level programming language is done through 
 a process called convulation, through a programm called a compiler.					   

      REASONS FOR COMBINING C with ASSEMBLY -> Efficiency plus optimization:

 Most modern OS systems are written in high level programming languages but some portions are written 
 in Assembly for optimization.


 		          C CODE
           
	        compiler
 	bar.c    -->	    bar.o  (object file generated from c code)		

 	Interpreter: interpreters will convert source code into action

 	          Compiler VS Interpreter:

 	  Interpreter converts one language to another (interprets)
 	  Compiler converts source to machine

 	  An interpreter will execute without an executable file, instead will
	  simply run through the interpreter, reading set of instructions.

 	  all code running simultaneously through an interpreter will allow the
	  interpreter to shape how to handle the instructions of the code:


 	  foo 

		(Interpreter) --->   (Action)
 	  
	  bar


SOURCE CODE :  introduce code reading, line by line. 
               storing variables into memory.
               introduce control flow, using if , else statements.
               functions.



               			      JAVA

 Another way to use code is to run compilers and Interpretation together. 
 Java does this through a virtual machine:
 
              Compiler               virtual machine
  hello.java    -->    hello.class         -->      (ACTION)
  (source)             (bytecode) 		

  bytecode: intermediate code  <--

  ( java introduces bytecode to be run and executed by an interpreter, which java calls: a virtual
  machine) 	      
      
        - bytecode looks like machine code, however, bytecode cannot be interpreted by any actual 
	processor. Instead, it uses an interpreter to read and execute the instructions line by line. 

  Compile code typically runs faster than interpreted code because interpreters need to parse the 
  source code. On one hand, Compilers are under tight pressure to run the executable, while interpreted 
  code has all the time it needs to run each instruction line by line.      

          - Java's Hybrid approach uses the advantages of convulation and interpretation to optimize
	          a set of instructions and allowing it to run across different platforms.

    VM with JIT (Just-in-time) --> implementation into a virtual machine to interpret what set of machine 
    instructions to run and execute most of the code instead of interpreting each line.      



    				ADDRESS SPACE OF PROCESS:

   |
   |
   |
   |
   |                 TEXT (Code)    ( Stores code of process)
   |                                 ( Generally, Read Only)
   |                                  
   | 				

Programm      Call Stack            ( Continous stack of chain of function calls)
 Memory    (local variables)   

   |
   |
   |
   |
   |                    HEAP           ( rest of the address space)
   |               (Everything Else)   (programmer must explicitely request from |										the Operating system, each chain of 											memory so OS system can 												efficiently use memory spaces)
   |
   |
   | 

                             JAVASCRIPT & PYTHON

     Automatic memory management --> garbage collection.  
     ( the programmer can create as many objects as they like and the interpreter will handle 
     memory usage as needed, interpreter will also keep track of objects that are no longer reachable 
     and give back to the OS system, heap space that are no longer needed. )      

                                 Memory Leak:

        ( A bug in which a the program allocates a chunk of heap memory but neglects to give the chunk 
	back to the OS when it's no longer needed. Especially for long running processes, which need more 
	and more heap as it is running.)                                      

         -> difficult bugs to track down. Can go undetected for months and years.
            leaks from one part of code looks same for all parts of code.

            javascript -> assign memory into array , store into local variable and forget about them.

            injecting automatic memory management into c language will create too much overhead and take 
	    away precision to control heap space, defeating the purpose of using the C language.


Types of Mistakes:

       dynamic typing:  - the types of variables, parameters and functions are  
                           not declared.
                        - the types of operands are checked at runtime when an operation is invoked
                        - can throw exception for mistakes.
                        (JavaScript, Pidgin)

      static typing:    - the types of variables. parameters and 	
      					  functions are declared.
      					- the types of operands, arguments and assigned values are 
					checked before execution.
      					- compiler will detect errors before running the code.                   
      					( Rules of operations, independant objects, parameters and return 
					functions.) (C & Java)


Polymorphism: 
      
   ( accepts varied number and/or types of inputs)  int, String, boolean )
   ( change separate function types determined by the type of input within the function)


       weak typing: - allows the programmer to manipulate bytes of data in any
       				  arbitrary way desired.

       				  (assembly language, modify data without appropriate to it's type, 
				  can produce garbage.)

       strong typing  - allows the programmer to manipulate a piece of data only
       					with operations defined for that data's type.

       					(only allows perform operations to datatypes to it's sensible type)

Paradigms:

	imperative:  (do modify state) -> needs to compute and transmit to console  
	                                  or display, or transmit network.

	functional:    ( don't modify state )  -> prohibits, talking outside it's box
	                                           makes easier to manipulate code.
         (X)

	procedural: (action-centered design)  --> programmer thinks about what   											functions they need before entering 										datatype.

	object-oriented: (data-centered design)  -> programmer thinks about what 												datatypes can be used before 												creating a functional code.


							LEARNING A PROGRAMMING LANGUAGE

			1. Syntax.   -> writing text
			2. Semantics. -> meaning behind text
			3. Libraries. -> body of pre-existing code for common functionality
			4. Tools. -> 
							(compiler, linker, interpreter, text editor, 
							debugger
							profiler ( optimize code), version control 
							(repos github), IDE (integrated developer 
							environment) full functionality )
    
 C Language:  

		- Created in 1970s
		- Static, weak, and compiled to machine code.
		- low-level control, efficiency.

		#include <stdio.h>

		int main()
		{
			printf("Hello, world!\n");
			return 0;
		}	

   code writtin in c can link with code written in assembly with little over-head. C is a high 
   level language, compared to assembly. Linux Kernel is mostly written in C.

 C++ Language: 

   ( C language w/ more overhead and features for Object oriented programming)

   		- created in 1980s
   		- (almost) superset of C
   		- C with features.
   		- C++ compiler can run C code.. large overlaps between C and C++ but not entirely 
		true. Developed on their own, over the years.

   		#include <iostream>

   		int main()
   		{
   			std::cout << "Hello, World!\n";
   			return 0;
   		}

   		C++  joke... increment C . 

 JAVA Language:

   		- Created in 1990s by Sun Microsystems
   		- Object-Oriented
   		- C - Style Syntax
   		- Mix of Static and Dynamic Typing
   		- Compiled to bytecode, run by VM
   		- JVM (Java Virtual Machine)

   	public class HelloWorld{

   		public static void main(String[] args) {

   			System.out.println("Hello World");
   		}
   	}	

C# Language:
	- created in 2001 by microsoft
	- object-oriented
	- C -style syntax
	- mix of static and dynamic typing
	- compiles to bytecode, run by VM
	- CLR(Common Language Runtime)

	using System;

	class ExampleClass
	{
		static void Main()
		{
			Console.WriteLine("Hello, world!");
		}
	}

Perl
	- created 1990s
	- dynamic   
	- interpreted	
	- (semi-) object-oriented

	print"Hello, world!\n";

	*expressive, can get more work done per line of code.

	often difficult to read 

	Slow dynamic language to compile.  
	as computers upgraded through time, the cost of running dynamic languages was enhanced 
	and insignificant.

Python
	- created in 1990s
	- dynamic
	- object-oriented
	- indentation-sensitive

	print("Hello, world!\n")

	Clean and simple syntax.

Ruby
	- created in 1990's
	- dynamic
	- interpreted
	- object-oriented

	puts"Hello, world!\n"

	(like perl, too many misguided convolutions )

PHP
	- created in 1990s
	- dynamic
	- interpreted
	- (semi-) object-oriented
	- mostly used in web programming

	<?php
		Print"Hello, World!";
	?>

	- easiest learning curve.


Javascript
	- created in 1990s
	- dynamic
	- interpreted
	- C-style syntax
	- object-oriented(via prototypes)
	- interpreter embedded	

	alert("Hello, world!\n");

Efficiency

	Programmer Control
	OverHead: interpretation, automatic memory
	management, dynamic typing.

	Dynamic languages which implements ease of programming structure; 
	require more over-head, dynamic typing and automatic memory management, usually compile slower.

	Static Languages compiles faster.

	Performance

	1. Assembly, C, C++, Object-C   (Compiler Languages)    }       (Garbage Collection)
	2. Java, C#    (Hybrid Languages)                       }
	3. Perl, Python, Ruby, PHP, Javascript   (Interpreter Languages) }   (automation)

  Over Head + Compile time --> Efficiency:

  "a 12 hour plane ride.. doesnt add much time difference if you walk 40 min or take a 15 min cab."

Portability

	CPU instruction sets
	System Calls
	Capabilities
	Libraries

	processors: x86, arm  different, System calls depend on CPU, Capable uses different Libraries.

	Library Code: make right calls, to run on different operating systems and processors.

	if target platform has no programming device , (OS ) there is no program that can program
	the device.

	Windows filesystem similar to Unix but differs in logging capabilities
	-> programs avoid areas where there is no overlap.


	FUNCTIONAL LANGUAGES:
	(Scheme, Haskell, Scala, ML)

	LOGIC LANGUAGES:
	(Prolog)   -> only logic programming language & never used outside of Acadameia

	SHELL LANGUAGES:
	(cmd (batch),bash, zsh, ksh, sh)   --> running commands on shell. 
	(general purpose use)

         -Script... given directions but hard work is done by programs.

     SCRIPTING LANGUAGES:(Perl, Python) --> but used more and more for 													development.
     DATA LANGUAGES: (HTML , XML) --> not used for programming but are formats 									used by libraries.

     QUERY LANGUAGES: (SQL)  --> Database language for storing data

     DOMAIN-SPECIFIC LANGUAGES:  solve one specific problem in one domain.

     GRAPHICAL LANGUAGE --> Not text but graphic.  GUI BUILDERS 
     (Data languages for domain specific  --> 
     advantages does not outway potential errors) 							

