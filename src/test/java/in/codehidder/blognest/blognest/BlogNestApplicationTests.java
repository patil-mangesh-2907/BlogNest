package in.codehidder.blognest.blognest;

import in.codehidder.blognest.blognest.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BlogNestApplicationTests {

    @Autowired
    private UserRepository repository;

    @Test
    void contextLoads() {
    }

    @Test
    public void fun() {
        String className = repository.getClass().getName();
        String packageName = repository.getClass().getPackageName();

        System.out.println("Class Name: " + className);
        System.out.println("Package Name: " + packageName);
    }

}
