public class Intern extends Slave {
    private String universityName;

    public Intern(String name, String surname, String universityName) {
        super(name, surname);
        this.universityName = universityName;
    }

    public String getUniversityName() {
        return universityName;
    }

    @Override
    public String toString() {
        String internAsString = "Intern{%s, universityName='%s'}".formatted(super.toString(), universityName);

        return internAsString;
    }
}
