package exam2;

interface Parent {
	void method1();
}

class Child1 implements Parent{
	@Override
	public void method1() {
		System.out.println("Child1");
	}
}

class Child2 implements Parent{
	@Override
	public void method1() {
		System.out.println("Child2");
	}
}

public class Exam09 {

	/*****************************
	Override vs Overloading ������
	�������� �������� �����ϴ� ����̴�.
	Overloading - �Լ��� �̸��� ������ ��ȯ Ÿ���̳� ������ ����,
	 ������ Ÿ���� �ٸ���� �Լ��� ������ �ϴ°�

	 Override - ����� ���迡�� �θ�� �ڽ��� �Լ�(�޼���)�� ���� 
	 ����� ���������� �Լ��� ������ �ٸ� ��� �ڽ��� Ŭ�������� �Լ��� ������ �ϴ°�.

	�������� �����ϴ� ���� >> �ڵ尡 �پ��
	 *****************************/
	static void doSomething(Parent child) {
		child.method1();
	}

	public static void main(String[] args) {
		Child1 child1 = new Child1();
		Child2 child2 = new Child2();
		doSomething(child1); // ������ ȣ���� �ƴ�
		doSomething(child2); // ������ ȣ���� �ƴ�
	}
}
