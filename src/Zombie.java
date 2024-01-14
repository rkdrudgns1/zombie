import java.util.Random;

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
                    break;
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

    Zombie() {

    }

    Zombie(int _hp, String _name) {
        hp = _hp;
        name =_name;
    }
}
