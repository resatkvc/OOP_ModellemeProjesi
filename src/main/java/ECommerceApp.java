import models.Product;
import models.User;
import models.Order;
import utils.ShoppingCart;
import java.util.Scanner;

public class ECommerceApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ön tanımlı geçerli kullanıcı bilgileri
        User validUser = new User("kavci", "12345");

        // Kullanıcı Yönetimi: Kullanıcı bilgileri tanımlanır ve doğrulama işlemi yapılır.
        boolean isAuthenticated = false;
        String usernameInput = "";
        String passwordInput = "";

        while (!isAuthenticated) {
            System.out.println("Lütfen giriş yapın");
            System.out.print("Kullanıcı Adı: ");
            usernameInput = scanner.nextLine();
            System.out.print("Şifre: ");
            passwordInput = scanner.nextLine();

            // Kullanıcı Doğrulama (Girilen bilgilerle ön tanımlı kullanıcıyı doğrula)
            if (validUser.authenticate(usernameInput, passwordInput)) {
                System.out.println("Kullanıcı girişi başarılı: " + validUser.getUsername());
                isAuthenticated = true; // Başarılı giriş, döngüden çık
            } else {
                System.out.println("Kullanıcı adı yada şifre hatalı lütfen tekrar deneyiniz ! ");
            }
        }

        // Ürün Yönetimi: Ürünler oluşturulur ve sepete eklenir.
        // Mevcut Ürünleri Tanımlama
        Product laptop = new Product(1, "Laptop", 8550.75);
        Product keyboard = new Product(2, "Klavye", 499.99);
        Product mouse = new Product(3, "Mouse", 185.50);
        Product monitor = new Product(4, "Monitor", 2500.20);
        Product printer = new Product(5, "Yazıcı", 1200.75);
        Product webcam = new Product(6, "Webcam", 350.00);
        Product headset = new Product(7, "Kulaklık", 750.30);

        // Ürün listesi oluşturma
        Product[] availableProducts = {laptop, keyboard, mouse, monitor, printer, webcam, headset};

        // Sepet Oluşturma
        ShoppingCart cart = new ShoppingCart();

        // Konsoldan ürün seçimi alma
        int productId;

        System.out.println("\nSepete eklemek istediğiniz ürünleri seçin.");
        System.out.println("Çıkmak için 0 girin.");

        while (true) {
            System.out.println("\nMevcut Ürünler:");
            for (Product product : availableProducts) {
                System.out.println(product.getId() + ". " + product.getName() + " (" + product.getPrice() + " TL)");
            }

            System.out.print("Ürün ID girin: ");

            try {
                productId = scanner.nextInt();
                if (productId == 0) {
                    break; // Çıkış
                }

                Product selectedProduct = null;
                for (Product product : availableProducts) {
                    if (product.getId() == productId) {
                        selectedProduct = product;
                        break;
                    }
                }

                if (selectedProduct != null) {
                    cart.addItem(selectedProduct);
                } else {
                    System.out.println("Geçersiz ürün ID!");
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("Geçersiz giriş! Lütfen bir sayı girin.");
                scanner.next(); // Hatalı girdiyi temizle
            }
        }

        // Sepeti Görüntüleme
        cart.viewCart();

        // Sipariş Oluşturma
        Order order = new Order(validUser, cart.getItems());

        // Sepeti Temizleme (Opsiyonel, sipariş oluşturulduktan sonra)
        cart.clearCart();

        // Sipariş Bilgilerini Görüntüleme
        order.displayOrderDetails();

        // Scanner kapatma (Ensure this is at the very end of main)
        scanner.close();
    }
} 