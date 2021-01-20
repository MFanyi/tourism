import com.shangda.tourism.TourismApplication;
import com.shangda.tourism.dao.AreaDao;
import com.shangda.tourism.dao.CommentDao;
import com.shangda.tourism.dao.HotelDao;
import com.shangda.tourism.dao.UserDao;
import com.shangda.tourism.model.Hotel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = TourismApplication.class)
public class MapperTest {
    @Resource
    private AreaDao areaDao;

    @Resource
    private UserDao userDao;

    @Resource
    private CommentDao commentDao;

    @Resource
    private HotelDao hotelDao;

//    @Test
//    public void insertTest() {
//        User user = new User();
//        user.setUsername("123");
//        user.setPassword("123");
//        user.setSalt("aa");
//        user.setEmail("bbb");
//        user.setName("ddd");
//        user.setPhone("123456789");
//        user.setGender(1);
//        user.setType(2);
//        user.setStatus(1);
//        user.setHeaderUrl("178");
//        user.setBirthday("1999.02.06");
//        user.setCreateTime(new Date());
//        userDao.insertUser(user);
//    }
//
//    @Test
//    public void selectTest() {
//        //User user = userDao.selectByUsername("123");
//    }
//

//    @Test
//    public void selectCode() {
//        PageHelper.startPage(1,10);
//        List<Area> list = areaDao.selectArea();
//        PageInfo<Area> pageInfo = new PageInfo<>(list);
//        System.out.println(pageInfo.getList().get(0).getName());
//    }

//    @Test
//    public void selectCommentByAreaId(){
//        List<Comment> commentList = commentDao.selectCommentByAreaId(1);
//        System.out.println(commentList.get(0).getContent());
//    }

//    @Test
//    public void selectThisArea(){
//        Area area = areaDao.selectThisArea(1);
//        System.out.println(area.getName());
//    }

//    @Test
//    public void selectUserEmail(){
//        List<Hotel> list = hotelDao.selectHotel();
//        for(Hotel hotel : list){
//            System.out.println(hotel.getHotelName());
//        }
//    }

    @Test
    public void selectHotHotel(){
        List<Hotel> list = hotelDao.selectHotHotel();
        for(Hotel hotel : list){
            System.out.println(hotel.getHotelName());
            System.out.println(hotel.getId());
        }
    }
}
