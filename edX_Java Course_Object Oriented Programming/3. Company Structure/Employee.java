import java.util.ArrayList;

public abstract class Employee {
    private String name;
    private double baseSalary;
    private static ArrayList<Employee> listOfEmployees = new ArrayList<>();
    private int employeeID;
    private boolean isManager;
    private static ArrayList<ArrayList<Employee>> teams = new ArrayList<>();

    public Employee(String name, double baseSalary){
        this.name = name;
        this.baseSalary = baseSalary;
        listOfEmployees.add(this);
        employeeID = listOfEmployees.indexOf(this) + 1;
        isManager = false;
    }

    public double getBaseSalary(){
        return baseSalary;
    }

    public void setBaseSalary (double salary){
        baseSalary = salary;
    }

    public String getName(){
        return name;
    }

    public boolean getIsManager(){
        return isManager;
    }

    public void setIsManager(boolean setManager){
        isManager = setManager;
    }

    public int getEmployeeID(){
        return employeeID;
    }

    public ArrayList<ArrayList<Employee>> getTeams(){
        return teams;
    }

    public void setTeams (ArrayList<Employee> team){
        teams.add(team);
    }

    public Employee getManager(){
        if (this instanceof BusinessEmployee.Accountant) {
            for (int i = 0; i < teams.size(); i++) {
                for (int j = 0; j < 3; j++) {
                    if (teams.get(i).get(j) instanceof BusinessEmployee.Accountant) {
                        for (int k = 0; k < 3; k++) {
                            if (teams.get(i).get(k) instanceof BusinessEmployee.BusinessLead) {
                                return teams.get(i).get(k);
                            }
                        }
                    }
                }
            }
        } else if (this instanceof TechnicalEmployee.SoftwareEngineer) {
            for (int i = 0; i < teams.size(); i++) {
                for (int j = 0; j < 3; j++) {
                    if (teams.get(i).get(j) instanceof TechnicalEmployee.TechnicalLead) {
                        if (((TechnicalEmployee.TechnicalLead) teams.get(i).get(j)).directReports.contains(this)) {
                            return teams.get(i).get(j);
                        }
                    }
                }
            }
        } else if (this instanceof TechnicalEmployee.TechnicalLead) {
            for (int i = 0; i < teams.size(); i++) {
                for (int j = 0; j < 3; j++) {
                    if (teams.get(i).get(j) instanceof TechnicalEmployee.TechnicalLead) {
                        for (int k = 0; k < 3; k++) {
                            if (teams.get(i).get(k) instanceof BusinessEmployee.BusinessLead) {
                                return teams.get(i).get(k);
                            }
                        }
                    }
                }
            }
        } else {
            return this;
        }

        return this;
    }

    public boolean equals(Employee other){
        return this.employeeID == other.employeeID;
    }

    public String toString(){
        return employeeID + " " + name;
    }

    public abstract String employeeStatus();
}
