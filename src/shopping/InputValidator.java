package shopping;
import java.util.Scanner;

class InputValidator {
    
    String strInput;

    private final Scanner in;
    static String error = "\n## ERROR! ## -  It's not a valid number, please try again.";
    static InputValidator sc = new InputValidator();
    static String itemName;
    static double itemPrice;
    static int amountItems = 0;
    static int intInput;
    static String exit;
    static String deleteOption;

InputValidator() { in = new Scanner(System.in); }

public int readInteger( String errorMsg) {
    
 int num = 0;
 boolean valid = false;
 
 while (valid == false){
 
     strInput = in.nextLine();  // /Getting the input from the user
     strInput = strInput.toLowerCase(); // changing the string to lowercase in case of the user types "EXIT" for example
     
     try{ 
 
     num = Integer.parseInt(strInput); //  try to converte String to integer
     valid = true; // if find a valid number, change valid to true
     
     }
     catch (NumberFormatException e) {
         // checking exceptations words to set valid to true
         if ("exit".equals(strInput) || "pay".equals(strInput) || "all".equals(strInput)) {
          valid = true;
         }
         else { // if user didn't type a numb9er
             System.out.println(errorMsg);
         }
     }

 }
    
 return num;
}  
}