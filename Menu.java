import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
class Menu {
	private List<String> options;
	private int choice;

	public Menu(){
		options = new ArrayList<String>();	
		options.add("1. Attack");
		options.add("2. Change Animal");
		options.add("3. Flee");
		options.add("4. Item");
	}

	public Menu(List<String> options){
		this.options = options;
	}
	
	public void choose(){
		Scanner sc = new Scanner(System.in);
		choice = Integer.parseInt(sc.nextLine())-1;
	}

	public int getChoiceNumber(){
		return choice;
	}

	public String getChoice(){
		return options.get(choice);
	}


	public String toString(){
		String tmp="";
		for(String option: options)
			tmp += option +"\n";
		return tmp;
	}
}
