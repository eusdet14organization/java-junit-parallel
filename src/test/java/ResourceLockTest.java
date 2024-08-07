import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.api.parallel.Isolated;
import org.junit.jupiter.api.parallel.ResourceLock;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.parallel.ExecutionMode.CONCURRENT;
import static org.junit.jupiter.api.parallel.ExecutionMode.SAME_THREAD;



public class ResourceLockTest {

    private List<String> resources;

    @BeforeEach
    void before() {
        resources = new ArrayList<>();
        resources.add("test");
    }
    @AfterEach
    void after() {
        resources.clear();
    }

    @Test
    @Execution(SAME_THREAD)
    @ResourceLock(value = "resources")
    public void first() throws Exception {
        System.out.println("ParallelResourceLockUnitTest first() start => " + Thread.currentThread().getName());
        resources.add("first");
        Thread.sleep(500);
        System.out.println(resources);

        System.out.println("ParallelResourceLockUnitTest first() end => " + Thread.currentThread().getName());
    }
    @Test
    @Execution(ExecutionMode.SAME_THREAD)
    @ResourceLock(value = "resources")
    public void second() throws Exception {
        System.out.println("ParallelResourceLockUnitTest second() start => " + Thread.currentThread().getName());
        resources.add("second");
        System.out.println(resources);
        System.out.println("ParallelResourceLockUnitTest second() end => " + Thread.currentThread().getName());
    }

}
