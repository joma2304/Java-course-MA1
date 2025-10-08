import java.util.Scanner; // Importera Scanner klassen

public class Main {

    // Konstanta variabler
    public static final int DICE_MIN_NR = 1;
    public static final int DICE_MAX_NR = 3;
    public static final int POINTS_TO_WIN = 12;
    public static final int DICE_SIDES = 6;
    public static final String WELCOME_MESSAGE = "Welcome to dice game 12. You must roll 1-3 dice and try to get the sum of 12 ...\n";
    public static final String ENTER_MESSAGE = "Enter which dice you want to roll [1,2,3] (exit with q):";
    public static final String ERROR_MESSAGE = "Sorry, that is an invalid entry. Try again. Valid entries are 1, 2, 3, and q\n";
    public static final String REPETETIVE_NR_MESSAGE = "Sorry, you have already rolled that dice. Try again";

    public static void main(final String[] args) {

        // Variabler för tärningarna
        int dice1 = 0;
        int dice2 = 0;
        int dice3 = 0;
        int sumOfDices = 0;

        // Resultat (vinst eller förlust)
        int nrOfWins = 0;
        int nrOfLoses = 0;

        // Bool för att spela
        boolean play = true;

        // Scanner
        Scanner playerInput = new Scanner(System.in);
        int number = 0;
        System.out.println(WELCOME_MESSAGE);

        while (play) {
            System.out.print(ENTER_MESSAGE);

            if (playerInput.hasNextInt()) {
                number = playerInput.nextInt();

                if (number >= DICE_MIN_NR && number <= DICE_MAX_NR) {

                    switch (number) {
                        case 1:
                            if (dice1 != 0) {
                                System.out.println(REPETETIVE_NR_MESSAGE);
                            } else {
                                dice1 = (int) (Math.random() * DICE_SIDES) + 1;
                            }
                            break;

                        case 2:
                            if (dice2 != 0) {
                                System.out.println(REPETETIVE_NR_MESSAGE);
                            } else {
                                dice2 = (int) (Math.random() * DICE_SIDES) + 1;
                            }
                            break;

                        case 3:
                            if (dice3 != 0) {
                                System.out.println(REPETETIVE_NR_MESSAGE);
                            } else {
                                dice3 = (int) (Math.random() * DICE_SIDES) + 1;
                            }
                            break;
                            
                        default:
                            System.out.println(ERROR_MESSAGE);
                            break;
                    }

                    sumOfDices = dice1 + dice2 + dice3;

                    // Koll om vinst/förlust eller inget därav
                    if (dice1 != 0 && dice2 != 0 && dice3 != 0 && sumOfDices < POINTS_TO_WIN) {
                        System.out.println(dice1 + " " + dice2 + " " + dice3 +
                                " sum: " + sumOfDices +
                                " #win: " + nrOfWins +
                                " #loss: " + nrOfLoses);
                        System.out.println("You neither won nor lost the game.");
                        // Ny runda
                        dice1 = 0;
                        dice2 = 0;
                        dice3 = 0;
                        sumOfDices = 0;
                        System.out.println("\nNext round!");
                    } else if (sumOfDices == POINTS_TO_WIN) { // Vid vinst
                        nrOfWins++;
                        System.out.println(dice1 + " " + dice2 + " " + dice3 +
                                " sum: " + sumOfDices +
                                " #win: " + nrOfWins +
                                " #loss: " + nrOfLoses);
                        System.out.println("You won!!");
                        // Ny runda
                        dice1 = 0;
                        dice2 = 0;
                        dice3 = 0;
                        sumOfDices = 0;
                        System.out.println("\nNext round!");
                    } else if (dice1 != 0 && dice2 != 0 && dice3 != 0 && sumOfDices > POINTS_TO_WIN) { // Vid förlust
                        nrOfLoses++;
                        System.out.println(dice1 + " " + dice2 + " " + dice3 +
                                " sum: " + sumOfDices +
                                " #win: " + nrOfWins +
                                " #loss: " + nrOfLoses);
                        System.out.println("You lost!!");
                        // Ny runda
                        dice1 = 0;
                        dice2 = 0;
                        dice3 = 0;
                        sumOfDices = 0;
                        System.out.println("\nNext round!");
                    } else { // skriv ut nuvarande tärningsstatus
                        System.out.println(dice1 + " " + dice2 + " " + dice3 +
                                " sum: " + sumOfDices +
                                " #win: " + nrOfWins +
                                " #loss: " + nrOfLoses);
                    }

                } else { // Ogiltigt tal
                    System.out.println(ERROR_MESSAGE);
                }

            } else { // Om input inte är en siffra
                String inString = playerInput.next();
                if (inString.equalsIgnoreCase("q")) {
                    System.out.println("#win: " + nrOfWins + " #loss: " + nrOfLoses);
                    System.out.println("Game over!");
                    play = false;
                } else {
                    System.out.println(ERROR_MESSAGE);
                }
            }
        }

        playerInput.close();
    }
}
