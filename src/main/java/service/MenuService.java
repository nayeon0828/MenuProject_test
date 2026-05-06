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
    //메뉴데이터 list 호출할 수 있는 유일 통로 생성
    public ArrayList<MenuVO> getList(){
        return list;
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
            System.out.println("사원 정보 로드 완료");


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


    /************메뉴 추가  추가 메서드**************/




    /************메뉴 삭제  추가 메서드**************/
    /************메뉴 수정  추가 메서드**************/
    /************메뉴 조회  추가 메서드**************/





}
