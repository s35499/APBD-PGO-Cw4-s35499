import java.util.Scanner;
import enums.DeadlineType;

public class Main {
    public static void main(String[] args) {
        SoftwareHouse softwareHouse = new SoftwareHouse("Campus App Software House");

        Slave intern = new Intern("Adam", "Internowski", "Institute of Applied Physiology");

        Slave programmer = new Programmer("Anna", "Kodarska", 15000, "Java");
        Slave designer = new Designer("Marta", "Figmowska", 11000, "Figma");
        Slave qa = new QA("Piotr", "Testowski", 10000, true);

        softwareHouse.addMember(intern);
        softwareHouse.addMember(programmer);
        softwareHouse.addMember(designer);
        softwareHouse.addMember(qa);

        System.out.println("Choose deadline type:");
        System.out.println("1 - NORMAL");
        System.out.println("2 - HARD");
        System.out.println("3 - HELL");

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        DeadlineType deadlineType;

        switch (choice) {
            case 1:
                deadlineType = DeadlineType.NORMAL;
                break;
            case 2:
                deadlineType = DeadlineType.HARD;
                break;
            case 3:
                deadlineType = DeadlineType.HELL;
                break;
            default:
                deadlineType = DeadlineType.NORMAL;
        }

        softwareHouse.printTeam();

        System.out.println();
        System.out.println("Monthly cost: " + softwareHouse.calculateMonthlyCost());

        softwareHouse.runProject(deadlineType);

        System.out.println();
        System.out.println("Final report:");
        softwareHouse.printTeam();

        System.out.println();
        System.out.println("Final monthly cost: " + softwareHouse.calculateMonthlyCost());

        System.out.println();
        softwareHouse.printEmployees();

        System.out.println();
        System.out.println("Polymorphism example:");

        Slave polymorphicReference = new Programmer("Karol", "Polimorficzny", 17000, "Kotlin");

        System.out.println(polymorphicReference);

        System.out.println();
        System.out.println("instanceof example:");

        if (polymorphicReference instanceof Employee) {
            Employee employee = (Employee) polymorphicReference;

            employee.increaseSalary(1000);
            System.out.println(employee);
        }

        System.out.println();
        System.out.println("equals example:");
        softwareHouse.compareMembers(programmer, qa);
    }
}