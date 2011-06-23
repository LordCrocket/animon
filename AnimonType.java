import java.util.List;

class AnimonType {
	private int hp,mana;
	private List<Attack> attacks;
	private String name;

	AnimonType(String name, int hp, int mana, List<Attack> attacks){
		this.name = name;
		this.hp = hp;
		this.mana = mana;
		this.attacks = attacks;
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

	public Attack getAttack(int attackNumber){
		return attacks.get(attackNumber);
	}
	public int getNumberOfAttacks(){
		return attacks.size();
	}
}
