package pt2016.project4.bank;

public class SavingAccount extends Account {

	public static final int MAX_SUM_TO_BE_WITHDRAWN = 1000;
	public static final int MAX_SUM_TO_BE_ADDED = 3000;
	public static final double COMMISSION = 0.045;

	public SavingAccount(int id, double money) {
		super(id, money, "saving");
	}

	@Override
	public void addMoney(double sum) {

		if (sum < MAX_SUM_TO_BE_ADDED) {
			setChanged();
			money += sum;
			notifyObservers("The sum + " + sum + " was added to your " + this.getClass().getSimpleName());
		} else {
			System.out.println("You cannot deposit so much money. Max allowed: " + MAX_SUM_TO_BE_ADDED);
		}

	}

	@Override
	public void withdrawMoney(double sum) {

		if (money >= sum) {
			if (sum <= MAX_SUM_TO_BE_WITHDRAWN) {
				setChanged();
				//money -= sum;
				money = money - sum * COMMISSION;
				notifyObservers(
						"The sum + " + sum + " was taken from your: " + this.getClass().getSimpleName());

			} else {
				System.out.println("Too much money to be withdrawn. Maximum allowed is: " + MAX_SUM_TO_BE_WITHDRAWN);
			}

		} else {
			System.out.println("You don't have enough money!" + this.getClass().getSimpleName());
		}

	}

}
