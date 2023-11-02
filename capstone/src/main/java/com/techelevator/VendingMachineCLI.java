package com.techelevator;

import com.techelevator.view.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VendingMachineCLI {

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";

	private static final String MAIN_MENU_OPTION_EXIT = "Exit";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE, MAIN_MENU_OPTION_EXIT };

	private static final String FEED_MONEY = "Feed Money";
	private static final String SELECT_PRODUCT = "Select Product";
	private static final String FINISH_TRANSACTION = "Finish Transaction";
	private static final String[] PURCHASE_MENU_OPTIONS = {FEED_MONEY, SELECT_PRODUCT, FINISH_TRANSACTION};


	public static void addToList() {
		List<ItemsClass> items = new ArrayList<>();

		Chips potatoCrisps = new Chips("Potato Crisps", "A1", 3.05, "Chips", 5, "Crunch Crunch, Yum!");
		Chips stackers = new Chips("Stackers", "A2", 1.45, "Chips", 5, "Crunch Crunch, Yum!");
		Chips grainWaves = new Chips("Grain Waves", "A3", 2.75, "Chips", 5, "Crunch Crunch, Yum!");
		Chips cloudPopcorn = new Chips("Cloud Popcorn", "A4", 3.65, "Chips", 5, "Crunch Crunch, Yum!");
		Candy moonpie = new Candy("Moonpie", "B1", 1.80, "Candy", 5, "Munch Munch, Yum!");
		Candy cowtales = new Candy("Cowtales", "B2", 1.50, "Candy", 5, "Munch Munch, Yum!");
		Candy wonkaBar = new Candy("Wonka Bar", "B3", 1.50, "Candy", 5, "Munch Munch, Yum!");
		Candy crunchie = new Candy("Crunchie", "B4", 1.75, "Candy", 5, "Munch Munch, Yum!");
		Drinks cola = new Drinks("Cola", "C1", 1.25, "Drinks", 5, "Glug Glug, Yum!");
		Drinks drSalt = new Drinks("Dr. Salt", "C2", 1.50, "Drinks", 5, "Glug Glug, Yum!");
		Drinks mountainMelter = new Drinks("Mountain Melter", "C3", 1.50, "Drinks", 5, "Glug Glug, Yum!");
		Drinks heavy = new Drinks("Heavy", "C4", 1.50, "Drinks", 5, "Glug Glug, Yum!");
		Gum uChews = new Gum("U-Chews", "D1", 0.85, "Gum", 5, "Chew Chew, Yum!");
		Gum littleLeagueChew = new Gum("Little League Chew", "D2", 0.95, "Gum", 5, "Chew Chew, Yum!");
		Gum chiclets = new Gum("Chiclets", "D3", 0.75, "Gum", 5, "Chew Chew, Yum!");
		Gum triplemint = new Gum("Triplemint", "D4", 0.75, "Gum", 5, "Chew Chew, Yum!");

		items.add(potatoCrisps);
		items.add(stackers);
		items.add(grainWaves);
		items.add(cloudPopcorn);
		items.add(moonpie);
		items.add(cowtales);
		items.add(wonkaBar);
		items.add(crunchie);
		items.add(cola);
		items.add(drSalt);
		items.add(mountainMelter);
		items.add(heavy);
		items.add(uChews);
		items.add(littleLeagueChew);
		items.add(chiclets);
		items.add(triplemint);

		//loop through items and determine if they have been purchased
		for (ItemsClass item: items){

			if (item.getQuantity() == 0) {
				System.out.println(item.getLocation() + "|Item: " + item.getName() + " |Price: " + item.getPrice() + "|" + "SOLD OUT!");
			} else {
				System.out.println(item.getLocation() + "| Item: " + item.getName() + " |Price: " + item.getPrice());
			}
		}

			//if they have been purchased, quantity count --

			//else - quantity count = quantity count

	}







	private Menu menu;

	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
	}

	public void run() {
		while (true) {
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				displayItems();
			} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				String purchaseChoice = (String) menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);
				while (true){
					if (purchaseChoice.equals(FEED_MONEY)){
						System.out.println("Please enter amount in full dollars ");
						menu.feedMoney();
						break;
					} else if (purchaseChoice.equals(SELECT_PRODUCT)){

						//if ()
						menu.selectProduct();
						break;
					} else {
						break;
					}
				}
			} else if (choice.equals(MAIN_MENU_OPTION_EXIT)){
				break;
			}
		}
	}

	public static void main(String[] args) {
		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		cli.run();

	}

	public static void displayItems(){

		String vendingMachineCSV = "C:\\Users\\Student\\workspace\\oct-blue-capstone-1-team-1\\capstone\\vendingmachine.csv";

		File vendingMachineMenu = new File(vendingMachineCSV);

		try (Scanner fileReader = new Scanner(vendingMachineMenu)){

			while (fileReader.hasNextLine()){
				String line = fileReader.nextLine();
					//if ()
				System.out.println(line);
			}

		} catch (Exception ex){
			System.out.println("Something went wrong");

		}

	}

	public static void purchaseItems(){



	}


}
