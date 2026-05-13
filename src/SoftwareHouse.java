import java.util.ArrayList;
import enums.DeadlineType;

public class SoftwareHouse {
    private String name;
    private ArrayList<Slave> teamMembers;

    public SoftwareHouse(String name) {
        this.name = name;
        this.teamMembers = new ArrayList<>();
    }

    public void addMember(Slave member) {
        teamMembers.add(member);
    }

    public void printTeam() {
        System.out.println("Software house: " + name);
        System.out.println("Team members:");

        for (Slave member : teamMembers) {
            System.out.println(member);
        }
    }

    public double calculateMonthlyCost() {
        double sum = 0;

        for (Slave member : teamMembers) {
            if (member instanceof Employee) {
                Employee employee = (Employee) member;
                sum += employee.getSalary();
            }
        }

        return sum;
    }

    public Slave findByUuid(String uuid) {
        for (Slave member : teamMembers) {
            if (member.getUuid().equals(uuid)) {
                return member;
            }
        }

        return null;
    }

    public void printEmployees() {
        System.out.println("Employees:");

        for (Slave member : teamMembers) {
            if (member instanceof Employee) {
                Employee employee = (Employee) member;
                System.out.println(employee);
            }
        }
    }

    public void compareMembers(Slave first, Slave second) {
        System.out.println("Are members equal?");
        System.out.println(first.equals(second));
    }

    public void runProject(DeadlineType deadlineType) {
        System.out.println();
        System.out.println("Running project with deadline: " + deadlineType);

        switch (deadlineType) {
            case NORMAL:
                runNormalDeadline();
                break;
            case HARD:
                runHardDeadline();
                break;
            case HELL:
                runHellDeadline();
                break;
            default:
                System.out.println("Unknown deadline type.");
        }
    }

    private void runNormalDeadline() {
        for (Slave member : teamMembers) {
            try {
                member.workSoftly();

                if (member instanceof Employee) {
                    Employee employee = (Employee) member;
                    employee.rest();
                }
            } catch (IllegalStateException error) {
                System.out.println(error.getMessage());
            }
        }
    }

    private void runHardDeadline() {
        for (Slave member : teamMembers) {
            try {
                member.workHard();
                member.workHard();

                if (member instanceof Employee) {
                    Employee employee = (Employee) member;

                    if (employee instanceof Programmer) {
                        employee.increaseSalary(3000);
                    } else if (employee instanceof QA) {
                        employee.increaseSalary(1500);
                    } else if (employee instanceof Designer) {
                        employee.decreaseSalary(1000);
                    }
                }

                if (member instanceof Intern) {
                    member.workHard();
                    member.workHard();
                    member.workHard();
                }
            } catch (IllegalStateException error) {
                System.out.println(error.getMessage());
            }
        }
    }

    private void runHellDeadline() {
        for (int day = 1; day <= 8; day++) {
            System.out.println();
            System.out.println("Day " + day + " of hell deadline");

            for (Slave member : teamMembers) {
                try {
                    if (member instanceof Employee) {
                        Employee employee = (Employee) member;

                        if (employee instanceof Programmer) {
                            employee.increaseSalary(5000);
                        } else {
                            employee.decreaseSalary(2000);
                        }
                    }

                    member.workHard();
                    member.workHard();
                } catch (IllegalStateException error) {
                    System.out.println(error.getMessage());
                }
            }
        }
    }
}
