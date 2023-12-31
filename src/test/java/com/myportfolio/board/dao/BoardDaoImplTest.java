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


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class BoardDaoImplTest {
    @Autowired
    private BoardDao boardDao;

    @Test
    public void selectPageTest() throws Exception {
        boardDao.deleteAll();

        for (int i = 1; i <= 250; i++) {
            BoardDto boardDto = new BoardDto(""+i, "no content"+i, "asdf");
            boardDao.insert(boardDto);
        }

        Map map = new HashMap();
        map.put("offset", 0);
        map.put("pageSize", 3);

        List<BoardDto> list = boardDao.selectPage(map);
        assertTrue(list.get(0).getTitle().equals("10"));
        assertTrue(list.get(1).getTitle().equals("9"));
        assertTrue(list.get(2).getTitle().equals("8"));

        map = new HashMap();
        map.put("offset", 0);
        map.put("pageSize", 1);

        list = boardDao.selectPage(map);
        assertTrue(list.get(0).getTitle().equals("10"));

        map = new HashMap();
        map.put("offset", 7);
        map.put("pageSize", 3);

        list = boardDao.selectPage(map);
        assertTrue(list.get(0).getTitle().equals("3"));
        assertTrue(list.get(1).getTitle().equals("2"));
        assertTrue(list.get(2).getTitle().equals("1"));
    }
    @Test
    public void countTest() throws Exception{
        int rowCnt = boardDao.count();
        System.out.println("rowCnt = " + rowCnt);
    }

    @Test
    public void updateTest()throws Exception{
        boardDao.deleteAll();
        BoardDto boardDto = new BoardDto("no title", "no content", "asdf");

        assertTrue(boardDao.insert(boardDto)==1);
        System.out.println(boardDto);

            Integer bno = boardDao.selectAll().get(0).getBno();
        System.out.println("bno = " + bno);
        boardDto.setBno(bno);
        boardDto.setTitle("aassa title");
        boardDto.setContent("dongmin content");

        boardDao.update(boardDto);

    }
    @Test
    public void selectAllTest() throws Exception{
        boardDao.deleteAll();
        BoardDto boardDto = new BoardDto("11","22","33");
        BoardDto boardDto1 = new BoardDto("af","asdf","adf");

        boardDao.insert(boardDto);
        boardDao.insert(boardDto1);

        System.out.println(boardDao.selectAll());
    }
    @Test
    public void deleteTest() throws Exception{
        deleteAllTest();
        BoardDto boardDto = new BoardDto("aa","bb","cc");
        boardDao.insert(boardDto);
        assertTrue(boardDao.insert(boardDto)==1);


        int rowCnt = boardDao.delete(boardDao.selectAll().get(0).getBno(), "cc");
        assertTrue(rowCnt==1);

    }
    @Test
    public void deleteAllTest()throws Exception{

        boardDao.deleteAll();
        BoardDto boardDto = new BoardDto("no title", "no content", "no writer");
        System.out.println(boardDto);
        boardDao.insert(boardDto);
        int rowCnt = boardDao.deleteAll();
//        System.out.println(boardDto);

        assertTrue(rowCnt==1);
    }

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