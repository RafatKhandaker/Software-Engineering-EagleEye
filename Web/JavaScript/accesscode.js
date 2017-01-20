
var windowinnerWidth = 1002;

if(windowinnerWidth > 1000){
	console.log('The window is over 1000px')
}else{
	console.log('The window is tless than 1000px');
}

console.log("...............................................");

////////////////////////////////////////////////////////////////////////////////

var myName = "Sam"

if (myName == "Joe" || myName == "Sam") {
	console.log("My name is " + myName);
}

console.log("...............................................");

////////////////////////////////////////////////////////////////////////////////

var userAge = 12;

if(userAge >= 21){
	// userAge is 21 or higher
	console.log("Let's party tonight");
}else if( userAge >= 18){
	// User age is 18 or higher but less than 21
	console.log("Let's have a LAN party tonight");
}else{
	console.log("Let's have a sleep over");
}

console.log("...............................................");

/////////////CONDITIONALS/////////////////////////

if(parent.window.innerWidth > 1000){
	console.log("The window is over 1000px");
}else{
	console.log("The window is less than 1000px")
}

// parent window// 

var condition = function(){
	var testVal = Math.round(Math.random());
	console.log(testVal);
	if(testVal == 0){
	  return(false);
	}else{
			return(true);
	}
}; 

condition();


if(condition() == true){
	console.log("true");
	
}else{
	console.log("false");
}

console.log("...............................................");

////////////////////////////////////////////////////////////////////
var condition2 = function(){
	var testVal2 = Math.round(Math.random()*2);
	console.log(testVal2);
	if(testVal2 == 0){
	  return("Matt");
	}else if(testVal2 == 1){
			return("Steve");
	}else{
			return("Bob");
	}
	
}; 

condition2();

if(condition2() === "Matt"){
	console.log("Matt");
	
}else if(condition2() === "Steve"){
	console.log("Steve");
}else{
	console.log("Bob");
}

console.log("...............................................");

//////////////////////////////////////////////////////////////////////////
// HOW TO CALL VARIABLE WITHIN IF STATEMENT //  

var color = ["red", "blue", "green", "yellow", " teal", "purple", "violet"];

var primColor = ["red", "blue", "green"];
var randNum = Math.floor(Math.random()*color.length);
	
	console.log(randNum);

var colorRand = color[randNum];

if(colorRand === primColor[0,2]){
	console.log("This color is a primary color");
}else{
	console.log("This color is not a primary color");
}

console.log("...............................................");

///////////////////////////////////////////////////////////////////////////

var myInteger = 4;
if(myInteger % 2 === 0){
	console.log("That number is even");
}else{
	console.log("That number is odd");
}


console.log("...............................................");

////////////////////////////////////////////////////////////////

var array = []
	if(array.length != 0){
		console.log("this is not empty");
	} else {
		console.log("this array is empty");
	}
	
	
console.log("...............................................");

////////////////////////////////////////////////////////////////

var arr = [5, 4, 3, 2, 1];
var endOfArray = arr.length - 1 ;

var i = endOfArray;

for(var i = endOfArray; i >= 0; i--){
	console.log(arr[i]);
}


console.log("...............................................");

////////////////////////////////////////////////////////////////
////////////////////PRINT OUT ODD VALUES/////////////////////// ////////////////////////////////////////////////////////////

var myArray = [7, 24, 25, 9, 40, 41, 11, 60, 61];
var endOfArray = myArray.length - 1;

for( i = endOfArray; i>=0; i-- ){
	if( myArray[i]%2 !== 0 ){
		console.log(myArray[i]);
	}
		
}
console.log("...............................................");

//////////////////////////////////////////////////////////////
var myArray = [7, 24, 25, 9, 40, 41, 11, 60, 61];
var endOfArray = myArray.length - 1;

for( var i = endOfArray; i>=0; i-- ){
	if( i%2 !== 0 ){
		console.log(myArray[i]);
	}
		
}


console.log("...............................................");

////////////////////////////////////////////////////////////////////////


//////////////////////////////////////////////////////////////////////////

// Get the average of 4 / 5, multiply itby the average of 6 and 7 and divide it by the average of 78 and 89 // 

//parameters 

console.log((( 4 + 5) / 2) * (( 6 + 7) / 2) / (( 78 + 89 ) / 2) );

var avg = function(x, y){
	return (x + y) / 2; 
}


console.log(avg(4,5)*avg(6,7)/avg(78,89));

/////////////////////////////////////////////////////////

var integerSizw = 10;
	// expect array to be: [0,1,2,3,4,5,6,7,8,9]//

var arr =[];

var buildArray = function(integerSize){
	// (integerSize,Jon)//
	for (var i = 0; i < integerSize; i++){
		arr.push(i); // arr 
	//  arr.push(jon);
	}
      return arr;
}

console.log(buildArray(10));

// try with each element value being double its own index? Or triple?
//what about if all the odd indicies are double while all the even indices are quadruple?

/////////////////////////////////////////////////////////

console.log(".........................................");


var isPerfectSquare = function(arg) {
  // Some code belongs here.
  // Hint: what variable needs to be created and assigned?
  var sqrtOfArg = Math.sqrt(arg);
  
  if(Math.floor(sqrtOfArg) === sqrtOfArg) {
    // It's a perfect square!
    console.log("It's a perfect square!");
  
  	
  } else {
    // It's not
    console.log("It's not a perfect square!");
  }
}

isPerfectSquare(9); // returns true
isPerfectSquare(16); // returns true
isPerfectSquare(2); // return false

////////////////////////////////////////////////////////////



var MysteryFunction = function(input) {
  if (MysteryFunction2(input % 5) > 10) {
    return MysteryFunction2(input % 3)
  }
  return MysteryFunction2(input % 4)
}

var MysteryFunction2 = function(input) {
  return input * 3
}

// What does it log?
console.log(MysteryFunction(23));

//////////////////////////////////////////////////////////////

console.log("..............................................");

var MysteryFunction = function(input) {
  if (input.length > 4) {
    return MysteryFunction2(input, 3)
  }     // automatic inferred "else" 
  return MysteryFunction2(input, 2)
}

var MysteryFunction2 = function(input1, input2) {
  for (i = input2; i >= 0; i--) {
    input1.push(i)
  }
  return input1
}

// What does it log?
console.log(MysteryFunction([4,5,6]))
// What about this call?
//console.log(MysteryFunction([10,9,8,7,6])
console.log();

///////////////////////////////////////////////////////////////////////////


var arr = [2, 10, 300, 10, 99];
// for the array above, expect:
// largest element => 101
// smallest element => 10 


var largest = 0;

for(i=0; i <= arr.length - 1; i++){
j=0;
	largest = arr[i]
	lowest = arr[i]
	checkVal = arr[j]

	while(j != arr.length -1 ){
		
		if(largest >= checkVal){
			
			largest = checkVal;
			console.log(largest);
			
		}else if(lowest <= checkVal){
			
			lowest = checkVal;
0			console.log(lowest);
		}
		
	j++;
	console.log(j);
		
	}
		
		
		
}	
console.log("............................................................");
console.log(largest);
console.log(lowest);

/////////////////////////////////////////////////////////////////////////////////

var array = [1,3,5,4,3]
var largest = arr[0]
var smallest = arr[0]

for (var i = 1; i <= arr.length; i++) {
	
	currentLarge = arr[i]
	currentSmall = arr[i]
	
	if (currentLarge >= largest) {
		largest = currentLarg
	}
	
	if (currentSmall <= smallest) {
		smallest = currentSmall
	}
	console.log(currentLarge);
	console.log(currentSmall);
}

///////////////////////////////////////////////////////////////////////////////////