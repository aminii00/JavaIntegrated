package movie_prac;

import java.util.Scanner;

abstract class AbstractMenu implements Menu{

	protected String menuText;
	protected Menu prevmenu;
	protected static final Scanner scanner = new Scanner(System.in);
	
	public AbstractMenu(String menuText, Menu prevmenu) {
		this.menuText = menuText;
		this.prevmenu = prevmenu;
	}
	public void print() {
		System.out.print("\n" + menuText);
	}
	public void setPrevMenu(Menu prevMenu) {
		this.prevmenu = prevMenu;
	}
}
