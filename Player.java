package fp;

public class Player {
	private String name;
	 private int money;
	 public Player(String n) {
	  name=n;
	  money=1000;
	 }
	 public String getn() {
	  return name;
	 }
	 public int getm() {
	  return money;
	 }
	 public void setm(int z) {
	  money+=z;
	 }
	 public void setn(String n) {
		 name=n;
	 }
	 public void setM(int n) {
		 money=n;
	 }
}
