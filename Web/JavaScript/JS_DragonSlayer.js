// This game is a mini dragon slayer game, which is an example from CodeAcademy for learning purpose //

/*

var slaying = true;
// A bit of new math magic to calculate the odds
// of hitting the dragon. We'll cover this soon!
var youHit = Math.floor(Math.random() * 2);
var damageThisRound = Math.floor(Math.random() * 5 + 1);
var totalDamage = 0;

while (slaying) {
  if (youHit) {
    console.log("You hit the dragon and did " + damageThisRound + " damage!");
    totalDamage += damageThisRound;
    
    if (totalDamage >= 4) {
      console.log("You did it! You slew the dragon!");
      slaying = false;
    } else {
      youHit = Math.floor(Math.random() * 2);
    }
  } else {
    console.log("The dragon burninates you! You're toast.");
    slaying = false;
  }
}
*/

// My version of the Dragon slayer code  - R.K 07/10/16 // 
var slaying = true;

var youHit = function(damage){
    damage = Math.floor(Math.random()*2); 
    if(poison === "equiped"){
       var damage = damage + (Math.random()*0.3);
    }
    if(longSword === "equiped"){
        var damage = damage + (Math.random()*.50);
    }    
    
    if(shortSword === "equiped"){
        var damage = damage + (math.random()*0.25); 
    }
}

var totalDamage = 0;
var totalDamage = function(totalDamage){
    totalDamage = totalDamage + youHit;
}
