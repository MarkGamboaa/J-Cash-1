import java.util.Random;
import java.util.Scanner;

public abstract class accounts {
    private int accountNo;  //randomly assigned 3 digit number
    private String name;    //name of the account holder
    private String address; //address of the account holder
    private int pin;    //write only 4 digit pin
    private int YoB;    // year of birth
    private int balance;    //current balance in the account
    
    Scanner input = new Scanner(System.in);

    public accounts() {
        name = " ";
        pin = 0;
        accountNo = 0;
        YoB = 0;
    }

    public void setAccountNo() {
        Random accountNo = new Random();
        this.accountNo = accountNo.nextInt(900) + 100; // Generates a random number between 100 and 999
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPin(int pin) {
        while(true){
            if(pin <= 999 || pin >= 10000){
                System.out.println("PIN must contain 4 digits.");
                System.out.print("Enter PIN: ");
                pin = input.nextInt();
            }
            else{
                this.pin = pin;
                break;
            }
        }
    }

    public void setYoB(int yob){
        while(true){
            if(2024 - yob <= 17){
                System.out.println("You must be 18 years old or older to create an account.");
                System.out.print("Enter Year of Birth: ");
                yob = input.nextInt();
            }
            else{
                this.YoB = yob;
                break;
            }
        }
    }

    public void setInitialDepo(int initialDepo) {
        while(true){
            if(initialDepo <= 2999){
                System.out.println("Initial deposit must be at least PHP 3000.");
                System.out.print("Enter Initial Deposit: \t");
                initialDepo = input.nextInt();
            }
            else{
                this.balance = initialDepo;
                break;
            }
        }
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getAccountNo(){
        return this.accountNo;
    }

    public String getName(){
        return this.name;
    }

    public String getAddress(){
        return this.address;
    }

    public int getAge(){
        return 2024 - this.YoB;
    }

    public int getBalance(){
        return this.balance;
    }

    public void deposit(int amount){
            this.balance += amount;
    }

    public void getDetails(){
        System.out.println("Account Number: " + this.getAccountNo());
        System.out.println("Name: \t\t" + this.getName());
        System.out.println("Age: \t\t" + this.getAge());
        System.out.println("Address: \t" + this.getAddress());
        System.out.println("Balance: \t" + this.getBalance());
    }

    public boolean verify(int pin){
        int attempts = 0;
        while (attempts < 2){
            if(this.pin == pin){
                return true;
            }
            else{
                System.out.println("INCORRECT PIN. " + (2 - attempts) + " attempts left.");
                System.out.print("Enter Again: \t\t");
                pin = input.nextInt();
                attempts++;
            }
        }
        return false;
    }

    public abstract boolean withdraw(int amount);
}