package bookMng.book.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


import bookMng.book.dto.BookDTO;
import bookMng.book.service.BookService;


/** tomcat 실행 후 web.xml 실행 -> (/classpath*:spring/servlet-context.xml)실행실행
 * 
 * servlet-context.xml 에서 <context:include-filter type="annotation" expression="org.springframework.stereotype.Controller"/>
 *  @Controller로 명시된 거 객체생성 스프링컨테이너(객체생성,관리,소멸) 
 *  
 *  클라이언트 요청  @RequestMapping("main.do")라면 @RequestMapping를  Handlermapping에 올려둠
 *  그럼 Handlermapping 안에  @RequestMapping("main.do") -> BookController -> main(); List형태로 정보를 가지고 있다고 가정!
 *  
 *  @Controller scan 후 container 올려두는데 @RequestMapping 선언된 메서드를 메모리에 올려두면 main.do로 된 Controller를 찾아가서 실행
 *   
 *  ("main.do") 실행 후 DispacherServlet -> Handlermapping 조회 -> HandlerAdapter(해당 요청을 실행(처리)할 수 있는 HandlerAdapter 조회 후 실행
 *   
 */
@Controller
public class BookController {

	
	@Autowired
	private BookService bookservice;

	//클라이언트 요청 main.do  
	@RequestMapping("/main.do")	
	public String main()  throws Exception {

		//prefix,suffix로  WEB-INF/views/jsp 제외하고 forward
		return "main/Main";
	}

	/** Method Name  :  SelectBook  
	 * ==================================== Method Detail ======================================== 
	 * 1. Main.do에서 상단 카테고리 중 도서를 클릭 하면 도서목록을 SelectBook.JSP에 보여줘야 하기 위해 때문에 처리 할
	 * 2. bookservice.getLists() 전달.
	 * 3. Controller는 Dispatcher-Servlet 에게 다음페이지로(forward)해야하기 때문에 객체바인딩 후 다음 주소의 url를 반환
	 * 4. Service에서 에러 발생 시 에러를 받기 위해 try-catch
	 * ============================================================================================
	 */	
	@RequestMapping("/selectBook.do")
	public String selectBook(HttpServletRequest request, HttpServletResponse rseponse) throws Exception {

		try {

			//DB에 저장된 값을 가져오기위해서 List<BookDTO> List 선언  
			List<BookDTO> List = bookservice.getLists();
			//객체바인딩  SelectBook에 값을 보여줘야 하기 때문에
			request.setAttribute("List", List);

		}catch(Exception e) {

			System.out.println(e.getMessage());
		}

		//prefix,suffix로  WEB-INF/views/jsp 제외하고 forward 
		return "book/SelectBook";

	}

	//사용자가 insertBookPage.do 요청 시 도서를 등록할 수 있는 InsertBook.JSP로 페이지 이동
	@RequestMapping("/insertBookPage.do")
	public String insertBookPage() throws Exception {

		//prefix,suffix로  WEB-INF/views/jsp 제외하고 forward
		return "book/InsertBook";
	}

	/** Method Name  : insertBook  
	 * ========================================== Method Detail =============================================
	 * 1. InsertBook.JSP에서 전달 받은 도서정보를 가지고 도서추가를 하기 위해 처리 할 bookservice.bookInsert(dto) 전달.
	 * 2. Controller는 Dispatcher-Servlet 에게 다음 주소를 알려줘야 하고, forward 필요없이 redirect로 url를 반환.  
	 * 3. Service에서 에러 발생 시 에러를 받기 위해 try-catch문
	 * 4. Dispatcher-Servlet 에게 주소를 반환
	 * 5. insertBook.jsp에서 입력값을 BooDTO[Type] dto에 저장하기
	 * 6. insertBook.jsp name값과 BookDTO에 선언한 멤버변수와 동일하게 적용. 
	 * ======================================================================================================
	 */	
	@RequestMapping("/insertBook.do")
	public String insertBook(BookDTO dto, HttpServletRequest request, HttpServletResponse rseponse) throws Exception {
		try {

			// 객체바인딩을 하지 않고 dto값만 전달하기 위해서 service 호출.
			bookservice.bookInsert(dto);

		}catch(Exception e) {
			System.out.println(e.getMessage());
		}

		//DB에 저장 하고 forward가 필요 없어서 Page전환 redirect 설정.
		return "redirect:/main.do";
	}

	/** Method Name  :  updateBookPage 
	 * ========================================= Method Detail ==============================================
	 * 1. SelectBook.JSP에서 도서목록 테이블에 도서ID를 클릭하면 특정 도서의정보가 나오게끔 처리 할 bookservice.updateBookPage(bookID) 전달.
	 * 2. Controller는 Dispatcher-Servlet 에게 다음페이지로(forward)해야하기 때문에 객체바인딩 후 다음 주소의 url를 반환
	 * 3. Service에서 에러 발생 시 에러를 받기 위해 try-catch문
	 * ======================================================================================================
	 */	
	@RequestMapping("/updateBookPage.do")
	public String updateBookPage(int bookID, HttpServletRequest request, HttpServletResponse rseponse) throws Exception {

		try {

			//bookID에 해당하는 도서정보를 가져와야 하기 때문에 BookDTO dto에 return 값을 저장
			BookDTO dto = bookservice.updateBookPage(bookID);

			//객체바인딩 updateBookPage에 값을 보여줘야하기 때문에 
			request.setAttribute("dto",dto);
			//prefix,suffix로  WEB-INF/views/jsp 제외하고 forward

		}catch(Exception e) {

			System.out.println(e.getMessage());
		}
		//prefix,suffix로  WEB-INF/views/jsp 제외하고 forward
		return "book/UpdateBookPage"; 
	}

	/** Method Name  :  UpdateBook  
	 * ======================================= Method Detail ============================================
	 * 1. UpdateBookPage.JSP에서 특정 도서의 정보를 수정하기 위해 전달 받은 값을 처리 할 bookservice.updateBook(dto) 전달.
	 * 2. Controller에서 Dispatcher-Servlet 에게 다음 주소를 알려줘야 하고, forward 필요없이 redirect로 url를 반환.
	 * 3. Service에서 에러 발생 시 에러를 받기 위해 try-catch문
	 * ==================================================================================================
	 */		
	@RequestMapping("/updateBook.do")
	public String updateBook(BookDTO dto,HttpServletRequest request, HttpServletResponse rseponse) throws Exception{


		try {
			//객체바인딩을 하지 않고 dto(특정도서정보)값만 전달하기 위해서 service 호출.
			bookservice.updateBook(dto);


		}catch(Exception e) {

			System.out.println(e.getMessage());			
		}
		//DB에 저장 하고 forward가 필요 없어서 Page전환 redirect 설정.
		return "redirect:/main.do";
	}


	/** Method Name  :  deleteBook  
	 * ==================================== Method Detail =============================================
	 * 1. SelectBook.JSP에서 CheckBox(bookID)로 전달 받아 도서삭제를 하기 위해 처리 할  bookservice.deleteBook(bookID) 전달.
	 * 2. Controller에서 Dispatcher-Servlet 에게 다음 주소를 알려줘야 하고, forward 필요없이 redirect로 url를 반환.
	 * 3. Service에서 에러 발생 시 에러를 받기 위해 try-catch문
	 * ================================================================================================
	 */
	@RequestMapping("/deleteBook.do")
	public  String deleteBook(int bookID,HttpServletRequest request, HttpServletResponse rseponse) throws Exception {

		int result = 0;

		try {
			//객체바인딩을 하지 않고 dto(특정도서정보)값만 전달하기 위해서 service 호출.
			result = bookservice.deleteBook(bookID);

			if(result > 0 ) {
				
				//도서삭제만 forward가 필요 없어서 Page전환 redirect 설정
				return "redirect:/main.do";
			}
		}
		catch(Exception e) {

			System.out.println(e.getMessage());
		}

		//도서삭제만 forward가 필요 없어서 Page전환 redirect 설정
		return "redirect:/main.do";
	}
}
