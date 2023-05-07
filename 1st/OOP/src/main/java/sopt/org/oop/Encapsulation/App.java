package sopt.org.oop.Encapsulation;

import sopt.org.oop.Encapsulation.MyDefault.MyDefault;
import sopt.org.oop.Encapsulation.MyPrivate.MyPrivate;
import sopt.org.oop.Encapsulation.MyProtected.MyProtected;
import sopt.org.oop.Encapsulation.MyPublic.MyPublic;

public class App {
    public static void main(String[] args) {
        MyDefault myDefault = new MyDefault();
        MyPrivate myPrivate = new MyPrivate();
        MyProtected myProtected = new MyProtected();
        MyPublic myPublic = new MyPublic();

        // default
        // 접근 제어자는 본인과 같은 패키지에 있는 클래스만 접근이 가능하고, 외부 패키지에서는 접근이 불가합니다.
        /**
         * 'number' is not public in 'sopt.org.oop.Encapsulation.MyDefault.MyDefault'.
         * Cannot be accessed from outside package
         */
        System.out.println("myDefault = " + myDefault.number);

        // private
        // 해당 멤버가 선언된 클래스 내부에서만 접근할 수 있습니다.
        /**
         * 'number' has private access in 'sopt.org.oop.Encapsulation.MyPrivate.MyPrivate'
         */
        System.out.println("myPrivate = " + myPrivate.number);

        // protected
        // 기본적으로 본인과 같은 패키지의 클래스는 모두 접근 가능하고,
        // 하나의 예외적인 경우로 다른 패키지에 있어도 protected 변수가 선언된 클래스를 상속받은 자식클래스는 해당 변수에 접근이 가능합니다.
        /**
         * 'number' has protected access in 'sopt.org.oop.Encapsulation.MyProtected.MyProtected'
         */
        System.out.println("myProtected = " + myProtected.number);

        // public
        // 내부는 물론 외부 패키지의 모든 클래스에서 접근을 가능하게 합니다.
        System.out.println("myPublic = " + myPublic.number);
    }
}
