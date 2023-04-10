package bookMng.user.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import bookMng.bookRental.service.impl.BookRentalMapper;
import bookMng.user.dto.UserDTO;
import bookMng.user.service.UserService;


/**===================================
 * Cotroller -> Service -> Mapper
 * Mapper - > Service - > Controller
 * ==================================
 * Controller에서 전달받은 값으로 Service는 비즈니스 로직 수행 -> Mapper에게 값 전달
 * Mapper는 DB에서 받아온 데이터를(반환) 값을 Service가 받아서 가공 후 Controller에게 반환
 * Service는 사용자가 요청한 작업을 처리하는 과정을 하나로 묶은 것.
 * ========================================================================
 */

@Service
@Primary
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper usermapper;
	@Autowired
	private BookRentalMapper book_rental_mapper;
	
	/** Method Name  :  getLists()  
	 * ===================================== Method Detail =========================================
	 * 1. Controller에서 사용자조회를 요청을 함으로써 요청을 처리 할 usermapper.getLists() 전달 후 Controller에게 반환 
	 * 2. 에러 발생 시 throws Exception로 해당 서비스 호출한 Controller에게 Exception 전달
	 * =============================================================================================
	 */
	@Override
	public List<UserDTO> getLists() throws Exception {

		return  usermapper.getLists();
	}
	
	/** Method Name  :  userInsert  
	 * ======================================= Method Detail ============================================ 
	 * 1. Controller에서 전달 받은 사용자정보를 가지고 사용자추가를 하기 위해 처리 할 usermapper.userInsert(dto)전달 후 Controller에게 반환 
	 * 2. 에러 발생 시 throws Exception로 해당 서비스 호출한 Controller에게 Exception 전달
	 * ==================================================================================================
	 */   
	@Override
	//insert 하기 때문에 반환값이 int형이기 때문에 메서드 타입을 int로 설정
	public int userInsert(UserDTO dto) throws Exception {
		
		//userMapper에서 반환값을 Controller에게 반환해야하기 때문에 return에 바로 설정 
		return usermapper.userInsert(dto);
	}

	/** Method Name  :  updateUserPage 
	 * ========================================== Method Detail ==============================================
	 * 1. Controller에서 특정 도서정보를 요청 시. 처리 할 bookMapper.updateBookPage(bookID) 전달 후 Controller에게 반환 
	 * 2. 에러 발생 시 에러 발생 시 throws Exception로 해당 서비스 호출한 Controller에게 Exception 전달 
	 * =======================================================================================================
	 */	
	@Override
	public UserDTO updateUserPage(int userID) throws Exception {
		
		//userMapper에서 반환값을 Controller에게 반환해야하기 때문에 return에 바로 설정 
		return usermapper.updateUserPage(userID);
	}

	/** Method Name  :  updateUser  
	 * ======================================= Method Detail ===========================================
	 * 1. Controller에서 전달 받은 사용자정보를 가지고 사용자의 정보를 수정 하기 위해 처리 할 usermapper.updateUser(dto) 전달 후 Controller에게 반환
	 * 2. 에러 발생 시 throws Exception로 해당 서비스 호출한 Controller에게 Exception 전달
	 * =================================================================================================
	 */	
	@Override
	//update 하기 때문에 반환값이 int형이기 때문에 메서드 타입을 int로 설정
	public int updateUser(UserDTO dto) throws Exception {
	
		//userMapper에서 반환값을 Controller에게 반환해야하기 때문에 return에 바로 설정 
		return usermapper.updateUser(dto);
	}
	
	/** Method Name  :  deleteUser  
	 * =================================== Method Detail =======================================
	 * 1. Controller에서 전달 받은 사용자ID(PK)를 가지고 사용자를 삭제를 하기 위해 처리 할  usermapper.deleteUser(UserID) 전달.
	 * 2. 전달 후 삭제된 사용자를 대여 중 인 대여정보도 함께 사라져야 하기 때문에 book_rental_mapper.returnBookRental(UserID) 호출
	 * 3. 호출 후 result 값을 Controller에게 반환
	 * 4. 에러 발생 시 throws Exception로 해당 서비스 호출한 Controller에게 Exception 전달
	 * =========================================================================================
	 */	
	@Override
	//delete 하기 때문에 반환값이 int형이기 때문에 메서드 타입을 int로 설정
	public int deleteUser(int UserID) throws Exception {
		
		//delete 하기 때문에 반환값이 int형이기 때문에 메서드 타입을 int로 설정
		int result = 0 ; 
		
		//usermapper.deleteUser(UserID) 호출 후 반환 값을 바로 result에 담기.
		result = usermapper.deleteUser(UserID);
		
		if(result > 0) {
			
			//회원이 삭제가 되었다면  대여중인 회원정보도 함께 삭제
			book_rental_mapper.returnBookRental(UserID);
		}
		
		//userMapper에서 반환값을 Controller에게 반환해야하기 때문에 return에 바로 설정 
		return result;
	}

	
}
