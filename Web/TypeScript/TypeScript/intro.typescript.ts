function greeter(person){ return "Hello," + person; }

let user = "Jane user";
document.body.innerHTML = greeter(user);

document.body.innerHTML = greeter([0,1,2]);
