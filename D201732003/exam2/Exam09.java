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
	Override vs Overloading 차이점
	공통점은 다형성을 지원하는 방법이다.
	Overloading - 함수의 이름은 같으나 반환 타입이나 인자의 갯수,
	 인자의 타입이 다른경우 함수를 재정의 하는것

	 Override - 상속의 관계에서 부모와 자식의 함수(메서드)가 같은 
	 기능을 수행하지만 함수의 내용이 다른 경우 자식의 클래스에서 함수를 재정의 하는것.

	다형성을 구현하는 이유 >> 코드가 줄어듬
	 *****************************/
	static void doSomething(Parent child) {
		child.method1();
	}

	public static void main(String[] args) {
		Child1 child1 = new Child1();
		Child2 child2 = new Child2();
		doSomething(child1); // 다형성 호출이 아님
		doSomething(child2); // 다형성 호출이 아님
	}
}
