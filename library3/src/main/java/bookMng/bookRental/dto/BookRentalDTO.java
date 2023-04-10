package bookMng.bookRental.dto;

public class BookRentalDTO {


	private int bookID; //도서아아디
	private int userID; //사용자아이디
 
	private String bookTitle; //도서명
	private String bookAuthor; // 도서저자
	private int bookPrice; //도서가격

	private String userName; //사용자이름
	private String userSex;  //사용자성별
	private int userAge;  //사용자나이
	private String userPhone; //사용자전화번호


	public int getbookID() {
		return bookID;
	}



	public void setBookID(int bookID) {
		this.bookID = bookID;
	}



	public int getUserID() {
		return userID;
	}



	public void setUserID(int userID) {
		this.userID = userID;
	}



	public String getBookTitle() {
		return bookTitle;
	}



	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}



	public String getBookAuthor() {
		return bookAuthor;
	}



	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}



	public int getBookPrice() {
		return bookPrice;
	}



	public void setBookPrice(int bookPrice) {
		this.bookPrice = bookPrice;
	}



	public String getUserName() {
		return userName;
	}



	public void setUserName(String userName) {
		this.userName = userName;
	}



	public String getUserSex() {
		return userSex;
	}



	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}



	public int getUserAge() {
		return userAge;
	}



	public void setUserAge(int userAge) {
		this.userAge = userAge;
	}



	public String getUserPhone() {
		return userPhone;
	}



	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

}
