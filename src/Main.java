import java.util.Scanner;

public class Main {

    public static int numPlayers(){
        Scanner scan1 = new Scanner(System.in);

        System.out.println("Enter the number of players: ");
        int numPlayers = scan1.nextInt();
        return numPlayers;

    }
    public static int timesAtBat(int i){
        Scanner scan1 = new Scanner(System.in);

        System.out.printf("please provide number of times at bat: (%d) ", i + 1);

        int timesAtBat = scan1.nextInt();
        return timesAtBat;

    }

    public static void main(String[] args) {
        Scanner scan1 = new Scanner(System.in);
        double sumGreaterThanZero = 0.0;
        double basesSum = 0.0;
        double battingAvg = 0.0;
        double slugPercent = 0.0;

        int numPlayers = numPlayers();


        int[][] bball = new int[numPlayers][]; // jagged array

        for (int i = 0; i < numPlayers; i++)
        {
            int timesAtBat = timesAtBat(i);


            bball[i] = new int[timesAtBat]; // create the column array
            for (int j = 0; j < bball[i].length; j++) {

                System.out.printf("Enter the number of bases earned for each at bat, less than 4:(%d, %d)", i + 1, j + 1);

                    bball[i][j] = scan1.nextInt();
                    scan1.nextLine();
                    if(bball[i][j] < 0 || bball[i][j] > 4){
                        System.out.println("Invalid Range, enter 0 to 4 inclusive.");
                        break;
                    }
                    basesSum = bball[i][j] + basesSum;



                    if (bball[i][j] > 0) {
                        sumGreaterThanZero = sumGreaterThanZero + 1;
                    }



            }
            battingAvg = sumGreaterThanZero / timesAtBat;
            slugPercent = basesSum / timesAtBat;
            System.out.print("Batter " + (i + 1));
            System.out.printf(" average: %.3f", battingAvg );
            System.out.printf(" Slugging percentage: %.3f", slugPercent);
            System.out.println();
            battingAvg = 0.0;
            slugPercent = 0.0;
            basesSum = 0.0;
            sumGreaterThanZero = 0.0;


        }
    }

}
