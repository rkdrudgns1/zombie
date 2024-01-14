public class User {
    int hp;
    String name;
    double money;
    int hpMedicineCounts;
    int changeNameCouponeCounts;

    @Override
    public String toString() {
        return "User{" +
                "hp=" + hp +
                ", name='" + name + '\'' +
                ", money=" + money +
                ", hpMedicineCounts=" + hpMedicineCounts +
                ", changeNameCouponeCounts=" + changeNameCouponeCounts +
                '}';
    }

    User() {

    }

    User(int _hp, String _name, double _money, int _hpMedicineCounts, int _changeNameCouponeCounts) {
        hp = _hp;
        name = _name;
        money = _money;
        hpMedicineCounts = _hpMedicineCounts;
        changeNameCouponeCounts = _changeNameCouponeCounts;
    }
}
