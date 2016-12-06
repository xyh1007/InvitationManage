package service.Impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import dao.InvMapper;
import entity.Invitation;
import service.InvServ;
@Service("InvServ")
public class InvServImpl implements InvServ{
	int pageSize = 4;
@Resource
private InvMapper invMapper;
	@Override
	public List<Invitation> getInvList(int startNum, String title) {
		// TODO Auto-generated method stub
		return invMapper.getInvList(startNum, title);
	}

	@Override
	public List<Invitation> getAllInv(int startNum) {
		// TODO Auto-generated method stub
		return invMapper.getAllInv(startNum);
	}

	@Override
	public int getInvCount() {
		// TODO Auto-generated method stub
		return invMapper.getInvCount();
	}

	@Override
	public void deleteInv(int id) {
		// TODO Auto-generated method stub
		invMapper.deleteInv(id);
	}

	@Override
	public void deleteRep(int id) {
		// TODO Auto-generated method stub
		invMapper.deleteRep(id);
	}

	@Override
	public int getTotalPage() {
		// TODO Auto-generated method stub
		int count = invMapper.getInvCount();
		if(count%pageSize==0){
			return count/pageSize;
		}else{
			return count/pageSize+1;
		}
	}

	@Override
	public int getstartNum(int currentPage) {
		// TODO Auto-generated method stub
		return (currentPage-1)*pageSize;
	}

	@Override
	public int getSearchInvListCount(String title) {
		// TODO Auto-generated method stub
		return invMapper.getSearchInvListCount(title);
	}

	@Override
	public int getSearchTotalPage(String title) {
		// TODO Auto-generated method stub
		int count = invMapper.getSearchInvListCount(title);
		if(count==0){
			return 1;
		}
		if(count%pageSize==0){
			return count/pageSize;
		}else{
			return count/pageSize+1;
		}
	}

}
