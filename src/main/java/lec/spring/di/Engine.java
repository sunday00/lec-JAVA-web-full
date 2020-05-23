package lec.spring.di;

import org.springframework.stereotype.Component;

@Component
public class Engine {
    public Engine() {
        System.out.println("created Engine");
    }
    public void exec () {
        System.out.println("it's working");
    }
}
