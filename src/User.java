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
                    realuser.hp += 70;
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

    public User choose(User user1, User user2, User user3)
    {
        while(true)
        {
            Scanner scan = new Scanner(System.in);

            User realuser;

            System.out.println("유저 몇번을 선택한것인가?");
            System.out.println("게임 종료를 원한다면 0번");
            int user = scan.nextInt();

            if(user == 1)
            {
                realuser = user1;
                System.out.println(realuser.name + " 선택!");
                return realuser;
            }
            else if(user == 2)
            {
                realuser = user2;
                System.out.println(realuser.name + " 선택!");
                return realuser;
            }
            else if(user ==3)
            {
                realuser = user3;
                System.out.println(realuser.name + " 선택!");
                return realuser;
            }
            else
            {
                System.out.println("게임을 종료한다.");
            }
        }
    }

    public void openItem(User realuser)
    {

        Scanner scan = new Scanner(System.in);

        System.out.println("아이템 가방을 열였다.");
        System.out.println("현재 체력 물약: " + realuser.hpMedicineCounts + "개");
        System.out.println("현재 이름 변경 쿠폰: " + realuser.changeNameCouponeCounts + "개");
        System.out.println("몇번을 선택?");
        System.out.println("[1]체력 물약 판매, [2]이름변경권 판매, [3]이름변경권 사용, [4]나가기");

        int itemselect = scan.nextInt();
        if(itemselect == 1)
        {
            System.out.println("체력 물약 판매!");
            realuser.money += 30;
        }
        else if(itemselect == 2)
        {
            System.out.println("이름변경권 판매!");
            realuser.money += 100;
        }
        else if(itemselect == 3)
        {
            System.out.println("이름 변경권을 사용한 것인가?");
            System.out.println("[1]사용, [2]사용 안함.");
            int use = scan.nextInt();

            scan.nextLine();

            if(use == 1)
            {
                if(realuser.changeNameCouponeCounts > 0)
                {
                    realuser.changeNameCouponeCounts --;
                    System.out.println("이름 입력: ");
                    realuser.name = scan.nextLine();
                }
                else
                {
                    System.out.println("개수 부족!");
                }
            }
            else if(use == 2)
            {
                return;
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
