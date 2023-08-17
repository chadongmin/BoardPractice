package com.myportfolio.board.controller;


import com.myportfolio.board.domain.BoardDto;
import com.myportfolio.board.domain.PageHandler;
import com.myportfolio.board.service.BoardService;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.*;

import javax.servlet.http.*;
import java.time.*;
import java.util.*;

@Controller
@RequestMapping("/board")
public class BoardController {
    @Autowired
    BoardService boardService;

    @GetMapping("/read")
    public String read(Integer bno,Integer page, Integer pageSize,  Model m){
        try {
            BoardDto boardDto = boardService.read(bno);
//            m.addAttribute("title", boardDto.getTitle());
//            m.addAttribute("content", boardDto.getContent());
            m.addAttribute(boardDto);
            m.addAttribute("page", page);
            m.addAttribute("pageSize", pageSize);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "board";
    }

    @GetMapping("/list")
    public String list(Integer pageSize, Integer page,HttpServletRequest request,Model m) {

        if (page==null) page=1;
        if (pageSize==null)pageSize=10;
        try {
            int totalCnt = boardService.getCount();
            PageHandler pageHandler = new PageHandler(totalCnt, page, pageSize);
            Map map = new HashMap();
            map.put("offset", (page-1)*pageSize);
            map.put("pageSize", pageSize);

            List<BoardDto> list = boardService.getPage(map);

            m.addAttribute("list",list);
            m.addAttribute("ph", pageHandler);
            m.addAttribute("page", page);
            m.addAttribute("pageSize", pageSize);
        } catch (Exception e) {
            e.printStackTrace();

        }

        return "boardList"; // 로그인을 한 상태이면, 게시판 화면으로 이동
    }

}