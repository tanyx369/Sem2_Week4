public class AlienPack
{
	private Alien[] aliens;
	public AlienPack (int numAliens)
	{
		aliens = new Alien[numAliens];
	}
	public void addAlien(Alien newAlien, int index)
	{
		aliens[index] = newAlien;
	}
	public Alien[] getAliens()
	{
		return aliens;
	}
	
	public int calculateDamage()
	{
		
		int damage = 0 ;
		for (int i=0; i < aliens.length; i++)
		{
			damage += aliens[i].getDamage();
		}
		return damage;
	}
	
	public static void main(String[] args) {
		Snake s1 = new Snake(30 , "Snaker" , 10);
		Orge o1 = new Orge(42 , "Goko" , 6);
		Marhs m1 = new Marhs(23 , "Fino" , 1);
		
		AlienPack pack = new AlienPack(3);
		pack.addAlien(s1, 0);
		pack.addAlien(o1, 1);
		pack.addAlien(m1, 2);
		
		System.out.println("Total damage by aliens: " + pack.calculateDamage());
	}
}
