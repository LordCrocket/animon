class Attack{
	private String name;
	private int manaCost, damage;

	Attack(String name,  int damage, int manaCost){
		this.name = name;
		this.damage = damage;
		this.manaCost = manaCost;
	}

	public String getName(){
		return name;
	}
	public int getManaCost(){
		return manaCost;
	}
	public int getDamage(){
		return damage;
	}
}
