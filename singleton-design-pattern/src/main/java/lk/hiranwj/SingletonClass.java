package lk.hiranwj;

public class SingletonClass {

    private static volatile SingletonClass singletonClass;

    public SingletonClass() {
        if (singletonClass != null) {
            throw new RuntimeException("Please use getSingletonClass");
        }
    }

    public static SingletonClass getSingletonClass() {
        if (singletonClass == null) {

            singletonClass = new SingletonClass();
        }

        return singletonClass;
    }
}
