package com.myportfolio.board.dao;



import com.myportfolio.board.domain.BoardDto;

import java.util.*;

public interface BoardDao {
    BoardDto select(Integer bno) throws Exception;
    List<BoardDto> selectAll() throws Exception;

    List<BoardDto> selectPage(Map map) throws Exception // List<E> selectList(String statement, Object parameter)
    ;

    int insert(BoardDto dto) throws Exception;
    int deleteAll() throws Exception;
    int delete(Integer bno, String writer) throws Exception;
    int update(BoardDto boardDto) throws Exception;
    int count() throws Exception;

    int increaseViewCnt() throws Exception;
}