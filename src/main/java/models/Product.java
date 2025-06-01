package models;

public class Product {

    // Ürüne ait özel alanlar (özellikler)
    private int id;             // Ürünün benzersiz kimliği (ID)
    private String name;        // Ürünün adı
    private double price;       // Ürünün fiyatı

    // Constructor: Product nesnesi oluşturulurken ID, isim ve fiyat değerleri alınır
    public Product(int id, String name, double price) {
        this.id = id;               // Parametre ile gelen ID değeri sınıf değişkenine atanır
        this.name = name;           // Parametre ile gelen isim atanır
        this.price = price;         // Parametre ile gelen fiyat atanır
    }

    // Getter metodu: Ürünün ID bilgisini döndürür
    public int getId() {
        return id;
    }

    // Getter metodu: Ürünün ismini döndürür
    public String getName() {
        return name;
    }

    // Getter metodu: Ürünün fiyatını döndürür
    public double getPrice() {
        return price;
    }

    // toString metodu: Ürün nesnesini String olarak okunabilir hale getirir
    @Override
    public String toString() {
        return "Product{" + "id=" + id +     // Ürün ID’si
                ", name='" + name + '\'' +   // Ürün ismi
                ", price=" + price +         // Ürün fiyatı
                '}';                         // Kapanış
    }
}
