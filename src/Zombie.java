import java.util.Random;
import java.util.Scanner;

public class Zombie {
    int hp;
    String name;

    public void attack(User realuser, Zombie realzombie)
    {
        Random random = new Random();

        System.out.println(realzombie.name + "가 먼저 공격");
        while(true)
        {
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
                    System.out.println(realuser.name + "가 죽음.");
                    if(realuser.money >=10)
                    {
                        realuser.money *= 0.9;
                    }
                    break;
                }
            }

            int userattack = random.nextInt(50) + 1;
            realzombie.hp -= userattack;

            if(realzombie.hp <= 0)
            {
                System.out.println(realzombie.name + "가 죽음.");
                realuser.money += 20;
                break;
            }
        }
    }

    public Zombie choose(Zombie zombie1, Zombie zombie2)
    {
        while(true)
        {
            Scanner scan = new Scanner(System.in);

            System.out.println("좀비 몇번을 선택한것인가?");
            int zombie = scan.nextInt();

            Zombie realzombie;

            if(zombie == 1)
            {
                realzombie = zombie1;
                System.out.println(realzombie.name + " 선택!");
                return realzombie;
            }
            else if(zombie == 2)
            {
                realzombie = zombie2;
                System.out.println(realzombie.name + " 선택!");
                return realzombie;
            }
            else
            {

                System.out.println("좀비 정보가 없다.");
            }
        }
    }

    Zombie() {

    }

    Zombie(int _hp, String _name) {
        hp = _hp;
        name =_name;
    }
}
