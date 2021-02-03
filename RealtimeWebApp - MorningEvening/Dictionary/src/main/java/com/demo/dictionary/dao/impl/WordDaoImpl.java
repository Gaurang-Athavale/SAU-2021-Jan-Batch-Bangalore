package com.demo.dictionary.dao.impl;

import com.demo.dictionary.dao.IWordDao;
import com.demo.dictionary.entity.Word;
import com.demo.dictionary.queries.WordQueries;
import com.demo.dictionary.table.constants.WordTableConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class WordDaoImpl implements IWordDao {
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private static Logger logger = LoggerFactory.getLogger(WordDaoImpl.class);

    @Override
    public Word save(Word word) {
        final KeyHolder holder = new GeneratedKeyHolder();
        String sql = "INSERT INTO WORDS ( WORD , MEANING , PART_OF_SPEECH , EXAMPLE , CREATION_TM , LAST_MODIFIED_TM ) "
                + " VALUES ( :WORD , :MEANING , :PART_OF_SPEECH , :EXAMPLE , :CREATION_TM , :LAST_MODIFIED_TM )";
        MapSqlParameterSource srcMap = new MapSqlParameterSource();
        srcMap.addValue("WORD", word.getWord());
        srcMap.addValue("MEANING",word.getMeaning());
        srcMap.addValue("PART_OF_SPEECH",word.getPartOfSpeech());
        srcMap.addValue("EXAMPLE",word.getExample());
        srcMap.addValue("CREATION_TM",word.getCreationTm());
        srcMap.addValue("LAST_MODIFIED_TM",word.getLastModifiedTm());

        namedParameterJdbcTemplate.update(sql, srcMap,
                holder, new String[] {"ID"});
        word.setId(holder.getKey().intValue());
        return word;
    }

    @Override
    public List<Word> retrieveAll() {
        String sql = "SELECT * FROM WORDS";
        return namedParameterJdbcTemplate.query(sql, (resultSet, rowNum) -> {
            Word word = new Word();
            word.setId(resultSet.getInt("ID"));
            word.setCreationTm(resultSet.getDate("CREATION_TM"));
            word.setExample(resultSet.getString("EXAMPLE"));
            word.setMeaning(resultSet.getString("MEANING"));
            word.setLastModifiedTm(resultSet.getDate("LAST_MODIFIED_TM"));
            word.setPartOfSpeech(resultSet.getString("PART_OF_SPEECH"));
            word.setWord(resultSet.getString("WORD"));
            return word;
        });
//        return null;
    }

    @Override
    public int delete(int id) {
        logger.info(WordQueries.DELETE_QUERY);
        MapSqlParameterSource srcMap = new MapSqlParameterSource();
        srcMap.addValue(WordTableConstants.ID, id);
        return namedParameterJdbcTemplate.update(WordQueries.DELETE_QUERY, srcMap);
    }

    @Override
    public int update(Word word) {
        String UPDATE_QUERY = WordQueries.UPDATE_QUERY_FIRST;
        MapSqlParameterSource srcMap = new MapSqlParameterSource();
        if (word.getWord() != null) {
            UPDATE_QUERY += " " + WordTableConstants.WORD + " = :" + WordTableConstants.WORD + " , ";
            srcMap.addValue(WordTableConstants.WORD, word.getWord());
        }
        if (word.getMeaning() != null) {
            UPDATE_QUERY += " " + WordTableConstants.MEANING + " = :" + WordTableConstants.MEANING + " , ";
            srcMap.addValue(WordTableConstants.MEANING, word.getMeaning());
        }
        if (word.getPartOfSpeech() != null) {
            UPDATE_QUERY += " " + WordTableConstants.POS + " = :" + WordTableConstants.POS + " , ";
            srcMap.addValue(WordTableConstants.POS, word.getPartOfSpeech());
        }
        if (word.getExample() != null) {
            UPDATE_QUERY += " " + WordTableConstants.EXAMPLE + " = :" + WordTableConstants.EXAMPLE + " , ";
            srcMap.addValue(WordTableConstants.EXAMPLE, word.getExample());
        }

        UPDATE_QUERY = UPDATE_QUERY.substring(0, UPDATE_QUERY.length() - 2);
        UPDATE_QUERY += " " + WordQueries.UPDATE_QUERY_LAST;

        logger.info(UPDATE_QUERY);
        srcMap.addValue(WordTableConstants.ID, word.getId());

        return namedParameterJdbcTemplate.update(UPDATE_QUERY, srcMap);
    }

    @Override
    public List<Word> searchByPattern(String pattern) {
        MapSqlParameterSource srcMap = new MapSqlParameterSource();
        srcMap.addValue(WordTableConstants.WORD, "%" + pattern + "%");
        logger.info(WordQueries.PATTERN_QUERY);
        return namedParameterJdbcTemplate.query(WordQueries.PATTERN_QUERY, srcMap, (resultSet, rowNum) -> {
            Word word = new Word();
            word.setId(resultSet.getInt(WordTableConstants.ID));
            word.setCreationTm(resultSet.getDate(WordTableConstants.CREATION_TM));
            word.setExample(resultSet.getString(WordTableConstants.EXAMPLE));
            word.setLastModifiedTm(resultSet.getDate(WordTableConstants.LAST_MODIFIED_TM));
            word.setMeaning(resultSet.getString(WordTableConstants.MEANING));
            word.setPartOfSpeech(resultSet.getString(WordTableConstants.POS));
            word.setWord(resultSet.getString(WordTableConstants.WORD));
            return word;
        });
    }
}
