import java.util.ArrayList;

public class BusinessEmployee extends Employee {
    public double bonusBudget;

    public BusinessEmployee(String name){
        super(name, 50000);
    }

    public double getBonusBudget(){
        return bonusBudget;
    }

    public String employeeStatus(){
        return this.toString() + " with a budget of " + getBonusBudget();
    }

    public static class BusinessLead extends BusinessEmployee{
        private int headCount;
        private ArrayList<Accountant> directReports = new ArrayList<>();

        public BusinessLead(String name){
            super(name);
            this.setBaseSalary(2 * super.getBaseSalary());
            this.setIsManager(true);
            headCount = 10;
            bonusBudget = 0;
        }

        public boolean hasHeadCount(){
            return directReports.size() < headCount;
        }

        public boolean addReport(Accountant e, TechnicalEmployee.TechnicalLead supportTeam){
            if (hasHeadCount()){
                directReports.add(e);
                bonusBudget += 1.1 * e.getBaseSalary();
                e.supportTeam(supportTeam);
                ArrayList<Employee> team = new ArrayList<>();
                team.add(this);
                team.add(e);
                team.add(supportTeam);
                setTeams(team);
                return true;
            } else {
                return false;
            }
        }

        public boolean requestBonus(Employee e, double bonus){
            if (bonus > bonusBudget){
                return false;
            } else {
                e.setBaseSalary(e.getBaseSalary() + bonus);
                this.bonusBudget -= bonus;
                return true;
            }
        }

        public boolean approveBonus(Employee e, double bonus){
            boolean result = false;
            for (int i = 0; i < this.directReports.size(); i++) {
                if (this.directReports.get(i).getTeamSupported().directReports.contains(e)) {
                    if (bonus > this.directReports.get(i).getBonusBudget()) {
                        result = false;
                    } else {
                        e.setBaseSalary(e.getBaseSalary() + bonus);
                        result = true;
                    }
                }
            }
            return result;
        }

        public String getTeamStatus(){
            if (directReports.size() == 0){
                return this.employeeStatus() + " and no direct reports yet";
            } else {
                String build = "" + this.employeeStatus() + " and is managing:\n";
                for (int i = 0; i < directReports.size(); i++){
                    build += directReports.get(i).employeeStatus() + "\n";
                }
                return build;
            }
        }
    }

    public static class Accountant extends BusinessEmployee{
        private TechnicalEmployee.TechnicalLead teamSupported;


        public Accountant(String name){
            super(name);
            bonusBudget = 0;
            teamSupported = null;
        }

        public TechnicalEmployee.TechnicalLead getTeamSupported(){
            return teamSupported;
        }

        public void supportTeam(TechnicalEmployee.TechnicalLead lead){
            teamSupported = lead;
            for (int i = 0; i < lead.directReports.size(); i++){
                bonusBudget += 1.1 * lead.directReports.get(i).getBaseSalary();
            }
        }

        public boolean approveBonus(double bonus){
            if (this.getTeamSupported() == null){
                return false;
            } else {
                return bonus <= bonusBudget;
            }
        }

        public String employeeStatus(){
            return super.employeeStatus() + " is supporting " + this.getTeamSupported();
        }
    }
}
