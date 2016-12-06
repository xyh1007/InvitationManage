package dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import entity.Invitation;

/**
 * @author Administrator
 *
 */
public interface InvMapper {
	
	/**
	 * 获取查询后的帖子列表
	 * @param startNum 起始数
	 * @param title 查询的标题
	 * @return 查询后的帖子列表
	 */
	List<Invitation> getInvList(@Param("startNum") int startNum,@Param("title")String title);
	/**
	 * 获取总的帖子列表
	 * @param startNum 起始数
	 * @return 总的帖子列表
	 */
	List<Invitation> getAllInv(@Param("startNum") int startNum);
	/**
	 * 获取总的帖子数
	 * @return
	 */
	int getInvCount();
	
	/**
	 * 获取查询后的帖子总数
	 * @param title
	 * @return
	 */
	int getSearchInvListCount(@Param("title")String title);
	
	/**
	 * 删除帖子
	 * @param id
	 */
	void deleteInv(int id);
	
	/**
	 * 删除回复
	 * @param id
	 */
	void deleteRep(int id);
}
