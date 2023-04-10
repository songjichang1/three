package bookMng.book.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import bookMng.book.dto.BookDTO;
import bookMng.book.service.BookService;
import bookMng.bookRental.service.impl.BookRentalMapper;


/**===================================
 * Cotroller -> Service -> Mapper
 * Mapper - > Service - > Controller
 * ==================================
 * Controller에서 전달받은 값으로 Service는 비즈니스로직 수행 -> Mapper에게 값 전달
 * Mapper는 DB에서 받아온 데이터를(반환) 값을 Service가 받아서 가공 후 Controller에게 반환
 * Service는 사용자가 요청한 작업을 처리하는 과정을 하나로 묶은 것.
 * ========================================================================
 */

@Service
@Primary
public class BookServiceImpl implements BookService {

	//container에 생성되어 있는 BookMapper 객체 가져옴 (필드 주입)
	@Autowired
	private BookMapper bookMapper;
	//container에 생성되어 있는 BookRentalService 객체 가져옴 (필드 주입)
	@Autowired
	private BookRentalMapper book_rental_mapper;

	
	/** Method Name  :  getLists()  
	 * ===================================== Method Detail =========================================
	 * 1. Controller에서 도서조회를 요청을 함으로써 요청을 처리 할 bookMapper.getLists() 전달 후 Controller에게 반환 
	 * 2. 에러 발생 시 throws Exception로 해당 서비스 호출한 Controller에게 Exception 전달
	 * =============================================================================================
	 */
	@Override
	public List<BookDTO> getLists() throws Exception {

		//bookMapper에서 반환값을 Controller에게 반환해야하기 때문에 return에 바로 설정 
		return bookMapper.getLists();
	}

	/** Method Name  :  bookInsert  
	 * ======================================= Method Detail ============================================ 
	 * 1. Controller에서 전달 받은 도서정보를 가지고 도서추가를 하기 위해 처리 할 bookMapper.bookInsert(dto)전달 후 Controller에게 반환 
	 * 2. 에러 발생 시 throws Exception로 해당 서비스 호출한 Controller에게 Exception 전달
	 * ==================================================================================================
	 */
	@Override
	public int bookInsert(BookDTO dto) throws Exception {

		//bookMapper에서 반환값을 Controller에게 반환해야하기 때문에 return에 바로 설정 
		return bookMapper.bookInsert(dto);
	}

	/** Method Name  :  updateBookPage 
	 * ========================================== Method Detail ==============================================
	 * 1. Controller에서 특정 도서정보를 요청 시. 처리 할 bookMapper.updateBookPage(bookID) 전달 후 Controller에게 반환 
	 * 2. 에러 발생 시 에러 발생 시 throws Exception로 해당 서비스 호출한 Controller에게 Exception 전달 
	 * =======================================================================================================
	 */	
	@Override
	public BookDTO updateBookPage(int bookID) throws Exception {

		//bookMapper에서 반환값을 Controller에게 반환해야하기 때문에 return에 바로 설정 
		return bookMapper.updateBookPage(bookID);
	}

	/** Method Name  :  updateBook  
	 * ======================================= Method Detail ===========================================
	 * 1. Controller에서 전달 받은 도서정보를 가지고 도서수정을 하기 위해 처리 할 bookMapper.updateBook(dto) 전달 후 Controller에게 반환
	 * 2. 에러 발생 시 throws Exception로 해당 서비스 호출한 Controller에게 Exception 전달
	 * =================================================================================================
	 */	
	@Override
	//update 하기 때문에 반환값이 int형이기 때문에 메서드 타입을 int로 설정
	public int updateBook(BookDTO dto) throws Exception {

		//bookMapper에서 반환값을 Controller에게 반환해야하기 때문에 return에 바로 설정 
		return bookMapper.updateBook(dto);
	}

	/** Method Name  :  deleteBook  
	 * =================================== Method Detail =======================================
	 * 1. Controller에서 전달 받은 도서ID(PK)를 가지고 도서삭제를 하기 위해 처리 할  bookMapper.deleteBook(bookID) 전달.
	 * 2. 전달 후 삭제된 도서를 대여 중 인 대여정보도 함께 사라져야 하기 때문에 book_rental_mapper.returnBookRental1(bookID) 호출
	 * 3. 호출 후 result 값을 Controller에게 반환
	 * 4. 에러 발생 시 throws Exception로 해당 서비스 호출한 Controller에게 Exception 전달
	 * =========================================================================================
	 */	
	
	@Override
	//delete 하기 때문에 반환값이 int형이기 때문에 메서드 타입을 int로 설정
	public int deleteBook(int bookID) throws Exception {

		int result = 0 ;
		
		result = bookMapper.deleteBook(bookID);
	 
		//성공적으로 도서가 삭제가 되었다면 
		if(result > 0) {
			
			//삭제된 도서를 대여중인 대여정보도 함께 삭제
			book_rental_mapper.returnBookRental1(bookID);
		}
		
		return result;
		
	}
}
