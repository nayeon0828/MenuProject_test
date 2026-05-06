package main;

import controller.Controller;
import controller.HandlerMapping;

import java.util.Scanner;

public class MenuMain {
    //사용자와의 ui부분
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true){
            System.out.println("-- 메뉴 관리 프로그램 --");
            System.out.println("1.메뉴 추가");
            System.out.println("2.메뉴 삭제");
            System.out.println("3.메뉴 수정");
            System.out.println("4.전체 메뉴 조회");
            System.out.println("0. 종료");
            System.out.print("사용자 입력 번호 : ");
            //사용자의 입력값
            int no = sc.nextInt();
            sc.nextLine();


            Controller controller = HandlerMapping.getInstance().createController(no);

            if(controller != null)
                controller.execute(sc);

            if(no == 0) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }
        }



    }

}
