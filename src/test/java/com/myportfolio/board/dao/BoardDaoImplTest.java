package com.myportfolio.board.dao;

import com.myportfolio.board.dao.BoardDao;
import com.myportfolio.board.domain.*;
import org.junit.*;
import org.junit.runner.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.test.context.*;
import org.springframework.test.context.junit4.*;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.*;

import static org.junit.Assert.*;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class BoardDaoImplTest {
    @Autowired
    private BoardDao boardDao;


    @Test
    public void insertTest() throws Exception {

        BoardDto boardDto = new BoardDto("no title", "no content", "aaaa");
        assertTrue(boardDao.insert(boardDto)==1);

//        boardDto = new BoardDto("no title", "no content", "asdf");
//        assertTrue(boardDao.insert(boardDto)==1);
//        assertTrue(boardDao.count()==2);
//
//
//        boardDto = new BoardDto("no title", "no content", "asdf");
//        assertTrue(boardDao.insert(boardDto)==1);
//        assertTrue(boardDao.count()==1);
    }


}