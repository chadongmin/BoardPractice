package com.myportfolio.board.controller;


import com.myportfolio.board.domain.BoardDto;
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

    @GetMapping("/list")
    public String list(Integer pageSize, Integer page,HttpServletRequest request,Model m) {

        if (page==null) page=1;
        if (pageSize==null)pageSize=10;
        try {
            Map map = new HashMap();
            map.put("offset", (page-1)*pageSize);
            map.put("pageSize", pageSize);

            List<BoardDto> list = boardService.getPage(map);


            m.addAttribute("list",list);
        } catch (Exception e) {
            e.printStackTrace();

        }

        return "boardList"; // 로그인을 한 상태이면, 게시판 화면으로 이동
    }

}