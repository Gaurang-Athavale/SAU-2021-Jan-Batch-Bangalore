package com.demo.dictionary.queries;

import com.demo.dictionary.table.constants.WordTableConstants;

public class WordQueries {

    private WordQueries() { }

    public static final String DELETE_QUERY = "DELETE FROM " + WordTableConstants.TABLE_NAME + " WHERE " + WordTableConstants.ID + " = :" + WordTableConstants.ID;

    public static final String PATTERN_QUERY = "SELECT * FROM " + WordTableConstants.TABLE_NAME + " where " + WordTableConstants.WORD + " LIKE :" + WordTableConstants.WORD + " ";

    public static final String UPDATE_QUERY_FIRST = "UPDATE " + WordTableConstants.TABLE_NAME + " SET ";

    public static final String UPDATE_QUERY_LAST = " WHERE " + WordTableConstants.ID + " = :" + WordTableConstants.ID;
}
