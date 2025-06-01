package utils;

import models.Product;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<Product> items;

    public ShoppingCart() {
        this.items = new ArrayList<>();
    }

    public void addItem(Product product) {
        this.items.add(product);
        System.out.println("Sepetinize ürünler başarılı eklendi.");
    }

    public void removeItem(Product product) {
        if (this.items.remove(product)) {
            System.out.println(product.getName() + " sepetten çıkarıldı.");
        } else {
            System.out.println(product.getName() + " sepette bulunamadı.");
        }
    }

    public List<Product> getItems() {
        return items;
    }

    public void clearCart() {
        this.items.clear();
    }

    public void viewCart() {
        System.out.println("--- Sepetiniz ---");
        if (items.isEmpty()) {
            System.out.println("Sepetiniz boş.");
        } else {
            for (Product item : items) {
                System.out.println("- " + item.getName() + " (" + item.getPrice() + " TL)");
            }
        }
        System.out.println("-----------------");
    }
} 