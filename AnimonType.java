import java.util.HashSet;

class AnimonType {
	private int hp,mana;
	private Attack defaultAttack;
	private HashSet<Attack> canLearn;
	private String name;

	AnimonType(String name, int hp, int mana, Attack defaultAttack){
		this.name = name;
		this.hp = hp;
		this.mana = mana;
		this.defaultAttack = defaultAttack;
		this.canLearn = new HashSet<Attack>();
	}
	public String getName(){
		return name;
	}

	public int getHp(){
		return hp;
	}
	public int getMana(){
		return mana;
	}

	public boolean canLearn(Attack attack){
		return canLearn.contains(attack);
	}

	public Attack getDefaultAttack(){
		return defaultAttack;
	}

	public void addLearnableAttack(Attack attack){
		canLearn.add(attack);
	}

}
