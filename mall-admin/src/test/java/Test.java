import com.shadow.Person;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @program mall
 * @description:
 * @author: wangjian
 * @create: 2019/11/20 09:25:18
 */
public class Test {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(Config.class);
        context.getBean("person");

        Person bean = context.getBean(Person.class);



    }
}
