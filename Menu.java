import java.util.List;
import java.util.ArrayList;
class Menu {
	private List<String> options;
	private int choice;
	public static final int ATTACK =0,CHANGE_ANIMAL=1,FLEE=2,ITEM =3;

	public Menu(){
		options = new ArrayList<String>();	
		options.add("Attack");
		options.add("Change Animal");
		options.add("Flee");
		options.add("Item");
	}

	public Menu(List<String> options){
		this.options = options;
	}
	
	public void choose(int choice){
		this.choice = choice;
	}

	public int getChoiceNumber(){
		return choice;
	}

	public String getChoice(){
		return options.get(choice);
	}

	public List<String> getOptions(){
		return options;
	}


	public String toString(){
		String tmp="";
		for(int optionNumber = 0; optionNumber<options.size();optionNumber++)
			tmp += optionNumber+1 + ". "+options.get(optionNumber) +"\n";
		return tmp;
	}
}
