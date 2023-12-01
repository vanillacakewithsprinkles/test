import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;
import java.lang.Math;
import java.util.Random;
import java.awt.Desktop;

public class main
{
public static void main(String[]args) throws Exception{
    ArrayList<character> benchplayerone = new ArrayList<character>();
    ArrayList<character> benchplayertwo = new ArrayList<character>();
        int inputNum = 0;
        Scanner menu = new Scanner(System.in);
        Scanner sc1 = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);
        File deckone = new File("deck1.txt");
        File decktwo = new File("deck2.txt");
    while(inputNum != 6){
    System.out.println("please pick a menu item");
    System.out.println("press 1 to load your character");
    System.out.println("press 2 to add a new character");
    System.out.println("press 3 to view your characters");
    System.out.println("press 4 to edit a character");
    System.out.println("press 5 to battle");
    System.out.println("press 6 to quit");
     inputNum = menu.nextInt();
     if(inputNum == 1){
         System.out.println("please type one to load player one's characters, two to load player two's or three to load both.");
         int choice = sc2.nextInt();
         if(choice == 1){
             System.out.println("your characters hav been loaded (player 1):");
         for (int i=0;i<loadCharacters(deckone).size();i++){
        benchplayerone.add(loadCharacters(deckone).get(i));
        System.out.println("character #"+i);
        System.out.println(benchplayerone.get(i).getName()+" "+benchplayerone.get(i).getAttack()+" "+benchplayerone.get(i).getDefense()+" "+benchplayerone.get(i).getHealth()+" "+benchplayerone.get(i).getSpeed());
       }
         }
         else if(choice == 2){
             System.out.println("your characters hav been loaded (player 2):");
       for (int i=0;i<loadCharacters(decktwo).size();i++){
        benchplayertwo.add(loadCharacters(decktwo).get(i));
        System.out.println("character #"+i);
        System.out.println(benchplayertwo.get(i).getName()+" "+benchplayertwo.get(i).getAttack()+" "+benchplayertwo.get(i).getDefense()+" "+benchplayertwo.get(i).getHealth()+" "+benchplayertwo.get(i).getSpeed());
       }
         }
         else if(choice == 3){
         System.out.println("your characters hav been loaded (player 1):");
         for (int i=0;i<loadCharacters(deckone).size();i++){
        benchplayerone.add(loadCharacters(deckone).get(i));
        System.out.println("character #"+i);
        System.out.println(benchplayerone.get(i).getName()+" "+benchplayerone.get(i).getAttack()+" "+benchplayerone.get(i).getDefense()+" "+benchplayerone.get(i).getHealth()+" "+benchplayerone.get(i).getSpeed());
       }
       System.out.println("your characters hav been loaded (player 2):");
       for (int i=0;i<loadCharacters(decktwo).size();i++){
        benchplayertwo.add(loadCharacters(decktwo).get(i));
        System.out.println("character #"+i);
        System.out.println(benchplayertwo.get(i).getName()+" "+benchplayertwo.get(i).getAttack()+" "+benchplayertwo.get(i).getDefense()+" "+benchplayertwo.get(i).getHealth()+" "+benchplayertwo.get(i).getSpeed());
       }
    }
    }
    
    else if(inputNum == 2){
        int a, d, h, s;
        String n;
        System.out.println("please enter one to create a new character for player one, or two to create a new character for player two");
       int newcharchoice = sc2.nextInt();
       if(newcharchoice == 1){
          System.out.println("enter the name, attack, defense, health and speed.");
            System.out.println("press enter after each input.");
            n = sc1.nextLine();
            a = sc2.nextInt();
            d = sc2.nextInt();
            h = sc2.nextInt();
            s = sc2.nextInt();
            sc1.nextLine(); //absorbs the enter key for the next string input
            benchplayerone.add(createNewCharacter(n, a, d, h, s, deckone, benchplayerone)); 
       }
      else if(newcharchoice == 2){
          System.out.println("enter the name, attack, defense, health and speed.");
            System.out.println("press enter after each input.");
            n = sc1.nextLine();
            a = sc2.nextInt();
            d = sc2.nextInt();
            h = sc2.nextInt();
            s = sc2.nextInt();
            sc1.nextLine(); //absorbs the enter key for the next string input
            benchplayertwo.add(createNewCharacter(n, a, d, h, s, deckone, benchplayertwo)); 
       }
    }
    else if(inputNum == 3){
        System.out.println("press one to view playerone's characters, press two for playertwo's characters, or press three to view all characters");
        int viewchoice = sc2.nextInt();
        if(viewchoice == 1){
            System.out.println("printing characters for player one..");
           printdeck(benchplayerone);
        }
        else if(viewchoice == 2){
            System.out.println("printing characters for player two..");
             printdeck(benchplayertwo);
        }
         else if(viewchoice == 3){
              System.out.println("printing characters for player one..");
           printdeck(benchplayerone);
            System.out.println("printing characters for player two..");
             printdeck(benchplayertwo);
       
        }
    }
    else if(inputNum == 4){
        System.out.println("press one for playerone, two for playertwo");
       int editchoice = sc2.nextInt();
        if(editchoice == 1){
        System.out.println("what character do you want to edit? enter the character number: ");
       int characterNumber = sc2.nextInt();
        System.out.println("your chosen character to change's stats are: "+benchplayerone.get(characterNumber).getName()+" "+benchplayerone.get(characterNumber).getAttack()+" "+benchplayerone.get(characterNumber).getDefense()+" "+benchplayerone.get(characterNumber).getHealth()+" "+benchplayerone.get(characterNumber).getSpeed());
        System.out.println("what stat do you want to change? enter n (name), a (attack), d (defense), h (health), or s(speed)");
        Character statChange = sc1.nextLine().charAt(0);
            if(statChange == 'n'){
               System.out.println("input your name change for your character: ");
               String newName = sc1.nextLine();
              character repChar = editCharacter(newName, benchplayerone.get(characterNumber).getAttack(), benchplayerone.get(characterNumber).getDefense(), benchplayerone.get(characterNumber).getHealth(), benchplayerone.get(characterNumber).getSpeed(),characterNumber, deckone, benchplayerone);
           benchplayerone.set(characterNumber,repChar);
            }
            else if(statChange == 'a'){
               System.out.println("input your attack change for your character: ");
               float newAttack = sc2.nextInt();
              character repChar = editCharacter(benchplayerone.get(characterNumber).getName(), newAttack, benchplayerone.get(characterNumber).getDefense(), benchplayerone.get(characterNumber).getHealth(), benchplayerone.get(characterNumber).getSpeed(),characterNumber, deckone, benchplayerone);
            benchplayerone.set(characterNumber,repChar);
            }
            else if(statChange == 'd'){
               System.out.println("input your defense change for your character: ");
               float newDefense = sc2.nextInt();
              character repChar = editCharacter(benchplayerone.get(characterNumber).getName(), benchplayerone.get(characterNumber).getAttack(), newDefense, benchplayerone.get(characterNumber).getHealth(), benchplayerone.get(characterNumber).getSpeed(),characterNumber, deckone, benchplayerone);
            benchplayerone.set(characterNumber,repChar);
            }
            else if(statChange == 'h'){
               System.out.println("input your health change for your character: ");
               float newHealth = sc2.nextInt();
              character repChar = editCharacter(benchplayerone.get(characterNumber).getName(), benchplayerone.get(characterNumber).getAttack(), benchplayerone.get(characterNumber).getDefense(), newHealth, benchplayerone.get(characterNumber).getSpeed(),characterNumber, deckone, benchplayerone);
            benchplayerone.set(characterNumber,repChar);
            }
            else if(statChange == 's'){
               System.out.println("input your speed change for your character: ");
               float newSpeed = sc2.nextInt();
              character repChar = editCharacter(benchplayerone.get(characterNumber).getName(), benchplayerone.get(characterNumber).getAttack(), benchplayerone.get(characterNumber).getDefense(), benchplayerone.get(characterNumber).getHealth(), newSpeed,characterNumber, deckone, benchplayerone);
              benchplayerone.set(characterNumber,repChar);
            }
        }
        else if(editchoice == 2){
            System.out.println("what character do you want to edit? enter the character number: ");
       int characterNumber = sc2.nextInt();
        System.out.println("your chosen character to change's stats are: "+benchplayertwo.get(characterNumber).getName()+" "+benchplayertwo.get(characterNumber).getAttack()+" "+benchplayertwo.get(characterNumber).getDefense()+" "+benchplayertwo.get(characterNumber).getHealth()+" "+benchplayertwo.get(characterNumber).getSpeed());
        System.out.println("what stat do you want to change? enter n (name), a (attack), d (defense), h (health), or s(speed)");
        Character statChange = sc1.nextLine().charAt(0);
            if(statChange == 'n'){
               System.out.println("input your name change for your character: ");
               String newName = sc1.nextLine();
              character repChar = editCharacter(newName, benchplayertwo.get(characterNumber).getAttack(), benchplayertwo.get(characterNumber).getDefense(), benchplayertwo.get(characterNumber).getHealth(), benchplayertwo.get(characterNumber).getSpeed(),characterNumber, deckone, benchplayertwo);
            benchplayertwo.set(characterNumber,repChar);
            }
            else if(statChange == 'a'){
               System.out.println("input your attack change for your character: ");
               float newAttack = sc2.nextInt();
              character repChar = editCharacter(benchplayertwo.get(characterNumber).getName(), newAttack, benchplayertwo.get(characterNumber).getDefense(), benchplayertwo.get(characterNumber).getHealth(), benchplayertwo.get(characterNumber).getSpeed(),characterNumber, deckone, benchplayertwo);
            benchplayertwo.set(characterNumber,repChar);
            }
            else if(statChange == 'd'){
               System.out.println("input your defense change for your character: ");
               float newDefense = sc2.nextInt();
              character repChar = editCharacter(benchplayertwo.get(characterNumber).getName(), benchplayertwo.get(characterNumber).getAttack(), newDefense, benchplayertwo.get(characterNumber).getHealth(), benchplayertwo.get(characterNumber).getSpeed(),characterNumber, deckone, benchplayertwo);
            benchplayertwo.set(characterNumber,repChar);
            }
            else if(statChange == 'h'){
               System.out.println("input your health change for your character: ");
               float newHealth = sc2.nextInt();
              character repChar = editCharacter(benchplayertwo.get(characterNumber).getName(), benchplayertwo.get(characterNumber).getAttack(), benchplayertwo.get(characterNumber).getDefense(), newHealth, benchplayertwo.get(characterNumber).getSpeed(),characterNumber, deckone, benchplayertwo);
            benchplayertwo.set(characterNumber,repChar);
            }
            else if(statChange == 's'){
               System.out.println("input your speed change for your character: ");
               float newSpeed = sc2.nextInt();
              character repChar = editCharacter(benchplayertwo.get(characterNumber).getName(), benchplayertwo.get(characterNumber).getAttack(), benchplayertwo.get(characterNumber).getDefense(), benchplayertwo.get(characterNumber).getHealth(), newSpeed,characterNumber, deckone, benchplayertwo);
              benchplayertwo.set(characterNumber,repChar);
            }
        }
    }
    else if(inputNum == 5){
        ArrayList<item> playeronebag = new ArrayList();
        
        ArrayList<item> playertwobag = new ArrayList();
        System.out.println("battle has begun");
        System.out.println("player one, choose your character:");
        int p1pick = sc2.nextInt();
        System.out.println("player two, choose your character:");
        
        int p2pick = sc2.nextInt();
        int optionmenuplayerone = 0;
        int optionmenuplayertwo = 0;
        boolean defenseplayerone =false;
        boolean defenseplayertwo = false;
        boolean check = flipacoin(benchplayerone.get(p1pick).getSpeed(),benchplayertwo.get(p2pick).getSpeed());
        if (check == true){
        
        while(optionmenuplayerone != 5){
    System.out.println("press 1 to attack");
    System.out.println("press 2 to defend");
    System.out.println("press 3 to heal");
    System.out.println("press 4 to swap characters");
    System.out.println("press 5 to forfeit and retreat");
     optionmenuplayerone = menu.nextInt();
     if(optionmenuplayerone == 1){
         System.out.println(benchplayerone.get(p1pick).getName()+" is now attacking "+benchplayertwo.get(p2pick).getName());
         if(defenseplayertwo == true){
             character defensechar = new character(benchplayertwo.get(p2pick).getName(), benchplayertwo.get(p2pick).getAttack(), (benchplayertwo.get(p2pick).getDefense()*2), benchplayertwo.get(p2pick).getHealth(), benchplayertwo.get(p2pick).getSpeed());
         benchplayertwo.set(p2pick, FIGHT(defensechar, benchplayerone.get(p1pick), benchplayertwo, p2pick, decktwo));
     }
     else if(defenseplayertwo == false){
         benchplayertwo.set(p2pick, FIGHT(benchplayertwo.get(p2pick), benchplayerone.get(p1pick), benchplayertwo, p2pick, decktwo));
     }
     defenseplayertwo = false;
     boolean fullcheckhp = hpcheck(benchplayertwo);
     boolean checkhp = hpcheckcurrentplayer(benchplayertwo.get(p2pick));
     if(fullcheckhp == true){
         System.out.println("player two has lost the battle");
         optionmenuplayerone = 6;
         optionmenuplayertwo = 6;
     }
     if(checkhp == true){
         System.out.println("player two, your character has run out of hp and fainted");
         System.out.println("remaining characters: ");
         for(int i = 0; i<benchplayerone.size();i++){
             int j = 0;
             if(benchplayertwo.get(i).getHealth() > 0){
                 System.out.println("character #"+j);
                 j++;
                 System.out.println(benchplayertwo.get(i).getName()+" "+benchplayertwo.get(i).getAttack()+" "+benchplayertwo.get(i).getDefense()+" "+benchplayertwo.get(i).getHealth()+" "+benchplayertwo.get(i).getSpeed());
             }
         }
         System.out.println("what character would you like use next?");
         int prevpick = p2pick;
         p2pick = sc2.nextInt();
          System.out.println("you have swapped: "+benchplayertwo.get(prevpick).getName()+" "+benchplayertwo.get(prevpick).getAttack()+" "+benchplayertwo.get(prevpick).getDefense()+" "+benchplayertwo.get(prevpick).getHealth()+" "+benchplayertwo.get(prevpick).getSpeed()+" with "+benchplayertwo.get(p2pick).getName()+" "+benchplayertwo.get(p2pick).getAttack()+" "+benchplayertwo.get(p2pick).getDefense()+" "+benchplayertwo.get(p2pick).getHealth()+" "+benchplayertwo.get(p2pick).getSpeed());
     }
     }
    
     else if(optionmenuplayerone == 2){
          defenseplayerone = true;
     }
     else if(optionmenuplayerone == 3){
         System.out.println("please enter the number one of the items: ");
         int itemchoice = sc2.nextInt();
         character repChar = editCharacterhealth(benchplayerone.get(p1pick).getName(), benchplayerone.get(p1pick).getAttack(), benchplayerone.get(p1pick).getDefense(), (benchplayerone.get(p1pick).getHealth()+playeronebag.get(itemchoice).getHealthgain()), benchplayertwo.get(p1pick).getSpeed(), deckone, benchplayerone);   
         benchplayerone.set(p1pick,repChar);
         item newitem = new item (playeronebag.get(itemchoice).getName(), playeronebag.get(itemchoice).getHealthgain(), (playeronebag.get(itemchoice).getAmount()-1));
         playeronebag.set(itemchoice,newitem);
     }
     else if(optionmenuplayerone == 4){
        System.out.println("remaining characters: ");
         for(int i = 0; i<benchplayerone.size();i++){
             int j = 0;
             if(benchplayerone.get(i).getHealth() > 0){
                 System.out.println("character #"+j);
                 j++;
                 System.out.println(benchplayerone.get(i).getName()+" "+benchplayerone.get(i).getAttack()+" "+benchplayerone.get(i).getDefense()+" "+benchplayerone.get(i).getHealth()+" "+benchplayerone.get(i).getSpeed());
             }
         }
         System.out.println("what character would you like to swap your character for?");
         int prevpick = p1pick;
         p1pick = sc2.nextInt();
          System.out.println("you have swapped: "+benchplayerone.get(prevpick).getName()+" "+benchplayerone.get(prevpick).getAttack()+" "+benchplayerone.get(prevpick).getDefense()+" "+benchplayerone.get(prevpick).getHealth()+" "+benchplayerone.get(prevpick).getSpeed()+" with "+benchplayerone.get(p1pick).getName()+" "+benchplayerone.get(p1pick).getAttack()+" "+benchplayerone.get(p1pick).getDefense()+" "+benchplayerone.get(p1pick).getHealth()+" "+benchplayerone.get(p1pick).getSpeed());
     }
     if(optionmenuplayerone ==5){
    System.out.println("Player one has forfeited the game. in forfeiting, player one has lost the battle");
    optionmenuplayertwo = 6; optionmenuplayerone = 6;
}
     while(optionmenuplayertwo != 5){
    System.out.println("press 1 to attack");
    System.out.println("press 2 to defend");
    System.out.println("press 3 to heal");
    System.out.println("press 4 to swap characters");
    System.out.println("press 5 to forfeit and retreat");
     optionmenuplayertwo = menu.nextInt();
     if(optionmenuplayertwo == 1){
         System.out.println(benchplayertwo.get(p2pick).getName()+" is now attacking "+benchplayerone.get(p1pick).getName());
         if(defenseplayerone == true){
             character defensechar = new character(benchplayerone.get(p1pick).getName(), benchplayerone.get(p1pick).getAttack(), (benchplayerone.get(p1pick).getDefense()*2), benchplayerone.get(p1pick).getHealth(), benchplayerone.get(p1pick).getSpeed());
         benchplayerone.set(p1pick, FIGHT(defensechar, benchplayertwo.get(p2pick), benchplayerone, p1pick, deckone));
     }
     else if(defenseplayertwo == false){
         benchplayertwo.set(p2pick, FIGHT(benchplayerone.get(p1pick), benchplayertwo.get(p2pick), benchplayerone, p1pick, deckone));
     }
     defenseplayertwo = false;
     boolean fullcheckhp = hpcheck(benchplayerone);
     boolean checkhp = hpcheckcurrentplayer(benchplayerone.get(p1pick));
     if(fullcheckhp == true){
         System.out.println("player one has lost the battle");
         optionmenuplayerone = 6;
         optionmenuplayertwo = 6;
     }
     if(checkhp == true){
         System.out.println("player one, your character has run out of hp and fainted");
         System.out.println("remaining characters: ");
         for(int i = 0; i<benchplayerone.size();i++){
             int j = 0;
             if(benchplayerone.get(i).getHealth() > 0){
                 System.out.println("character #"+j);
                 j++;
                 System.out.println(benchplayerone.get(i).getName()+" "+benchplayerone.get(i).getAttack()+" "+benchplayerone.get(i).getDefense()+" "+benchplayerone.get(i).getHealth()+" "+benchplayerone.get(i).getSpeed());
             }
         }
         System.out.println("what character would you like use next?");
         int prevpick = p1pick;
         p1pick = sc2.nextInt();
          System.out.println("you have swapped: "+benchplayerone.get(prevpick).getName()+" "+benchplayerone.get(prevpick).getAttack()+" "+benchplayerone.get(prevpick).getDefense()+" "+benchplayerone.get(prevpick).getHealth()+" "+benchplayerone.get(prevpick).getSpeed()+" with "+benchplayerone.get(p1pick).getName()+" "+benchplayerone.get(p1pick).getAttack()+" "+benchplayerone.get(p1pick).getDefense()+" "+benchplayerone.get(p1pick).getHealth()+" "+benchplayerone.get(p1pick).getSpeed());
     }
    }
     else if(optionmenuplayertwo == 2){
          defenseplayertwo = true;
     }
     else if(optionmenuplayertwo == 3){
         printitems(playertwobag);
         System.out.println("please enter the number one of the items: ");
         int itemchoice = sc2.nextInt();
         System.out.println("which character would you like to apply the item to? ");
            printdeck(benchplayertwo);
        int itemapply = sc2.nextInt();
         character repChar = editCharacterhealth(benchplayertwo.get(itemapply).getName(), benchplayertwo.get(itemapply).getAttack(), benchplayertwo.get(itemapply).getDefense(), (benchplayertwo.get(itemapply).getHealth()+playertwobag.get(itemchoice).getHealthgain()), benchplayertwo.get(itemapply).getSpeed(), decktwo, benchplayertwo);   
         benchplayerone.set(p1pick,repChar);
         item newitem = new item (playertwobag.get(itemchoice).getName(), playertwobag.get(itemchoice).getHealthgain(), (playertwobag.get(itemchoice).getAmount()-1));
         playertwobag.set(itemchoice,newitem);
     }
     else if(optionmenuplayertwo == 4){
        System.out.println("remaining characters: ");
         for(int i = 0; i<benchplayertwo.size();i++){
             int j = 0;
             if(benchplayertwo.get(i).getHealth() > 0){
                 System.out.println("character #"+j);
                 j++;
                 System.out.println(benchplayertwo.get(i).getName()+" "+benchplayertwo.get(i).getAttack()+" "+benchplayertwo.get(i).getDefense()+" "+benchplayertwo.get(i).getHealth()+" "+benchplayertwo.get(i).getSpeed());
             }
         }
         System.out.println("what character would you like to swap your character for?");
         int prevpick = p2pick;
         p2pick = sc2.nextInt();
          System.out.println("you have swapped: "+benchplayertwo.get(prevpick).getName()+" "+benchplayertwo.get(prevpick).getAttack()+" "+benchplayertwo.get(prevpick).getDefense()+" "+benchplayertwo.get(prevpick).getHealth()+" "+benchplayertwo.get(prevpick).getSpeed()+" with "+benchplayertwo.get(p2pick).getName()+" "+benchplayertwo.get(p2pick).getAttack()+" "+benchplayertwo.get(p2pick).getDefense()+" "+benchplayertwo.get(p2pick).getHealth()+" "+benchplayertwo.get(p2pick).getSpeed());
     }
     if(optionmenuplayertwo ==5){
    System.out.println("Player two has forfeited the game. in forfeiting, player two has lost the battle");
    optionmenuplayertwo = 6; optionmenuplayerone = 6;
}
  }
}
}
else if(check == false){
    while(optionmenuplayertwo != 6){
    System.out.println("press 1 to attack");
    System.out.println("press 2 to defend");
    System.out.println("press 3 to heal");
    System.out.println("press 4 to swap characters");
    System.out.println("press 5 to forfeit and retreat");
     optionmenuplayertwo = menu.nextInt();
     if(optionmenuplayertwo == 1){
         System.out.println(benchplayertwo.get(p2pick).getName()+" is now attacking "+benchplayerone.get(p1pick).getName());
         if(defenseplayerone == true){
             character defensechar = new character(benchplayerone.get(p1pick).getName(), benchplayerone.get(p1pick).getAttack(), (benchplayerone.get(p1pick).getDefense()*2), benchplayerone.get(p1pick).getHealth(), benchplayerone.get(p1pick).getSpeed());
         benchplayerone.set(p1pick, FIGHT(defensechar, benchplayertwo.get(p2pick), benchplayerone, p1pick, deckone));
     }
     else if(defenseplayerone == false){
         benchplayertwo.set(p2pick, FIGHT(benchplayerone.get(p1pick), benchplayertwo.get(p2pick), benchplayerone, p1pick, deckone));
     }
     defenseplayertwo = false;
     boolean fullcheckhp = hpcheck(benchplayerone);
     boolean checkhp = hpcheckcurrentplayer(benchplayerone.get(p1pick));
     if(fullcheckhp == true){
         System.out.println("player one has lost the battle");
         optionmenuplayerone = 6;
         optionmenuplayertwo = 6;
     }
     if(checkhp == true){
         System.out.println("player one, your character has run out of hp and fainted");
         System.out.println("remaining characters: ");
         for(int i = 0; i<benchplayerone.size();i++){
             int j = 0;
             if(benchplayerone.get(i).getHealth() > 0){
                 System.out.println("character #"+j);
                 j++;
                 System.out.println(benchplayerone.get(i).getName()+" "+benchplayerone.get(i).getAttack()+" "+benchplayerone.get(i).getDefense()+" "+benchplayerone.get(i).getHealth()+" "+benchplayerone.get(i).getSpeed());
             }
         }
         System.out.println("what character would you like use next?");
         int prevpick = p1pick;
         p1pick = sc2.nextInt();
          System.out.println("you have swapped: "+benchplayerone.get(prevpick).getName()+" "+benchplayerone.get(prevpick).getAttack()+" "+benchplayerone.get(prevpick).getDefense()+" "+benchplayerone.get(prevpick).getHealth()+" "+benchplayerone.get(prevpick).getSpeed()+" with "+benchplayerone.get(p1pick).getName()+" "+benchplayerone.get(p1pick).getAttack()+" "+benchplayerone.get(p1pick).getDefense()+" "+benchplayerone.get(p1pick).getHealth()+" "+benchplayerone.get(p1pick).getSpeed());
     }
    }
     else if(optionmenuplayertwo == 2){
          defenseplayertwo = true;
     }
     else if(optionmenuplayertwo == 3){
         printitems(playertwobag);
         System.out.println("please enter the number one of the items: ");
         int itemchoice = sc2.nextInt();
         System.out.println("which character would you like to apply the item to? ");
            printdeck(benchplayertwo);
        int itemapply = sc2.nextInt();
         character repChar = editCharacterhealth(benchplayertwo.get(itemapply).getName(), benchplayertwo.get(itemapply).getAttack(), benchplayertwo.get(itemapply).getDefense(), (benchplayertwo.get(itemapply).getHealth()+playertwobag.get(itemchoice).getHealthgain()), benchplayertwo.get(itemapply).getSpeed(), decktwo, benchplayertwo);   
         benchplayerone.set(p1pick,repChar);
         item newitem = new item (playertwobag.get(itemchoice).getName(), playertwobag.get(itemchoice).getHealthgain(), (playertwobag.get(itemchoice).getAmount()-1));
         playertwobag.set(itemchoice,newitem);
     }
     else if(optionmenuplayertwo == 4){
        System.out.println("remaining characters: ");
         for(int i = 0; i<benchplayertwo.size();i++){
             int j = 0;
             if(benchplayertwo.get(i).getHealth() > 0){
                 System.out.println("character #"+j);
                 j++;
                 System.out.println(benchplayertwo.get(i).getName()+" "+benchplayertwo.get(i).getAttack()+" "+benchplayertwo.get(i).getDefense()+" "+benchplayertwo.get(i).getHealth()+" "+benchplayertwo.get(i).getSpeed());
             }
         }
         System.out.println("what character would you like to swap your character for?");
         int prevpick = p2pick;
         p2pick = sc2.nextInt();
          System.out.println("you have swapped: "+benchplayertwo.get(prevpick).getName()+" "+benchplayertwo.get(prevpick).getAttack()+" "+benchplayertwo.get(prevpick).getDefense()+" "+benchplayertwo.get(prevpick).getHealth()+" "+benchplayertwo.get(prevpick).getSpeed()+" with "+benchplayertwo.get(p2pick).getName()+" "+benchplayertwo.get(p2pick).getAttack()+" "+benchplayertwo.get(p2pick).getDefense()+" "+benchplayertwo.get(p2pick).getHealth()+" "+benchplayertwo.get(p2pick).getSpeed());
     }
     if(optionmenuplayertwo ==5){
    System.out.println("Player two has forfeited the game. in forfeiting, player two has lost the battle");
    optionmenuplayertwo = 6;optionmenuplayerone =6;
}
     while(optionmenuplayerone != 5){
    System.out.println("press 1 to attack");
    System.out.println("press 2 to defend");
    System.out.println("press 3 to heal");
    System.out.println("press 4 to swap characters");
    System.out.println("press 5 to forfeit and retreat");
     optionmenuplayerone = menu.nextInt();
     if(optionmenuplayerone == 1){
         System.out.println(benchplayerone.get(p1pick).getName()+" is now attacking "+benchplayertwo.get(p2pick).getName());
         if(defenseplayertwo == true){
             character defensechar = new character(benchplayertwo.get(p2pick).getName(), benchplayertwo.get(p2pick).getAttack(), (benchplayertwo.get(p2pick).getDefense()*2), benchplayertwo.get(p2pick).getHealth(), benchplayertwo.get(p2pick).getSpeed());
         benchplayertwo.set(p2pick, FIGHT(defensechar, benchplayerone.get(p1pick), benchplayertwo, p2pick, decktwo));
         
     }
     else if(defenseplayertwo == false){
         benchplayertwo.set(p2pick, FIGHT(benchplayertwo.get(p2pick), benchplayerone.get(p1pick), benchplayertwo, p2pick, decktwo));
     }
     defenseplayertwo = false;
     boolean fullcheckhp = hpcheck(benchplayertwo);
     boolean checkhp = hpcheckcurrentplayer(benchplayertwo.get(p2pick));
     if(fullcheckhp == true){
         System.out.println("player two has lost the battle");
         optionmenuplayerone = 6;
         optionmenuplayertwo = 6;
     }
     if(checkhp == true){
         System.out.println("player two, your character has run out of hp and fainted");
         System.out.println("remaining characters: ");
         for(int i = 0; i<benchplayerone.size();i++){
             int j = 0;
             if(benchplayertwo.get(i).getHealth() > 0){
                 System.out.println("character #"+j);
                 j++;
                 System.out.println(benchplayertwo.get(i).getName()+" "+benchplayertwo.get(i).getAttack()+" "+benchplayertwo.get(i).getDefense()+" "+benchplayertwo.get(i).getHealth()+" "+benchplayertwo.get(i).getSpeed());
             }
         }
         System.out.println("what character would you like use next?");
         int prevpick = p2pick;
         p2pick = sc2.nextInt();
          System.out.println("you have swapped: "+benchplayertwo.get(prevpick).getName()+" "+benchplayertwo.get(prevpick).getAttack()+" "+benchplayertwo.get(prevpick).getDefense()+" "+benchplayertwo.get(prevpick).getHealth()+" "+benchplayertwo.get(prevpick).getSpeed()+" with "+benchplayertwo.get(p2pick).getName()+" "+benchplayertwo.get(p2pick).getAttack()+" "+benchplayertwo.get(p2pick).getDefense()+" "+benchplayertwo.get(p2pick).getHealth()+" "+benchplayertwo.get(p2pick).getSpeed());
     }
    }
     else if(optionmenuplayerone == 2){
          defenseplayerone = true;
     }
     else if(optionmenuplayerone == 3){
         printitems(playeronebag);
         System.out.println("please enter the number one of the items: ");
         int itemchoice = sc2.nextInt();
            System.out.println("which character would you like to apply the item to? ");
            printdeck(benchplayerone);
        int itemapply = sc2.nextInt();
         character repChar = editCharacterhealth(benchplayerone.get(itemapply).getName(), benchplayerone.get(itemapply).getAttack(), benchplayerone.get(itemapply).getDefense(), (benchplayerone.get(itemapply).getHealth()+playeronebag.get(itemchoice).getHealthgain()), benchplayerone.get(itemapply).getSpeed(), deckone, benchplayerone);   
         benchplayerone.set(p1pick,repChar);
         item newitem = new item (playeronebag.get(itemchoice).getName(), playeronebag.get(itemchoice).getHealthgain(), (playeronebag.get(itemchoice).getAmount()-1));
         playeronebag.set(itemchoice,newitem);
     }
     else if(optionmenuplayerone == 4){
        System.out.println("remaining characters: ");
         for(int i = 0; i<benchplayerone.size();i++){
             int j = 0;
             if(benchplayerone.get(i).getHealth() > 0){
                 System.out.println("character #"+j);
                 j++;
                 System.out.println(benchplayerone.get(i).getName()+" "+benchplayerone.get(i).getAttack()+" "+benchplayerone.get(i).getDefense()+" "+benchplayerone.get(i).getHealth()+" "+benchplayerone.get(i).getSpeed());
             }
         }
         System.out.println("what character would you like to swap your character for?");
         int prevpick = p1pick;
         p1pick = sc2.nextInt();
          System.out.println("you have swapped: "+benchplayerone.get(prevpick).getName()+" "+benchplayerone.get(prevpick).getAttack()+" "+benchplayerone.get(prevpick).getDefense()+" "+benchplayerone.get(prevpick).getHealth()+" "+benchplayerone.get(prevpick).getSpeed()+" with "+benchplayerone.get(p1pick).getName()+" "+benchplayerone.get(p1pick).getAttack()+" "+benchplayerone.get(p1pick).getDefense()+" "+benchplayerone.get(p1pick).getHealth()+" "+benchplayerone.get(p1pick).getSpeed());
     }
          if(optionmenuplayerone ==5){
    System.out.println("Player one has forfeited the game. in forfeiting, player one has lost the battle");
    optionmenuplayertwo = 6; optionmenuplayerone = 6;
}
    }
}
}
}
}
}
// this is the method that loads characters from a text file into an ArrayList.
    public static ArrayList<character> loadCharacters (File f) throws Exception{
    Scanner inFile1 = new Scanner(f); 
    Scanner inFile2 = new Scanner(f);
    String name = " "; 
    int a = 0; 
    int d = 0; 
    int h = 0; 
    int s= 0;
    int i = 0;
    ArrayList<character> charholder = new ArrayList(); 
    while (inFile1.hasNextLine()){
       name = inFile1.next();
       a = Integer.parseInt(inFile1.next());
       d =Integer.parseInt(inFile1.next());
       h = Integer.parseInt(inFile1.next());
       s = Integer.parseInt(inFile1.next());
       int sumstats = a+d+h+s;
        float rationer = 500/sumstats;
        int ra = Math.round(rationer*a);
        int rd = Math.round(rationer*d);
        int rh = Math.round(rationer*h);
        int rs = Math.round(rationer*s);
       charholder.add(new character (name, ra, rd, rh, rs));
       i++;
    }
    return charholder;
}

    public static character createNewCharacter (String n, int a, int d, int h, int s, File f, ArrayList<character> characterHolder) throws Exception{
        int sumstats = a+d+h+s;
        float rationer = 500/sumstats;
        int ra = Math.round(rationer*a);
        int rd = Math.round(rationer*d);
        int rh = Math.round(rationer*h);
        int rs = Math.round(rationer*s);
       BufferedWriter bw = new BufferedWriter(new FileWriter(f));
       for(int i = 0; i< characterHolder.size(); i++){
           bw.write(characterHolder.get(i).getName()+" "+characterHolder.get(i).getAttack()+" "+characterHolder.get(i).getDefense()+" "+characterHolder.get(i).getHealth()+" "+characterHolder.get(i).getSpeed()+"\n");
       }
       bw.write(n+" "+ra+" "+rd+" "+rh+" "+rs);
       bw.close();
       character newcharacter = new character (n, ra, rd, rh, rs);
       System.out.println("your character has been created:\n"+newcharacter.getName()+" "+newcharacter.getAttack()+" "+newcharacter.getDefense()+" "+newcharacter.getHealth()+" "+newcharacter.getSpeed());
    return newcharacter;
    }
    
    public static character editCharacter (String n, float a, float d, float h, float s, int characterNumber, File f, ArrayList<character> characterHolder) throws Exception{
       Scanner inFile = new Scanner(System.in);
       String lineOfText = inFile.nextLine();
       float sumstats = a+d+h+s;
        float rationer = 500/sumstats;
        int ra = Math.round(rationer*a);
        int rd = Math.round(rationer*d);
        int rh = Math.round(rationer*h);
        int rs = Math.round(rationer*s);
       BufferedWriter bw = new BufferedWriter(new FileWriter(f));
       for(int i = 0; i< characterHolder.size(); i++){
           bw.write(characterHolder.get(i).getName()+" "+characterHolder.get(i).getAttack()+" "+characterHolder.get(i).getDefense()+" "+characterHolder.get(i).getHealth()+" "+characterHolder.get(i).getSpeed()+"\n");
       }
       bw.write(n+" "+ra+" "+rd+" "+rh+" "+rs);
       bw.close();
       character newcharacter = new character (n, ra, rd, rh, rs);
    return newcharacter;
    }
    public static character editCharacterhealth (String n, int a, int d, int h, int s, File f, ArrayList<character> characterHolder) throws Exception{
       BufferedWriter bw = new BufferedWriter(new FileWriter(f));
       for(int i = 0; i< characterHolder.size(); i++){
           bw.write(characterHolder.get(i).getName()+" "+characterHolder.get(i).getAttack()+" "+characterHolder.get(i).getDefense()+" "+characterHolder.get(i).getHealth()+" "+characterHolder.get(i).getSpeed()+"\n");
       }
       bw.write(n+" "+a+" "+d+" "+h+" "+s);
       bw.close();
       character newcharacter = new character (n, a, d, h, s);
    return newcharacter;
    }
    public static void printitems(ArrayList<item> bag){
        for (int i=0;i<bag.size();i++){
           System.out.println("item #"+i);
           System.out.print(bag.get(i).getName()+": adds "+bag.get(i).getHealthgain()+" health. You have"+bag.get(i).getAmount()+" "+bag.get(i).getName()+"s left");
        }
    }
    public static void printdeck(ArrayList<character> deck){
        for (int i=0;i<deck.size();i++){
           System.out.println("item #"+i);
        System.out.println(deck.get(i).getName()+" "+deck.get(i).getAttack()+" "+deck.get(i).getDefense()+" "+deck.get(i).getHealth()+" "+deck.get(i).getSpeed());
       }
    }
public static boolean flipacoin (int sc1, int sc2){
    boolean speedcheck = false;
    if(sc1>sc2){
        speedcheck = true;
    }
    else if(sc2>sc1){
        speedcheck = false;
    }
        return speedcheck;
}
public static character FIGHT (character charone, character chartwo, ArrayList<character> bench, int pickp, File f)throws Exception{
    Random rand = new Random();
    int dmg = Math.round(Math.round((rand.nextInt(100))*(charone.getAttack()/chartwo.getDefense())+1)/2);
    if(dmg<20){
        System.out.println("your attack was not very effective");
    }
    else if(dmg>80){
        System.out.println("your attack was super effective");
    }
    System.out.println("damage taken: "+dmg+"/"+charone.getHealth());
    BufferedWriter bw = new BufferedWriter(new FileWriter(f));
    character hurtchar = new character(charone.getName(),charone.getAttack(),charone.getDefense(),(charone.getHealth()-dmg),charone.getSpeed());
    bench.set(pickp,hurtchar);
       for(int i = 0; i< bench.size(); i++){
           bw.write(bench.get(i).getName()+" "+bench.get(i).getAttack()+" "+bench.get(i).getDefense()+" "+bench.get(i).getHealth()+" "+bench.get(i).getSpeed()+"\n");
       }
       bw.close();
    return hurtchar;
}


public static boolean hpcheck(ArrayList<character> deck){
    boolean check = false;
    int faintcount = 0;
    for (int i = 0; i>deck.size();i++){
        if(deck.get(i).getHealth() <= 0){
            faintcount++;
        }
    }
    if(faintcount == deck.size()-1){
        check = true;
    }
    return check;
}
public static boolean hpcheckcurrentplayer(character player){
    boolean check = false;
    if(player.getHealth() <= 0){
        check = true;
    }
    return check;
}
}
