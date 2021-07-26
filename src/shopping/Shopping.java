
package shopping;
import java.util.ArrayList;


public class Shopping extends InputValidator {

    public static void main(String[] args) {

    ArrayList<ShoppingBag> theMenu = new ArrayList<>(); // Create an ArrayList object theMenu
        
        // Below I added all the Items to the menu
        theMenu.add(new ShoppingBag("Starters   ", "Nachos      ", 0 ,3.5));
        theMenu.add(new ShoppingBag("Starters   ", "Chicken bull", 0 ,3.5));
        theMenu.add(new ShoppingBag("Main Course", "BBQ         ", 0 ,12.5));
        theMenu.add(new ShoppingBag("Main Course", "Pasta       ", 0 ,9));
        theMenu.add(new ShoppingBag("Dessert    ", "IceCream    ", 0 ,4.5));
        theMenu.add(new ShoppingBag("Dessert    ", "Cake        ", 0 ,3.5));
        theMenu.add(new ShoppingBag("Drink      ", "Ceveza      ", 0 ,5.5));
        theMenu.add(new ShoppingBag("Drink      ", "SoftDrink   ", 0 , 4));

        // printing the head of the menu 
        System.out.println("ҨҨҨҨҨҨҨҨҨҨҨҨҨҨҨҨҨҨҨҨҨҨҨҨҨҨҨҨҨҨҨҨҨҨҨҨ");
        System.out.println("ҨҨҨҨҨҨҨҨ  WELCOME TO EL GRITO  ҨҨҨҨҨҨҨҨҨҨ");
        System.out.println("ҨҨҨҨҨҨҨҨҨҨҨҨҨҨҨҨҨҨҨҨҨҨҨҨҨҨҨҨҨҨҨҨҨҨҨҨ\n");
        
        
      printMenu(theMenu); // call method printMenu to print the menu
      
      chooseItems(theMenu); // method chooseItems to user choose items inside the menu
    
      
    } // end main 
    
    // #####################################################################################################################################
  
    // printing the Menu
    
        public static void printMenu (ArrayList<ShoppingBag> printMenu){ 
            System.out.println("φφφφφφφφφφφφφφφφφφφ MENU φφφφφφφφφφφφφφφφφφφφφ\n");
            System.out.println("ID:     Items           Category:       Price:\n");
            System.out.println("⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙");
         for (int i = 0; i < printMenu.size(); i++ ){ 
            
            System.out.println("[ " + i + " ]  " +  printMenu.get(i).getName() + "     " + printMenu.get(i).getCourse() + "     € " +  printMenu.get(i).getPrice());
            System.out.println("⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙");
        }
       
        } 
    // end printMenu
        
    
   // #####################################################################################################################################
     
    //chooseItems  
       public static void chooseItems (ArrayList<ShoppingBag> item) { 
        
        // printing 3 instructions to how users can buy or stop shopping
        System.out.println("\nHello there =), folow the Steps below to buy on El Grito:");
        System.out.println("\n#1 - ADD ITEM TO SHOPPING BAG: choose any item by ID");
        System.out.println("#2 - SELECT THE AMOUNT THAT YOU WANT");
        System.out.println("#3 - TO LEAVE THE SHOP AND PAY TYPE: exit");
        System.out.println("\nPS: FREE DELIVERY FOR SHOPPING OVER €35 =]");
        
        intInput = sc.readInteger(error); // getting the first input from the user 
        
        ArrayList<ShoppingBag> mybag = new ArrayList<>(); // creating a new ArrayList object to store the items that the user will choose
        
        
        exit = sc.strInput; // leave the program in case of the user types exit as first input
    
        while (!exit.contains("exit")) { // while user does not choose leave, the program will still ask if he/she wants to keep buying

            // checking if the user input is greater than 0 and Less than ArrayList size and also if he/she chooses to leave
            while (intInput >= item.size() || intInput < 0 && !exit.contains("exit")){
                System.out.println("\n## ERROR! ## - Please choose a number betwen 0 to " + (item.size() -1) );
                intInput = sc.readInteger( error); // getting the new input after a wrong one
                
             }

            int userItem =  intInput; // getting the input from user and store in userItem to add  the item to the bag
            
            // asking how many items they want to add to shopping bag
            System.out.println("How many " + item.get(userItem).getName().trim() + " do you want to add to Shopping Bag?"); 
            intInput = sc.readInteger(error); // getting the amount for the choosen Item
            
            // creating and passing values to varibles to store in new ArrayList (shopping bag)
            int amountItems =  intInput;
            String itemName = item.get(userItem).getName();
            String itemCourse = item.get(userItem).getCourse();
            double itemPrice = item.get(userItem).getPrice();
           // printing messsage to users that the item was successfully added 
           System.out.println( "\nYou added " +amountItems + " " +  item.get(userItem).getName().trim() + " to your shopping Bag.\n" );
           
           printMenu(item); // printing menu again to users
           
           // Message for users to continue shopping or leave
           System.out.println("\nKeep shopping or type \"exit\" to leave the menu.");
           intInput = sc.readInteger(error); // getting new input 
           exit = sc.strInput; // setting the new input to variable exit in case the user wants to leave
           
           // Adding the item to bag
           mybag.add(new ShoppingBag (itemName, itemCourse, amountItems , itemPrice));
        }

        printBag(mybag, 0 ); // print Bag after users selected leave
        

    } 
    // end chooseItems  
       
    // #####################################################################################################################################
       
       
    //printBag
    public static void printBag (ArrayList<ShoppingBag> myBag , int firstTime) { 
           
        int bagSize = myBag.size(); // initializing bagsize to the size of the bag to check if it is empty
        double finalPrice = 0; // initialilizing to 0 to use later to show the total of the bag
        
        if (bagSize != 0){ // if bagSize is not empty print the bag to user
            
           System.out.println("\n             HERE IS YOUR SHOPPING BAG:\n");
           System.out.println("ID:                     ITEM         AMOUNT:    PRICE:\n");
           
           // for loop to print the bag 
           for (int i = 0; i < myBag.size(); i++ ){
                System.out.println("⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙");
                System.out.println("[ " + i + " ]" + myBag.get(i));
                System.out.println("⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙");
            } 
           
           // printing a message to see if user want to finish or delete something from the bag 
           
           if (firstTime == 0){
               
                System.out.println("\nPress 0 to remove Items or any number to finish your shopping:");
                int removeItem; 
                removeItem = sc.readInteger(error); // declaring removeItem to the user input
                
                if (removeItem == 0){ // if user selected remove, call the method removeItems
                    removeItem(myBag);
                }else{ // if user selected finish, print the final bag and finish the program
                    printFinalBag(myBag);
                }
           
           }
           else{    
               System.out.println("\nKeep removing Items or press pay to finish your shopping:");
               removeItem(myBag);
           }
           
           
        }else // if the bag is empty, print the message below and finish the program
        {
            System.out.println("\n⁙⁙⁙⁙⁙⁙⁙ You left the shop. ⁙⁙⁙⁙⁙⁙⁙");
            System.out.println("⁙⁙⁙⁙ We appreciate your visit ⁙⁙⁙⁙\n");
        }
          
       
    } 
    // end printBag


    // Printing the final Bag with Final price and end the program
    public static void printFinalBag(ArrayList<ShoppingBag> finalBag) { 
        

        System.out.println("\n            HERE IS YOUR RECEIPT :\n");
       System.out.println("CATEGORY:       ITEM         AMOUNT:    PRICE:\n");
        System.out.println("⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙");
        
        double finalPrice = 0;// initializing finalPrice to 0 
        double deliveryfee = 5.0; // initializing price to delivery fee
        
           for (int i = 0; i < finalBag.size(); i++ ){
                System.out.println(finalBag.get(i));
                System.out.println("⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙⁙");
                finalPrice = finalPrice + finalBag.get(i).getPrice() * finalBag.get(i).getqtd();
            } 
           
           if (finalPrice < 35){ // checking if finalPrice needs a delivery fee
               
               finalPrice = finalPrice + deliveryfee; // adding Delivery fee to finalPrice
                System.out.println("                        Delivery fee:   € 5.00");
                System.out.println("                          Item total:   € " + finalPrice );
                System.out.println("       \nTHANK YOU FOR SHOPPING WITH US =)\n");
            
           }else{ //finalPrice with free Delivery
                System.out.println("       Delivery fee:   free");
                System.out.println("           Total is:   € " + finalPrice );
                System.out.println("\nTHANK YOU FOR SHOPPING WITH US =)\n");
           }

}

    // end Printing the final bag 

    // #####################################################################################################################################
    
    // remove items
     public static void removeItem (ArrayList<ShoppingBag> itemRemove) { 
  
     // printing the instruction for users to delete items or finish the shopping   
     System.out.println("To remove Items from your Shopping Bag follow the options below:");
     System.out.println("#1 - DELETE SINGLE ITEM: choose by ID");
     System.out.println("#2 - DELETE ALL ITEM TYPE: all");
     System.out.println("#3 - FINISH YOUR SHOPPING TYPE: pay");
     
     intInput = sc.readInteger(error); // getting users input
     deleteOption = sc.strInput; // setting users input to variable deleteOption 
     
     if (deleteOption.contains("all")){ // if user want to delete all the items in the bag   
         itemRemove.clear(); // delete all the items in the bag
         System.out.println("\n## You choose delete aLl, Now your bag is empty");
         System.exit(0);// stop the program
     } 
     else if (deleteOption.contains("pay")){ // if user wants to finish, print final bag and finish the program
         printFinalBag(itemRemove);
         System.exit(0);// stop the program
 
     } else{ // if user wants to delete single item
       
             while (!deleteOption.contains("pay" ) || !deleteOption.contains("all") )  { // checking if user wants to leave or keeping deleting
                 
            // checking if the user input is greater than 0 and Less than ArrayList size
             while (intInput >= itemRemove.size() || intInput < 0){ // check if the input is on the range of the Arraylist size
                // Message error after a wrong input 
                System.out.println("\n## ERROR! ## - choose a number between 0 to " + (itemRemove.size() -1) );
                intInput = sc.readInteger( error); // getting next input
             }

            int idRemove =  intInput; // setting the user input to idRemove to remove the item 

            if (itemRemove.size() == 1){ // checking if there just one item in the bag. if it is true run the code below and finish the program 
                
                System.out.println("\nYou removed the last item in your bag: " ); // Message 'last item was successfully deleted
                itemRemove.remove(idRemove); // remove the last item
                System.out.println("Now your bag is empty \nTHANK YOU FOR YOUR VISIT =]\n");
                System.exit(0); // stop the program
            
            }
            else if (deleteOption.contains("pay")) { // if user chooses finish type "pay"
            printBag(itemRemove, 2);
            }
            else
            {
            System.out.println("\nYou have removed " + itemRemove.get(idRemove).getName().trim()); // Message that item was successfully deleted
            itemRemove.remove(idRemove);

            printBag(itemRemove, 2);

            }
        }
         
       }      
             
        if (intInput > 0) {
        printFinalBag(itemRemove); 
        }     
                
    }
    // end remove Items     
    
    
}