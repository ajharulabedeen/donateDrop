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
import java.util.Random;

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
        List<User> userList = dumpDao.getUsers(0, 10);
        Random random = new Random();
        List<PostComment> comments = new ArrayList<>();
        for (int y = 0; y <= random.nextInt(5); y++) {
            String useID = userList.get(random.nextInt(userList.size() - 1)).getId().toString();
            PostComment postComment = new PostComment(DumpData.getDate(), DumpData.getNote(), useID);
            comments.add(postComment);
        }

        Post post = new Post(
                userList.get(random.nextInt(userList.size() - 1)).getId().toString(),
                DumpData.getBloodGroup(),
                dumpDao.getAddressString("PRESENT"),
                DumpData.getHospitalName(),
                DumpData.getHospitalAddress(),
                DumpData.getGender(),
                DumpData.getPatientDescription(),
                "20-10-10",
                DumpData.getDate(),
                DumpData.getQuantity(),
                DumpData.getPhoneNumber(),
                "0",
                DumpData.getNote(),
                "NO",
                "SON",
                DumpData.getNote(),
                "NA",
                DumpData.getNote(),
                comments);

        status = dao_post_i.savePost(post);
        Assert.assertEquals(StringUtil.OK, status.get(StringUtil.STATUS));

    }

    @Test
    public void testAddManyPostsSequential() {
        List<User> userList = dumpDao.getUsers(10, 200);
        Random random = new Random();
        for (int x = 0; x < userList.size(); x++) {
            List<PostComment> comments = new ArrayList<>();
            for (int y = 0; y <= random.nextInt(5); y++) {
                String useID = userList.get(random.nextInt(userList.size() - 1)).getId().toString();
                PostComment postComment = new PostComment(DumpData.getDate(), DumpData.getNote(), useID);
                comments.add(postComment);
            }

            Post post = new Post(
                    userList.get(x).getId().toString(),
                    DumpData.getBloodGroup(),
                    dumpDao.getAddressString("PRESENT"),
                    DumpData.getHospitalName(),
                    DumpData.getHospitalAddress(),
                    DumpData.getGender(),
                    DumpData.getPatientDescription(),
                    "20-10-10",
                    DumpData.getDate(),
                    DumpData.getQuantity(),
                    DumpData.getPhoneNumber(),
                    "0",
                    DumpData.getNote(),
                    "NO",
                    "SON",
                    DumpData.getNote(),
                    "NA",
                    DumpData.getNote(),
                    comments);

            dao_post_i.savePost(post);
        }
    }

    @Test
    public void testAddManyPostsRandom() {
        List<User> userList = dumpDao.getUsers(10, 200);
        Random random = new Random();
        for (int x = 0; x < 200; x++) {
            List<PostComment> comments = new ArrayList<>();
            for (int y = 0; y <= random.nextInt(5); y++) {
                String useID = userList.get(random.nextInt(userList.size() - 1)).getId().toString();
                PostComment postComment = new PostComment(DumpData.getDate(), DumpData.getNote(), useID);
                comments.add(postComment);
            }

            String useID = userList.get(random.nextInt(userList.size() - 1)).getId().toString();
            Post post = new Post(
                    useID,
                    DumpData.getBloodGroup(),
                    dumpDao.getAddressString("PRESENT"),
                    DumpData.getHospitalName(),
                    DumpData.getHospitalAddress(),
                    DumpData.getGender(),
                    DumpData.getPatientDescription(),
                    "20-10-10",
                    DumpData.getDate(),
                    DumpData.getQuantity(),
                    DumpData.getPhoneNumber(),
                    "0",
                    DumpData.getNote(),
                    "NO",
                    "SON",
                    DumpData.getNote(),
                    "NA",
                    DumpData.getNote(),
                    comments);

            dao_post_i.savePost(post);
        }
    }


}// class
