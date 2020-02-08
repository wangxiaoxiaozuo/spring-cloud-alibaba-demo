import com.mall.search.SearchApplication;
import javafx.application.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * <pre>
 * +--------+---------+-----------+---------+
 * |                                        |
 * +--------+---------+-----------+---------+
 * </pre>
 *
 * @author wangjian
 * @since 2020/02/08 12:22:59
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {SearchApplication.class})// 指定启动类
public class SearchApplicationTest {


    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;


    @Test
    public void test() {
        System.out.println("------");
    }
}
