class Animon {
	private int hp,mana;	
	private AnimonType type;
	
	public Animon(AnimonType type){
		this.type = type;
		hp = type.getHp();
		mana = type.getMana();
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

	public String toString(){
		String tmp ="";
		tmp += type.getName() + "\n";
		tmp += "Hp :" +hp + "\n";
		tmp += "Mana :"+mana;
		return tmp;
	}

	
}
