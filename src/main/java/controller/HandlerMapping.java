package controller;

public class HandlerMapping {

    //싱글 패턴으로 만들어주기
    private static HandlerMapping instance = new HandlerMapping();

    //유일 핸들러매핑 연결 통로 생성
    public static  HandlerMapping getInstance(){
        if(instance== null){
            instance = new HandlerMapping();
        }
        return instance;
    }

    public HandlerMapping(){}

    public Controller createController(int no){

        Controller controller = null;

        switch (no){
            case 1:
                controller = new addMenuController();
                break;
        }

        return controller;
    }


}
