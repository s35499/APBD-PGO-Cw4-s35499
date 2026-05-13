public class QA extends Employee {
    private boolean automationTester;

    public QA(String name, String surname, double salary, boolean automationTester) {
        super(name, surname, salary);
        this.automationTester = automationTester;
    }

    @Override
    protected int getRebellionIncreaseAfterSalaryDecrease() {
        return automationTester ? 20 : 30;
    }

    @Override
    protected int getRebellionDecreaseAfterSalaryIncrease() {
        return automationTester ? 20 : 10;
    }

    @Override
    protected int getQuitRebellionThreshold() {
        return automationTester ? 80 : 75;
    }

    @Override
    public String toString() {
        return String.format(
            "QA{%s, automationTester='%s'}",
            super.toString(),
            automationTester
        );
    }
}
