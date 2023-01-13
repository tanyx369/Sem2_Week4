class Alien
{
	private int health; // 0=dead, 100=full strength
	private String name;
	private int damage;
	
	
	public Alien (int health, String name , int xp)
	{
		
		this.health = health;
		this.name = name;
		this.damage = xp;
	}
	
	public int getHealth() {
		return health;
	}
	
	public void setHealth( int hp) {
		this.health = hp;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getDamage() {
		return damage;
	}
}
