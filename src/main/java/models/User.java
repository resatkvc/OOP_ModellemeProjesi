package models;

public class User {

    private String username;  // Kullanıcı adı
    private String password;  // Kullanıcının şifresi (gerçek uygulamalarda hashlenmiş olmalıdır)

    // Constructor: User nesnesi oluşturulurken kullanıcı adı ve şifre alınır
    public User(String username, String password) {
        this.username = username;     // Parametre ile gelen kullanıcı adı atanır
        this.password = password;     // Parametre ile gelen şifre atanır
    }

    // Kullanıcı adını döndüren getter metodu
    public String getUsername() {
        return username;
    }

    // Basit bir kimlik doğrulama metodu
    public boolean authenticate(String username, String password) {
        // Gelen kullanıcı adı ve şifre, mevcut nesnedeki bilgilerle karşılaştırılır
        return this.username.equals(username) && this.password.equals(password);
    }

}
