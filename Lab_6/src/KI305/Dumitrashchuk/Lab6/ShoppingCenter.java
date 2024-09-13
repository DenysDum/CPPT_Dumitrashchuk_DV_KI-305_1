/**
 * Пакет лабораторної роботи №6
 */
package KI305.Dumitrashchuk.Lab6;

import java.util.ArrayList;

/**
 * Клас <code>ShoppingCenter</code> - контейнер для зберігання магазинів.
 * Реалізує можливість додавання, видалення магазинів, пошук магазину
 * з максимальною кількістю товарів, пошук за назвою та підрахунок
 * загальної кількості товарів.
 */
public class ShoppingCenter<T extends Store> {
    private ArrayList<T> stores;

    /**
     * Конструктор класу <code>ShoppingCenter</code>
     */
    public ShoppingCenter() {
        stores = new ArrayList<>();
    }

    /**
     * Метод для додавання магазину до торгового центру.
     * @param store Магазин, який потрібно додати.
     */
    public void addStore(T store) {
        stores.add(store);
    }

    /**
     * Метод для видалення магазину з торгового центру.
     * @param store Магазин, який потрібно видалити.
     */
    public void removeStore(T store) {
        stores.remove(store);
    }

    /**
     * Метод для пошуку магазину з максимальною кількістю товарів.
     * @return Магазин з найбільшою кількістю товарів.
     */
    public T findStoreWithMaxProducts() {
        if (stores.isEmpty()) {
            return null;
        }

        T maxStore = stores.get(0);
        for (T store : stores) {
            if (store.getProductCount() > maxStore.getProductCount()) {
                maxStore = store;
            }
        }
        return maxStore;
    }

    /**
     * Метод для отримання всіх магазинів в торговому центрі.
     * @return Список всіх магазинів.
     */
    public ArrayList<T> getStores() {
        return stores;
    }
    
    /**
     * Метод для пошуку магазину за назвою.
     * @param name Назва магазину для пошуку.
     * @return Магазин з відповідною назвою або null, якщо такого немає.
     */
    public T findStoreByName(String name) {
        for (T store : stores) {
            if (store.getName().equalsIgnoreCase(name)) {
                return store;
            }
        }
        return null;
    }

    /**
     * Метод для підрахунку загальної кількості товарів у всіх магазинах.
     * @return Загальна кількість товарів.
     */
    public int getTotalProductCount() {
        int total = 0;
        for (T store : stores) {
            total += store.getProductCount();
        }
        return total;
    }

}

/**
 * Абстрактний клас <code>Store</code> є базовим класом для всіх магазинів.
 */
abstract class Store {
    protected String name;
    protected int productCount;

    /**
     * Конструктор класу <code>Store</code>
     * @param name назва продуктового магазину 
	 * @param productCount к-сть продукції у наявності
     */
    public Store(String name, int productCount) {
        this.name = name;
        this.productCount = productCount;
    }

    /**
     * Метод для отримання назви магазину
     * @return назва магазину 
     */
    public String getName() {
        return name;
    }

    /**
     * Метод для отримання к-сть наявної продукції магазину
     * @return к-сть продукції магазину 
     */
    public int getProductCount() {
        return productCount;
    }

    /**
     * Метод для отримання к-сть наявної продукції магазину
     * @return форматований рядок з інформацією про магазин типом String
     */
    public String toString() {
        return "Store{" +
                "name='" + name + '\'' +
                ", productCount=" + productCount +
                '}';
    }
}

/**
 * Клас <code>GroceryStore</code> - продуктовий магазин.
 */
class GroceryStore extends Store {
	/**
	 * Конструктор класу <code>GroceryStore</code>
	 * @param name назва продуктового магазину 
	 * @param productCount к-сть продукції у наявності
	 */
    public GroceryStore(String name, int productCount) {
        super(name, productCount);
    }
}

/**
 * Клас <code>ClothingStore</code> - магазин одягу.
 */
class ClothingStore extends Store {
	/**
	 * Конструктор класу <code>GroceryStore</code>
	 * @param name назва магазину одягу 
	 * @param productCount к-сть продукції у наявності
	 */
    public ClothingStore(String name, int productCount) {
        super(name, productCount);
    }
}

/**
 * Клас <code>BookStore</code> - книжковий магазин.
 */
class BookStore extends Store {
	/**
	 * Конструктор класу <code>BookStore</code>
	 * @param name назва книжкового магазину 
	 * @param productCount к-сть продукції у наявності
	 */
    public BookStore(String name, int productCount) {
        super(name, productCount);
    }
}

/**
 * Клас <code>ElectronicsStore</code> - магазин електроніки.
 */
class ElectronicsStore extends Store {
	/**
	 * Конструктор класу <code>ElectronicsStore</code>
	 * @param name назва магазину електроніки
	 * @param productCount к-сть продукції у наявності
	 */
    public ElectronicsStore(String name, int productCount) {
        super(name, productCount);
    }
}