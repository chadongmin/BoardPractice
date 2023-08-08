package com.myportfolio.board.service;



import com.myportfolio.board.domain.BoardDto;

import java.util.*;

public interface BoardService {

    int write(BoardDto boardDto) throws Exception;

    BoardDto read(Integer bno) throws  Exception;

    int remove(Integer bno, String writer)throws Exception;

    int modify(BoardDto boardDto) throws Exception;

    int getCount() throws Exception;

    List<BoardDto> getList() throws Exception;

    List<BoardDto> getPage(Map map) throws Exception;
}