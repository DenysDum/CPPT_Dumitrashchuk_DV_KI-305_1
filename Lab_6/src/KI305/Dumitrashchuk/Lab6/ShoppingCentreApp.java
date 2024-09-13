/**
 * Пакет лабораторної роботи №6
 */
package KI305.Dumitrashchuk.Lab6;

/**
 * Клас-драйвер для тестування класу <code>ShoppingCenter</code>.
 */
public class ShoppingCentreApp {

	/**
	 * Головний метод для тестування <code>ShoppingCenter</code>
	 * @param args у даній програмі не використовується
	 */
	public static void main(String[] args) {
		// Створюємо екземпляр торгового центру
        ShoppingCenter<Store> shoppingCenter = new ShoppingCenter<>();

        // Створюємо кілька магазинів
        GroceryStore groceryStore = new GroceryStore("Продукти", 120);
        ClothingStore clothingStore = new ClothingStore("Одяг", 200);
        BookStore bookStore = new BookStore("Книги", 150);
        ElectronicsStore electronicsStore = new ElectronicsStore("Електроніка", 90);

        // Додаємо магазини в торговий центр
        shoppingCenter.addStore(groceryStore);
        shoppingCenter.addStore(clothingStore);
        shoppingCenter.addStore(bookStore);
        shoppingCenter.addStore(electronicsStore);

        // Виводимо інформацію про всі магазини
        System.out.println("Магазини в торговому центрі:");
        for (Store store : shoppingCenter.getStores()) {
            System.out.println(store);
        }

        // Знаходимо магазин з максимальною кількістю товарів
        Store maxStore = shoppingCenter.findStoreWithMaxProducts();
        System.out.println("\nМагазин з максимальною кількістю товарів: " + maxStore);

        // Шукаємо магазин за назвою
        Store foundStore = shoppingCenter.findStoreByName("Книги");
        System.out.println("\nЗнайдений магазин: " + foundStore);

        // Виводимо загальну кількість товарів
        int totalProducts = shoppingCenter.getTotalProductCount();
        System.out.println("\nЗагальна кількість товарів у всіх магазинах: " + totalProducts);
    }

}

