package controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import dao.RepMapper;

import entity.Reply;

import service.ReplyServ;

@Controller

public class ReplyController {
@Resource	
	private ReplyServ replyserv;
	@RequestMapping(value="/replist",method=RequestMethod.GET)
	public String replist(@RequestParam String id,HttpSession session) throws IOException{

		List<Reply> replist = new ArrayList<Reply>();
		int iid= Integer.parseInt(id);
		replist=replyserv.getRepByInvid(iid);
		session.setAttribute("replist", replist);
		session.setAttribute("id", id);
		return "replist";
	}
	@RequestMapping(value="/addrep",method=RequestMethod.GET)
	public String addrep(@RequestParam String id,HttpSession session){
		session.setAttribute("id", id);
		return "addrep";
	}
	@RequestMapping(value="addrep",method=RequestMethod.POST)
	public String addrep(@RequestParam String id,@RequestParam String content,@RequestParam String author,HttpSession session) throws IOException{

		Reply reply = new Reply();
		reply.setContent(content);
		reply.setAuthor(author);
		int iid=Integer.parseInt(id);
		reply.setInvid(iid);
		replyserv.addrep(reply);
		return "redirect:/replist?id="+id;
	}
}
