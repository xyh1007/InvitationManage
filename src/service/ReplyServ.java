package service;

import java.util.List;

import entity.Reply;

public interface ReplyServ {
	List<Reply> getRepByInvid(int id);
	void addrep(Reply reply);
}
