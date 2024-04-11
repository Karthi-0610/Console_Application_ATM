import java.util.*;
public class Main{
    public static Scanner scan=new Scanner(System.in);
    public static Map<String,HashMap<Integer,ArrayList<String>>> banks=new HashMap<>();
    public static HashMap<Integer,ArrayList<String>> UserTransaction=new HashMap<>();
    public static void main(String args[]){
        System.out.println("Existing Bank Name:NILA \nUser Account Number:1234567 User Name:KARTHI  User Pin:12345 \nAdmin Name:ADMIN  Admin Pin:54321\n");
        Bank bank=new Bank();
        User user=new User();
        Admin admin=new Admin();
        bank.existing();
        boolean bool=true;
        while(bool){
            System.out.println("IDENTITY\n1-USER\n2-ADMIN\n3-Exit\n\nENTER YOUR IDENTITY:");
            int identity=scan.nextInt();
            scan.nextLine();
            System.out.println("\n");
            switch(identity){
                case 1:
                    System.out.println("Enter Bank Name:");
                    String BankName=scan.nextLine();
                    if(banks.containsKey(BankName)){
                        System.out.println("Enter Account Number:");
                        int AccountNumber=scan.nextInt();
                        scan.nextLine();
                        System.out.println("Enter User Name:");
                        String UserName=scan.nextLine();
                        System.out.println("Enter User Pin:");
                        int UserPin=scan.nextInt();
                        scan.nextLine();
                        if(bank.PasswordCheck(AccountNumber, BankName, UserName, UserPin)){
                            System.out.println("\n");
                            System.out.println("WELCOME "+UserName+"\n\n");
                            Boolean BoolUserOption=true;
                            int AccountBalance=bank.getBalance(BankName,AccountNumber);
                            while(BoolUserOption){
                                System.out.println("1-DEPOSIT\n2-WITHDRAW\n3-TRANSACTION DETAILS\n4-BALANCE\n5-CHANGE PIN\n6-EXIT\n");
                                System.out.println("Enter your option:");
                                int UserOption=scan.nextInt();
                                scan.nextLine();
                                System.out.println("\n");
                                switch(UserOption){
                                    case 1:
                                        System.out.println("Enter an amount to Deposit:");
                                        int DepositAmount=scan.nextInt();
                                        scan.nextLine();
                                        AccountBalance=user.Deposit(DepositAmount, AccountBalance,AccountNumber);
                                        bank.setBalance(BankName,AccountNumber,AccountBalance);
                                        break;
                                    case 2:
                                        System.out.println("Enter an amount to WithDraw:");
                                        int WithdrawAmount=scan.nextInt();
                                        scan.nextLine();
                                        AccountBalance=user.Withdraw(WithdrawAmount,AccountBalance,AccountNumber);
                                        bank.setBalance(BankName,AccountNumber,AccountBalance);
                                        break;
                                    case 3:
                                        System.out.println("Transaction Details of "+UserName);
                                        user.TransactionDetails(AccountNumber,AccountBalance);
                                        break;
                                    case 4:
                                        System.out.println("Your Balance: "+AccountBalance);
                                        System.out.println("\n");
                                        break;
                                    case 5:
                                        user.ChangePin(BankName,AccountNumber,UserPin);
                                    case 6:
                                        BoolUserOption=false;
                                        break;
                                }
                            }
                        }else{
                            System.out.println("Check UserName And UserPin");
                            System.out.println("\n");
                        }
                    }else{
                        System.out.println("Invalid Bank");
                        System.out.println("\n");
                    }
                    break;
                case 2:
                    System.out.println("Enter Admin Name:");
                    String AdminName=scan.nextLine();
                    System.out.println("Enter Admin Pin:");
                    int AdminPin=scan.nextInt();
                    scan.nextLine();
                    System.out.println("\n");
                    if(AdminName.equals("ADMIN") && AdminPin==54321){
                        System.out.println("Welcome Admin");
                        Boolean BoolAdminOption=true;
                        while(BoolAdminOption){
                            System.out.println("\n");
                            System.out.println("1-ADD BANK\n2-ADD ACCOUNT\n3-DELETE ACCOUNT\n4-VIEW BANKS\n5-VIEW ACCOUNTS IN BANK\n6-EXIT\n");
                            System.out.println("Enter your option:");
                            int AdminOption=scan.nextInt();
                            System.out.println("\n");
                            scan.nextLine();
                            switch (AdminOption) {
                                case 1:
                                    admin.AddNewBank();
                                    break;
                                case 2:
                                    System.out.println("Enter the Bank Name to create new account:");
                                    String NewAccountBankName=scan.nextLine();
                                    admin.AddNewAccount(NewAccountBankName);
                                    break;
                                case 3:
                                    System.out.println("Enter the Bank Name to delete an account:");
                                    String DeleteAccountBankName=scan.nextLine();
                                    admin.DeleteAccount(DeleteAccountBankName);
                                    break;
                                case 4:
                                    admin.ViewBanks();
                                    break;
                                case 5:
                                    admin.ViewAccounts();
                                    break;
                                case 6:
                                    BoolAdminOption=false;
                                    break;
                            }
                        }
                    }else{
                        System.out.println("Check AdminName and AdminPin");
                        System.out.println("\n");
                    }
                    break;
                case 3:
                    bool=false;
                    break;
                default:
                    System.out.println("Invalid option");
            }
        }
    }
}
