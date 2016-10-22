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
		attackMap.put("bite", new Attack("Bite",30,10));
		attackMap.put("charge", new Attack("Charge",20,20));
		attackMap.put("cover bite", new Attack("Cover bite",20,20));
		attackMap.put("death roll", new Attack("Death roll",60,20));
		attackMap.put("horn attack", new Attack("Horn attack",50,20));
		attackMap.put("horn fury", new Attack("Horn fury",70,20));
		attackMap.put("kick",new Attack("Kick",10,10));
		attackMap.put("neck bite", new Attack("Neck bite",50,20));
		attackMap.put("paws fury", new Attack("Paw's fury",50,20));
		attackMap.put("poison fang", new Attack("Poison fang",20,20));
		attackMap.put("poison sting", new Attack("Poison Sting",20,20));
		attackMap.put("rampage", new Attack("Rampage",50,20));
		attackMap.put("scratch",new Attack("Scratch",10,10));
		attackMap.put("sky dive", new Attack("Sky dive",50,20));
		attackMap.put("slaugher rage", new Attack("Slaughter Rage",70,20));
		attackMap.put("sneak attack",new Attack("Sneak attack",40,10));
		attackMap.put("snap bite",new Attack("Snap bite",40,10));
		attackMap.put("spear", new Attack("Spear",30,20));
		attackMap.put("taunt", new Attack("Taunt",10,20));
		attackMap.put("talon strike", new Attack("Talon strike",30,20));
		attackMap.put("tooth slith", new Attack("Tooth Slith",50,20));
		attackMap.put("stomp", new Attack("Stomp",40,20));
		attackMap.put("take down", new Attack("Take down",50,20));
		attackMap.put("tackle", new Attack("Tackle",20,20));
		attackMap.put("trunk attack", new Attack("Trunk attack",20,20));
		attackMap.put("tusk stab", new Attack("Tush stab",20,20));
		attackMap.put("venom", new Attack("Venom",40,20));

	}
	private void initAnimon(){
		animonMap = new HashMap<String,AnimonType>();	

		AnimonType wolf = new AnimonType("Wolf",100,50,attackMap.get("scratch"));
		wolf.addLearnableAttack(getAttack("bite"));
		animonMap.put("wolf",wolf);

		AnimonType deer = new AnimonType("Deer",150,50,attackMap.get("kick"));
		deer.addLearnableAttack(getAttack("spear"));
		animonMap.put("deer",deer);
		/*
		AnimonType elephant = new AnimonType("Elephant",200,50,attackMap.get("charge"));
		elephant.addLearnableAttack(getAttack("rampage"));
		animonMap.put("elephant",elephant);
		*/
		AnimonType elephant = new AnimonType("Elephant",400,200,attackMap.get("trunk attack"));
		elephant.addLearnableAttack(getAttack("stomp"));
		elephant.addLearnableAttack(getAttack("tusk stab"));
		elephant.addLearnableAttack(getAttack("taunt"));
		animonMap.put("elephant",elephant);

		AnimonType bear = new AnimonType("Bear",200,100,attackMap.get("scratch"));
		bear.addLearnableAttack(getAttack("bite"));
		bear.addLearnableAttack(getAttack("paws fury"));
		bear.addLearnableAttack(getAttack("slaughter rage"));
		animonMap.put("bear",bear);


		AnimonType lion = new AnimonType("Lion",160,100,attackMap.get("bite"));
		lion.addLearnableAttack(getAttack("tooth slith"));
		lion.addLearnableAttack(getAttack("neck bite"));
		lion.addLearnableAttack(getAttack("paws fury"));
		animonMap.put("lion",lion);

		AnimonType snake = new AnimonType("Snake",80,100,attackMap.get("bite"));
		snake.addLearnableAttack(getAttack("poison fang"));
		snake.addLearnableAttack(getAttack("hug of death"));
		snake.addLearnableAttack(getAttack("venom"));
 		animonMap.put("snake",snake);

		AnimonType crocodile = new AnimonType("Crocodile",200,100,attackMap.get("bite"));
		crocodile.addLearnableAttack(getAttack("death roll"));
		crocodile.addLearnableAttack(getAttack("tooth slith"));
		animonMap.put("crocodile",crocodile);

		AnimonType cougar = new AnimonType("Cougar",130,100,attackMap.get("scratch"));
		cougar.addLearnableAttack(getAttack("bite"));
		cougar.addLearnableAttack(getAttack("take down"));
		cougar.addLearnableAttack(getAttack("sneak attack"));
		animonMap.put("cougar",cougar);

		AnimonType moose = new AnimonType("Moose",230,100,attackMap.get("tackle"));
		moose.addLearnableAttack(getAttack("stomp"));
		animonMap.put("moose",moose);

		AnimonType blowfish = new AnimonType("Blowfish",100,100,attackMap.get("poison sting"));
		blowfish.addLearnableAttack(getAttack("bite"));
		animonMap.put("blowfish",blowfish);
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
