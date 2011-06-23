class Combat {
	public static final int OK = 0, NOT_ENOUGH_MANA =1; 
	public static int attack(Animon attacker, Animon defender, int attackNumber){
		Attack attack = attacker.getAttack(attackNumber);	
		int attackManaCost = attack.getManaCost();
		if((attacker.getMana() - attackManaCost)<0)
			return 1;	
		attacker.changeMana(0-attackManaCost);
		defender.changeHp(0-attack.getDamage());	
		return 0;
	}
}
