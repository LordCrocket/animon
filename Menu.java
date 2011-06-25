import java.util.ArrayList;
class Menu {
	private ArrayList<String> options;
	private int choice,coloumns = 2;
	private MenuType type;
	public static final int ATTACK =0,CHANGE_ANIMON=1,FLEE=2,ITEM =3;

	public Menu(){
		options = new ArrayList<String>();	
		options.add("Attack");
		options.add("Change Animon");
		options.add("Flee");
		options.add("Item");
		type = MenuType.main;
		choice = 0;
	}

	public Menu(ArrayList<String> options,MenuType type, int coloumns){
		this(options,type);
		this.coloumns = coloumns;
	}

	public Menu(ArrayList<String> options,MenuType type){
		this.options = options;
		this.type = type;
		choice = 0;
	}


	public MenuType getType(){
		return type;
	}

	public int getColoumns(){
		return coloumns;
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
