package ua.newhouses.club.manager;

import java.util.ArrayList;
import ua.newhouses.club.dao.MemberDAO;
import ua.newhouses.club.dto.MemberDTO;

public class MemberManager {
	
	public static ArrayList<MemberDTO> getAllMembers() {
		ArrayList<MemberDTO> memberList = new ArrayList<MemberDTO>();
		memberList = MemberDAO.getAllMembers();
	
		 return memberList;
	 }
	
	public static MemberDTO getMemberById(String id) {
		MemberDTO member = new MemberDTO();
		member = MemberDAO.getMemberById(id);
		return member;
		
	 }

	public static void deleteUser(String id) {
		MemberDAO.deleteUser(id);
	 }
	
	public static void addUser(MemberDTO member) {
		MemberDAO.addUser(member);
	 }
	
	public static void updateUser(MemberDTO member) {
		MemberDAO.updateUser(member);
	 }
		
}
