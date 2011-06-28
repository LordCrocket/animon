class Combat {
	public static Result attack(Animon attacker, Animon defender, int attackNumber){
		Attack attack = attacker.getAttack(attackNumber);	
		int attackManaCost = attack.getManaCost();
		if((attacker.getMana() - attackManaCost)<0)
			return new Result(1,0);	
		attacker.changeMana(0-attackManaCost);
		defender.changeHp(0-attack.getDamage());	
		return new Result(0,attack.getDamage());
	}
}
