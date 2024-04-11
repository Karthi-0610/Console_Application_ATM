import java.util.*;
public class Admin {
    Bank bank=new Bank();
    public void AddNewBank(){
        System.out.println("Enter Bank Name:");
        String NewBankName=Main.scan.nextLine();
        if(!Main.banks.containsKey(NewBankName)){
            Main.banks.put(NewBankName,new HashMap<Integer,ArrayList<String>>());
            AddNewAccount(NewBankName);
        }else{
            System.out.println("Bank Already Exists");
            System.out.println("\n");
        }
    }

    public void AddNewAccount(String NewBankName){
        System.out.println("Enter New Account Number:");
        int NewAccountNumber=Main.scan.nextInt();
        Main.scan.nextLine();
        HashMap<Integer,ArrayList<String>> checking=Main.banks.get(NewBankName);
        if(checking.isEmpty() || !checking.containsKey(NewAccountNumber)){
            System.out.println("Enter Account User Name:");
            String NewAccountUserName=Main.scan.nextLine();
            System.out.println("Enter Pin Number:");
            int NewPinNumber=Main.scan.nextInt();
            Main.scan.nextLine();
            ArrayList<String> arr=new ArrayList<>();
            arr.add(NewAccountUserName);
            arr.add(Integer.toString(NewPinNumber));
            arr.add("0");
            checking.put(NewAccountNumber,arr);
            Main.banks.put(NewBankName,checking);
            Main.UserTransaction.put(NewAccountNumber,new ArrayList<>());
            System.out.println("Account Created Successfully");
            System.out.println("\n");
        }else{
            System.out.println("Account Number Already Exists in the "+NewBankName+" Bank");
            System.out.println("\n");
        }
    }

    public void DeleteAccount(String DeleteAccountBankName){
        if(Main.banks.containsKey(DeleteAccountBankName)){
            System.out.println("Enter the Account Number to Delete:");
            int DeleteAccountNumber=Main.scan.nextInt();
            Main.scan.nextLine();
            HashMap<Integer,ArrayList<String>> DeleteAccountMap=Main.banks.get(DeleteAccountBankName);
            DeleteAccountMap.remove(DeleteAccountNumber);
            Main.banks.put(DeleteAccountBankName, DeleteAccountMap);
            System.out.println("Account Deleted Successfully");
            System.out.println("\n");
        }else{
            System.out.println("Bank Does not Exists");
            System.out.println("\n");
        }
    }

    public void ViewBanks(){
        System.out.println("Available Banks:");
        for(String BankNames:Main.banks.keySet()){
            System.out.println("          "+BankNames);
        }
        
    }

    public void ViewAccounts(){
        System.out.println("Enter the Bank Name to View the Accounts:");
        String ViewAccountBankName=Main.scan.nextLine();
        System.out.println(Main.banks.get(ViewAccountBankName));
        System.out.println("\n");
    }
}
