import com.aye10032.util.GetUtil;
import com.aye10032.util.PostUtil;
import org.junit.jupiter.api.Test;

import java.io.IOException;

/**
 * @program: rtroapiutil
 * @className: test
 * @Description: 测试类
 * @version: v1.0
 * @author: Aye10032
 * @date: 2021/7/15 下午 4:10
 */
public class test {

    @Test
    void TestPost(){
        try {
            PostUtil.addVideo("https://www.aye10032.com",false,1234566L,"aaa");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    void TestGet(){
        System.out.println(GetUtil.getTransByVideoID(4).getData());
    }

}
