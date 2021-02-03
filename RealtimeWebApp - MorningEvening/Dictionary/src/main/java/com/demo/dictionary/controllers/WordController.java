package com.demo.dictionary.controllers;

import com.demo.dictionary.entity.Word;
import com.demo.dictionary.service.IWordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// In @Controller -> We can return only string
// In @RestController -> We can return json objects
@RestController
@RequestMapping("/word")
public class WordController {

    @Autowired
    IWordService iWordService;

    @PostMapping("/save")
    public Word save(@RequestBody Word word) {
        return iWordService.save(word);
    }

    @GetMapping("/getAll")
    public List<Word> getAll(){
        return iWordService.retrieveAll();
    }

    @GetMapping("/delete/{id}")
    public boolean getAll(@PathVariable int id) {
        return iWordService.delete(id);
    }

    @PostMapping("/update")
    public boolean update(@RequestBody Word word){
        return iWordService.update(word);
    }

    @GetMapping("/get/{pattern}")
    public List<Word> getPattern(@PathVariable String pattern){
        return iWordService.getMatching(pattern);
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test(){
        return "Success";
    }

}
