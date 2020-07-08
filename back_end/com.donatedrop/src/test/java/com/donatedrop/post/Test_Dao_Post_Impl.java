package com.donatedrop.post;

import com.donatedrop.other.DumpDao;
import javafx.geometry.Pos;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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
        Post post = new Post();
        post.
    }
}
