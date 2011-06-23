import java.util.ArrayList;
class Player {
	private String name;
	private ArrayList<Animon> animons;


	Player(String name){
		this.name = name;
		animons = new ArrayList<Animon>();	
	}

	public String getName(){
		return name;
	}


	public void addAnimon(Animon animon){
		if(!animons.contains(animon))
			animons.add(animon);
	}

	public Animon getAnimon(int animonNumber){
		return animons.get(animonNumber);
	}

	public String toString(){
		String tmp ="";
		tmp += name+"\n";
		tmp+= "=========\n";
		for(Animon animon: animons)
			tmp+= animon.toString();	
		tmp+= "=========\n";
		return tmp;
	}


} 
