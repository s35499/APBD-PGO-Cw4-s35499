import java.util.Random;

public class Employee extends Slave {
    private static final Random RANDOM = new Random();

    private double salary;
    private boolean employed;

    public Employee(String name, String surname, double salary) {
        super(name, surname);
        this.salary = salary;
        this.employed = true;
    }

    public double getSalary() {
        return salary;
    }

    public boolean isEmployed() {
        return employed;
    }

    protected int getRebellionIncreaseAfterSalaryDecrease() {
        return 25;
    }

    protected int getRebellionDecreaseAfterSalaryIncrease() {
        return 15;
    }

    protected int getQuitRebellionThreshold() {
        return 70;
    }

    public void increaseSalary(double amount) {
        requireAlive();

        salary += amount;
        reduceReadinessToRebel(getRebellionDecreaseAfterSalaryIncrease());

        System.out.println("Salary increased by: " + amount);
    }

    public void decreaseSalary(double amount) {
        requireAlive();

        salary = Math.max(0, salary - amount);
        increaseReadinessToRebel(getRebellionIncreaseAfterSalaryDecrease());

        System.out.println("Salary decreased by: " + amount);
    }

    public void rest() {
        requireAlive();

        System.out.println("Employee is resting...");

        reduceExhaustion(35);
        reduceReadinessToRebel(10);
    }

    private boolean shouldQuit() {
        return getLevelOfReadinessToRebel() >= getQuitRebellionThreshold() && RANDOM.nextBoolean();
    }

    private boolean checkIfQuits() {
        if (shouldQuit()) {
            employed = false;

            System.out.println(
                String.format("'%s' '%s' quit the job!", getName(), getSurname())
            );

            return true;
        }

        return false;
    }

    private void requireEmployed() {
        if (!employed) {
            throw new IllegalStateException(
                String.format("'%s' '%s' is no longer employed!", getName(), getSurname())
            );
        }
    }

    @Override
    public void workSoftly() {
        requireAlive();
        requireEmployed();

        if (checkIfQuits()) {
            return;
        }

        super.workSoftly();
    }

    @Override
    public void workHard() {
        requireAlive();
        requireEmployed();

        if (checkIfQuits()) {
            return;
        }

        super.workHard();
    }

    @Override
    public String toString() {
        return String.format(
            "Employee{%s, salary=%.2f, employed=%s}",
            super.toString(),
            salary,
            employed
        );
    }
}