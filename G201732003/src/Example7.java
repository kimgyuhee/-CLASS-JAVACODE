import java.util.Objects;

class Product {
	int id;
	String name;
	String category;

	public Product(int id, String name, String category) {
		this.id = id;
		this.name = name;
		this.category = category;
	}

	@Override
	public int hashCode() {
		// 구현
		return Objects.hash(id, name, category);
	}


	@Override
	public boolean equals(Object obj) {
		// 구현
		if(this==obj) return false;
		if(obj instanceof Product==false) return false;
		Product p = (Product)obj;
		return this.id == p.id && Objects.equals(this.name, p.name) && Objects.equals(this.category, p.category);
	}

}
public class Example7 {
	public static void main(String[] args) {
		Product product1 = new Product(1, "볼펜", "학용품");
		Product product2 = new Product(2, "연필", "학용품");
		Product product3 = new Product(1, "볼펜", "사무용품");
		Product product4 = new Product(1, null, "학용품");
		Product product5 = new Product(1, "볼펜", null);
		Product product6 = new Product(1, "볼펜", "학용품");

		System.out.println(product1.equals(null));
		System.out.println(product1.equals(product2));
		System.out.println(product1.equals(product3));
		System.out.println(product1.equals(product4));
		System.out.println(product1.equals(product5));
		System.out.println(product1.equals(product6));
		System.out.println(product1.hashCode() == product6.hashCode());
	}

}
