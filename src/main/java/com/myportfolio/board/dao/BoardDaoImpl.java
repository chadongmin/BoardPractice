package com.myportfolio.board.dao;

import com.myportfolio.board.domain.BoardDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDaoImpl implements BoardDao {

    @Autowired
    private SqlSession session;
   private static String namespace="com.myportfolio.board.dao.BoardMapper.";

    @Override
    public BoardDto select(Integer bno) throws Exception {
        return session.selectOne(namespace+"select",bno);
    }

    @Override
    public int insert(BoardDto boardDto) throws Exception{
        return session.insert(namespace+"insert", boardDto);
    }

}
