import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class Deneme2 {

	private static Scanner input;

	public static void main(String[] args) throws FileNotFoundException {
		input = new Scanner(new File("res/level1.txt"));
		input.useDelimiter(",|\n");

		Product[] products = new Product[0];
		while (input.hasNext()) {
			int location = input.nextInt();
			String type = input.next();
			String specs = input.next();
			

			Product newProduct = new Product(location, type, specs);
			products = addProduct(products, newProduct);
		}

		for (Product product : products) {
			System.out.println(product);
		}
	}

	private static Product[] addProduct(Product[] products, Product productToAdd) {
		Product[] newProducts = new Product[products.length + 1];
		System.arraycopy(products, 0, newProducts, 0, products.length);
		newProducts[newProducts.length - 1] = productToAdd;

		return newProducts;
	}
}

 class Product {
	protected int location;
	protected String type;
	protected String specs;

	//private static NumberFormat formatter = new DecimalFormat("#0.00");

	public Product(int l,String t, String s) {
		location = l;
		type = t;
		specs = s;
	}

	@Override
	public String toString() {
		return String.format("location: %d\r\nType: %s\r\nSpecs: %s\r\n",location,type,specs);
	}
}