package bookMng.bookRental.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import bookMng.book.dto.BookDTO;
import bookMng.book.service.BookService;
import bookMng.bookRental.dto.BookRentalDTO;
import bookMng.bookRental.service.BookRentalService;
import bookMng.user.dto.UserDTO;
import bookMng.user.service.UserService;



/** tomcat 실행 후 web.xml 실행 -> (/classpath*:spring/servlet-context.xml)실행실행
 * 
 * servlet-context.xml 에서 <context:include-filter type="annotation" expression="org.springframework.stereotype.Controller"/>
 *  @Controller로 명시된 거 객체생성 스프링컨테이너(객체생성,관리,소멸) 
 *  
 *  클라이언트 요청  @RequestMapping("*.do")라면 @RequestMapping를  Handlermapping에 올려둠
 *  그럼 Handlermapping 안에  @RequestMapping("*.do") -> Controller -> ?(); List형태로 정보를 가지고 있다고 가정!
 *  
 *  @Controller scan 후 container 올려두는데 @RequestMapping 선언된 메서드를 메모리에 올려두면 *.do로 된 Controller를 찾아가서 실행
 *   
 *  ("*.do") 실행 후 DispacherServlet -> Handlermapping 조회 -> HandlerAdapter(해당 요청을 실행(처리)할 수 있는 HandlerAdapter 조회 후 실행
 */

@Controller
public class BookRentalController {

	@Autowired
	private BookRentalService book_rental_service;
	
	@Autowired
	private BookService bookservice;
	
	@Autowired
	private UserService userservice; 


	
	/** Method Name  :  borrowSelectBook  
	 * ==================================== Method Detail ======================================== 
	 * 1. Main.do에서 상단 카테고리 중 대여를 클릭 하면 대여목록을 BorrowBookRental.JSP에 보여줘야 하기 위해 때문에 처리 할
	 * 2. book_rental_service.getLists() 전달.
	 * 3. Controller는 Dispatcher-Servlet 에게 다음페이지로(forward)해야하기 때문에 객체바인딩 후 다음 주소의 url를 반환
	 * 4. Service에서 에러 발생 시 에러를 받기 위해 try-catch문
	 * ============================================================================================
	 */	
	//클라이언트 요청 borrowSelectBook.do
	@RequestMapping("/borrowSelectBook.do")
	public String borrowSelectBook(HttpServletRequest request, HttpServletResponse rseponse) throws Exception {

		try {

			// DB에서 (대여정보)저장된 값을 가져오기 위해 List<BookRentlaDTO> List 선언
			List<BookRentalDTO> rentalList = book_rental_service.getLists();

			// 객체바인딩 BorrowBookRental.jsp에 값을 보여줘야 하기 때문에
			request.setAttribute("rentalList", rentalList);

		
		}catch(Exception e){

			System.out.println(e.getMessage());
		}

		//prefix,suffix로  WEB-INF/views/jsp 제외하고 forward 
		return "bookRental/BorrowBookRental";
	}


	/** Method Name  : borrowSelectBookPage 
	 * ============================================= Method Detail =====================================================
	 * 1. SelectBookRental.JSP에 사용자정보,도서정보를 보여줘야 하기 위해 처리 할 bookservice.getLists(),userservice.getLists() 전달.
	 * 2. FrontController(Dispatcher-Servlet)에서 다음페이지로(forward)해야하기 객체바인딩 후 다음 주소의 url를 반환  
	 * 3. Service에서 에러 발생 시 에러를 받기 위해 try-catch문
	 * =================================================================================================================
	 */	
	@RequestMapping("/borrowSelectBookPage.do")
	public String borrowSelectBookPage(HttpServletRequest request, HttpServletResponse rseponse) throws Exception {

		try {

			//DB에 저장된 값을 가져오기위해서 List<BookDTO> List 선언  
			List<BookDTO> bookList = bookservice.getLists();
			//객체바인딩  SelectBookRental.jsp에 값을 보여줘야 하기 때문에
			request.setAttribute("bookList", bookList);
			//DB 저장된 값을 가져오기위해 List<UserDTO> List 선언
			List<UserDTO> userList = userservice.getLists();
			//객체바인딩  SelectBookRental.jsp에 값을 보여줘야 하기 때문에
			request.setAttribute("userList", userList);

		}catch(Exception e) {

			System.out.println(e.getMessage());
		}

		//prefix,suffix로  WEB-INF/views/jsp 제외하고 forward 
		return "bookRental/SelectBookRental";
	}


	/** Method Name  :  borrowBookRental  
	 * ============================================= Method Detail =====================================================
	 * 1. SelectBookRental.jsp에서 CheckBox(bookID,userID)로 전달 받아 대여를 하기 위해 처리 할 book_rental_service.bookRental(dto) 전달.
	 * 2. Controller는 Dispatcher-Servlet에게 다음 주소를 알려줘야 하고, forward 필요없이 redirect로 url를 반환.  
	 * 3. Service에서 에러 발생 시 에러를 받기 위해 try-catch문
	 * =================================================================================================================
	 */	
	@RequestMapping("/borrowBookRental.do")
	public String borrowBookRental(BookRentalDTO dto,HttpServletRequest request, HttpServletResponse rseponse ) throws Exception {

		try {
	
			//borrowSelectBookPage.do 에서 CheckBox를 통해 bookID,userID를 BookRentalDTO dto 담아 
			//book_rental_service.bookRental(dto); 파라미터를 통해 값을 보낸다.
			book_rental_service.bookRental(dto);

		}catch(Exception e) {

			System.out.println(e.getMessage());
		}

		//대여만 하기 때문에 forward 필요없이 페이지만 전환 
		return "redirect:/borrowSelectBook.do";
	}

	/** Method Name  :  ReturnBookRental  
	 * ============================================= Method Detail =====================================================
	 * 1. BorrowBookRental.jsp에서 CheckBox(userID)로 전달 받아 반납을 하기 위해 처리 할 brs.deleteBookRental(userID) 전달.
	 * 2. Controller는 Dispatcher-Servlet에게 다음 주소를 알려줘야 하고, forward 필요없이 redirect로 url를 반환.   
	 * 3. Service에서 에러 발생 시 에러를 받기 위해 try-catch문
	 * =================================================================================================================
	 */	
    @RequestMapping("/ReturnBookRental.do")
    public String ReturnBookRental(int userID, HttpServletRequest request, HttpServletResponse rseponse) throws Exception {
    	
    	try {
    		
    		//BorrowBookRental.jsp에서 CheckBox를 통해 userID의 값을 받아 
    		//book_rental_service.ReturnBookRental(userID); 값을 보낸다.
    		book_rental_service.ReturnBookRental(userID);
    		
    	}catch(Exception e) {
    		
    		System.out.println(e.getMessage());
    	}
    	
    	// 반납만 때문에 forward 필요없이 페이지만 전환
    	return "redirect:/main.do";
    }

}
