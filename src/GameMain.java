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

        if(minute % 5 == 0) {
            user1 = new User(100, "유저1", 0, 10, 0);
            user2 = new User(100, "유저2", 0, 10, 0);
            user3 = new User(100, "유저3", 0, 10, 0);
        } else {
            user1 = new User(100, "유저1", 0, 0, 0);
            user2 = new User(100, "유저2", 0, 0, 0);
            user3 = new User(100, "유저3", 0, 0, 0);
        }

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

            while(true)
            {
                System.out.println("유저 몇번을 선택한것인가?");
                System.out.println("게임 종료를 원한다면 0번");
                int user = scan.nextInt();

                if(user == 1)
                {
                    realuser = user1;
                    System.out.println(realuser.name + " 선택!");
                    break;
                }
                else if(user == 2)
                {
                    realuser = user2;
                    System.out.println(realuser.name + " 선택!");
                    break;
                }
                else if(user ==3)
                {
                    realuser = user3;
                    System.out.println(realuser.name + " 선택!");
                    break;
                }
                else
                {
                    System.out.println("게임을 종료한다.");
                    return;
                }
            }

            while(true)
            {
                System.out.println("좀비 몇번을 선택한것인가?");
                int zombie = scan.nextInt();

                if(zombie == 1)
                {
                    realzombie = zombie1;
                    System.out.println(realzombie.name + " 선택!");
                    break;
                }
                else if(zombie == 2)
                {
                    realzombie = zombie2;
                    System.out.println(realzombie.name + " 선택!");
                    break;
                }
                else
                {
                    System.out.println("좀비 정보가 없다.");
                }
            }

            while(true)
            {
                System.out.println("몇번을 선택할것인가?");
                System.out.println("[1]전투시작, [2]상점, [3]아이템 개방, [4]로그아웃");
                System.out.println("가지고 있는 소지금: " + realuser.money);
                System.out.println("가지고 있는 포션: " + realuser.hpMedicineCounts);
                System.out.println("가지고 있는 이름 변경권: " + realuser.changeNameCouponeCounts);
                int select = scan.nextInt();;

                if(select == 1)
                {
                    System.out.println("전투 시작!");
                    int attackTurn = random.nextInt(12) + 1;
                    if(attackTurn%2 == 0)
                    {
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
                                    break;
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
                    else
                    {
                        System.out.println(realzombie.name + "가 먼저 공격");
                        while(true)
                        {
                            int zombieattack = random.nextInt(30) + 1;
                            user1.hp -= zombieattack;

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
                            zombie1.hp -= userattack;

                            if(realzombie.hp <= 0)
                            {
                                System.out.println(realzombie.name + "가 죽음.");
                                realuser.money += 20;
                                break;
                            }
                        }
                    }

                }
                else if(select == 2)
                {
                    System.out.println("어떤 물건을 구매할건가요?");
                    System.out.println("[1] 체력물약 50원, [2] 이름변경쿠폰 200원");
                    int selectproduct = scan.nextInt();

                    if(selectproduct == 1)
                    {
                        if(realuser.money >= 50)
                        {
                            realuser.hpMedicineCounts ++;
                            realuser.money -= 50;
                            System.out.println("체력 물약 구매!");
                        }
                        else
                        {
                            System.out.println("돈이 부족!");
                        }
                    }
                    else if(selectproduct == 2)
                    {
                        if(realuser.money >= 200)
                        {
                            realuser.changeNameCouponeCounts ++;
                            realuser.money -= 200;
                            System.out.println("이름변경쿠폰 구매!");
                        }
                        else
                        {
                            System.out.println("돈이 부족!");
                        }
                    }
                    else
                    {
                        System.out.println("상품이 없다.");
                    }

                } else if(select == 3)
                {
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
                            break;
                        }
                    }
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

