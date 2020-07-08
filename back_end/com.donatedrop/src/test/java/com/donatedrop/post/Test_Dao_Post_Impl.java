package com.donatedrop.post;

import com.donatedrop.other.DumpDao;
import com.donatedrop.other.DumpData;
import com.donatedrop.security.models.User;
import com.donatedrop.util.StringUtil;
import javafx.geometry.Pos;
import org.junit.Assert;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
public class Test_Dao_Post_Impl {
    @Autowired
    DumpDao dumpDao;

    @Autowired
    Dao_Post_I dao_post_i;

    @Test
    @Order(1)
    public void test_savePost() {
        Map<String, String> status = null;

        List<PostComment> comments = new ArrayList<>();
        PostComment postComment1 = new PostComment("2020-07-05", "Please call me at this number", "17");
        PostComment postComment2 = new PostComment("2020-07-05", "Please call me at this number", "18");
        PostComment postComment3 = new PostComment("2020-07-05", "Please call me at this number", "19");
        comments.add(postComment1);
        comments.add(postComment2);
        comments.add(postComment3);
        Post post = new Post(
                "16",
                "A+",
                "Dhaka",
                "Dhaka Sishu hospital!",
                "Shamoli Dhaka",
                "Male",
                DumpData.getPatientDescription(),
                "20-10-10",
                "2020-07-15",
                "3",
                "01713815267",
                "0",
                "from GUB",
                "NO",
                "SON",
                "Please Come in time.",
                "NA",
                "Old Women!",
                comments);

        status = dao_post_i.savePost(post);
        Assert.assertEquals(StringUtil.OK, status.get(StringUtil.STATUS));

    }

    @Test
    public void testAddManyPosts() {
        List<User> userList = dumpDao.getUsers(0, 100);
        for (int x = 0; x < userList.size(); x++) {
            List<PostComment> comments = new ArrayList<>();
            PostComment postComment1 = new PostComment("2020-07-05", "Please call me at this number", "17");
            PostComment postComment2 = new PostComment("2020-07-05", "Please call me at this number", "18");
            PostComment postComment3 = new PostComment("2020-07-05", "Please call me at this number", "19");
            comments.add(postComment1);
            comments.add(postComment2);
            comments.add(postComment3);
            Post post = new Post(
                    userList.get(x).getId().toString(),
                    DumpData.getBloodGroup(),
                    dumpDao.getAddressString("PRESENT"),
                    DumpData.getHospitalName(),
                    DumpData.getHospitalAddress(),
                    DumpData.getGender(),
                    DumpData.getPatientDescription(),
                    "20-10-10",
                    "2020-07-15",
                    "3",
                    "01713815267",
                    "0",
                    DumpData.getNote(),
                    "NO",
                    "SON",
                    DumpData.getNote(),
                    "NA",
                    "Old Women!",
                    comments);

            dao_post_i.savePost(post);
        }
    }

}// class
