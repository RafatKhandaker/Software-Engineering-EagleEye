The Question class contains a reference to a single String resource (int type)
and a boolean variable for its answer (simple true or false)

1) With a group, run the Quizzy app and discuss what you think it's doing, how the different features are accomplished, and report any erratic behavior of the app.

2) Revise the project by adding a MainActivity to the project. (You will need to add it to your manifest as well).
 Your MainActivity should prompt the user to enter their first name.


3) Write java code in the onCreate lifecycle method of MainActivity to store the entered name and send it as an intent extra to Quiz Activity


4) Launch an intent to navigate from MainActivity to QuizActivity


5) Modify the QuizActivity file to include more question objects in the questionBank array. The text for each of the questions must be stored as resources/


6) Implement the restartQuiz() method in QuizActivity


7) Implement the saveScore method. Users should see toasts with their accumulated score amount each time they answer a question.




