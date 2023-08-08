package com.myportfolio.board.service;

import com.myportfolio.board.dao.BoardDao;
import com.myportfolio.board.domain.BoardDto;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

@Service
public class BoardServiceImpl implements BoardService {
    @Autowired
    BoardDao boardDao;

    @Override
    public int write(BoardDto boardDto) throws Exception {
        return boardDao.insert(boardDto);
    }
    @Override
    public BoardDto read(Integer bno) throws  Exception{
        BoardDto boardDto =  boardDao.select(bno);
        boardDao.increaseViewCnt();
        return boardDto;
    }
    @Override
    public int remove(Integer bno, String writer)throws Exception{
        return boardDao.delete(bno, writer);
    }
    @Override
    public int modify(BoardDto boardDto) throws Exception{
        return boardDao.update(boardDto);
    }
    @Override
    public int getCount() throws Exception{
        return boardDao.count();
    }




}