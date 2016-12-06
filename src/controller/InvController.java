package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;



import entity.Invitation;
import service.InvServ;



@Controller
public class InvController {
	@Resource
	private InvServ InvServ;
	@RequestMapping(value={"/","/invlist"},method=RequestMethod.GET)
	public String invlist(HttpSession session) throws IOException{

		
		session.removeAttribute("title");
		List<Invitation> invlist = new ArrayList<Invitation>();
		invlist=InvServ.getAllInv(0);
		int totalPage=InvServ.getTotalPage();
		session.setAttribute("invlist", invlist);
		session.setAttribute("currentPage", "1");
		session.setAttribute("totalPage", totalPage);
		session.setAttribute("delflag", "0");
		session.setAttribute("id", "0");
		session.setAttribute("deldisplay", "0");
		session.setAttribute("title", "");
		return "invlist";
	}
	@RequestMapping(value="/invlist",method=RequestMethod.POST)
	public String invlist(@RequestParam String deldisplay,@RequestParam String id,@RequestParam String delflag,@RequestParam String title,@RequestParam String currentPage,@RequestParam String totalPage,HttpSession session) throws IOException{

		int totalPage1;
		int startNum=InvServ.getstartNum(Integer.parseInt(currentPage.trim()));
		if(Integer.parseInt(delflag.trim())==1){
			InvServ.deleteRep(Integer.parseInt(id.trim()));
			InvServ.deleteInv(Integer.parseInt(id.trim()));
            totalPage1=InvServ.getTotalPage();
            if(Integer.parseInt(totalPage)==totalPage1){
            	
            }
            else{
            	totalPage=Integer.toString(totalPage1);
            	currentPage=Integer.toString(Integer.parseInt(currentPage)-1);
            }
		}
		if(title.trim().equals("")||title.trim().equals(null)){
			List<Invitation> invlist = new ArrayList<Invitation>();
			totalPage=Integer.toString(InvServ.getTotalPage());
			startNum=InvServ.getstartNum(Integer.parseInt(currentPage.trim()));
			invlist=InvServ.getAllInv(startNum);
			session.setAttribute("invlist", invlist);
			session.setAttribute("currentPage", currentPage.trim());
			session.setAttribute("totalPage", totalPage);
			session.setAttribute("title", title.trim());
			session.setAttribute("delflag", "0");
			session.setAttribute("deldisplay", deldisplay);
			return "invlist";
		}else{
		List<Invitation> invlist = new ArrayList<Invitation>();
		invlist=InvServ.getInvList(0,title);
		totalPage=Integer.toString(InvServ.getSearchTotalPage(title));
		session.setAttribute("invlist", invlist);
		session.setAttribute("totalPage", totalPage);
		session.setAttribute("currentPage", "1");
		session.setAttribute("title", title.trim());
		session.setAttribute("delflag", "0");
		session.setAttribute("deldisplay", deldisplay);
		return "invlist";
		}
	}
}
