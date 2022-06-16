/*
    This is an implementation of the Prime Numbers KATA 
    Date: 06/16/2022
    By: Rafat Khandaker
*/

let PrimeNumbersKata = {
    // generate array of prime numbers as a cache
    primeNumberArrayCache : [] = [],

    /* This function will check if an input number is prime by 
        Iterating from 2 to input number. When a successful divisor 
        is found with no remainder then we know that there exists a number
        between 1 & the number input that can divide into the input. By definition
        Prime numbers are numbers that can only divide by one and itself

        This function runs on  O(N) time where N is the size of the number input
        This function takes a time complexit of O(1) -- no additional space is created
    */
    CheckNumberIsPrime: function( number ){
        if(number < 2) return false;
        for(let i = 2; i < number; i++ ) 
            if( number % i == 0 ) return false; 
        
        return true;
    },

    /* In this function we will optimize the  function above to achieve an optimized complexity
       roughly with a time complexity of (N/2 +1) Which is still O(N) and Space Complexity O(1)
    */
    PrimeCheckReductionByHalf: function( number ){
        if(number < 2) return false; else if( number == 2) return true;

        let i = 2;   // start at increment 2 (The first prime factor)

        // if statement condition will check if number is divisible by 2 then post-increment to 3
        if( number % i == 0 ) return false;  

        i++;  // increment to 3

        // starting at 3 and checking all values of increments that are not divisible by two 
        while( i < number ){
            if( number % i == 0 ) return false;  
            i += 2; 
            continue;
        };

        return true;
    },


    // Function will check if number input contains any existing prime factors
    isMultiplesOfExistingPrimeNumbers: function( number ){ 
        return (PrimeNumbersKata.primeNumberArrayCache.filter( x=> ( number % x == 0) ).length > 0);
    },


   /* Using the above 2 functions, if we were to find all the prime numbers between 1 & number,
       We will start to see a performance Degragation. All numbers between 1 & number will recursively check
       to see if the input is indeed prime or not. By methodology we will Achieve a Time complexity of O(N^2).

       But let's say we can optimize the search problem by trading Time complexity for Space Complexity:
       within a Time Complexity of O(N*Log N) and  Space Complexity of O(Log N) By Using a Cache of previous prime numbers
    
        Justification: We can say the relative number of prime factors greatly diminish by a factor of log N as the number we check
        increases exponentially, in such a way, that we no longer follow a linear pattern. Checking all prime numbers betweens 0 to 100 does not increase
        linearly as we check numbers from 0 to 1000, 0 to 10,0000 & 0-1,000,000,000. 

        So by lemma, if for every number between 1 & N, we check for GCD of an existing prime factor. We can say that the number
        of prime factors for larger numbers diminish by a logarithmic scale resulting in a time complexity of  ((N/2+1) * Log N) =>  O(N*Log N).
        We can say that it will take a O(Log N) space to contain a list of previous prime numbers as the list of prime factors grow.
     */

    Generate_All_Prime_Within_Number_By_PrimeFactorization: function( number ){
        PrimeNumbersKata.primeNumberArrayCache = [];

        let i = 2;   // start at increment 2 (The first prime factor)
        PrimeNumbersKata.primeNumberArrayCache.push(i++);     
        // if statement condition will check if number is divisible by 2 then post-increment to 3
        while( i < number ){
            if( !PrimeNumbersKata.isMultiplesOfExistingPrimeNumbers(i) ) {PrimeNumbersKata.primeNumberArrayCache.push(i);   };  
            i += 2;
            continue;

        };

        return this;
    },

    printPrimeNumberCacheSize: function(){ console.log( "Number of Prime Factors : " +PrimeNumbersKata.primeNumberArrayCache.length); return this; },

    printPrimeNumbersCache: function(){ PrimeNumbersKata.primeNumberArrayCache.forEach(x=>{ console.log(x); }); return this; }
    

}


function PrimeNumbersKataTest( maxInput, shouldPrint, runTests ){
    var countPrime = 0;
    console.log("____________________________________________________________");
    console.log(`For Input: ${maxInput} : Check all prime numbers between 0 & ${maxInput}`);
    console.log("____________________________________________________________");

    // Test 1 : checkNumberIsPrime
    if(runTests.includes(1)){
        countPrime = 0;
        console.log("---------------------------------------------- ");
        console.log("checkNumberIsPrime in O(N) Time");
        console.log("---------------------------------------------- ");

        for( let i=0; i <= maxInput; i++ ){
            isPrime = PrimeNumbersKata.CheckNumberIsPrime(i);
            isPrime ? countPrime++ : countPrime;
            shouldPrint? console.log( i +"=> isPrime? == "+isPrime) : null;
        }
        console.log("");
        console.log(`number of prime numbers: ${countPrime} \n\n`);
        console.log("");
        console.log("");

    }

    // Test 2 : PrimeCheckReductionByHalf
    if(runTests.includes(2)){
        countPrime = 0;
        console.log("--------------------------------------------------------------- ");
        console.log("PrimeCheckReductionByHalf in about (N/2 + 1) Time");
        console.log("-------------------------------------------------------------- ");

        for( let i=0; i <= maxInput; i++ ){
            isPrime = PrimeNumbersKata.PrimeCheckReductionByHalf(i);
            isPrime ? countPrime++ : countPrime;
            shouldPrint? console.log( i +"=> isPrime? == "+isPrime ) : null;
        }
        console.log("");
        console.log(` number of prime numbers: ${countPrime}`);
        console.log("");
        console.log("");

    }
   
    // Test 3 : Generate_All_Prime_Within_Number_By_PrimeFactorization
    if(runTests.includes(3)){
        console.log("---------------------------------------------------------------------------------------------------------------------------------------- ");
        console.log("Generate_All_Prime_Within_Number_By_PrimeFactorization in about ((N/2+1) * Log N) => O(N* Log N) Time Complex & O(Log N) Space Complex");
        console.log("---------------------------------------------------------------------------------------------------------------------------------------- ");

        shouldPrint? 
            PrimeNumbersKata
                .Generate_All_Prime_Within_Number_By_PrimeFactorization(maxInput)
                    .printPrimeNumberCacheSize()
                        .printPrimeNumbersCache()
                :
            PrimeNumbersKata
                .Generate_All_Prime_Within_Number_By_PrimeFactorization(maxInput)
                    .printPrimeNumberCacheSize();

    }

       
}


PrimeNumbersKataTest( 10, true, [1,2,3] );
PrimeNumbersKataTest( 100, true, [1,2,3]);
//PrimeNumbersKataTest( 1000, false, [1,2,3] );
//PrimeNumbersKataTest( 10000, false, [1,2,3] );
//PrimeNumbersKataTest( 100000, false, [1,2,3] );
//PrimeNumbersKataTest( 1000000, false, [1,2,3] );
