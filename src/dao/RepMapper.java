package dao;

import java.util.List;

import entity.Reply;

public interface RepMapper {
	
	/**
	 * 获取回复列表
	 * @param id
	 * @return
	 */
	List<Reply> getRepByInvid(int id);
	
	/**
	 * 添加回复
	 * @param reply
	 */
	void addrep(Reply reply);
}
