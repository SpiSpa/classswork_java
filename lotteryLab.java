import java.util.Scanner;
import javax.swing.JOptionPane;
import java.util.Random;

public class lotteryLab {

    //generate lottery numbers and return to main function
    static int[] getLottoNumbers(){  
        Random rand = new Random();
        int[] lotteryPick = new int[5];   // declare variable and create array to hold lottery picks
        lotteryPick[0] = rand.nextInt(10);   // pick first lottery number randomly from range 0-9 inclusive

        // generate each remaining lottery element, testing for duplicates, and regenerating element until it is distinct from rest of list
        for (int i = 1; i < 5; i++){ 
            boolean distinctNumber;  
            lotteryPick[i] = rand.nextInt(10);
            do {
                distinctNumber = true;
                for (int j = 0; j < i; j++){   // check for duplicates here
                    if (lotteryPick[i] == lotteryPick[j]){
                        distinctNumber = false;
                        lotteryPick[i] = rand.nextInt(10);
                    }   
                }
            }
            while (distinctNumber == false);  // false meanse a duplicate, so re-enter loop and draw a new number.
        }
        return lotteryPick;
    }

    //generate user's lotto numbers, check for duplicates, and return to main function
    static int[] getUserNumbers(){
        Scanner input = new Scanner(System.in);
        int[] userPick = new int[5];
        System.out.println("Enter pick #1: ");
        userPick[0] = input.nextInt();

        for (int i = 1; i < 5; i++){
            boolean distinctNumber;
            System.out.println("Enter pick #" + (i + 1) + ": ");
            userPick[i] = input.nextInt();
            do {
                distinctNumber = true;
                for (int j = 0; j < i; j++){
                    if (userPick[i] == userPick[j]){
                        System.out.println("duplicate found. enter new number: ");
                        distinctNumber = false;
                        userPick[i] = input.nextInt();;
                    }   
                }
            }
            while (distinctNumber == false);
        } 
        input.close();
        return userPick;
    }

    static void lotteryResults(int lottery[], int user[]){
        int lotteryRange; 
        int count = 0;
        String displayMessage = "";  // initalize string so we can add matching numbers in the following for loop.

        lotteryRange = lottery.length;

        for (int i = 0; i < lotteryRange; i++){
            if (lottery[i] ==  user[i]){;
                count++;
                displayMessage = displayMessage + lottery[i] + " ";
            }
        }
        if (count == 0){
            displayMessage = "Sorry! there are no matches.\n Number Count: " + count;
        }
        else{
            displayMessage = "Matching Numbers: " + displayMessage + "\nMatch Count: " + count;
        }
        
        JOptionPane.showMessageDialog(null, displayMessage, "Lottery Results", JOptionPane.INFORMATION_MESSAGE);
    
    }

    public static void main(String[] args) {

        int[] lotteryPicks = getLottoNumbers();
        int[] userPicks = getUserNumbers();

        System.out.print("Lottery Picks: \t");
        for (int i = 0; i < 4; i++){
            System.out.print(lotteryPicks[i] + ",");    
        }
        System.out.println(lotteryPicks[4]);

        System.out.print("User Picks: \t");
        for (int i = 0; i < 4; i++){
            System.out.print(userPicks[i] + ",");    
        }
        System.out.println(userPicks[4]);

        lotteryResults(lotteryPicks, userPicks);
    }
}