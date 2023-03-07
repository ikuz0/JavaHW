

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public class Logic {

    public ArrayList<Toy> createToys(){
        Toy toy1 = new Toy(0, "Plush cat", 10, 20);
        Toy toy2 = new Toy(1, "Tabletop game", 10, 10);
        Toy toy3 = new Toy(2, "Robot", 10, 20);
        Toy toy4 = new Toy(3, "Railway", 10, 50);
        ArrayList<Toy> toys = new ArrayList<Toy>();
        toys.add(toy1);
        toys.add(toy2);
        toys.add(toy3);
        toys.add(toy4);
        return toys;
    }

    public Toy createToy(ArrayList<Toy> toys){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter toy name: ");
        String entered = scanner.nextLine();
        Toy toy = new Toy(toys.size(), entered, 10, 10);
        return toy;
    }

    public ArrayList<Toy> changeDropRate(ArrayList<Toy> toys){
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        while(flag){
            System.out.print("Enter toy id: ");
            String entered = scanner.nextLine();
            try {
                int number = Integer.parseInt(entered);
                if (number < toys.size() && number >= 0){
                    boolean validPercentage = false;
                    while(!validPercentage){
                        System.out.print("Enter drop rate (% below 100): ");
                        String enteredInt = scanner.nextLine();
                        try {
                            int percentage = Integer.parseInt(enteredInt);
                            if (percentage < 100 && percentage > 0){
                                for(Toy toy : toys){
                                    if(toy.getId() == number){
                                        toy.setDropRate(percentage);
                                        validPercentage = true;
                                        flag = false;
                                    }
                                }
                            }
                            else{
                                System.out.println("Invalid percentage");
                            }
                        } catch (Exception e) {

                        }
                    }
                }
                else{
                    System.out.println("Invalid id");
                }
            } catch (Exception e) {
                
            }
        }
        
        return toys;
    }

    public void getRandomToy(ArrayList<Toy> toys){
        ArrayList<Double> chances = new ArrayList<Double>();
        for(Toy toy : toys){
            int chance = toy.getDropRate();
            chances.add((double)chance);
        }
        Random r = new Random();
        CsvExport csv = new CsvExport();
        boolean dropped = false;
        for (int i = 0; i < chances.size(); i++){
            if(chances.get(i) > r.nextDouble() * 100){
                Toy toy = toys.get(i);
                if (toy.getAmountRemaining() > 0) {
                    System.out.printf("You got toy %s!\n", toy.getToyName());
                    int current = toy.getAmountRemaining();
                    int newAmount = current-1;
                    toy.setAmountRemaining(newAmount);
                    csv.writeResult(toy);
                    dropped = true;
                }
                else{
                    System.out.printf("Oops, no toys of type %s remain\n", toy.getToyName());
                    dropped = true;
                }
                break;
            }    
        } 
        if (dropped == false) {
            System.out.println("You got nothing!");
        }
    }

    public void printToys(ArrayList<Toy> toys){
        for(Toy toy : toys){
            toy.printToyInfo();
        }
    }
}




