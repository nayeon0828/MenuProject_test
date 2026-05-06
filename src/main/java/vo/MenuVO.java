package vo;

import java.util.Objects;

public class MenuVO {

    /*
    *
    * 메뉴는 아래 정보를 포함해야 합니다.
        ● 메뉴 번호
        ● 메뉴명
        ● 가격
        ● 카테고리
        ● 판매 여부
    *
    * */

    //필드 선언
    private String id;
    private String name;
    private int price;
    private String category;
    private boolean isSell;

    //초기 생성자 선언
    public MenuVO(String id, String name, int price, String category, boolean isSell) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
        this.isSell = isSell;
    }

    //get & set  선언
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public boolean isSell() {
        return isSell;
    }

    public void setSell(boolean sell) {
        isSell = sell;
    }

    //메뉴 번호로 hash & equals
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        MenuVO menuVO = (MenuVO) o;
        return Objects.equals(id, menuVO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
