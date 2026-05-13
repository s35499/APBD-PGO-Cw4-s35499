public class Designer extends Employee {
    private String designTool;

    public Designer(String name, String surname, double salary, String designTool) {
        super(name, surname, salary);
        this.designTool = designTool;
    }

    @Override
    protected int getRebellionIncreaseAfterSalaryDecrease() {
        return 40;
    }

    @Override
    protected int getRebellionDecreaseAfterSalaryIncrease() {
        return 15;
    }

    @Override
    protected int getQuitRebellionThreshold() {
        return 70;
    }

    @Override
    public String toString() {
        return String.format(
            "Designer{%s, designTool='%s'}",
            super.toString(),
            designTool
        );
    }
}
