import java.util.*;
class Bank {
    User user=new User();
    public void existing(){
        HashMap<Integer,ArrayList<String>> user1=new HashMap<>();
        ArrayList<String> arr=new ArrayList<>();
        arr.add("KARTHI");
        arr.add("12345");
        arr.add("0");
        user1.put(1234567,arr);
        Main.banks.put("NILA",user1);
        Main.UserTransaction.put(1234567,new ArrayList<>());
    }


    public boolean PasswordCheck(int AccountNumber, String BankName,String UserName,int UserPin){
        HashMap<Integer,ArrayList<String>> check=Main.banks.get(BankName);
        if(check.containsKey(AccountNumber) && check.get(AccountNumber).get(0).equals(UserName) && Integer.valueOf(check.get(AccountNumber).get(1))==UserPin){
            return true;
        }else{
            return false;
        }
    }

    public int getBalance(String BankName,int AccountNumber){
        HashMap<Integer,ArrayList<String>> check=Main.banks.get(BankName);
        return Integer.valueOf(check.get(AccountNumber).get(2));
    }

    public void setBalance(String BankName,int AccountNumber, int AccountBalance){
        HashMap<Integer,ArrayList<String>> check=Main.banks.get(BankName);
        ArrayList<String> arr=check.get(AccountNumber);
        arr.set(2,Integer.toString(AccountBalance));
        check.put(AccountNumber,arr);
    }
}
