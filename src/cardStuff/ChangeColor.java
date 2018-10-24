
package cardStuff;

public class ChangeColor extends Card implements iActionable{

	public ChangeColor() {
		super();
		this.setName("Change Color");
		// TODO Auto-generated constructor stub
	}

	public void makeAction(String color) {
		// le pone color a la carta
		super.setColor(color);		
	}

	public void makeAction() {
		// TODO Auto-generated method stub
		
	}

}
