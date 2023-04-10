package bookMng.user.service;

import java.util.List;

import bookMng.user.dto.UserDTO;


public interface UserService {

	//DB에 저장된 유저정보를 가져오는 메서드
	public List<UserDTO> getLists()throws Exception;
	//유저의 정보를 DB에 저장하는 메서드
	public int userInsert(UserDTO dto)throws Exception;
	//특정 유저의 상세정보를 보는 메서드
	public UserDTO updateUserPage(int userID)throws Exception;
	//특정 유저의 정보를 수정하는 메서드 (userID) 제외
	public int updateUser(UserDTO dto)throws Exception;
	// 유저의 정보를 삭제하는 메서드
	public int deleteUser(int UserID)throws Exception;
}
