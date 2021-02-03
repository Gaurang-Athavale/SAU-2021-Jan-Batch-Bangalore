package com.demo.dictionary.service.impl;

import com.demo.dictionary.dao.IWordDao;
import com.demo.dictionary.entity.Word;
import com.demo.dictionary.service.IWordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WordServiceImpl implements IWordService {
    @Autowired
    IWordDao iWordDao;

    @Override
    public Word save(Word word) {
        return iWordDao.save(word);
    }

    @Override
    public List<Word> retrieveAll() {
        return iWordDao.retrieveAll();
    }

    @Override
    public boolean delete(int id) {
        int rowsAffected = iWordDao.delete(id);
        if (rowsAffected == 1) {
            return true;
        }
        return false;
    }

    @Override
    public List<Word> getMatching(String pattern) {
        return iWordDao.searchByPattern(pattern);
    }

    @Override
    public boolean update(Word word)
    {
        int num = iWordDao.update(word);
        if (num == 1) {
            return true;
        }
        return false;
    }
}
