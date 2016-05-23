package pt2016.project4.bank;

public class SpendingAccounts extends Account {

	public static final int MAX_SUM_TO_BE_WITHDRAWN = 1500;
	public static final int MAX_SUM_TO_BE_ADDED = 1500;
	public static final double COMMISSION = 0.85;

	public SpendingAccounts(int id, double money) {
		super(id, money, "spending");

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
				money -= sum * COMMISSION;
				// super.money = super.money - sum;
				notifyObservers("The sum + " + sum + " was taken from your account; m.name: "
						+ this.getClass().getSimpleName());
			} else {
				System.out.println("Too much money to be withdrawn. Maximum allowed is: " + MAX_SUM_TO_BE_WITHDRAWN);
			}

		} else {
			System.out.println("You don't have enough money!" + this.getClass().getSimpleName()
					+ " money you actually have: " + super.money + "money you want to withdraw: " + sum);
		}

	}
}
