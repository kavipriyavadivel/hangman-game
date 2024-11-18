import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class hangman {
    public static void main(String[] args) {
        list_items list = new list_items();
        figure stage = new figure();
        title head = new title();
        Scanner scan = new Scanner(System.in);
        System.out.println(head.header);
        int randnum = new Random().nextInt(list.items.length);
        String selected_item = list.items[randnum].toLowerCase();
        char[] display = new char[selected_item.length()];
        Arrays.fill(display, '_');
        System.out.println(display);
        int lives = 6;
        boolean game_over = false;
        while(!game_over){
            if(!new String(display).contains("_")){
                game_over = true;
                System.out.println(stage.stages[lives]);
                System.out.println("You Win!!!");
            }
            else if(lives == 0){
                game_over = true;
                System.out.println(stage.stages[lives]);
                System.out.println("You Lose...");
            }
            else {
                System.out.println("Guess a letter: ");
                Character guess = scan.next().toLowerCase().charAt(0);
                int flag = 0;
                for(int i = 0; i < selected_item.length(); i++){
                    if(guess == selected_item.charAt((i))){
                        flag = 1;
                        display[i] = guess;
                    }
                }
                if(flag == 0){
                    lives--;
                    System.out.println(stage.stages[lives]);
                    System.out.println(display);
                }
                else{
                    System.out.println(stage.stages[lives]);
                    System.out.println(display);
                }
            }
        }
    }
}
