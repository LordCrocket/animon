import java.util.ArrayList;
class Player {
	private String name;
	private ArrayList<Animon> animons;
	private Animon currentAnimon;


	Player(String name){
		this.name = name;
		animons = new ArrayList<Animon>();	
	}

	public String getName(){
		return name;
	}


	public void addAnimon(Animon animon){
		if(!animons.contains(animon)){
			animons.add(animon);
			if(currentAnimon==null)
				currentAnimon = animon;
		}
	}

	public Animon getAnimon(int animonNumber){
		return animons.get(animonNumber);
	}
	public Animon getCurrentAnimon(){
		return currentAnimon;
	}
	public void setCurrentAnimon(int animon){
		if(animon>-1 && animon<animons.size())
			currentAnimon = animons.get(animon);	
	}
	public int getNumberOfAnimons(){
		return animons.size();
	}
	public ArrayList<String> listAnimons(){
		ArrayList<String> animonNames = new ArrayList<String>();
		for(Animon animon: animons)
			animonNames.add(animon.getType().getName());
		return animonNames;
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
