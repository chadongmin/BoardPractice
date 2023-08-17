package com.myportfolio.board.service;

import com.myportfolio.board.dao.BoardDao;
import com.myportfolio.board.domain.BoardDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class BoardServiceImplTest {

    @Autowired
    BoardService boardService;
    @Autowired
    BoardDao boardDao;

    @Test
    public void writeTest() throws Exception{
        BoardDto boardDto = new BoardDto("title","content","dongmin");
        int rowCnt = boardService.write(boardDto);
        assertTrue(rowCnt==1);

    }

    @Test
    public void readTest()throws Exception {
        System.out.println(boardService.read(boardDao.selectAll().get(0).getBno()));
    }

    @Test
    public void deleteTest() throws Exception{
        int rowCnt = boardService.remove(boardDao.selectAll().get(0).getBno(), boardDao.selectAll().get(0).getWriter());
        assertTrue(rowCnt==1);
    }

    @Test
    public void modifyTest() throws Exception{

        BoardDto boardDto = boardService.read(48);
        boardDto.setTitle("title1");


        boardService.modify(boardDto);
        assertTrue(boardDto.getTitle().equals("title1"));

    }
}