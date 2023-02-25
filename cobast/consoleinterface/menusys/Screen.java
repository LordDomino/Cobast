package cobast.consoleinterface.menusys;

import java.util.ArrayList;

public class Screen extends ContainerWidget {

	public static ArrayList<Screen> screen_list = new ArrayList<Screen>();

	public ArrayList<Widget> children = new ArrayList<Widget>();

	public Screen() {
		super();
		screen_list.add(this);
	}

	public void executeScreen() {
		ArrayList<String> print_list = new ArrayList<String>();

		for (Widget obj : this.children) {
			print_list.addAll(obj.extractWidgetStyle());
		}

		for (String line : print_list) {
			System.out.println(line);
		}
	}
}
