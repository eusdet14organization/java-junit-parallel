import org.junit.jupiter.api.Test;

public class BTest {

    @Test
    public void first() throws Exception{
        System.out.println("FirstParallelUnitTest first() B start => " + Thread.currentThread().getName());
        Thread.sleep(500);
        System.out.println("FirstParallelUnitTest first() B end => " + Thread.currentThread().getName());
    }

    @Test
    public void second() throws Exception{
        System.out.println("FirstParallelUnitTest second() B start => " + Thread.currentThread().getName());
        Thread.sleep(500);
        System.out.println("FirstParallelUnitTest second() B end => " + Thread.currentThread().getName());
    }

}
