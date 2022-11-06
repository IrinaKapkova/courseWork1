import java.util.Arrays;

public class StaffBook {
    private final Employee[] staffBook;

    public StaffBook() {
        this.staffBook = new Employee[10];
    }

    public void addStaffBook(String fullName, int department, double salary) {
        for (int i = 0; i < staffBook.length; i = i + 1) {
            if (staffBook[i] == null) {
                staffBook[i] = new Employee(fullName, department, salary);
                return;
            }
        }
    }

    public void printAllEmployee() {
        for (Employee employees : staffBook) {
            if (employees != null) {
                System.out.printf("Табельный  номер сотрудника №%-2d ФИО: %40s, № %-1d отдела , зарплата: %,10.2f рублей\n", employees.getId(), employees.getFullName(), employees.getDepartment(), employees.getSalary());
            }
        }
    }

    public double calculateSumSalary() {
        double sumSalary = 0;
        for (Employee employee : staffBook) {
            if (employee != null) {
                sumSalary += employee.getSalary();
            }
        }
        return sumSalary;
    }

    public double getMinSalary() {
        double minTotalSalary = Double.MAX_VALUE;
        for (Employee employee : staffBook) {
            if (employee != null && employee.getSalary() < minTotalSalary) {
                minTotalSalary = employee.getSalary();
            }
        }
        return minTotalSalary;
    }

    public void printEmployeeWithMin() {
        for (Employee employee : staffBook) {
            if (employee != null && employee.getSalary() == getMinSalary()) {
                System.out.printf("Табельный  номер сотрудника №%-2d  - %-50s, %-1d отдел\n", employee.getId(), employee.getFullName(), employee.getDepartment());
            }
        }
    }

    public double getMaxSalary() {
        double max = Double.MIN_VALUE;
        for (Employee employee : staffBook) {
            if (employee != null && employee.getSalary() > max) {
                max = employee.getSalary();
            }
        }
        return max;
    }

    public void printEmployeeWithMaxSalary() {
        for (Employee employee : staffBook) {
            if (employee != null && employee.getSalary() == getMaxSalary()) {
                System.out.printf("Табельный  номер сотрудника №%-2d - %s, %d отдел\n", employee.getId(), employee.getFullName(), employee.getDepartment());
            }
        }
    }

    public double getAverageSalaryOfEmployees() {
        int counter = 0;
        for (Employee employee : staffBook) {
            if (employee != null) ;
            {
                counter++;
            }
        }
        return calculateSumSalary() / counter;
    }

    public void getFullNameEmployees() {
        for (Employee employees : staffBook) {
            if (employees != null) {
                System.out.printf("%s \n", employees.getFullName());
            }
        }
    }

    public void indexSalary(double percent) {
        double kof = percent / 100;
        for (Employee employees : staffBook) {
            if (employees != null) {
                double salary = employees.getSalary();
                employees.setSalary(salary + kof * salary);
            }
        }
        System.out.println("Проиндексированна заработная плата сотрудников на " + percent + " %");
    }

    public void showIndexSalary() {
        System.out.println("Проиндексированная заработная плата сотрудников:");
        for (Employee employee : staffBook) {
            if (employee != null) {
                System.out.printf("%s: %.2f рублей\n", employee.getFullName(), employee.getSalary());
            }
        }
    }

    public Employee[] filterDepartment(int department) {
        return Arrays.stream(staffBook).filter(x -> (x != null) && (x.getDepartment() == department)).toArray(Employee[]::new);
    }

    public Employee getMinSalaryDepartment(int department) {
        Employee result = staffBook[0];
        double min = Double.MAX_VALUE;
        for (Employee employee : filterDepartment(department)) {
            if (employee != null && employee.getSalary() < min) {
                min = employee.getSalary();
                result = employee;
            }
        }
        return result;
    }

    public Employee getMaxSalaryDepartment(int department) {
        Employee result = staffBook[0];
        double max = Double.MIN_VALUE;
        for (Employee employee : filterDepartment(department)) {
            if (employee != null && employee.getSalary() > max) {
                max = employee.getSalary();
                result = employee;
            }
        }
        return result;
    }

    public double getSumSalaryDepartment(int department) {
        double sumDepartment = 0;
        for (Employee employee : filterDepartment(department)) {
            if (employee != null) {
                sumDepartment += employee.getSalary();
            }
        }
        return sumDepartment;
    }

    public double departmentAverageSalary(int department) {
        double average = 0;
        for (Employee employee : filterDepartment(department)) {
            if (employee != null) {
                average += employee.getSalary() / filterDepartment(department).length;
            }
        }
        return average;
    }

    public void indexSalaryInDepartment(int department, double percent) {
        System.out.println("Заработная плата по отделу №" + department + " после индексации на " + percent + " % составила");
        double kof = percent / 100;
        for (Employee employee : filterDepartment(department)) {
            if (employee != null) {
                employee.setSalary(employee.getSalary() + (employee.getSalary() * kof));
                System.out.println(employee.withOutDepartment());
            }
        }
    }

    public void showEmployeeDataInDepartment(int department) {
        for (Employee employee : filterDepartment(department)) {
            if (employee != null) {
                System.out.println(employee.withOutDepartment());
            }
        }
    }

    public void findLowerSalary(double number) {
        System.out.printf("%,9.2f  рублей:\n", number);
        for (Employee employees : staffBook) {
            if (employees != null && employees.getSalary() < number) {
                System.out.println(employees.withOutDepartment());
            }
        }
        if (number < getMinSalary()) {
            System.out.println("Сотрудников с такой заработной платой нет.");
        }
    }

    public void findHigherSalary(double number) {
        System.out.printf("%,9.2f  рублей:\n", number);
        for (Employee employees : staffBook) {
            if (employees != null && employees.getSalary() >= number) {
                System.out.println(employees.withOutDepartment());
            }
        }
        if (number > getMaxSalary()) {
            System.out.println("Сотрудников с такой заработной платой нет.");
        }

    }

    public boolean deleteEmployee(int id) {
        for (int i = 0; i < staffBook.length; i++) {
            if (staffBook[id] != null && staffBook[i].getId() == id) {
                staffBook[i] = null;
                return true;
            }
        }
        return false;
    }

    public int getEmployeeIndex(String fullName) {
        for (int i = 0; i < staffBook.length; i++) {
            if (staffBook[i] != null && staffBook[i].getFullName().equals(fullName)) {
                return i;
            }
        }
        return -1;
    }

    public void setSalaryEmployees(String fullName, double salary) {
        int index = getEmployeeIndex(fullName);
        for (int i = index; i < staffBook.length; i++) {
            if (staffBook[i] != null) {
                staffBook[index].setSalary(salary);
            }
        }
    }

    public void setDepartmentEmployee(String fullName, int department) {
        int index = getEmployeeIndex(fullName);
        for (int i = index; i < staffBook.length; i++) {
            if (staffBook[i] != null) {
                staffBook[index].setDepartment(department);
            }
        }
    }

    public String DepartmentEmployees(int department) {
        for (Employee employee
                : this.filterDepartment(department)) {
            if (employee != null) {
                System.out.println(employee.withOutDepartment());
            }
        }
        return "";
    }

    public void printEmployeesDepartment() {
        for (int i = 1; i <= 5; i++) {
            this.filterDepartment(i);
            System.out.println("Сотрудники № " + i + " отдела:");
            System.out.println(DepartmentEmployees(i));
        }
    }
}


