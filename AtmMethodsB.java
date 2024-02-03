package BusinessLogicLayer.CostumerAccessoriesB;

import java.util.Random;

public class AtmMethodsB {
    public static String generateRandomATMCardNumber() {
        StringBuilder cardNumber = new StringBuilder("4");  // Starts with 4 (common for Visa cards)
        // Generate 15 random digits for the card number
        Random random = new Random();
        for (int i = 1; i <= 15; i++) {
            int digit = random.nextInt(10);  // Random digit from 0 to 9
            cardNumber.append(digit);
            if (i % 4 == 0 && i != 15) {
                cardNumber.append("-");  // Add a space every 4 digits for better readability
            }
        }

        return cardNumber.toString();
    }
}
