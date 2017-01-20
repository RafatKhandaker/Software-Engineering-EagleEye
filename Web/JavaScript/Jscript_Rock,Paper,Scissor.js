// ROCK PAPER SCISSOR  by Rafat K //
alert("Let's Play Rock, Paper, scissors");

// function for userChoice //
var userChoice = function(userVal){
	do{
		var userVal = prompt("choose a value (rock, paper or scissors)");
		return(userVal);
		
	}while(userVal != ["rock","paper","scissors"];)
};

// function for compChoice //
var compChoice = function(randVal){
    value = ((Math.random() * 10) -1);
    <!--console.log(value);  <-- just to test random #-->
        if(value <= 3.00){
            randVal = "rock";
        }else if(value <= 6.00) {
            randVal = "scissor";
        }else{
            randVal = "paper";
        }
    
    alert(randVal);
    return(randVal);
};

// function to return a case value //
var compare = function(choice1,choice2){
	if(choice1 === "rock"){
		if(choice2 === "scissor"){
            return(1);
        }else{
            return(0);
        }
        
    }else if(choice1 === "paper"){
        if(choice2 === "rock"){
            return(1);
        }else{
            return(0);
        }
		
    }else if(choice1 === "scissors"){
        if(choice2 === "rock"){
            return(0);
        }else{
            return(1); 
        }
    }
};
  

// do userChoice, compChoice while they are equal.. else do compare value //

do{
	userChoice(); 
	compChoice();
	
		if(userChoice === compChoice){
			alert("Tie!");
			alert("Please Retry !");
    
		}else{
			
			compare(userChoice,compChoice);
		
			switch(compare){   
				case 0: 
					alert("You Lose!"); 
					break;
				case 1:
					alert ("You Win!");
					break;
			}
		}
}while(userChoice === compChoice)