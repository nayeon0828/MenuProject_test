package main;

import java.util.Scanner;

public class MenuMain {
    //사용자와의 ui부분
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true){
            System.out.println("-- 메뉴 관리 프로그램 --");
            System.out.print("1.메뉴 추가");
            System.out.print("2.메뉴 삭제");
            System.out.print("3.메뉴 수정");
            System.out.print("4.전체 메뉴 조회");
            System.out.print("0. 종료");
            System.out.print("사용자 입력 번호 : ");
            //사용자의 입력값
            int no = sc.nextInt();

            if(no == 0) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }



        }



    }

}
