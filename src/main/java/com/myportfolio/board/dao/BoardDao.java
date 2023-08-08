package com.myportfolio.board.dao;



import com.myportfolio.board.domain.BoardDto;

import java.util.*;

public interface BoardDao {
    BoardDto select(Integer bno) throws Exception;
    int insert(BoardDto dto) throws Exception;
}