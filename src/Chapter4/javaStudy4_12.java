package Chapter4;

import java.util.Scanner;

class Concert{
    private String S[];
    private String A[];
    private String B[];
    private Scanner sc;

    public Concert(){
        sc = new Scanner(System.in);
        S = new String[10];
        A = new String[10];
        B = new String[10];
        for(int i=0; i<S.length; i++){
            S[i] = "___";
            A[i] = "___";
            B[i] = "___";
        }
    }

    public void seat(){
        System.out.print("좌석구분 S[1]  A[2]  B[3]>>");
        int selectSeat = sc.nextInt();
        switch(selectSeat){
            case 1:
                show(S,"S");
                reservation(S);
                break;
            case 2:
                show(A,"A");
                reservation(A);
                break;
            case 3:
                show(B,"B");
                reservation(B);
                break;
            default:
                System.out.println("잘못 입력함");
                break;
        }
    }

    public void show(String[] grade,String s){
        System.out.print(s+">> ");
        for(int i=0; i<grade.length; i++){
            System.out.print(grade[i]+" ");
        }
        System.out.println();
    }

    public void show(){
        show(S,"S");
        show(A,"A");
        show(B,"B");
    }

    public void reservation(String[] grade){
        System.out.println();
        System.out.print("이름>>");
        String name = sc.next();
        System.out.print("번호>>");
        int index = sc.nextInt() - 1 ; // 실제 들어가는값

        if(grade[index] !="___"){
            System.out.println("<<<이미 예약이 되어있는 자리입니다.>>>");
        }else{
            grade[index] = name;
        }
    }

    public void unBooking(){
        System.out.print("좌석 S[1]  A[2]  B[3]>>");
        int selectSeat = sc.nextInt();
        switch(selectSeat){
            case 1:
                show(S,"S");
                unTicket(S);
                break;
            case 2:
                show(A,"A");
                unTicket(A);
                break;
            case 3:
                show(B,"B");
                unTicket(B);
                break;
            default:
                System.out.println("잘못 입력함");
                break;
        }
    }

    public void unTicket(String[] grade){
        boolean flag = false;
        System.out.print("이름>>");
        String name = sc.next();
        for(int i=0; i<grade.length; i++){
            if(grade[i].equals(name)) {
                grade[i] = "___";
                flag = true;
            }
        }
        if(!(flag)){
            System.out.println("없는 예약자");
        }
    }
}

public class javaStudy4_12 {

    static void menu(){
        System.out.println("콘서트 예약 시스템");
        Concert concert = new Concert();
        boolean flag = true;
        while(flag) {
            System.out.print("예약[1]  조회[2]  예약취소[3]   끝내기[4] >>");
            Scanner sc = new Scanner(System.in);
            int select = sc.nextInt();
            switch (select) {
                case 1:
                    concert.seat();
                    break;
                case 2:
                    concert.show();
                    break;
                case 3:
                    concert.unBooking();
                    break;
            }
            if(select == 4){
                break;
            }
        }
    }

    public static void main(String []args){
        menu();
    }
}
