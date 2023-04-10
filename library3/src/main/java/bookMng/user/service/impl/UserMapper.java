package bookMng.user.service.impl;

import java.util.List;

import bookMng.user.dto.UserDTO;



public interface UserMapper {

	//DB에 저장된 유저정보를 가져오는 메서드
	public List<UserDTO> getLists();
	//유저의 정보를 DB에 저장하는 메서드
	public int userInsert(UserDTO dto);
	//특정 유저의 상세정보를 보는 메서드
	public UserDTO updateUserPage(int userID);
	//특정 유저의 정보를 수정하는 메서드 (userID) 제외
	public int updateUser(UserDTO dto);
	//유저의 정보를 삭제하는 메서드
	public int deleteUser(int UserID);
}
