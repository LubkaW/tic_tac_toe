package tictactoe;
import java.util.*;
import java.lang.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        char[][] ar = new char[3][3];

        //filling
        for(int i = 0; i < 3; i++)
        {
            for(int j = 0; j < 3; j++)
            {
                ar[i][j] = '_';
            }
        }

        print(ar);
        boolean cross = true;
        int round = 0;

        //Game
        do {
            System.out.print("Enter the coordinates: ");
            String[] cordi = sc.nextLine().split(" ");

            try {
                int cord0 = Integer.parseInt(cordi[0]);
                int cord1 = Integer.parseInt(cordi[1]);

                if( cord0 > 3 || cord0 < 1 || cord1 > 3 || cord1 < 1 ){
                    System.out.println("Coordinates should be from 1 to 3!");
                    continue;
                }

                if( ar[3 - cord1][cord0 -1] == '_') {
                    if(cross){
                        ar[3 - cord1][cord0 -1] = 'X';
                        cross = false;
                    }else{
                        ar[3 - cord1][cord0 -1] = 'O';
                        cross = true;
                    }

                    print(ar);
                    round++;
                    String s = check(ar,round);
                    if( s.equals("X wins") || s.equals("O wins") || s.equals("Draw")){
                        System.out.println(s);
                        break;
                    }

                }
                else{
                    System.out.println("This cell is occupied! Choose another one!");
                }


            } catch (NumberFormatException e) {
                System.out.println("You should enter numbers!");
            }
           }while(true);



    }







//-----------------------------------------------------------------------------------------

    public static String check (char[][] arr,int round) {

        char win = ' ';

        for (int i = 0; i < 3; i++)
        {

            if (arr[i][0] == arr[i][1] && arr[i][1] == arr[i][2] && arr[i][0] != '_')
            {
                win = arr[i][0];
            }
            else
            {

                if(arr[0][i] == arr[1][i] && arr[1][i] == arr[2][i] && arr[0][i] != '_'){
                    win = arr[0][i];
                }

            }


        }

        if((arr[0][0] == arr[1][1] && arr[1][1] == arr[2][2]) || (arr[0][2] == arr[1][1] && arr[1][1] == arr[2][0]))
            win = arr[1][1];

        if(win != ' ') return win + " wins";

        if(round == 9) return "Draw";

        return "continue";

    }
    //-----------------------------------------------------------------------------------------------



    public static void print(char[][] ar) {


        System.out.println("---------");
        for (int j = 0; j < 3; j++)
        {
            System.out.print("| ");

            for(int i = 0; i<3;i++)
            {
                System.out.print(ar[j][i] + " ");
            }

            System.out.print("|");
            System.out.println();

        }
        System.out.println("---------");
    }
}
