import java.util.Random;
import java.util.Scanner;


public class HigherOrLower {

	private  Random randomGenerator = new Random();
	private int comp,num,compScore=0,userScore=0;

	//init values
	public HigherOrLower(){
		this.Roll();
	}
	
	//algorithm to test guess
	public String Guess(String guess){
		String result;

		//player guesses that their roll will be higher
		if(guess.equals("higher")){

			if(comp<num){

				result="You rolled: "+this.getNum()+" \nYou guessed right!";
				userScore++;
				this.Roll();
				return result;
			}
			else{

				result= "You rolled: "+this.getNum()+" \nYou guessed wrong!";
				compScore++;
				this.Roll();
				return result;
			}
		}
		//player guesses that their roll will be lower
		else{

			if(comp>num){

				result="You rolled: "+this.getNum()+" \nYou guessed right!";
				userScore++;
				this.Roll();
				return result;
			}
			else{

				result="You rolled: "+this.getNum()+" \nYou guessed wrong!";
				compScore++;
				this.Roll();
				return result;
			}
		}


	}

	public int getCompScore() {
		return compScore;
	}

	public int getUserScore() {
		return userScore;
	}

	//changes the numbers for player and computer
	private void Roll(){

		num= randomGenerator.nextInt(13-2)+2;;
		comp= randomGenerator.nextInt(13-2)+2;
		while(num==comp){
			
			comp= randomGenerator.nextInt(13-2)+2;
		}
	}
	
	//getters
	public int getComp() {
		return comp;
	}
	
	public int getNum() {
		return num;
	}
	
	//testing out number guessing
	public static void main(String[] args){
		HigherOrLower h = new HigherOrLower();
		boolean flag=true;
		String guess,result;
		
		while(flag){
		
			System.out.println("Your opponent rolled: "+h.getComp());
			System.out.println("Guess higher or lower: ");
			guess = new Scanner(System.in).nextLine();
			result=h.Guess(guess);
			System.out.println(result+"\n");

		}
	}
}
