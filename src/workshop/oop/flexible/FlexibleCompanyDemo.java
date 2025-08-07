package workshop.oop.flexible;

public class FlexibleCompanyDemo {
    public static void main(String[] args) {
        
        MereClerk mereClerk1 = new MereClerk("ö��", 100);
        MereClerk mereClerk2 = new MereClerk("����", 100);
        Manager hrMgr = new Manager("ȫ�浿", 200);
        //�ڽ�mgr = new �ڽ�
        Manager mgr1 = new Manager("�Ѹ�",200,"HR");
        System.out.println(hrMgr.getName());
        System.out.println(hrMgr.getSalary());
        System.out.println(hrMgr.getDept());
        
        //������(Polymorphism) Poly(�پ���) + Morphism(����, ����)
        Employee itMgr = new Manager("�浿",250,"IT");
        System.out.println(itMgr.getName());
        System.out.println(itMgr.getSalary());
        //Manager(�ڽ�)�� ���� getDept() �޼��� ȣ��
        Manager itMgr2 = (Manager)itMgr;
        System.out.println(itMgr2.getDept());
        

        
        //Heterogeneous Collection Employee Ÿ���� �迭�� �����ϱ�
        //emps ������ Employee[]Ÿ��, emps[0]�� EmployeeŸ��
        Employee[] emps = new Employee[4];
        emps[0] = new Manager("�浿",250,"IT");
        emps[1] = new MereClerk("ö��", 100);
        emps[2] = new MereClerk("����", 100);
        emps[3] = new Manager("�Ѹ�",200,"HR");
        //
        System.out.println("���� �����Դϴ�.");
        printEmployeeInfo(emps);
        //
        for(Employee emp: emps) {
            emp.manageSalary(10);
        }
        //
    	System.out.println("�ø� ���� �����Դϴ�.");
        printEmployeeInfo(emps);
   }

	public static void printEmployeeInfo(Employee[] emps) {
		for(Employee emp: emps) {
			//emp�� Manager ��ü�� ���� ������� instance ������ üũ�ϴ� �����ڰ� instanceof
			if(emp instanceof Manager) {
				System.out.print("������ �μ��� = " + ((Manager)emp).getDept()+ " ");
			}
			
            System.out.println(emp.getName() + "�� ���� ������ " + emp.getSalary() + " ���� �Դϴ�.");

        }
	}
}

