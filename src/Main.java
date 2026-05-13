public class Main {
    public static void main(String[] args) {
        Slave intern = new Intern("Adam", "Nowak", "PJATK");

        Employee programmer = new Programmer("Anna", "Maj", 15000, "Java");
        Employee designer = new Designer("Marta", "Lis", 11000, "Figma");
        Employee qa = new QA("Piotr", "Kot", 10000, true);

        System.out.println(intern);
        System.out.println(programmer);
        System.out.println(designer);
        System.out.println(qa);

        programmer.decreaseSalary(2000);
        designer.decreaseSalary(1000);
        qa.increaseSalary(1500);

        programmer.workHard();
        designer.workSoftly();
        qa.workHard();

        System.out.println(programmer);
        System.out.println(designer);
        System.out.println(qa);
    }
}
