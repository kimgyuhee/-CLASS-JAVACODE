package exam2;

/**********************************************
class Hello {
	World world;

	public Hello(World world) {
		this.world = world;
	}

	public void say() {
		System.out.println(world.message);
	}

}
********************************************/
class World {
	String message = "�ȳ��ϼ���";

	public void doSomething() {
		Hello hello = new Hello();
		hello.say();
	}
	
	//�߰��� �κ�
	class Hello{
		public void say() {
			System.out.println(message);
		}
	}
}

public class Exam12 {

	public static void main(String[] args) {
		World world = new World();
		world.doSomething();
	}
}
