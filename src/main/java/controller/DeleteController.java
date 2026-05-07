package controller;

import service.MenuService;

import java.util.Scanner;

public class DeleteController implements Controller {
    @Override
    public void execute(Scanner sc) {
        System.out.println("메뉴정보 삭제를 시작합니다....");

        System.out.print("삭제할 메뉴의 번호 : ");
        String id = sc.nextLine();

        if(MenuService.getInstance().deleteMenutVO(id)) {
            System.out.println("메뉴 정보가 삭제되었습니다.");
        }else {
            System.out.println("삭제할 메뉴 정보가 없습니다.");
        }
    }
}
