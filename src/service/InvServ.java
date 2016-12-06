package service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import entity.Invitation;

public interface InvServ {
	List<Invitation> getInvList(int startNum,String title);
	List<Invitation> getAllInv(int startNum);
	int getInvCount();
	int getSearchInvListCount(String title);
	void deleteInv(int id);
	void deleteRep(int id);
	int getTotalPage();
	int getstartNum(int currentPage);
	int getSearchTotalPage(String title);
}
