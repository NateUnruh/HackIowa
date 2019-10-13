/*
 * Name: Addison Armstrong, Kayla Felderman, Nate Unruh, Ram Sajja
 * Name of Project: First Aid in Flight
 * Name of Class: PackItem
 * Description of Class: This Class creates the Pack Items.
 */

//Creating PackItem Class
/** This Class creates the Pack Items*/
public class PackItem
{
    // Private Variables used in class
    private String itemName;
    private double weightInGrams;
    private int money;

    //Constructor for PackItem
    public PackItem(String itemName, double weightInGrams, int money) {
        this.itemName = itemName;
        this.weightInGrams = weightInGrams;
        this.money = money;
    }
}