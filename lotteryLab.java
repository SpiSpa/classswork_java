import java.util.Scanner;
import java.util.Random;

public class lotteryLab {

    //generate lottery numbers
    static int[] getLottoNumbers(){
        Random rand = new Random();
        int[] lotteryPick = new int[5];
        lotteryPick[0] = rand.nextInt(10);
        for (int i = 1; i < 5; i++){
            boolean distinctNumber = false;
            lotteryPick[i] = rand.nextInt(10);
            while (distinctNumber == false){
                distinctNumber = true;
                for (int j = 0; j < i; j++){
                    if (lotteryPick[i] == lotteryPick[j]){
                        distinctNumber = false;
                        lotteryPick[i] = rand.nextInt(10);
                    }   
                }
            }
        }
        return lotteryPick;
    }

    //generate user's lotto numbers
    static int[] getUserNumbers(){
        Scanner input = new Scanner(System.in);
        int[] userPick = new int[5];
        System.out.println("Enter pick #1: ");
        userPick[0] = input.nextInt();

        for (int i = 1; i < 5; i++){
            boolean distinctNumber = false;
            System.out.println("Enter pick #" + (i + 1) + ": ");
            userPick[i] = input.nextInt();
            while (distinctNumber == false){
                distinctNumber = true;
                for (int j = 0; j < i; j++){
                    if (userPick[i] == userPick[j]){
                        System.out.println("duplicate found. enter new number: ");
                        distinctNumber = false;
                        userPick[i] = input.nextInt();;
                    }   
                }
            }
        } 
        input.close();
        return userPick;
    }

    static void lotteryResults(int lottery[], int user[]){
        int lotteryRange; 
        int[] lotteryMatches = new int[5];
        int count = 0;

        lotteryRange = lottery.length;

        for (int i = 0; i < lotteryRange; i++){
            if (lottery[i] ==  user[i]){
                lotteryMatches[count] = lottery[i];
                count++;
            }
        }
        System.out.println("matching count: " + count);
    }

    public static void main(String[] args) {

        int[] lotteryPicks = getLottoNumbers();
        int[] userPicks = getUserNumbers();

        System.out.print("Lottery Picks: ");
        for (int i = 0; i < 4; i++){
            System.out.print(lotteryPicks[i] + ",");    
        }
        System.out.println(lotteryPicks[4]);

        System.out.print("User Picks: ");
        for (int i = 0; i < 4; i++){
            System.out.print(userPicks[i] + ",");    
        }
        System.out.println(userPicks[4]);

        lotteryResults(lotteryPicks, userPicks);
    }
}
    

// generate lottery array
//  each number is only used once

// user enters lottery numbers
// no repeats

// compare the lists using a linear search
// create array of matching numbers
// find length of list

// display on pop-up

