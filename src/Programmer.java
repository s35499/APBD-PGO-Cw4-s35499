public class Programmer extends Employee {
    private String mainLanguage;

    public Programmer(String name, String surname, double salary, String mainLanguage) {
        super(name, surname, salary);
        this.mainLanguage = mainLanguage;
    }

    @Override
    protected int getRebellionIncreaseAfterSalaryDecrease() {
        return 35;
    }

    @Override
    protected int getRebellionDecreaseAfterSalaryIncrease() {
        return 25;
    }

    @Override
    protected int getQuitRebellionThreshold() {
        return 65;
    }

    @Override
    public String toString() {
        return String.format(
            "Programmer{%s, mainLanguage='%s'}",
            super.toString(),
            mainLanguage
        );
    }
}
