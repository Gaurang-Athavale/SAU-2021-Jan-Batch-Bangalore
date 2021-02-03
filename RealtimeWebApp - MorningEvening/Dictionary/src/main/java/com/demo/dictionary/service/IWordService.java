package com.demo.dictionary.service;

import com.demo.dictionary.entity.Word;

import java.util.List;

public interface IWordService {
    public Word save(Word word);
    public List<Word> retrieveAll();
    public boolean delete(int id);
    public List<Word> getMatching(String pattern);
    public boolean update(Word word);
}
