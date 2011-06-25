class AnimonFactory{
	private static final AnimonFactory creator = new AnimonFactory();	
	
	private static AnimonFactory getAnimonFactory(){
		return creator;
	}	

	public static Animon create(String typeName){
		AnimonType type =  AniDex.getAniDex().getAnimon(typeName);
		if(type!=null)
			return new Animon(type);	
		System.err.println("Could not create: " + typeName);
		return null;
	}
	

}
