class Result {

	public static final int OK = 0, NOT_ENOUGH_MANA =1; 
	private int outCome;
	private int damageDone;
	Result(int outCome, int damageDone){
		this.outCome = outCome;
		this.damageDone = damageDone;
	}

	public int getOutCome(){
		return outCome;
	}
	public int getDamageDone(){
		return damageDone;
	}


}
