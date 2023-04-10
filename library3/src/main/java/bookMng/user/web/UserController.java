package bookMng.user.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import bookMng.user.dto.UserDTO;


/** tomcat 실행 후 web.xml 실행 -> (/classpath*:spring/servlet-context.xml)실행
 * 
 * servlet-context.xml 에서 <context:include-filter type="annotation" expression="org.springframework.stereotype.Controller"/>
 *  @Controller로 명시된 거 객체생성 스프링컨테이너(객체생성,관리,소멸) 
 *  
 *  클라이언트 요청  @RequestMapping("*.do")라면 @RequestMapping를  Handlermapping에 올려둠
 *  그럼 Handlermapping 안에  @RequestMapping("*.do") -> BookController -> (); List형태로 정보를 가지고 있다고 가정!
 *  
 *  @Controller scan 후 container 올려두는데 @RequestMapping 선언된 메서드를 메모리에 올려두면 *.do로 된 Controller를 찾아가서 실행
 *   
 *  ("*.do") 실행 후 DispacherServlet -> Handlermapping 조회 -> HandlerAdapter(해당 요청을 실행(처리)할 수 있는 HandlerAdapter 조회 후 실행
 *   
 */

@Controller
public class UserController {

	//container에 생성되어 있는 UserService 객체 가져옴 (필드 주입)
	@Autowired
	private bookMng.user.service.UserService userservice;
	
	
	/** Method Name  :  selectUser  
	 * ==================================== Method Detail ======================================== 
	 * 1. Main.do에서 상단 카테고리 중 회원을 클릭 하면 사용자의정보 목록을 SelectUser.JSP에 보여줘야 하기 위해 때문에 처리 할
	 * 2. userservice.getLists() 전달.
	 * 3. Controller는 Dispatcher-Servlet 에게 다음페이지로(forward)해야하기 때문에 객체바인딩 후 다음 주소의 url를 반환
	 * 4. Service에서 에러 발생 시 에러를 받기 위해 try-catch문
	 * 5. Dispatcher-Servlet 에게 주소를 반환
	 * ============================================================================================
	 */	
	@RequestMapping("/selectUser.do")
	public String selectUser(HttpServletRequest request, HttpServletResponse rseponse)  throws Exception {
	
		try {

			//DB 저장된 값을 가져오기위해 List<UserDTO> List 선언
			List<UserDTO> List = userservice.getLists();
			
			//객체바인딩  SelectBook에 값을 보여줘야 하기 때문에
			request.setAttribute("List", List);
			
		}catch(Exception e) {
			
			System.out.println(e.getMessage());
		}

		//prefix,suffix로  WEB-INF/views/jsp 제외하고 forward 
		return "user/SelectUser";
	}

	//사용자가 insertBookPage.do 요청 시 도서를 등록할 수 있는 InsertBook.JSP로 페이지 이동
	@RequestMapping("/insertUserPage.do")
	public String insertUserPage() throws Exception {
		
		//prefix,suffix로  WEB-INF/views/jsp 제외하고 forward
		return "user/InsertUser";
	}
	
	
	
	/** Method Name  : insertUser  
	 * ========================================== Method Detail =============================================
	 * 1. InsertUser.JSP에서 전달 받은 도서정보를 가지고 도서추가를 하기 위해 처리 할 userservice.userInsert(dto) 전달.
	 * 2. Controller는 Dispatcher-Servlet 에게 다음 주소를 알려줘야 하고, forward 필요없이 redirect로 url를 반환.  
	 * 3. Service에서 에러 발생 시 에러를 받기 위해 try-catch문
	 * 4. Dispatcher-Servlet 에게 주소를 반환
	 * 5. insertUser.jsp에서 입력값을 UserDTO[Type] dto에 저장하기
	 * 6. insertUser.jsp name값과 UserDTO에 선언한 멤버변수와 동일하게 적용. 
	 * ======================================================================================================
	 */	
	@RequestMapping("/insertUser.do")
	public String insertUser(UserDTO dto, HttpServletRequest request, HttpServletResponse rseponse) throws Exception{
	
		try {
			
			// 객체바인딩을 하지 않고 dto값만 전달하기 위해 service. 호출.
			userservice.userInsert(dto);
			
		}catch(Exception e) {
			
			System.out.println(e.getMessage());
		}
		//DB에 저장 하고 forward가 필요 없어서 Page전환 redirect 설정.
		return "redirect:/main.do";
	}
	
	
	
	/** Method Name  :  updateUserPage 
	 * ================================================ Method Detail =====================================================
	 * 1. SelectBook.JSP에서 사용자목록 테이블에 사용자ID를 클릭하면 특정 사용자의정보가 나오게끔 처리 할 userservice.updateUserPage(userID) 전달.
	 * 2. Controller는 Dispatcher-Servlet 에게 다음페이지로(forward)해야하기 때문에 객체바인딩 후 다음 주소의 url를 반환
	 * 3. Service에서 에러 발생 시 에러를 받기 위해 try-catch문
	 * ====================================================================================================================
	 */	
	@RequestMapping("/updateUserPage.do")
	public String updateUserPage(int userID,HttpServletRequest request, HttpServletResponse rseponse) throws Exception {
		
		try {
			//userID에 해당하는 도서정보를 가져와야 하기 때문에 UserDTO dto에 return 값을 저장
			UserDTO dto = userservice.updateUserPage(userID);
			
			//객체바인딩 updateUserPage에 값을 보여줘야하기 때문에 
			request.setAttribute("dto", dto);
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		//prefix,suffix로  WEB-INF/views/jsp 제외하고 forward
		return "user/UpdateUserPage";
	}
	
	/** Method Name  :  updateUser  
	 * ======================================= Method Detail ============================================
	 * 1. UpdateUserPage.JSP에서 특정 사용자의 정보를 수정하기 위해 전달 받은 값을 처리 할 userservice.updateUser(dto) 전달.
	 * 2. Controller에서 Dispatcher-Servlet 에게 다음 주소를 알려줘야 하고, forward 필요없이 redirect로 url를 반환.
	 * 3. Service에서 에러 발생 시 에러를 받기 위해 try-catch문
	 * ==================================================================================================
	 */		
	@RequestMapping("/updateUser.do")
	public String updateUser(UserDTO dto, HttpServletRequest request, HttpServletResponse rseponse) throws Exception{
		
	
		 try {
			 //객체바인딩을 하지않고 dto(특정유저정보)값만 전ㄴ달하기 위해서 service 호출.
			 userservice.updateUser(dto);
			 
		 }catch(Exception e) {
			 System.out.println(e.getMessage());
		 }
		//DB에 저장 하고 forward가 필요 없어서 Page전환 redirect 설정
		 return "redirect:/main.do";
	}
	
	/** Method Name  :  deleteUser  
	 * ==================================== Method Detail =============================================
	 * 1. SelectBook.JSP에서 CheckBox(bookID)로 전달 받아 도서삭제를 하기 위해 처리 할  userservice.deleteUser(userID) 전달.
	 * 2. Controller에서 Dispatcher-Servlet 에게 다음 주소를 알려줘야 하고, forward 필요없이 redirect로 url를 반환.
	 * 3. Service에서 에러 발생 시 에러를 받기 위해 try-catch문
	 * ================================================================================================
	 */
	
	@RequestMapping("/deleteUser.do")
	public String deleteUser(int userID,HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		int result = 0;
		
		try {
			
			//객체바인딩을 하지 않고 dto(특정도서정보)값만 전달하기 위해서 service 호출.
			result = userservice.deleteUser(userID);
			
			if(result > 0 ) {
			
				//사용자 삭제만 forward가 필요 없어서 Page전환 redirect 설정
				return "redirect:/main.do";
			
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		//사용자 삭제만 forward가 필요 없어서 Page전환 redirect 설정
		 return "redirect:/main.do";
	}
}
