package com.demo.dictionary.dao;

import com.demo.dictionary.entity.Word;

import java.util.List;

public interface IWordDao {
    public Word save(Word word);
    public List<Word> retrieveAll();
    public int delete(int id);
    public List<Word> searchByPattern(String pattern);
    public int update(Word word);

}
