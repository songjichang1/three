package bookMng.book.service;

import java.util.List;

import bookMng.book.dto.BookDTO;


public interface BookService {

	//DB에 저장된 도서정보를 가져오는 메서드
	public List<BookDTO> getLists() throws Exception;
	//insertBookPage.jsp에서 입력한 정보를 DB에 저장하는 메서드
	public int bookInsert(BookDTO dto)  throws Exception;
	//SelectBook.JSP에서 특정 도서정보의 상세정보를 보는 메서드
	public BookDTO updateBookPage(int bookID)  throws Exception;
	// 특정 도서정보 도서ID 제외 도서정보를 수정하는 메서드
	public int updateBook(BookDTO dto)  throws Exception;
	//SelectBook.JSP에서 CheckBox를 통해 도서를 삭제하는 메서드
	public int deleteBook(int bookID) throws Exception;
	
}
