package User;

import entity.Account;
import service.AccountOperations;
import java.util.Scanner;
/*
 * with the menu and switcher method
 */
public class UserApp1 {

	Scanner sc = new Scanner(System.in);

	public static void displayMenu() {

		System.out.println("Menu");
		System.out.println("1. Accept the details");
		System.out.println("2. Display the details");
		System.out.println("3. withdraw");
		System.out.println("4. Deposit");
		System.out.println("5. Transfer");
		System.out.println("6. Exit");
		System.out.println("=========================================");
	}

	public static boolean switcher(int ch, Account acc1, Account acc2, AccountOperations accop) {
		Scanner sc = new Scanner(System.in);
		switch (ch) {

		case 1:
			System.out.println("please enter accno , name , balance");
			int accNo = sc.nextInt();
			String name = sc.next();
			double bal = sc.nextDouble();
			acc1.setAccNo(accNo);
			acc1.setAccName(name);
			acc1.setAccBalance(bal);
			break;

		case 2:
			System.out.println("Displaying the details ....................");
			System.out.println(acc1);
			break;

		case 3:
			System.out.println("Enter the amount to withdraw.....");
			int amt = sc.nextInt();
			boolean var1 = accop.withdrawAmount(acc1, amt);
			if (var1)
				System.out.println("withdraw operation is successful!!!!!!");
			else
				System.out.println("Not enough funds...........");
			break;

		case 4:
			System.out.println("Enter the amount to deposit.....");
			int amt1 = sc.nextInt();
			boolean var2 = accop.depositAmount(acc1, amt1);
			break;

		case 5:
			System.out.println("Enter the amount to tranfer.....");
			int amt2 = sc.nextInt();
			System.out.println("Tranfering funds..in process");
			accop.tranferAmount(acc1, acc2, amt2);
			System.out.println("Tranfering funds..is completed ");
			break;

		case 6:
			System.out.println("Exiting..");
			return false;

		default:
			System.out.println("invalid input !!!");
			break;

		}
		return true;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		Account acc1 = new Account(200, "Goverdhan", 30000.00); // para cons
		Account acc2 = new Account(202, "Ritesh", 50000.00); // para cons
		AccountOperations accop = new AccountOperations();

		boolean var = true;

		while (var) {
			displayMenu(); // modularity of the code
			System.out.println("Please enter the choice");
			int ch = sc.nextInt();

			var = UserApp1.switcher(ch, acc1, acc2, accop);
			// 1 2 3 4
			System.out.println("=====================================");
		}

	}

}
