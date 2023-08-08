package com.myportfolio.board.service;

import com.myportfolio.board.dao.BoardDao;
import com.myportfolio.board.domain.BoardDto;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.util.*;

@Service
public class BoardServiceImpl implements BoardService {
    @Autowired
    BoardDao boardDao;

    @Override
    public int write(BoardDto boardDto) throws Exception {
        return boardDao.insert(boardDto);
    }


}