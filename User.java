import java.util.*;
public class User {
    public int Deposit(int DepositAmount,int AccountBalance,int AccountNumber){
        if(DepositAmount<=0){
            System.out.println("Enter correct amount to Deposit");
            System.out.println("\n");
            return AccountBalance;
        }else{
            String Trans="You have Deposited "+Integer.toString(DepositAmount);
            ArrayList<String> TransactionList=Main.UserTransaction.get(AccountNumber);
            TransactionList.add(Trans);
            Main.UserTransaction.put(AccountNumber,TransactionList);
            System.out.println(DepositAmount+" Deposited Successfully");
            System.out.println("\n");
            return AccountBalance+DepositAmount;
        }
    }

    public int Withdraw(int WithdrawAmount,int AccountBalance,int AccountNumber){
        if(WithdrawAmount<=0){
            System.out.println("Enter correct amount to Withdraw");
            return AccountBalance;
        }else{
            if(AccountBalance-WithdrawAmount<0){
                System.out.println("Insufficient Bank Balance");
                System.out.println("\n");
                return AccountBalance;
            }else{
                String Trans="You have Withdrawed "+Integer.toString(WithdrawAmount);
                ArrayList<String> TransactionList=Main.UserTransaction.get(AccountNumber);
                TransactionList.add(Trans);
                Main.UserTransaction.put(AccountNumber,TransactionList);
                System.out.println(WithdrawAmount+" Withdrawed Successfully");
                System.out.println("\n");
                return AccountBalance-WithdrawAmount;
            }
        }
    }

    public void TransactionDetails(int AccountNumber, int AccountBalance){
        ArrayList<String> TransactionDetailsList=Main.UserTransaction.get(AccountNumber);
        for(String s:TransactionDetailsList){
            System.out.println(s);
        }
        System.out.println("Your Current Account Balance: "+AccountBalance);
        System.out.println("\n");
    }

    public void ChangePin(String BankName, int AccountNumber, int UserPin){
        System.out.println("Enter the Previous Pin Number:");
        int PreviousPinNumber=Main.scan.nextInt();
        Main.scan.nextLine();
        if(PreviousPinNumber==UserPin){
            System.out.println("Enter the New Pin Number:");
            int NewPinNumber=Main.scan.nextInt();
            Main.scan.nextLine();
            System.out.println("Enter the New Pin Number Again:");
            int NewPinNumberAgain=Main.scan.nextInt();
            Main.scan.nextLine();
            if(NewPinNumber==NewPinNumberAgain){
                ArrayList<String> ChangePinList=Main.banks.get(BankName).get(AccountNumber);
                ChangePinList.set(1,Integer.toString(NewPinNumber));
                Main.banks.get(BankName).put(AccountNumber,ChangePinList);
                System.out.println("Pin Number Changed Successfully");
                System.out.println("\n");
            }else{
                System.out.println("MisMatching New Pin Number");
            }
        }else{
            System.out.println("Wrong Pin Number");
        }
    }
}
