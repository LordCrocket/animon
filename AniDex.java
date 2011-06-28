import java.util.HashMap;
import java.util.ArrayList;
import java.util.HashSet;
class AniDex {
	private static final AniDex aniDex = new AniDex();
	private HashMap<String, AnimonType> animonMap;
	private HashMap<String, Attack> attackMap;
	private AniDex(){
		initAttacks();
		initAnimon();
	}

	public static AniDex getAniDex(){
			return aniDex;
	}


	public AnimonType getAnimon(String name){
		return animonMap.get(name);
	}
	public Attack getAttack(String name){
		return attackMap.get(name);
	}
	private void initAttacks(){
		attackMap = new HashMap<String,Attack>();	
		attackMap.put("bite", new Attack("Bite",20,10));
		attackMap.put("scratch",new Attack("Scratch",10,10));
		attackMap.put("kick",new Attack("Kick",10,10));
		attackMap.put("spear", new Attack("Spear",30,20));
		attackMap.put("charge", new Attack("Charge",20,20));
		attackMap.put("rampage", new Attack("Rampage",50,20));

	}
	private void initAnimon(){
		animonMap = new HashMap<String,AnimonType>();	
		HashSet<String> attackNames = new HashSet<String>();	
		attackNames.add("bite");
		AnimonType wolf = new AnimonType("Wolf",100,50,attackMap.get("scratch"),canLearn(attackNames));
		animonMap.put("wolf",wolf);


		attackNames = new HashSet<String>();	
		attackNames.add("spear");
		AnimonType deer = new AnimonType("Deer",150,50,attackMap.get("kick"),canLearn(attackNames));
		animonMap.put("deer",deer);

		attackNames = new HashSet<String>();	
		attackNames.add("rampage");
		AnimonType elephant = new AnimonType("Elephant",200,50,attackMap.get("charge"),canLearn(attackNames));
		animonMap.put("elephant",elephant);

	}	

	private HashSet<Attack> canLearn(HashSet<String> attackNames){
		HashSet<Attack> canLearn = new HashSet<Attack>();	
		for(String attackName : attackNames)
			canLearn.add(attackMap.get(attackName));
		return canLearn;
	} 

	public ArrayList<String> getAnimonNames(){
		return new ArrayList<String>(animonMap.keySet());	
	}
}
