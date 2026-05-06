package controller;

import service.MenuService;
import vo.MenuVO;

import java.util.ArrayList;
import java.util.Scanner;

public class printAllController implements Controller {
    @Override
    public void execute(Scanner sc) {
        ArrayList<MenuVO> list = MenuService.getInstance().getList();

        System.out.println("전체 메뉴정보를 조회합니다.............");
        for (MenuVO vo : list) {
            // vo.getSellStatus()를 호출하여 "판매중" 또는 "품절" 텍스트를 가져옴
            System.out.printf("번호: %-5s | 메뉴명: %-10s | 가격: %d원 | 카테고리: %-5s | 상태: %s%n",
                    vo.getId(),
                    vo.getName(),
                    vo.getPrice(),
                    vo.getCategory(),
                    vo.getSellStatus()); // 새로 만든 메서드 사용
        }
    }
}
