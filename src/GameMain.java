//RPG 게임을 만들어봅시다.
//프로그램 실행하면 유저3명, 좀비2마리, 상인1명 생성됩니다.
//프로그램을 실행할때 현재의 분이 5분,10분,15분,20분,25분,30분,35분,40분,45분,50분,55분 중에 하나라도 걸린다면
//체력물약갯수를 10개 채워넣어 유저를 생성합니다.
//유저는 필수적으로 체력, 이름, 소지금, 체력물약갯수(초기에는0), 이름변경쿠폰갯수(초기에는 0)를 가집니다. (체력,소지급은 랜덤으로 부여)
//좀비는 필수적으로 체력, 이름을 가집니다. (체력은 랜덤으로 부여)
//1번누르면 전투시작
//2번누르면 상점
//3번누르면 아이템가방
//4번누르면 로그아웃
//전투는 유저가 좀비를 먼저 때릴수도있고, 좀비가 유저를 먼저 때릴수도 있습니다.
//이 때 공격력은 전투시마다 랜덤으로 부여되며, 공격력만큼 체력이 감소됩니다.
//유저가 좀비를 해치웠다면 소정의 보상금이 소지금에 추가됩니다1.
//유저가 좀비에게 죽었다면 현재의 소지금 10%을 잃고 부활합니다. 만약 소지금이 10원미만이라면 잃지않고 부활합니다.
//        상점에서는 [1] 체력물약 50원, [2] 이름변경쿠폰 200원 아이템을 판매합니다.
//1번구매시 소지금을 50원 지불하여 체력물약을 구매합니다.전투중에 사용할 수 있습니다.
//        2번구매시 소지금을 200원 지불하여 이름변경쿠폰을 구매합니다.
//        3번눌러 아이템가방메뉴를 열고, 체력물약은 30원에 팔수있고 이름변경쿠폰은 100원에 팔수있습니다.
//또한 이름변경쿠폰을 사용할지 여부를 결정하고 변경할 수 있습니다.

import java.time.LocalTime;
import java.util.Random;
import java.util.Scanner;

public class GameMain {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        LocalTime now = LocalTime.now();

        int minute = now.getMinute();

        System.out.println("현재 분: " + minute);

        User realuser;
        User user1;
        User user2;
        User user3;

        User users = new User();

        if(minute % 5 == 0) {
            user1 = new User(100, "유저1", 0, 10, 0);
            user2 = new User(100, "유저2", 0, 10, 0);
            user3 = new User(100, "유저3", 0, 10, 0);
        } else {
            user1 = new User(100, "유저1", 0, 0, 0);
            user2 = new User(100, "유저2", 0, 0, 0);
            user3 = new User(100, "유저3", 0, 0, 0);
        }

        Zombie zombies = new Zombie();

        Zombie realzombie;

        Random random = new Random();
        int hpzombie1 = random.nextInt(201) + 200;
        Zombie zombie1 = new Zombie(hpzombie1, "좀비1");

        int hpzombie2 = random.nextInt(201) + 200;
        Zombie zombie2 = new Zombie(hpzombie2, "좀비2");

        Casher casher = new Casher();


        while(true)
        {
            System.out.println("게임을 시작!!");

            realuser = users.choose(user1, user2, user3);

            realzombie = zombies.choose(zombie1, zombie2);

            while(true)
            {
                int select = users.selectMenu(realuser);

                if(select == 1)
                {
                    System.out.println("전투 시작!");

                    int attackTurn = random.nextInt(12) + 1;
                    if(attackTurn%2 == 0)
                    {
                       users.attack(realuser, realzombie);
                    }
                    else
                    {
                       zombies.attack(realuser, realzombie);
                    }

                }
                else if(select == 2)
                {
                    casher.usershop(realuser);
                } else if(select == 3)
                {
                    users.openItem(realuser);
                }
                else
                {
                    System.out.println("로그아웃한다.");
                    break;
                }
            }
        }

    }
}

