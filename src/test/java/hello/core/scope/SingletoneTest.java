package hello.core.scope;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.lang.annotation.Annotation;

public class SingletoneTest {

    @Test
    void singletoneBeanFind() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SingletoneBean.class);
        SingletoneBean bean = ac.getBean(SingletoneBean.class);
        SingletoneBean bean1 = ac.getBean(SingletoneBean.class);

        System.out.println("bean = " + bean);
        System.out.println("bean1 = " + bean1);

        Assertions.assertThat(bean).isSameAs(bean1);
        ac.close();

    }

    @Scope("singleton")
    static class SingletoneBean {
        @PostConstruct
        public void init() {
            System.out.println("SingletoneBean.init");
        }

        @PreDestroy
        public void destroy() {
            System.out.println("SingletoneBean.destroy");
        }

    }
}
