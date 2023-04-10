package bookMng.bookRental.service.impl;

import java.util.List;

import bookMng.bookRental.dto.BookRentalDTO;

public interface BookRentalMapper {

	//DB에 저장된 도서를 대여중인 정보를 가져오는 메서드
	public List<BookRentalDTO> getLists();
	//도서를 대여하는 메서드
	public int bookRental(BookRentalDTO dto);
	//도서반납하는 메서드
	public int returnBookRental(int userID);
	//도서가 삭제가 되었을 때 그 도서를 대여중인 회원의 대여정보를 반납(삭제)되는 메서드
	public int returnBookRental1(int bookID);
	//사용자가 삭제가 되었을 때 회원의 대여정보도 삭제되는 메서드
	public int returnBookRental2(int userID);
}
