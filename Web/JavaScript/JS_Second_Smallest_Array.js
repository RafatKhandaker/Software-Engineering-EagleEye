/* this program will order any array from least to greatest and then pull out the second smallest vallue */

var array = [5,28,1,3,15,8,30]

var newarray = array.sort(function(a,b){return a-b})

console.log(newarray);

 do{
     newarray.pop(); 
     
 }while(newarray.length != 2)
 
 console.log(newarray)
 
 console.log("........................RESULT.................................")
 console.log("")
 console.log("The second smallest value is " + "" + newarray[1])
 
 
 	
 	