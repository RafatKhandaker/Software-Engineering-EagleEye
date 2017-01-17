#ASSEMBLY

---------------------ASSEMBLY LANGUAGE------------------

Notes By Rafat K
source: Hitesh Kumar

Requirements: Linux or Windows Computer

Boolean Algebra
The Computer
The NASM assembler
Structure of a program
Macros
Boolean Operations
Functions
Aggregates
Floating point numbers
Related Stuff


	| Reasons for Assembly |

perform 8 bit ac register with bit value operation 
add with 37 :  

00100100  00100101

dec: 36 37

hex: 24 25

AND AC,37

^   ^   --> AND and AC are called mnemonics
( it is easier to catch errors in assemblers with words
but for binary operations, the machine code will just 
execute what is written )

mnemonics -> words for bit patterns.

higher level languages : (Cobal and Fortran)

C Language is used for Assembly language. 

Assembly language will make better programmers for C, C++ & Java
(knowing internals of the programming)

__________________Make Better Programmers___________________________

Learn how computers work
Faster and Smaller code
Direct Hardware Access
Learn What Compilers Do

   | Opposite of Portable |

a = b + c;

ADD CX, SI    --> registry named CX & SI
                   pre existing hardware will make no sense 
                   Does not port to another machine.

JAVA is a portable language (JVM) has it's own bytecode.

UNIX, entire operating system was written in Assembly at 
first, then entirelanguage was rewritten in C, except for some 
portions kept within Assembly.


    |ASSEMBLER|

NASM --> Windows & Linux
32 bit model * Code can be written in more than one mode for intel 
processors. However, almost all programs today will run in flat 32 
bit address space

16 bit memory --> bizarre structure 

64 bit system  * special cases --> technique is the same but slightly
different structure.

Technique is the same for alien architectures.. all assembly language 
will be similar.

Step By Step Execution

You store programs into a location and have it do operations you wish.

4 places data can be addressed :  
in Memory , Register (CPU location), 
Immediate (inside of instructions)
   -ex: 
   		somewhere in memory y is created, copy a value of Y into 
   		register two copies exist for y. 

        Add 5 to register

        Copy the register to Y back into memory

   Step By Step Execution 
   
        Copy Data (instructions to copy data)
        Arithmetic (add & or values to shift bits)
        Test bits  (flag bits to test operation)
        Branch  (Storing or return adddress)
        Input & Output  (External interrupts)   

   | Hexadecimal / Octal / Binary |

0  0000  0
1  0001  1       10110110  -> B6
2  0010  2
3  0011  3
4  0100  4
5  0101  5
6  0110  6
7  0111  7
8  1000  8
9  1001  9
10 1010  A
11 1011  B
12 1100  C
13 1101  D
14 1110  E
15 1111  F

 hex: 3c4
 dec: (3 * 256) + (12 * 16) + 4 = 964

 convert dec to hex:  964/256 = 3 with remainder of 196  256 = 16^2
                      196/16  = 12  with remainder of 4   16 = 16^1
                      4/1 = 4 = 4   

                 (3) (12) (4)
            hex:    3c4    

  |Boolean Operations|

150
11110

shift left * 2  .. shift right  /2 

__Binary Boolean operator__

0 = false
1 = true

__Tens Compliment__

subtraction is done through compliment

1000 - 741 = 259 

use compliments:

000741, subtract 9 from each digit gives us 9's compliment

999258   , then add 1 , gives us 10's compliment

999249   , then add to 1000

001000 + 999259 = 1000259  < like parity bit.. throw away the 
space that exceeds 6 digits..  

Hardware logic:  AND operators.. comparing two bits.


__Binary__

subtract:
01100100   (100)
00011001   (25)

1's compliment change 1s to 0s and 0s to ones

(25) 00011001  --> 11100110

2's compliment by adding 1

11100111

add  :  01100100
      + 11100111
      _____________
        101001011

      ommit -> (1) 01001011  (75)  


       | Integers (Negative and positive) |

like parity bit, leading bit determines sign of number
if lead bit is 1, number is negative

if leading bit is 0 , number is positive

shifting right extends the sign
shifting left can change the sign

compliment reverses the sign

    | Memory and the CPU |

Random Access Memory (RAM)

	address      
    
32 bit computer

can address up to :  4,294,967,295 bits

that is why 32 bit computers can only support a maximum
of 4 GB of RAM.

   |Memory and the CPU|

Whole Register is 32 bits in size
(Can be addressed as a whole) or within 16 bits
                   | 16 bits  |

whole 32bit is known as:
 ESI                 16 bit is known as : SI
 EDI                 DI
 EBP                 BP
 ESP                 SP

E--> added or Extended . reference to 32 bits

            | 8bit | | 8bit |
---- left of  03 01 Memory & the CPU --- 3min in
