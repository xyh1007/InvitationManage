package service.Impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import dao.RepMapper;
import entity.Reply;
import service.ReplyServ;
@Service("replyserv")
public class ReplyServImpl implements ReplyServ{
@Resource
private RepMapper replyServ;
	@Override
	public List<Reply> getRepByInvid(int id) {
		// TODO Auto-generated method stub
		return replyServ.getRepByInvid(id);
	}

	@Override
	public void addrep(Reply reply) {
		// TODO Auto-generated method stub
		replyServ.addrep(reply);
	}

}
