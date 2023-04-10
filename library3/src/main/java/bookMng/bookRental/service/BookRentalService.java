package bookMng.bookRental.service;

import java.util.List;

import bookMng.bookRental.dto.BookRentalDTO;

public interface BookRentalService {

	//DB에 저장된 도서를 대여중인 정보를 가져오는 메서드
	public List<BookRentalDTO> getLists()throws Exception;
	//도서를 대여하는 메서드
	public int bookRental(BookRentalDTO dto)throws Exception;
	//도서반납하는 메서드
	public int ReturnBookRental(int userID)throws Exception;
	//도서가 삭제가 되었을 때 그 도서를 대여중인 회원의 대여정보를 반납(삭제)되는 메서드
	public int ReturnBookRental1(int bookID)throws Exception;
	
}
