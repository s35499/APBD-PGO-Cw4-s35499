# Software House Team Simulation

This is a simple Java console application created as an object-oriented programming exercise.

The application models a small software house team. It demonstrates inheritance, method overriding, polymorphism, `instanceof`, safe casting, `final` methods, `toString()`, `equals()`, and working with an `ArrayList` of objects using a parent type.

## Project idea

The program simulates a software house working under different deadline conditions.

The team may contain:

- interns,
- programmers,
- designers,
- QA engineers.

Each person has a health status, exhaustion level, and rebellion level. Employees also have salaries. Depending on the deadline scenario, team members may work softly, work hard, rest, receive salary increases, receive salary decreases, rebel, quit, or die from exhaustion.

## Class structure

```text
Slave
├── Intern
└── Employee
    ├── Programmer
    ├── Designer
    └── QA
```

## Main classes

### Slave

Slave is the base class for all team members.

It contains common fields such as:

- unique ID,
- name,
- surname,
- health status,
- exhaustion level,
- readiness to rebel.

It also contains shared behavior:

- working softly,
- working hard,
- changing exhaustion level,
- changing rebellion level,
- checking if the person is alive,
- toString(),
- equals().

The `equals()` method compares objects by their unique ID.

### Intern

Intern extends Slave.

It represents an intern in the team. It mostly uses the base behavior from Slave, but has its own `toString()` method and additional information about a fictional university.

### Employee

Employee extends Slave.

It adds employee-specific fields and behavior:

- salary,
- employment status,
- increasing salary,
- decreasing salary,
- resting,
- quitting when rebellion is high.

This class is the parent class for specific employee roles.

### Programmer

Programmer extends Employee.

It represents a programmer. Programmers react strongly to salary changes. They may become rebellious faster after salary decreases, but salary increases also reduce their rebellion more effectively.

### Designer

Designer extends Employee.

It represents a designer. Designers have their own reaction values for salary changes and quitting threshold.

### QA

QA extends Employee.

It represents a QA engineer. QA employees may be manual or automation testers. Automation testers are more stable and less likely to quit.

### SoftwareHouse

SoftwareHouse manages the whole team.

It stores all team members in:

`ArrayList<Slave>`

This shows polymorphism, because the list can contain objects of different subclasses:

```java
new Intern(...)
new Programmer(...)
new Designer(...)
new QA(...)
```

The class can:

- add team members,
- print the team,
- calculate monthly cost,
- find a member by UUID,
- print employees only,
- compare members with equals(),
- run one of the deadline scenarios.
 
#### DeadlineType

DeadlineType is an enum representing available project scenarios:

```
NORMAL
HARD
HELL
```

## Object-oriented programming concepts used

### Inheritance

Classes inherit from other classes:

```java
public class Employee extends Slave
```

```java
public class Programmer extends Employee
```

### Method overriding

Subclasses override methods from parent classes:

```java
@Override
public String toString() {
    return "...";
}
```

### Polymorphism

Objects of different classes are stored using the parent type:

```java
Slave programmer = new Programmer(...);
Slave designer = new Designer(...);
Slave intern = new Intern(...);
```

They can also be stored in one list:

```java
ArrayList<Slave> teamMembers = new ArrayList<>();
```

#### `instanceof` and safe casting

The program checks object types before casting:

```java
if (member instanceof Employee) {
    Employee employee = (Employee) member;
    employee.increaseSalary(1000);
}
```

#### `final` method

The base class contains a final method, for example:

```java
public final String getUuid()
```

This means subclasses cannot override it.

#### `toString()`

Classes override `toString()` to print readable object information.

#### `equals()`

The base class overrides `equals()` to compare team members by `UUID`.

## Deadline scenarios

### `NORMAL`

A calm project scenario.

Team members work softly. Employees may rest. Health and rebellion levels should remain relatively stable.

### `HARD`

A more difficult project scenario.

Some employees receive salary increases, some receive salary decreases, and interns work harder. Some people may become exhausted, rebellious, or leave.

### `HELL`

The most extreme project scenario.

The team works under heavy pressure for multiple days. Some employees may receive high salary increases and stay, but may still die from exhaustion. Others may quit because of rebellion.

## How to run

Open the project in IntelliJ IDEA.

Make sure the src directory is marked as:

```
Sources Root
```

Then run:

```java
Main.main()
```

The program will ask for a deadline type:

```
1 - NORMAL
2 - HARD
3 - HELL
```

After choosing a scenario, the program prints the initial team, runs the simulation, and then prints the final report.

## Purpose

The purpose of this project is not to create a realistic business application.
The goal is to demonstrate basic object-oriented programming concepts in Java in a simple console program.