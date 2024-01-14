import java.util.Random;
import java.util.Scanner;

public class User {
    int hp;
    String name;
    double money;
    int hpMedicineCounts;
    int changeNameCouponeCounts;

    public int selectMenu(User realuser) {

        Scanner scan = new Scanner(System.in);

        System.out.println("몇번을 선택할것인가?");
        System.out.println("[1]전투시작, [2]상점, [3]아이템 개방, [4]로그아웃");
        System.out.println("가지고 있는 소지금: " + realuser.money);
        System.out.println("가지고 있는 포션: " + realuser.hpMedicineCounts);
        System.out.println("가지고 있는 이름 변경권: " + realuser.changeNameCouponeCounts);
        int select = scan.nextInt();

        return select;
    }

    public void attack(User realuser, Zombie realzombie)
    {
        Random random = new Random();

        System.out.println(realuser.name+ "가 먼저 공격");
        while(true)
        {
            int userattack = random.nextInt(50) + 1;
            realzombie.hp -= userattack;

            if(realzombie.hp <= 0)
            {
                System.out.println(realzombie.name + "죽음.");
                realuser.money += 20;
                break;
            }
            int zombieattack = random.nextInt(30) + 1;
            realuser.hp -= zombieattack;

            if(realuser.hp <= 0)
            {
                if(realuser.hpMedicineCounts > 0) {
                    System.out.println("물약 사용!");
                    realuser.hpMedicineCounts--;
                }
                else
                {
                    System.out.println(realuser.name + "죽음.");
                    if(realuser.money >=10)
                    {
                        realuser.money *= 0.9;
                    }
                    break;
                }
            }
        }
    }

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
