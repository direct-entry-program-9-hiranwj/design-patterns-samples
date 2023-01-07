package lk.hiranwj;

import java.sql.Connection;

public class Main {

    public static void main(String[] args) {

        long start;
        long end;

//        SingletonClass sc1 = SingletonClass.getSingletonClass();
//        System.out.println(sc1);
//
//        SingletonClass sc2 = SingletonClass.getSingletonClass();
//        System.out.println(sc2);

        //--------------------------------------------------------------------------------------------------------------
        System.out.println();

        DoubleCheckingSingletonClass dcsc1 = DoubleCheckingSingletonClass.getDoubleCheckingSingletonClass();
        System.out.println(dcsc1);

        start = System.currentTimeMillis();
        Connection connection1 = dcsc1.getConnection();
        end = System.currentTimeMillis();

        System.out.println("end-start: " + (end-start));

        DoubleCheckingSingletonClass dcsc2 = DoubleCheckingSingletonClass.getDoubleCheckingSingletonClass();
//        System.out.println(dcsc2);

        start = System.currentTimeMillis();
        Connection connection2 = dcsc2.getConnection();
        end = System.currentTimeMillis();

        System.out.println("end-start: " + (end-start));


    }
}
