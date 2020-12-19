import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

/**
 * @author yujun.wu
 * @version 1.0
 * @create date 2020/12/18 22:48
 * @Description:类的具体作用描述
 */
public class Demo {

    @Test
    public void test() {
        Properties properties = System.getProperties();
        Iterator<Object> iterator = properties.keySet().iterator();
        while (iterator.hasNext()) {
            String key = (String) iterator.next();
            String value = System.getProperty(key);
            System.out.println(key+"=============>" + value);
        }

    }
}
