public class CompanyStructure {
    public static void main(String[] args) {
        TechnicalEmployee.TechnicalLead CTO = new TechnicalEmployee.TechnicalLead("Satya Nadella");
        TechnicalEmployee.SoftwareEngineer seA = new TechnicalEmployee.SoftwareEngineer("Kasey");
        TechnicalEmployee.SoftwareEngineer seB = new TechnicalEmployee.SoftwareEngineer("Breana");
        TechnicalEmployee.SoftwareEngineer seC = new TechnicalEmployee.SoftwareEngineer("Eric");
        CTO.addReport(seA);
        CTO.addReport(seB);
        CTO.addReport(seC);
        System.out.println(CTO.getTeamStatus());

        TechnicalEmployee.TechnicalLead VPofENG = new TechnicalEmployee.TechnicalLead("Bill Gates");
        TechnicalEmployee.SoftwareEngineer seD = new TechnicalEmployee.SoftwareEngineer("Winter");
        TechnicalEmployee.SoftwareEngineer seE = new TechnicalEmployee.SoftwareEngineer("Libby");
        TechnicalEmployee.SoftwareEngineer seF = new TechnicalEmployee.SoftwareEngineer("Gizan");
        TechnicalEmployee.SoftwareEngineer seG = new TechnicalEmployee.SoftwareEngineer("Zaynah");
        VPofENG.addReport(seD);
        VPofENG.addReport(seE);
        VPofENG.addReport(seF);
        VPofENG.addReport(seG);
        System.out.println(VPofENG.getTeamStatus());

        BusinessEmployee.BusinessLead CFO = new BusinessEmployee.BusinessLead("Amy Hood");
        BusinessEmployee.Accountant actA = new BusinessEmployee.Accountant("Niky");
        BusinessEmployee.Accountant actB = new BusinessEmployee.Accountant("Andrew");
        CFO.addReport(actA, CTO);
        CFO.addReport(actB, VPofENG);
        System.out.println(CFO.getTeamStatus());

        System.out.println("seA name: " + seA.getName());
        System.out.println("seA base salary: " + seA.getBaseSalary());
        System.out.println("Is seA a manager? " + seA.getIsManager());
        System.out.println("seA employee ID: " + seA.getEmployeeID());
        System.out.println("seA's manager: " + seA.getManager());
        System.out.println("seD's manager: " + seD.getManager());
        System.out.println("Is seA and seB the same employee? " + seA.equals(seB));
        System.out.println(seA);
        System.out.println();

        System.out.println(seA.getName() + "'s salary before request for bonus: " + seA.getBaseSalary());
        System.out.println("Is " + seA.getName() + "'s bonus approved: " + CTO.requestBonus(seA, 5000));
        System.out.println(seA.getName() + "'s salary after request for bonus: " + seA.getBaseSalary());
    }
}
