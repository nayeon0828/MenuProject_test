package controller;

import service.MenuService;
import vo.MenuVO;

import java.util.Scanner;

public class UpdateController implements Controller {
    @Override
    public void execute(Scanner sc) {

        System.out.println("메뉴정보 수정을 시작합니다.");

        System.out.print("수정할 메뉴의 번호 : ");
        String id = sc.nextLine();

        MenuVO vo = MenuService.getInstance().searchForUpdateMenuVO(id);

        if (vo == null) {
            System.out.println("수정할 메뉴가 없습니다.");
            return;
        }

        System.out.print("수정할 메뉴의 이름 : ");
        String name = sc.nextLine();
        System.out.print("수정할 메뉴의 가격 : ");
        int price = sc.nextInt(); sc.nextLine();
        System.out.print("수정할 메뉴의 카테고리 : ");
        String category = sc.nextLine();
        // 숫자(1 또는 0)로 입력받아 boolean으로 변환하는 방식
        System.out.print("등록할 메뉴 판매중인가? (판매중:1, 품절:0) : ");
        int sellInput = sc.nextInt();
        sc.nextLine(); // 버퍼 비우기
        boolean isSell = (sellInput == 1); // 1이면 true, 아니면 false

        vo.updateMenuVO(name, price,category,isSell);
        System.out.println("학생정보 수정이 완료되었습니다.");


    }
}
