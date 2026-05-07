package service;

import vo.MenuVO;

import java.io.*;
import java.util.ArrayList;

public class MenuService {

    //싱글 패턴으로 생성해주기
    private static  MenuService instance = new MenuService();
    //싱글 패턴 유일 통로 생성
    public static MenuService getInstance(){
        if(instance == null)
            instance = new MenuService();
        return instance;
    }

    //메뉴데이터로 list 선언
    private ArrayList<MenuVO> list;


    // 또는 생성자에서 초기화
    private MenuService() {
        list = new ArrayList<>();
        LoadToCSV(); // 초기화 후 데이터를 읽어와야 합니다.
    }

    //-------------시작전 파일 읽어들이기------------------
    private void LoadToCSV(){

        try(FileReader fr = new FileReader("menu.csv");
            BufferedReader br = new BufferedReader(fr);

        ){

            br.readLine(); //필드 목록 출력 건너뛰기
            while (true){
                String str = br.readLine();
                if(str == null) break;

                //,쉼표 기준으로 다 잘라서 배열 안에 넣기
                String[] arr = str.split(",");

                list.add(new MenuVO(arr[0],arr[1],Integer.parseInt(arr[2]),arr[3],Boolean.parseBoolean(arr[4])));
            }

            //파일 로드 완료
            System.out.println("메뉴 정보 로드 완료");


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }


    //-------------종료 파일 내보내기------------------

    private void  exportToCSV(){
        try(FileWriter fw = new FileWriter("menu.csv");
            PrintWriter pw = new PrintWriter(fw);
        ){
            //pw를 통해서 아이템들 작성해서 보내기
            list.forEach(item -> pw.println(item));
            System.out.println("메뉴 정보 저장 완료");

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //메뉴 중복 확인 메서드 생성
    /**
     * @param id 검색할 학번
     * @return 찾으면 배열 인덱스, 못 찾으면 -1
     */
    // 중복 찾는 list를 사용해서 바꾸기
    public int searchDuplicatMenuVO(String id) {

        for(int i=0; i<list.size(); i++) {
            // 대소문자 무시하고 비교
            if(list.get(i).getId().equalsIgnoreCase(id.trim()))
                return i;
        }
        return -1;
    }

    /************메뉴 추가  추가 메서드**************/

    public boolean appendMenuVO(MenuVO vo) {

        return list.add(vo);

    }


    /************메뉴 삭제  추가 메서드**************/


    public boolean deleteMenutVO(String id) {

        //삭제할 학생 정보가 있는지?
        int i = MenuService.getInstance().searchDuplicatMenuVO(id);

        // 삭제할 목록이 없으면 -1로 출력해서 false로 반환
        if(i == -1) {
            return false;
        }

        //list로해서 삭제하는 방법
        // list안에 같은 메뉴번호를 찾은 다음에 -> remove로 해당 메뉴 idx삭제하기

        return list.remove(i) != null;

    }



    /************메뉴 수정  추가 메서드**************/
    /************메뉴 조회  추가 메서드**************/
    //메뉴데이터 list 호출
    public ArrayList<MenuVO> getList(){
        return list;
    }






}
