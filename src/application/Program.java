package application;

import entities.Emplyoee;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<Emplyoee> emplyoeeList = new ArrayList<>();

        System.out.print("How many employees will be registered? ");
        int n = sc.nextInt();

        for (int i=0; i<n; i++) {

            System.out.println("Emplyoee #" + (i+1));

            System.out.print("Id: ");
            int id = sc.nextInt();

            sc.nextLine();

            System.out.print("Name: ");
            String name = sc.nextLine();

            System.out.print("Salary: ");
            double salary = sc.nextDouble();

            System.out.println();

            emplyoeeList.add(new Emplyoee(id, name, salary));
        }

        System.out.print("Enter the employee id that will have salary increase : ");
        int idIncrease = sc.nextInt();

        Emplyoee empId = emplyoeeList.stream().filter(x -> x.getId() == idIncrease).findFirst().orElse(null);

        if (empId == null) {
            System.out.println("this id does not exist!");
        } else {
            System.out.print("Enter the percentage: ");
            double percentage = sc.nextDouble();

            for (Emplyoee e: emplyoeeList) {
                if (idIncrease == e.getId()) {
                    e.increaseSalary(percentage);
                }
            }
        }

        System.out.println();

        System.out.println("List of employees:");
        for (Emplyoee emp : emplyoeeList) {
            System.out.println(emp);
        }

        sc.close();
    }
}
