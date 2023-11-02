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
