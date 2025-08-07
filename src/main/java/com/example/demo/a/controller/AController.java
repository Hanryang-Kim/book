package com.example.demo.a.controller;

import com.example.demo.a.model.ADto;
import com.example.demo.a.service.AService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/a")
public class AController {
    private final AService aService;

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody ADto.Register dto) {
        aService.register(dto);

        return ResponseEntity.status(200).body("등록 성공");
    }

    @GetMapping("/list")
    public ResponseEntity list() {
        List<ADto.ARes> response = aService.list();

        return ResponseEntity.status(200).body(response);
    }

    @GetMapping("/read")
    public ResponseEntity read(Integer idx) {
        ADto.ARes response = aService.read(idx);

        return ResponseEntity.status(200).body(response);
    }


    @GetMapping("/search")
    public ResponseEntity search(String name) {
        List<ADto.ARes> response = aService.search(name);

        return ResponseEntity.status(200).body(response);
    }


}
