

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    public void menu(){
        Scanner scanner = new Scanner(System.in);
        Logic logic = new Logic();
        boolean flag = true;
        ArrayList<Toy> toys = new ArrayList<Toy>();
        while(flag){
            System.out.print("Options: 1 - Load toys from database\n" +
            "2 - Add new toy\n" +
            "3 - Print toy info\n" +
            "4 - Change toy drop rate\n" +
            "5 - Do some lootboxes\n" +
            "0 - Exit\n");
            char entered = scanner.next().charAt(0);
            switch(entered){
                case '1': {
                    toys = logic.createToys();
                    break;
                }
                case '2': {
                    toys.add(logic.createToy(toys));
                    break;
                }
                case '3': {
                    logic.printToys(toys);
                    break;
                }
                case '4': {
                    logic.changeDropRate(toys);
                    break;
                }
                case '5': {
                    logic.getRandomToy(toys);
                    break;
                }
                case '0': {
                    flag = false;
                    break;
                }
                default: {
                    System.out.println("Error");
                    break;
                }
            }
        }
    }
}