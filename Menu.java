import java.util.ArrayList;
class Menu {
	private ArrayList<String> options;
	private int choice;
	private String name;
	public static final int ATTACK =0,CHANGE_ANIMAL=1,FLEE=2,ITEM =3;

	public Menu(){
		options = new ArrayList<String>();	
		options.add("Attack");
		options.add("Change Animal");
		options.add("Flee");
		options.add("Item");
		name = "main";
		choice = 0;
	}

	public Menu(ArrayList<String> options,String name){
		this.options = options;
		this.name = name;
		choice = 0;
	}

	public String getName(){
		return name;
	}
	
	public void choose(int choice){
		if(!(choice<0 || choice>=options.size()))
			this.choice = choice;			
	}

	public int getChoiceNumber(){
		return choice;
	}

	public String getChoice(){
		return options.get(choice);
	}

	public int getNumberOfOptions(){
		return options.size();
	}

	public ArrayList<String> getOptions(){
		return options;
	}


	public String toString(){
		String tmp="";
		for(int optionNumber = 0; optionNumber<options.size();optionNumber++)
			tmp += optionNumber+1 + ". "+options.get(optionNumber) +"\n";
		return tmp;
	}
}
