package controller;

import service.MenuService;
import vo.MenuVO;

import java.util.Scanner;

public class AddMenuController implements Controller {
    @Override
    public void execute(Scanner sc) {
        System.out.println();
        System.out.println("메뉴 정보를 추가합니다.");
        System.out.print("등록 메뉴 번호 : ");
        String id = sc.nextLine();

        //중복 찾기
        while (true){
            if(MenuService.getInstance().searchDuplicatMenuVO(id)== -1)
                break;

            System.out.println("메뉴 번호가 중복되었습니다.");
            System.out.print("다시 입력해주세요 : ");
            id =  sc.nextLine();
        }

        System.out.print("등록할 메뉴 이름 : ");
        String name = sc.nextLine();
        System.out.print("등록할 메뉴 가격 : ");
        int price = sc.nextInt(); sc.nextLine();
        System.out.print("등록할 메뉴 카테고리 : ");
        String category = sc.nextLine();
        // 숫자(1 또는 0)로 입력받아 boolean으로 변환하는 방식
        System.out.print("등록할 메뉴 판매중인가? (판매중:1, 품절:0) : ");
        int sellInput = sc.nextInt();
        sc.nextLine(); // 버퍼 비우기
        boolean isSell = (sellInput == 1); // 1이면 true, 아니면 false

        // 3. VO 객체 생성 및 서비스로 전달
        boolean result = MenuService.getInstance()
                .appendMenuVO(new MenuVO(id, name, price, category,isSell));

        if(result) {
            System.out.println("메뉴 정보 등록이 완료되었습니다.");
        } else {
            System.out.println("메뉴 정보 등록에 실패하였습니다.");
        }


    }
}
