package com.techelevator.view;

import com.techelevator.VendingMachineCLI;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {

	private PrintWriter out;
	private Scanner in;
	public double totalMoneyFed;





	public Menu(InputStream input, OutputStream output) {
		this.out = new PrintWriter(output);
		this.in = new Scanner(input);
	}

	public Object getChoiceFromOptions(Object[] options) {
		Object choice = null;
		while (choice == null) {
			displayMenuOptions(options);
			choice = getChoiceFromUserInput(options);
		}
		return choice;
	}

	private Object getChoiceFromUserInput(Object[] options) {
		Object choice = null;
		String userInput = in.nextLine();
		try {
			int selectedOption = Integer.valueOf(userInput);
			if (selectedOption > 0 && selectedOption <= options.length) {
				choice = options[selectedOption - 1];
			}
		} catch (NumberFormatException e) {
			// eat the exception, an error message will be displayed below since choice will be null
		}
		if (choice == null) {
			out.println(System.lineSeparator() + "*** " + userInput + " is not a valid option ***" + System.lineSeparator());
		}
		return choice;
	}

	private void displayMenuOptions(Object[] options) {
		out.println();
		for (int i = 0; i < options.length; i++) {
			int optionNum = i + 1;
			out.println(optionNum + ") " + options[i]);
		}
		out.print(System.lineSeparator() + "Please choose an option >>> ");
		out.flush();
	}

	public void feedMoney() {

		while (true) {
			if (in.hasNextLine()) {
				Double cash = Double.parseDouble(in.nextLine());
				totalMoneyFed += cash;
				Log.run("FEED MONEY", cash, totalMoneyFed);
				System.out.println("Current Money Provided: " + "$" + totalMoneyFed);
				break;
			} else {
				System.out.println("Current Money Provided: " + "$" + totalMoneyFed);
				break;
			}

		}
	}
	private List<ItemsClass> items = new ArrayList<>();
	public void addToList() {

		if (items.size() == 0) {


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
		}
		//loop through items and determine if they have been purchased
		for (ItemsClass item : items) {

			if (item.getQuantity() == 0) {
				System.out.println(item.getLocation() + "| Item: " + item.getName() + " |Price: " + item.getPrice() + "|" + "SOLD OUT!");
			} else {
				System.out.println(item.getLocation() + "| Item: " + item.getName() + " |Price: " + item.getPrice() + " " + item.getQuantity());
			}
		}


		System.out.println("Please enter a valid item location for desired item (Character + Number) ex B3 ");
		System.out.println("Please enter 'Exit' to go back to the main menu");
		//show list of products available and inventory amount by calling
		while (true) {
			if (in.hasNextLine()) {
				String productSelection = in.nextLine();
				if (productSelection.equalsIgnoreCase("Exit")) {
					break;
				}
				for (ItemsClass item : items) {
					if (item.getLocation().equals(productSelection) && totalMoneyFed >= item.getPrice() && item.getQuantity() > 0) {
						totalMoneyFed -= item.getPrice();
						String itemName =  item.getName();
						double itemPrice = item.getPrice();
						Log.run(itemName, itemPrice, totalMoneyFed);
						item.setQuantity(item.getQuantity() - 1);
						System.out.println(item.getName() + " Item Price: " + item.getPrice() + " Money Remaining: " + totalMoneyFed + " " + item.getSound());

					} else if (item.getLocation().equals(productSelection) && totalMoneyFed < item.getPrice()) {
						System.out.println("Insufficient Funds!");
						break;
					} else if (item.getQuantity() <= 0) {
						System.out.println("SOLD OUT!!");
						break;
					}

				}

			}
			break;

			//if they have been purchased, quantity count --

			//else - quantity count = quantity count

		}
	}
	public void finishTransaction(){
		//take totalMoneyFed and set it to new variable
		int change = (int)(totalMoneyFed * 100);


		//Implement logic to distribute change by dollars, quarters, dimes, nickles using smallest amount of coins possible
		int quarters = change / 25;
		change %= 25;

		int dime = change / 10;
		change %= 10;

		int nickels = change / 5;
		change %= 5;

		System.out.println("Here is your change!");
		System.out.println("Quarters: " + quarters);
		System.out.println("Dimes: " + dime);
		System.out.println("Nickels " + nickels);

		//set totalMoneyFed to zero
		totalMoneyFed -= change;
		Log.run("GIVE CHANGE", totalMoneyFed, change);
	}
}
