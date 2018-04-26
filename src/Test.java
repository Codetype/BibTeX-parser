import static org.junit.Assert.*;
import BibTex.*;
import BibTex.BookTypes.*;

public class Test {

	@org.junit.Test
	public void test1() {
		Book book = new Book();
		
		book.setTitle("aaa");
		String bt = book.getTitle();
		assertEquals("aaa", bt);
		
		book.setAuthor("bbb");
		String ba = book.getAuthor();
		assertEquals("bbb", ba);
		
		book.setPublisher("ccc");
		String bp = book.getPublisher();
		assertEquals("ccc", bp);
		
		book.setYear("ddd");
		String by = book.getYear();
		assertEquals("ddd", by);
	
		LibraryItems l1 = new LibraryItems();
		l1.setBook(book);
		l1.getBook().setTitle("aaa");
		String bt2 = l1.getBook().getTitle();
		assertEquals("aaa", bt2);
	}
	
	@org.junit.Test
	public void test2() {
		Article article = new Article();
		
		article.setTitle("www");
		String at = article.getTitle();
		assertEquals("www", at);
		
		article.setAuthor("xxx");
		String aa = article.getAuthor();
		assertEquals("xxx", aa);
		
		article.setJournal("yyy");
		String bp = article.getJournal();
		assertEquals("yyy", bp);
		
		article.setYear("zzz");
		String ay = article.getYear();
		assertEquals("zzz", ay);
		
		LibraryItems l1 = new LibraryItems();
		l1.setArticle(article);
		l1.getArticle().setTitle("www");
		String at2 = l1.getArticle().getTitle();
		assertEquals("www", at2);
	}
	
	@org.junit.Test
	public void test3() {
		Booklet booklet = new Booklet();
		
		booklet.setTitle("kkk");
		String bkt = booklet.getTitle();
		assertEquals("kkk", bkt);
		
		LibraryItems l1 = new LibraryItems();
		l1.setBooklet(booklet);
		l1.getBooklet().setTitle("kkk");
		String bkt2 = l1.getBooklet().getTitle();
		assertEquals("kkk", bkt2);
	}
	
	@org.junit.Test
	public void test4() {
		Inbook inbook = new Inbook();
		
		inbook.setTitle("ooo");
		String it = inbook.getTitle();
		assertEquals("ooo", it);
		
		inbook.setAuthor("lll");
		String ia = inbook.getAuthor();
		assertEquals("lll", ia);
		
		inbook.setPublisher("mmm");
		String ip = inbook.getPublisher();
		assertEquals("mmm", ip);
		
		inbook.setChapter("mmm");
		String ic = inbook.getChapter();
		assertEquals("mmm", ic);
		
		inbook.setYear("nnn");
		String iy = inbook.getYear();
		assertEquals("nnn", iy);
		
		LibraryItems l1 = new LibraryItems();
		l1.setInbook(inbook);
		l1.getInbook().setTitle("kkk");
		String bkt2 = l1.getInbook().getTitle();
		assertEquals("kkk", bkt2);
	}
	
	
}
