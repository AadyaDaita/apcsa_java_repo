package com.nighthawk.spring_portfolio;
import java.util.Scanner;

class Classes1 {
    public static void main(String[] args) {
      Scanner input = new Scanner(System.in);  // Create a Scanner object
      System.out.println("Enter something");
      String something = input.nextLine();  // Read user input

      boolean period = false;
      if (something.contains(".")){
        period = true;
      }

      boolean a = false;
      if (something.contains("a")){
        a = true;
      }

      boolean b = false;
      if (something.contains("b")){
        b = true;
      }

      boolean five_plus = false;

      if(something.length() >= 5){
        five_plus = true;
        System.out.println("something has 5 or more letters");
      }

      else{
        System.out.print("something does not contain more than 5 letters. ");
      }


    if(five_plus && !period ){
        System.out.println(" something has more than 5 letters AND doesn't contain a period");
   
    }
    else{
        System.out.println("  something has less than 5 letters AND contains a period");

    }
    



    if(a || b ){
        System.out.println("something contains the letter a OR contains the letter b");
    }
    else{
        System.out.println("something doesn't contain the letter a OR contain the letter b");

    }


    
    if ((five_plus && !period) && (a || b)) {
        System.out.println("something has more that 5 letters and doesn't contain a period AND something has either the letter a or the letter b");
    }
    else{
        System.out.println("something has less that 5 letters and contains a period. cannot say for sure if something contains a or b");
    }


    if (! ((!five_plus || b) || (a && period) )) { //DeMorgan's law
        System.out.println("De Morgan's law with code that I cannot explain through writing");
    }
    else{
        System.out.println("De Morgan's law with code, if it doesn't work");
    }




      
        

 
          

        
    
      }
   
    


     
    }
  

