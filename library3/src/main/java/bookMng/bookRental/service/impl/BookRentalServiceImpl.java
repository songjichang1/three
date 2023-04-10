package bookMng.bookRental.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import bookMng.bookRental.dto.BookRentalDTO;
import bookMng.bookRental.service.BookRentalService;

/**===================================
 * Cotroller -> Service -> Mapper
 * Mapper - > Service - > Controller
 * ==================================
 * Controller에서 전달받은 값으로 Service는 비즈니스로직 수행 -> Mapper에게 값 전달
 * Mapper는 DB에서 받아온 데이터를(반환) 값을 Service가 받아서 가공 후 Controller에게 반환
 * Service는 사용자가 요청한 작업을 처리하는 과정을 하나로 묶은 것.
 * ========================================================================
 * @Service로 명시된 거 객체생성 스프링컨테이너(객체생성,관리,소멸) 
 * <context:include-filter type="annotation" expression="org.springframework.stereotype.Service"/>
 * ================================================================================================
 */

@Service
@Primary
public class BookRentalServiceImpl implements BookRentalService  {

	
	@Autowired
	private BookRentalMapper book_rental_mapper;

	/** Method Name  :  getLists()  
	 * ===================================== Method Detail =========================================
	 * 1. Controller에서 대여목록을 요청을 함으로써 요청을 처리 할book_rental_mapper.getLists() 전달 후 Controller에게 반환 
	 * 2. 에러 발생 시 throws Exception로 해당 서비스 호출한 Controller에게 Exception 전달
	 * =============================================================================================
	 */
	@Override
	public List<BookRentalDTO> getLists() throws Exception {
		
		//book_rental_mapper에서 반환값을 Controller에게 반환해야하기 때문에 return에 바로 설정 
		return book_rental_mapper.getLists();
	}

	/** Method Name  :  bookRental  
	 * ======================================= Method Detail ============================================ 
	 * 1. Controller에서 전달 받은 userID,bookID를 가지고 대여를 하기 위해 처리 할 book_rental_mapper.bookRental(dto)전달 후 Controller에게 반환 
	 * 2. 에러 발생 시 throws Exception로 해당 서비스 호출한 Controller에게 Exception 전달
	 * ==================================================================================================
	 */
	@Override
	public int bookRental(BookRentalDTO dto) throws Exception {
		
		//book_rental_mapper에서 반환값을 Controller에게 반환해야하기 때문에 return에 바로 설정
		
		return book_rental_mapper.bookRental(dto);
	}

	/** Method Name  :  ReturnBookRental
	 * =================================== Method Detail =======================================
	 * 1. Controller에서 전달 받은 userID(PK)를 가지고 회원이 삭제가 되었을 때 대여목록도 함께 삭제가 되어야 하기 때문에 이를 처리 할
 	 * 2. book_rental_mapper.returnBookRental(userID) 전달 후 Controller에게 반환
	 * 3. 에러 발생 시 throws Exception로 해당 서비스 호출한 Controller에게 Exception 전달
	 * =========================================================================================
	 */	
	@Override
	public int ReturnBookRental(int userID) throws Exception {
		
		//book_rental_mapper에서 반환값을 Controller에게 반환해야하기 때문에 return에 바로 설정
		return book_rental_mapper.returnBookRental(userID);
	}

	/** Method Name  :  ReturnBookRental1
	 * =================================== Method Detail =======================================
	 * 1. Controller에서 전달 받은 bookID(PK)를 가지고 도서가 삭제가 되었을 때 대여목록도 함께 삭제가 되어야 하기 때문에 이를 처리 할
 	 * 2. book_rental_mapper.returnBookRental1(bookID) 전달 후 Controller에게 반환
	 * 3. 에러 발생 시 throws Exception로 해당 서비스 호출한 Controller에게 Exception 전달
	 * =========================================================================================
	 */	
	@Override
	public int ReturnBookRental1(int bookID) throws Exception {
		
		//book_rental_mapper에서 반환값을 Controller에게 반환해야하기 때문에 return에 바로 설정
		 return book_rental_mapper.returnBookRental1(bookID);
	}

	

}
