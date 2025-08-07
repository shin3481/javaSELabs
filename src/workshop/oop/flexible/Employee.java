package workshop.oop.flexible;
/* abstract class
 * �߻�Ŭ������ ��ü�� ������ �� ����. Employee e = new Employee(); (x)
 * 							Employee m = new Manager(); (o)
 * �߻�޼��带 �ϳ� �̻� ������ ������ ������ �߻�Ŭ������ �ȴ�.
 * Super Ŭ������ �޼��尡  �߻�޼����̸� , Sub Ŭ�������� �� �߻�޼��带 
 * �ݵ�� �������̵� �ؾ� �Ѵ�. 
 */
public abstract class Employee {

	private String name;
	protected double salary;

	
	public Employee(String name, double salary) {
		super();
		this.name = name;
		this.salary = salary;
	}

	//Concrete Method (�ٵ��ִ� �޼���)
	public String getName() {
	    return this.name;
	}

	public double getSalary() {
	    return this.salary;
	}
	
	//Abstract Method (�߻�޼���)
	public abstract void manageSalary(double rate);

}