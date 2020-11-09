import java.io.*;
class RockPaperScissors {
BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));
public static void main(String[] args) {
RockPaperScissors RPS = new RockPaperScissors();
System.out.println("Welcome to Rock, Paper, or Scissors!");
System.out.print("Please enter the number of rounds you would like to play : ");
int round = RPS.rounds();
int user = 0;
int computer = 0;
for (int i = 0; i < round; i++) {
if (RPS.choose(i + 1))
user++;
else
computer++;
}
RPS.result(user, computer);
}

void result(int user, int computer) {
System.out.println("RESULTS:");
System.out.println("User wins : " + user);
System.out.println("Computer wins : " + computer);
if (user > computer)
System.out.println("User wins the game!\n");
else
System.out.println("Computer wins the game!\n");
}

int rounds() {
try {
int temp = Integer.parseInt(BR.readLine());
if (temp % 2 == 0)
throw new Exception();
return temp;
}
catch (Exception err) {
System.out.print("Sorry, you need to enter an odd number. Please try again : ");
return rounds();
}
}

boolean choose(int val) {
System.out.print("[Round " + val + "] Rock, Paper, or Scissors? : ");
String input = "";
try {
input = BR.readLine();
}
catch(Exception err) {
}
if (input.equals("Rock"))
return process(1, val);
else if (input.equals("Paper"))
return process(2, val);
else if (input.equals("Scissors"))
return process(3, val);
else {
System.out.println("Sorry, \"" + input + "\" is not a valid entry!\n");
return choose(val);
}
}

boolean process(int user, int val) {
String[] hand = {"", "Rock", "Paper", "Scissors"};
int comp = (int)(Math.random() * 3) + 1;
if (user == comp) {
System.out.println("Computer chooses " + hand[user] + ". It's a tie.\n");
return choose(val);
}
else if (user == 1 && comp == 3) {
System.out.println("Computer chooses " + hand[comp] + ". You win!\n");
return true;
}
else if (user == 2 && comp == 3) {
System.out.println("Computer chooses " + hand[comp] + ". You lose!\n");
return false;
}
else if (user == 1 && comp == 2) {
System.out.println("Computer chooses " + hand[comp] + ". You lose!\n");
return false;
}
else if (user == 3 && comp == 2) {
System.out.println("Computer chooses " + hand[comp] + ". You win!\n");
return true;
}
else if (user == 2 && comp == 1) {
System.out.println("Computer chooses " + hand[comp] + ". You win!\n");
return true;
}
else {
System.out.println("Computer chooses " + hand[comp] + ". You lose!\n");
return false;
}
}
}
