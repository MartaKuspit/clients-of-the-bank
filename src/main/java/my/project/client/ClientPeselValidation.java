package my.project.client;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.List;

public class ClientPeselValidation implements ConstraintValidator<ClientPeselValidator,String> {

    @Override
    public boolean isValid(String pesel, ConstraintValidatorContext context) {
        if (pesel == null) {
            return false;
        } else if (pesel.length() != 11) {
            return false;
        } else {
            List<Character> znaki = Arrays.asList('0', '1', '2', '3', '4', '5', '6', '7', '8', '9');
            char[] peselZnaki = pesel.toCharArray();

            for(int i = 0; i < pesel.length(); ++i) {
                if (!znaki.contains(peselZnaki[i])) {
                    return false;
                }
            }

            int[] peselNumbers = new int[11];

            int validNumber;
            for(validNumber = 0; validNumber < peselNumbers.length; ++validNumber) {
                peselNumbers[validNumber] = Integer.parseInt(String.valueOf(peselZnaki[validNumber]));
            }

            validNumber = peselNumbers[0] + peselNumbers[1] * 3
                    + peselNumbers[2] * 7 + peselNumbers[3] * 9
                    + peselNumbers[4] + peselNumbers[5] * 3 + peselNumbers[6] * 7
                    + peselNumbers[7] * 9 + peselNumbers[8] + peselNumbers[9] * 3;
            int cyfraKontrolna = validNumber % 10;
            cyfraKontrolna = 10 - cyfraKontrolna;
            cyfraKontrolna %= 10;
            return cyfraKontrolna == peselNumbers[10];
        }
    }
}

