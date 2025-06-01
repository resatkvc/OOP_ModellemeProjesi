package models;

import java.util.List;
import java.util.ArrayList;

public class Order {

    private static int orderCounter = 0; // Tüm siparişler arasında benzersiz ID oluşturmak için sayaç (statik)

    private int orderId;                // Her siparişe özel benzersiz sipariş ID’si
    private User user;                  // Siparişi veren kullanıcıyı tutar
    private List<Product> items;        // Siparişteki ürünlerin listesini tutar
    private double totalAmount;         // Siparişin toplam tutarı

    // Constructor: Sipariş nesnesi oluşturulduğunda otomatik ID atar ve toplam tutarı hesaplar
    public Order(User user, List<Product> items) {
        this.orderId = ++orderCounter;                // orderCounter artırılır, sipariş ID atanır
        this.user = user;                             // Kullanıcı atanır
        this.items = new ArrayList<>(items);          // Orijinal listeyi bozmamak için kopyası alınır
        this.totalAmount = calculateTotalAmount();    // Toplam tutar hesaplanır
    }

    // Getter metodu: Sipariş ID’sini döner
    public int getOrderId() {
        return orderId;
    }

    // Getter metodu: Siparişi veren kullanıcıyı döner
    public User getUser() {
        return user;
    }

    // Getter metodu: Siparişteki ürün listesini döner
    public List<Product> getItems() {
        return items;
    }

    // Getter metodu: Toplam tutarı döner
    public double getTotalAmount() {
        return totalAmount;
    }

    // Private metot: Siparişteki ürünlerin fiyatlarını toplayarak toplam tutarı hesaplar
    private double calculateTotalAmount() {
        double total = 0;
        for (Product item : items) {         // Her ürünün fiyatı toplanır
            total += item.getPrice();
        }
        return total;
    }

    // Sipariş detaylarını ekrana yazdırır
    public void displayOrderDetails() {
        System.out.println("--- Order Details ---");                       // Başlık
        System.out.println("Order ID: " + orderId);                        // Sipariş ID
        System.out.println("User: " + user.getUsername());                // Kullanıcı adı
        System.out.println("Items:");                                     // Ürün listesi başlığı
        for (Product item : items) {
            System.out.println("- " + item.getName() + " (" + item.getPrice() + " TL)"); // Ürün adı ve fiyatı
        }
        System.out.println("Total Amount: " + totalAmount + " TL");       // Toplam tutar
        System.out.println("---------------------");                      // Bitiş çizgisi
    }
}
