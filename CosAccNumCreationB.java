package BusinessLogicLayer.CostumerAccessoriesB;

import java.util.Random;

public class CosAccNumCreationB {
    public static String generateRandomAccountNumber() {
        StringBuilder accountNumber = new StringBuilder();
        // Generate 10 random digits for the account number
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            int digit = random.nextInt(10);  // Random digit from 0 to 9
            accountNumber.append(digit);
        }
        return accountNumber.toString();
    }
}
