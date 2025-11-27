
package os.numbersystemsimulation;
import java.util.Scanner;

public class NumberSystemSimulation {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        
        do {
            
            System.out.println("\n===== NUMBER SYSTEM SIMULATION =====");
            System.out.println("1. Decimal to Binary");
            System.out.println("2. Binary to Decimal");
            System.out.println("3. Decimal to Hexadecimal");
            System.out.println("4. Hexadecimal to Decimal");
            System.out.println("5. Binary to Hexadecimal");
            System.out.println("6. Hexadecimal to Binary");
            System.out.println("0. Exit");
            System.out.println("=====================================");
            System.out.print("Enter your choice: ");
            
            choice = scanner.nextInt();
            
            switch(choice) {
                case 1:
                    decimalToBinary(scanner);
                    break;
                case 2:
                    binaryToDecimal(scanner);
                    break;
                case 3:
                    decimalToHexadecimal(scanner);
                    break;
                case 4:
                    hexadecimalToDecimal(scanner);
                    break;
                case 5:
                    binaryToHexadecimal(scanner);
                    break;
                case 6:
                    hexadecimalToBinary(scanner);
                    break;
                case 0:
                    System.out.println("Thank you for using the program! Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
            
        } while(choice != 0);
        
        scanner.close();
    }
    
    // Decimal to Binary
    public static void decimalToBinary(Scanner scanner) {
        System.out.print("\nEnter a decimal number: ");
        int decimal = scanner.nextInt();
        
        int originalNumber = decimal;
        
        String binary = "";
        
        if(decimal == 0) {
            binary = "0";
        } else {
            while(decimal > 0) {
                int remainder = decimal % 2;
                binary = remainder + binary;  
                decimal = decimal / 2;
            }
        }
        
        System.out.println("\nDecimal " + originalNumber + " => Binary " + binary);
    }
    
    // Binary to Decimal
    public static void binaryToDecimal(Scanner scanner) {
        System.out.print("\nEnter a binary number: ");
        String binary = scanner.next();
        
        int decimal = 0;
        int power = 0;

        for(int i = binary.length() - 1; i >= 0; i--) {
            
            char digit = binary.charAt(i);
            
            int value = digit - '0';
            
            decimal = decimal + (value * (int)Math.pow(2, power));
            power++;
        }
        
        System.out.println("\nBinary " + binary + " => Decimal " + decimal);
    }
    
    // Decimal to Hexadecimal
    public static void decimalToHexadecimal(Scanner scanner) {
        System.out.print("\nEnter a decimal number: ");
        int decimal = scanner.nextInt();
        
        int originalNumber = decimal;
        String hexadecimal = "";
        

        char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 
                            'A', 'B', 'C', 'D', 'E', 'F'};
        
        if(decimal == 0) {
            hexadecimal = "0";
        } else {
            while(decimal > 0) {
                int remainder = decimal % 16;
                hexadecimal = hexDigits[remainder] + hexadecimal;
                decimal = decimal / 16;
            }
        }
        
        System.out.println("\nDecimal " + originalNumber + " => Hexadecimal " + hexadecimal);
    }
    
    // Hexadecimal to Decimal
    public static void hexadecimalToDecimal(Scanner scanner) {
        System.out.print("\nEnter a hexadecimal number: ");
        String hex = scanner.next().toUpperCase();  
        
        int decimal = 0;
        int power = 0;
        
        for(int i = hex.length() - 1; i >= 0; i--) {
            char digit = hex.charAt(i);
            int value;

            if(digit >= '0' && digit <= '9') {
                value = digit - '0';  
            } else {
                value = digit - 'A' + 10;  
            }
            
            decimal = decimal + (value * (int)Math.pow(16, power));
            power++;
        }
        
        System.out.println("\nHexadecimal " + hex + " => Decimal " + decimal);
    }
    
    // Binary to Hexadecimal
    public static void binaryToHexadecimal(Scanner scanner) {
        System.out.print("\nEnter a binary number: ");
        String binary = scanner.next();
        
        String originalBinary = binary;
        
        int decimal = 0;
        int power = 0;
        
        for(int i = binary.length() - 1; i >= 0; i--) {
            char digit = binary.charAt(i);
            int value = digit - '0';
            decimal = decimal + (value * (int)Math.pow(2, power));
            power++;
        }
        
        String hexadecimal = "";
        char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 
                            'A', 'B', 'C', 'D', 'E', 'F'};
        
        if(decimal == 0) {
            hexadecimal = "0";
        } else {
            int temp = decimal;
            while(temp > 0) {
                int remainder = temp % 16;
                hexadecimal = hexDigits[remainder] + hexadecimal;
                temp = temp / 16;
            }
        }
        
        System.out.println("\nBinary " + originalBinary + " => Hexadecimal " + hexadecimal);
        System.out.println("(Intermediate: Decimal => " + decimal + ")");
    }
    
    // Hexadecimal to Binary
    public static void hexadecimalToBinary(Scanner scanner) {
        System.out.print("\nEnter a hexadecimal number: ");
        String hex = scanner.next().toUpperCase();
        
        int decimal = 0;
        int power = 0;
        
        for(int i = hex.length() - 1; i >= 0; i--) {
            char digit = hex.charAt(i);
            int value;
            
            if(digit >= '0' && digit <= '9') {
                value = digit - '0';
            } else {
                value = digit - 'A' + 10;
            }
            
            decimal = decimal + (value * (int)Math.pow(16, power));
            power++;
        }
        
        String binary = "";
        if(decimal == 0) {
            binary = "0";
        } else {
            int temp = decimal;
            while(temp > 0) {
                int remainder = temp % 2;
                binary = remainder + binary;
                temp = temp / 2;
            }
        }
        
        System.out.println("\nHexadecimal " + hex + " => Binary " + binary);
        System.out.println("(Intermediate: Decimal => " + decimal + ")");
    }
}
