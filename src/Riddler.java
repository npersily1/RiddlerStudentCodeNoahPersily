/**
 * The Riddler:
 * A puzzle by Zach Blick
 * for Adventures in Algorithms
 * At Menlo School in Atherton, CA
 * <p>
 * Completed by: Noah Persily
 */
public class Riddler {

    public String decryptOne(String encrypted) {
        String decrypted = "";

        // TODO: Complete the decryptOne() function.

        // For each character
        for (int i = 0; i < encrypted.length(); i++) {
            // If it is not a letter
            if (!Character.isLetter(encrypted.charAt(i))) {
                // Keep it the same and add it to the decrypted message
                decrypted += encrypted.charAt(i);
            } else {
                // Convert the letter to a number and add 9
                int temp = (int) encrypted.charAt(i) + 9;
                // If it is lowercase check if the letter is out of bounds and correct
                if (Character.isLowerCase(encrypted.charAt(i))) {
                    if (temp > 122) {
                        temp -= 26;
                    }
                }
                // Same but with upper case
                else {
                    if (temp > 90) {
                        temp -= 26;
                    }
                }
                // Add it to the decrypted message
                decrypted += (char) temp;
            }
        }
        return decrypted;
    }

    public String decryptTwo(String encrypted) {
        String decrypted = "";
        // Create an array of strings for each number
        String[] charList = encrypted.split(" ");
        // For each number
        for (int i = 0; i < charList.length; i++) {
            // Convert it into a letter and add it to the decrypted string
            decrypted += (char) (Integer.parseInt(charList[i]));
        }
        // TODO: Complete the decryptTwo() function.

        return decrypted;
    }

    public String decryptThree(String encrypted) {
        String decrypted = "";

        // TODO: Complete the decryptThree() function.

        // For each encrypted byte
        for (int i = 0; i < encrypted.length(); i += 8) {
            // Separate the byte and convert to a number then to a character then add it to the decrypted message
            decrypted += (char) byteToInt(encrypted.substring(i, i + 8));
        }
        return decrypted;
    }

    public String decryptFour(String encrypted) {
        String decrypted = "";

        // TODO: Complete the decryptFour() function.
        for (int i = 0; i < encrypted.length(); i++) {

            // Convert the letter to a number and add 9
            int temp = (int) encrypted.charAt(i) -  9919;
            // If it is lowercase check if the letter is out of bounds and correct
            if (Character.isLowerCase(encrypted.charAt(i))) {
                if (temp > 122) {
                    temp -= 26;
                }
            }
            // Same but with upper case
            else {
                if (temp > 90) {
                    temp -= 26;
                }
                // Add it to the decrypted message
                decrypted += (char) temp;
            }
        }
        return decrypted;
    }

    // Takes in a String with 8 letters being either 1 or 0 and returns it as a decimal number
    public int byteToInt(String s) {
        int temp = 0;
        // For each bit in the String
        for (int i = 0; i < 8; i++) {
            // Multiply the value by 2^ to it's position and add it to the number to be returned
            temp += (Integer.parseInt(s.substring(i, i + 1))) * (1 << (8 - i - 1));
        }
        return temp;
    }
}
