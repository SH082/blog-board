package com.example.blog_board.controller;

import com.example.blog_board.domain.Board;
import com.example.blog_board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("board/")
@RequiredArgsConstructor
public class BoardController {

    public final BoardService service;

    @GetMapping("/hello")
    public String Hello(){
        return "boards/hello";
    }

    @GetMapping("/test")
    public String test(Model model){
        model.addAttribute("cnt",service.boardCount());
        model.addAttribute("test",service.boardCount());

        return "boards/hello";
    }

    @GetMapping("/main")
    public String main1(Model model){
        model.addAttribute("list", service.boardList()); // boardList() 호출하여 데이터를 가져옴
        return "boards/main";
    }

    @GetMapping("/view")
    public String viewBoard(Model model,Long boardId){
        model.addAttribute("view",service.getBoard(boardId));
        return "boards/view";
    }

    @GetMapping("/upload")
    public String uploadBoardForm(){
        return "/boards/upload";
    }

    @PostMapping("/upload")
    public String uploadBoard(Board board){
        service.uploadBoard(board);
        return "redirect:/board/main";
    }

    @PutMapping("/update")
    public String updateBoard(Board board){
        service.updateBoard(board);
        return "redirect:/board/main";
    }

    @DeleteMapping("/delete")
    public String deleteBoard(Long boardId){
        service.deleteBoard(boardId);
        return "redirect:/board/main";
    }

}
