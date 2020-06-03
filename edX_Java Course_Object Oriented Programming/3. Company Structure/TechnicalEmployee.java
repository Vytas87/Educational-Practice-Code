import java.util.ArrayList;

public class TechnicalEmployee extends Employee {
    public int successfulCheckIns;

    public TechnicalEmployee(String name){
        super(name, 75000);
    }

    public String employeeStatus(){
        return this.toString() + " has " + successfulCheckIns + " successful check ins";
    }

    public static class TechnicalLead extends TechnicalEmployee {
        private int headCount;
        public ArrayList<SoftwareEngineer> directReports = new ArrayList<>();

        public TechnicalLead(String name){
            super(name);
            this.setBaseSalary(1.3 * super.getBaseSalary());
            this.setIsManager(true);
            headCount = 4;
        }

        public boolean hasHeadCount(){
            return directReports.size() < headCount;
        }

        public boolean addReport(SoftwareEngineer e){
            if (this.hasHeadCount()){
                directReports.add(e);
                return true;
            } else {
                return false;
            }
        }

        public boolean approveCheckIn(SoftwareEngineer e){
            return directReports.contains(e) && e.getCodeAccess();
        }

        public boolean requestBonus(Employee e, double bonus){
            boolean result = false;
            for (int i = 0; i < getTeams().size(); i++) {
                if (getTeams().get(i).contains(this)) {
                    for (int j = 0; j < 3; j++) {
                        if (getTeams().get(i).get(j) instanceof BusinessEmployee.BusinessLead) {
                            result = ((BusinessEmployee.BusinessLead) getTeams().get(i).get(j)).approveBonus(e, bonus);
                            break;
                        } else {
                            result = false;
                        }
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

    public static class SoftwareEngineer extends TechnicalEmployee {
        private boolean codeAccess;

        public SoftwareEngineer(String name){
            super(name);
            codeAccess = false;
            successfulCheckIns = 0;
        }

        public boolean getCodeAccess(){
            return codeAccess;
        }

        public void setCodeAccess(boolean access){
            codeAccess = access;
        }

        public int getSuccessfulCheckIns(){
            return successfulCheckIns;
        }

        public boolean checkInCode(){
            if (((TechnicalLead) this.getManager()).approveCheckIn(this)){
                successfulCheckIns++;
                return true;
            } else {
                codeAccess = false;
                return false;
            }
        }
    }
}
