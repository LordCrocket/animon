class Combat {
	public static void attack(Animon attacker, Animon defender, int attackNumber){
		Attack attack = attacker.getType().getAttack(attackNumber);	
		attacker.changeMana(0-attack.getManaCost());
		defender.changeHp(0-attack.getDamage());	
	}
}
