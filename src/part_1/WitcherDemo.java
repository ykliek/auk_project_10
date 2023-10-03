/* ************************************************************************** */
/*                                                                            */
/*                                                 :       ::    :: ::   ::   */
/*   WitcherDemo.java                             :+:      :+    :+ :+  :+    */
/*                                               +:+:+     :+    :+ :+  :+    */
/*   By: ykliek <yurii.kliek@auk.edu.ua>        +#   :+    +#    :+ +#:+      */
/*                                             +#+#+#+#+   +#    +# +# +#     */
/*   Created: 2023/10/03 23:38:13 by ykliek   #+       #+  #+    #+ #+  #+    */
/*   Updated: 2023/10/03 23:38:16 by ykliek  ##         ##  ######  ##   ##   */
/*                                                                            */
/* ************************************************************************** */

package part_1;

// WitcherCharacter class to represent a Witcher character
class WitcherCharacter {
	String name;
	int level;

	public WitcherCharacter(String name, int level) {
		this.name = name;
		this.level = level;
	}
}

public class WitcherDemo {
	public static void main(String[] args) {
		// Create a Witcher character named Geralt at level 10
		WitcherCharacter geralt = new WitcherCharacter("Geralt of Rivia", 10);

		// Assign the reference of 'geralt' to two different variables
		WitcherCharacter witcher1 = geralt;
		WitcherCharacter witcher2 = geralt;

		// Change the level of witcher1
		witcher1.level = 15;

		// Monitor the properties
		System.out.println("Witcher 1: " + witcher1.name + " - Level " + witcher1.level);
		System.out.println("Witcher 2: " + witcher2.name + " - Level " + witcher2.level);

		// Both witcher1 and witcher2 point to the same object, so the changes influence both

		// Create another Witcher character named Ciri at level 5
		WitcherCharacter ciri = new WitcherCharacter("Ciri", 5);

		// Pass the 'ciri' object to a method as an argument and change her level inside the method
		changeWitcherLevel(ciri, 8);

		// Check the object property outside the method
		System.out.println("Ciri: " + ciri.name + " - Level " + ciri.level);
		// The change to Ciri's level inside the method influenced the original variable 'ciri'
	}

	// Method to change the Witcher character's level
	public static void changeWitcherLevel(WitcherCharacter witcher, int newLevel) {
		witcher.level = newLevel;
	}
}
