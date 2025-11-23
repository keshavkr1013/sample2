package LLDQuestions.VendingMachine;

import LLDQuestions.VendingMachine.MachineStates.*;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        State state = new IdleState();
        List<ItemShelf> itemSelves = fillInventory();
        Inventory inventory = new Inventory(itemSelves);
        VendingMachine machine = new VendingMachine(inventory, state, new ArrayList<>());
        try{
            State machineState = machine.getState();
            System.out.println("New stock came in inventory");
            machineState.clickOnInsertCoinButton(machine);

            machineState = machine.getState();
            Coin coin1 = Coin.COPPER, coin2 = Coin.IRON;
            machineState.insertCoin(machine, coin1);
            machineState.insertCoin(machine, coin2);
            machineState.clickOnSelectProductButton(machine);


            //notice how we need to use getState() everytime this is because machineState is a local variable and any change in actual
            //state of vending machine won't be reflected in this local variable
            machineState = machine.getState();
            ItemShelf itemShelf = machine.getItemShelf(12);
            machineState.selectProduct(machine, itemShelf);
            machine.displayInventory();

            
            machineState = machine.getState();
            machineState.clickOnInsertCoinButton(machine);
            machineState = machine.getState();
            Coin coin3 = Coin.NICKEL;
            machineState.insertCoin(machine, coin3);
            machineState.clickOnSelectProductButton(machine);
            machineState = machine.getState();
            itemShelf = machine.getItemShelf(21);
            machineState.selectProduct(machine, itemShelf);
            machine.displayInventory();

        } catch(Exception e){
            machine.displayInventory();
        }


    }
    public static List<ItemShelf> fillInventory()
    {
        List<ItemShelf> itemselves = new ArrayList<>();
        for(int code = 1; code<=10; code++)
        {
            Item item = new Item(ItemType.COKE, 10);
            ItemShelf itemShelf = new ItemShelf(item, code, true);
            itemselves.add(itemShelf);
        }
        for(int code = 11; code<=20; code++)
        {
            Item item = new Item(ItemType.KURKURE, 10);
            ItemShelf itemShelf = new ItemShelf(item, code, true);
            itemselves.add(itemShelf);
        }
        for(int code = 21; code<=30; code++)
        {
            Item item = new Item(ItemType.JUICE, 10);
            ItemShelf itemShelf = new ItemShelf(item, code, true);
            itemselves.add(itemShelf);
        }
        return itemselves;
    }
}   
