package com.assignment.library;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class BookManager {

	private static SessionFactory factory;
	public static void main(String[] args) {
		try{
			factory = new Configuration().configure().buildSessionFactory();
		}catch(Exception e){
			System.err.println(e);
		}
		
		BookManager bookManager = new BookManager();
		
		String Books [][] = {{"The ABC Murders", "Agatha Christie"},{"The Murder on the Orient Express","Agatha Christie"},{"The Murder of Rojer Acroyd","Agatha Christie"}, {"Harry Potter Series", "J. K. Rowling"}, {"Sherlock Holmes","Arthur Conandoyal"}};
		int years [] = {2005, 1990, 1986, 1995, 2000};
				
		// ======================= ADD BOOKS ==========================
		
//		for (int i=0; i<years.length; i++) {
//			Integer bookId = bookManager.addBook(Books[i][0], Books[i][1], years[i]);
//			System.out.print("Book is inserted: id is " + bookId.intValue());
//		}
		
		System.out.println("=========================  Get Books =============================");
		bookManager.getBooks();
		
//		System.out.println("=========================  Update Books =============================");
//		bookManager.updateBookById(1);
		
//		System.out.println("=========================  Delete Books =============================");
//		bookManager.deleteBookById(3);
		
		System.out.println("=========================  Count Books =============================");
		System.out.println("The Size of the BOOKS table is: "+bookManager.countBooks());
	}
	
	public Integer addBook(String title, String author, int year) {
		Session session=factory.openSession();
		Transaction tx = null;
		Integer bookId = null;
		try {
			tx = session.beginTransaction();
			Book book = new Book(title, author, year);
			bookId = (Integer) session.save(book);
			tx.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			if(tx !=null)
				tx.rollback();
		}finally {
			session.close();
		}
		return bookId;
	}
	
	private void getBooks() {
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			List<Book> booksList = session.createQuery("FROM Book").list();
	
			for(Book book : booksList) {
				System.out.println(book.getId());
				System.out.println(book.getTitle());
				System.out.println(book.getAuthor());
				System.out.println(book.getYear());
				System.out.println("================================================================");
			}
			tx.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			if(tx!=null) {
				tx.rollback();
			}
		}finally {
			session.close();
		}
	}
	
	private void updateBookById(int id) {
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Book book  = session.get(Book.class, id);
			System.out.println(book.getId());
			System.out.println(book.getTitle());
			System.out.println(book.getAuthor());
			System.out.println(book.getYear());
			book.setTitle("Secret Seven");
			book.setAuthor("Enid Blyton");
			book.setYear(1999);
			session.update(book);
			tx.commit();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				if(tx!=null)
					tx.rollback();
			} finally {
				session.close();
		}

	}
	
	private void deleteBookById(int id) {
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Book book  = session.get(Book.class, id);
			session.delete(book);
			tx.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			if(tx!=null)
				tx.rollback();
		} finally {
			session.close();		
			}	
	}
	
	private int countBooks() {
		Session session = factory.openSession();
		Transaction tx = null;
		int countBook = 0;
		try {
			tx = session.beginTransaction();
			List<Book> booksList = session.createQuery("FROM Book").list();
			countBook = booksList.size();
			
			tx.commit();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			if(tx!=null) {
				tx.rollback();
			}
		}finally {
			session.close();
		}
		return countBook;
	}
	
}
