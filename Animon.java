import java.util.ArrayList;
class Animon {
	private int hp,mana;	
	private AnimonType type;
	private ArrayList<Attack> attacks;
	
	public Animon(AnimonType type){
		this.type = type;
		hp = type.getHp();		
		mana = type.getMana();
		attacks = new ArrayList<Attack>();
		attacks.add(type.getDefaultAttack());
	} 

	public AnimonType getType(){
		return type;
	}
	public int getMana(){
		return mana;
	}
	private void setMana(int mana){
		if(mana<0)
			this.mana = 0;
		else if(mana>type.getMana())
			this.mana = type.getMana();
		else 
			this.mana = mana;
	}
	public void changeMana(int manaChange){
		setMana(mana + manaChange);
	}

	public int getHp(){
		return hp;
	}

	private void setHp(int hp){
		if(hp<0)
			this.hp = 0;
		else if(hp>type.getHp())
			this.hp = type.getHp();
		else 
			this.hp = hp;
	}


	public void changeHp(int hpChange){
		setHp(hp + hpChange);
	}

	public Attack getAttack(int attackNumber){
		return attacks.get(attackNumber);
	}
	public ArrayList<String> getAttackNames(){
		ArrayList<String> attackNames = new ArrayList<String>();	
		for(Attack attack: attacks)
			attackNames.add(attack.getName());
		return attackNames;
	}
	public int getNumberOfAttacks(){
		return attacks.size();
	}

	public boolean learnAttack(Attack attack){
		if((!type.canLearn(attack)) && (!attacks.contains(attack)))
			return false;
		attacks.add(attack);
		return true;
	}

	public String toString(){
		String tmp ="";
		tmp += type.getName() + "\n";
		tmp += "Hp :" +hp + "\n";
		tmp += "Mana :"+mana + "\n";
		return tmp;
	}

	
}
