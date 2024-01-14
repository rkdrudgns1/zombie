import java.util.Scanner;

public class Casher {

    public void usershop(User realuser)
    {
        Scanner scan = new Scanner(System.in);

        System.out.println("상점에 오신걸 환영합니다!!");

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
    }
}
