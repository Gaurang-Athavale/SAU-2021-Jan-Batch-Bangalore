package com.example.au.couchbasedemo.repository;	

import java.util.ArrayList;
import java.util.List;


import org.springframework.data.repository.CrudRepository;

import com.example.au.couchbasedemo.model.Blogs;

public interface BlogRepository extends CrudRepository<Blogs, String> {
	
	List findByAuthor(String author);

	ArrayList<Blogs> findByTag1(String tags);
	ArrayList<Blogs> findByTag2(String tags);
	ArrayList<Blogs> findByTag3(String tags);
	
	List deleteBytopicAndAuthor(String title, String author);
	   
}