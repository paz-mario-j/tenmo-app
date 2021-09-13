package com.techelevator.tenmo.dao;



import com.techelevator.tenmo.model.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;


import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;


public class JdbcUserDaoTest extends TenmoDaoTests {
    private JdbcUserDao sut;
    private User testUser;
    private List<User> testUsers;

    @Before
    public void setup() {

        sut = new JdbcUserDao(new JdbcTemplate(dataSource));
        testUser = new User();
        testUser.setId(1001L);
        testUser.setUsername("user1");
        testUser.setPassword("0000");
        testUsers = new ArrayList<>();
    }

    private void assertUsersMatch(User expected, User actual) {
        Assert.assertEquals(expected.getId(), actual.getId());
        Assert.assertEquals(expected.getUsername(), actual.getUsername());
        Assert.assertEquals(expected.getPassword(), actual.getPassword());

    }
    @Test
    public void findIdByUsername_returns_correct_id() {
        int actual = sut.findIdByUsername("user1");
        int expected = 1001;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void findAll_retrieves_correct_number_of_users() {
        List<User> users= sut.findAll();

        Assert.assertEquals(2, users.size());
    }


    @Test
    public void findByUsername_returns_correct_user_for_username() {

        User user = sut.findByUsername("user1");
        assertUsersMatch(testUser, user);
    }

    @Test
    public void getUserByUserId_returns_correct_user() {
        User user = sut.getUserByUserId(1001);
        Assert.assertEquals(user.getId(), testUser.getId());
        Assert.assertEquals(user.getUsername(), testUser.getUsername());

    }

}