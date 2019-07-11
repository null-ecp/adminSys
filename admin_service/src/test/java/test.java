import org.junit.Test;

public class test {

    @Test
    public void test(){
        int op = Integer.MAX_VALUE - 100;
        int ed = Integer.MAX_VALUE;
        System.out.println("op : " + op);
        System.out.println("ed : " + ed);
        int count = 0;
        for (int i = op; i <= ed; i++) {
            count ++;
        }
        System.out.println(count);
    }
}
