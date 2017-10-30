import com.memory.pzp.CoreConfig;
import com.memory.pzp.base.mapper.AccountMapper;
import com.memory.pzp.base.mapper.LogininfoMapper;
import com.memory.pzp.base.mapper.SystemdictionaryitemMapper;
import com.memory.pzp.base.mapper.UserinfoMapper;
import com.memory.pzp.exp.mapper.ExpAccountMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * Created by wall on 2017/9/9.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={CoreConfig.class})
@WebAppConfiguration
public class MyTest {

    @Autowired
    private LogininfoMapper mapper;

    @Autowired
    private SystemdictionaryitemMapper systemdictionaryitemMapper;

    @Autowired
    private AccountMapper accountMapper;

    @Autowired
    private UserinfoMapper userinfoMapper;

    @Autowired
    private ExpAccountMapper expAccountMapper;

    @Test
    public void test(){

        System.out.println(mapper.selectByPrimaryKey(10L));

    }
}
