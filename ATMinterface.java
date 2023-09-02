import java.util.*;
import java.util.Scanner;
class ATM{
    float balance;
    int PIN=8692;
    int count=0;
    HashMap<Integer,Float>map=new HashMap<>();
    public void checkpin(){
        System.out.print("Please enter your pin:");
        Scanner obj=new Scanner(System.in);
        int pin=obj.nextInt();
        if(pin==PIN){
            dashboard();
        }
        else{
            System.out.println("Please enter a valid pin");
            checkpin();
        }
    }
    public void dashboard(){
        System.out.println("Enter your choice");
        System.out.println("1.Check a/c balance");
        System.out.println("2.Withdrawal");
        System.out.println("3.Deposit money");
        System.out.println("4.Transfer money");
        System.out.println("5.Transaction history");
        System.out.println("6.Exit");
        Scanner obj=new Scanner(System.in);
        int opt=obj.nextInt();
        if(opt==1){
            BalanceInquiry();
        }
        else if(opt==2){
           WithDrawal();
        }
        else if(opt==3){
           Deposit();
        }
        else if(opt==4){
           MoneyTransfer();
        }
        else if(opt==5)
            transactionHistory();
        else if(opt==6)
            return;
        else{
           dashboard();
        }
    }
    public void transactionHistory(){
        for(Map.Entry<Integer,Float>entry:map.entrySet()){
            int num=entry.getKey();
            float transaction_amount=entry.getValue();
            if(transaction_amount>0){
                System.out.println("Transaction "+num+":Deposit of "+transaction_amount);
            }
            else{
                System.out.println("Transaction "+num+":Withdrawal of "+(-transaction_amount));
            }
        }
        dashboard();
    }
    public void MoneyTransfer(){
        System.out.println("Please enter account Number");
        try (Scanner obj = new Scanner(System.in)) {
            int accnum=obj.nextInt();
            System.out.println("Please enter the amount you want to transfer");
            float amount=obj.nextFloat();
            if(amount%10!=0){
                System.out.println("Please enter valid amount");
            }
            else if(amount>balance){
                System.out.println("Insufficient Funds");
            }
            else{
                balance=balance-amount;
                count++;
                map.put(count,-amount);
                System.out.println("Transfer Succesful");
            }
        }
        dashboard();

    }

    public void BalanceInquiry(){
        System.out.println("Balance Amount:"+balance);
        dashboard();
    }
    public void WithDrawal(){
        System.out.println("enter amount to withdraw:");
        Scanner obj=new Scanner(System.in);
        float amount=obj.nextFloat();
        if(amount%10!=0){
            System.out.println("Please enter valid amount");
        }
        else if(amount>balance){
            System.out.println("Insufficient Funds");
        }
        else{
            balance=balance-amount;
            count++;
            map.put(count,-amount);
            System.out.println("Withdrawal Succesful");
        }
        dashboard();
    }
    public void Deposit(){
        System.out.println("Please enter the amount:");
        Scanner obj=new Scanner(System.in);
        float amount=obj.nextInt();
        if(amount%10!=0){
            System.out.println("Please enter a valid amount");
        }
        else{
        balance+=amount;
        count++;
        map.put(count,amount);
        System.out.println("Deposited succesfully");
        }
        dashboard();
    }
}
public class ATMinterface {
    public static void main(String args[]){
        ATM Obj=new ATM();
        Obj.checkpin();
    }
}