import org.junit.jupiter.api.Test;

public class ATest {

    @Test
    public void first() throws Exception{
        System.out.println("FirstParallelUnitTest first() A start => " + Thread.currentThread().getName());
        Thread.sleep(500);
        System.out.println("FirstParallelUnitTest first() A end => " + Thread.currentThread().getName());
    }

    @Test
    public void second() throws Exception{
        System.out.println("FirstParallelUnitTest second() A start => " + Thread.currentThread().getName());
        Thread.sleep(500);
        System.out.println("FirstParallelUnitTest second() A end => " + Thread.currentThread().getName());
    }

}
