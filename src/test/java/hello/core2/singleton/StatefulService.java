package hello.core2.singleton;

/**
 * 어떠한 서비스가 있다고 가정, 싱글톤 주의점 확인 테스트용
 */
public class StatefulService {
   // private int price; // 상태를 유지하는 필드
    
//    public void order(String name, int price){
//        System.out.println("name  = " + name + " price = " + price);
//        this.price = price; // 여기가 문제
//
//    }
    public int order(String name, int price){
        System.out.println("name = " + name + " price" + price);
        return price; // price를 반환해 지역변수로 할당하여 사용하게끔 함
    }

//    public int getPrice(){
//        return price;
//    }
}
