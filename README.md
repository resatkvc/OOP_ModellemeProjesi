# E-Ticaret Uygulaması - Proje Kurulum Rehberi

Bu rehber, Java ile geliştirilmiş basit bir e-ticaret uygulamasının nasıl yapılandırılacağını ve hangi sırayla geliştirileceğini adım adım açıklar. Kodlama sırası, sınıflar arası bağlılıklar dikkate alınarak mantıklı bir düzenle ilerler.

---

## ✅ Adım 1: Proje Dizin Yapısını Oluşturma

**Amaç:** Kodların düzenli tutulması ve modüler arasında kolay geçiş için temel klasör yapısını oluştururuz.

**Yapı:**

```
ecommerce-app/
├── src/
│   └── main/
│       └── java/
│           ├── models/
│           │   ├── Product.java
│           │   ├── User.java
│           │   └── Order.java
│           ├── utils/
│           │   └── ShoppingCart.java
│           └── ECommerceApp.java
├── README.md
```

---

## ✅ Adım 2: Ürün Modeli (`Product.java`)

**Konum:** `src/main/java/models/Product.java`

**Amaç:** Uygulamadaki her bir ürünü temsil eder.

**İçerik:**

* Ürün ID
* Ürün adı
* Fiyat
* Yapıcı metot (constructor)
* Getter metodlar

**Örnek Kod:**

```java
public class Product {
    private int id;
    private String name;
    private double price;

    public Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public double getPrice() { return price; }

    @Override
    public String toString() {
        return "Product{" + "id=" + id + ", name='" + name + '\'' + ", price=" + price + '}';
    }
}
```

---

## ✅ Adım 3: Kullanıcı Modeli (`User.java`)

**Konum:** `src/main/java/models/User.java`

**Amaç:** Kullanıcı bilgilerini tutar ve doğrulama (authentication) işlevi görür.

**İçerik:**

* Kullanıcı adı ve şifre
* `authenticate()` metodu

**Not:** Gerçek uygulamalarda şifreler hash'lenmelidir.

**Örnek Kod:**

```java
public class User {
    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() { return username; }

    public boolean authenticate(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }
}
```

---

## ✅ Adım 4: Sepet Yardımcı Sınıfı (`ShoppingCart.java`)

**Konum:** `src/main/java/utils/ShoppingCart.java`

**Amaç:** Kullanıcının sepete ürün eklemesini ve çıkarmasını sağlar.

**İçerik:**

* `addItem(Product)`
* `removeItem(Product)`
* `viewCart()`

**Bağlımlılık:** `import models.Product;`

---

## ✅ Adım 5: Sipariş Modeli (`Order.java`)

**Konum:** `src/main/java/models/Order.java`

**Amaç:** Kullanıcının verdiği siparişi tutar.

**Bağlımlılıklar:**

* `User`
* `Product`

**İçerik:**

* Sipariş ID
* Kullanıcı
* Ürün listesi
* Toplam tutar
* `displayOrderDetails()` metodu ile detayları gösterme

---

## ✅ Adım 6: Ana Uygulama Sınıfı (`ECommerceApp.java`)

**Konum:** `src/main/java/ECommerceApp.java`

**Amaç:** Tüm sınıfları birleştiren ve kullanıcı ile etkileşim sağlayan ana sınıftır.

**Bağlımlılıklar:**

```java
import models.User;
import models.Product;
import models.Order;
import utils.ShoppingCart;
import java.util.Scanner;
```

**Uygulama Akışı:**

1. Kullanıcıdan ad ve şifre alınır
2. `User` nesnesi ile doğrulama yapılır
3. Sabit `Product` listesi tanımlanır
4. `ShoppingCart` ile sepet işlemleri yapılır
5. Sipariş oluşturulur ve `Order` ile yazdırılır

---

## ✨ Sonuç

Bu yapı, hem bağlılıkları gözeterek geliştirilmiş hem de yeni başlayanlar için açık, okunabilir bir yapı sunar. Tüm kodlar ayrı klasörlere ayrılmış ve tek sorumluluk prensibine uygun şekilde düzenlenmiştir.
