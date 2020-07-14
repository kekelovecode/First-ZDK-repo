import com.keke.Dao.IUserDao;
import com.keke.Entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class test {
    private InputStream inputStream;
    private SqlSessionFactory factory;
    private SqlSession sqlSession;
    IUserDao iUserDao;
    @Test
    public void save() throws IOException {
        inputStream  = Resources.getResourceAsStream("SqlMapConfig1.xml");
        SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
        factory=builder.build(inputStream);
        sqlSession=factory.openSession();
        iUserDao=sqlSession.getMapper(IUserDao.class);
        List<User> users=iUserDao.findAll();
       for(User user:users )
        System.out.println(user.toString());
    sqlSession.commit();
    sqlSession.close();
    inputStream.close();
    }
}
