package com.myportfolio.board.service;



import com.myportfolio.board.domain.BoardDto;

import java.util.*;

public interface BoardService {

    int write(BoardDto boardDto) throws Exception;

}