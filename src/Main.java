public class Main {
    public static void printSeparator() {
        System.out.println("_________________________________________________________________________________________________________");
    }

    public static void main(String[] args) {
        StaffBook staffBook = new StaffBook();

        staffBook.addStaffBook("Volf Lev Dmitrievich", 2, 62000);
        staffBook.addStaffBook("Ivanov Ivan Ivanovich", 3, 45000);
        staffBook.addStaffBook("Petrov Petr Petrovich", 2, 52000);
        staffBook.addStaffBook("Sidorov Stepan Ivanovich", 1, 44000);
        staffBook.addStaffBook("Ivanov Petr Vladimirovich", 3, 55000);
        staffBook.addStaffBook("Safronov Lev Fomich", 4, 59000);
        staffBook.addStaffBook("Serov Ivan Ivanovich", 4, 46000);
        staffBook.addStaffBook("Pavlov Petr Petrovich", 5, 53000);
        staffBook.addStaffBook("Kraf Stepan Sergeevich", 1, 39000);
        printSeparator();
        System.out.println("Сотрудники компании");
        staffBook.printAllEmployee();
        printSeparator();
        System.out.printf("Затраты на заработную плату сотрудникам компании в месяц составили: %11.2f рублей\n", staffBook.calculateSumSalary());
        printSeparator();
        System.out.println("Минимальная зарплата сотрудника компании составляет: " + staffBook.getMinSalary() + " рублей");
        staffBook.printEmployeeWithMin();
        printSeparator();
        System.out.println("Максимальная зарплата сотрудника компании составляет: " + staffBook.getMaxSalary() + " рублей");
        staffBook.printEmployeeWithMaxSalary();
        printSeparator();
        System.out.printf("Средняя заработная плата сотрудника компании составляет: %9.2f рублей\n", staffBook.getAverageSalaryOfEmployees());
        printSeparator();
        System.out.println("Фамилии имена и отчества всех сотрудников компании: ");
        staffBook.getFullNameEmployees();
        printSeparator();
        staffBook.indexSalary(10);
        staffBook.showIndexSalary();
        printSeparator();
        System.out.println("Минимальная заработная плата сотрудника в отделе:\n" + staffBook.getMinSalaryDepartment(3));
        printSeparator();
        System.out.println("Максимальная заработная плата сотрудника в отделе:\n" + staffBook.getMaxSalaryDepartment(2));
        printSeparator();
        System.out.printf("Затраты на заработную плату по отделу составили: %12.2f рублей\n", staffBook.getSumSalaryDepartment(3));
        printSeparator();
        System.out.printf("Средняя заработная плата сотрудников отдела составляет: %.2f рублей\n", staffBook.departmentAverageSalary(4));
        printSeparator();
        staffBook.indexSalaryInDepartment(3, 10);
        printSeparator();
        System.out.println("Данные о работниках отдела: ");
        staffBook.showEmployeeDataInDepartment(4);
        printSeparator();
        System.out.print("Сотрудники компании с зарплатой меньше ");
        staffBook.findLowerSalary(6000);
        printSeparator();
        System.out.print("Сотрудники компании с зарплатой больше ");
        staffBook.findHigherSalary(120000);
        printSeparator();
        staffBook.addStaffBook("Levin Petr Vladimirovich", 5, 58000);
        System.out.println("Список сотрудников компании после добавления еще одного сотрудника");
        staffBook.printAllEmployee();
        printSeparator();

        staffBook.deleteEmployee(2);
        System.out.println("Откорректированный список после удаления сотрудника по id");
        staffBook.printAllEmployee();
        printSeparator();

        staffBook.setSalaryEmployees("Safronov Lev Fomich", 44000);
        System.out.println("Откорректированный список после изменения зарплаты сотрудника");
        staffBook.printAllEmployee();
        printSeparator();

        staffBook.setDepartmentEmployee("Safronov Lev Fomich", 3);
        System.out.println("Откорректированный список после перевода сотрудника в другой отдел (корректировка данных в системе по фамилии)");
        staffBook.printAllEmployee();
        printSeparator();
        System.out.println("Списки сотрудников компании по отделам");
        System.out.println(" ");
        staffBook.printEmployeesDepartment();
    }
}

