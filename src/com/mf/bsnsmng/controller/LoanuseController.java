package com.mf.bsnsmng.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mf.base.TreeNode;
import com.mf.bsnsmng.entity.Loanuse;
import com.mf.bsnsmng.service.LoanuseService;
import com.mf.util.WebTool;


@Controller
@RequestMapping(value="/mf/loanuse/")
public class LoanuseController {
@Autowired
private LoanuseService loanuseService;
	
    @RequestMapping(value="getDepartmentsTree")
    @ResponseBody
	 public Map<String,List> getDepartmentsTree(Model model,HttpServletRequest request){
    	System.out.println("-------------------------");
		 List<Loanuse> list = loanuseService.findAll();
		 List<TreeNode>  treeNodes = new ArrayList<TreeNode>();
		 if(list!=null&&list.size()>0){
			 for(int i=0;i<list.size();i++){
				 TreeNode node = convert(list.get(i),request);
				 treeNodes.add(node);
			 }
		 }
		 Map<String, List> map = new HashMap<String, List>();
		 map.put("treeNodes", treeNodes);
		 System.out.println(treeNodes);
		 return map;
	 }
	 public TreeNode convert(Loanuse org,HttpServletRequest request) {
			TreeNode node = new TreeNode();
			node.setChecked(false);
			node.setChkDisabled(false);
			node.setClick("");
			node.setClickExpand(false);
		    node.setDrag(true);
      	    node.setIcon(request.getContextPath() + "/libs/icons/user_group.gif");
			node.setIconClose("");
			node.setIconOpen("");
			node.setId(String.valueOf(org.getUseno()));
			node.setName(org.getUsenm());
			node.setParentId(String.valueOf(org.getFrstfthr()));
			node.setOldParentId(String.valueOf(org.getScndfthr()));
			node.setOpen(false);
			node.setExisted(true);
			return node;
		}
	 
	 @RequestMapping(value="getById")
	 public String getById(Model model,HttpServletRequest request,HttpServletResponse response){
		 String result ="{\"status\":true,\"message\":\"取值成功！\"}";
		 String id = request.getParameter("praentId");
		 Loanuse loanuse = loanuseService.getById(id);
		 String name = loanuse.getUsenm();
		 result = "{\"status\":true,\"message\":"+"\""+name+"\""+"}";
		 WebTool.writeJson(result, response);
		 return null;
	 }
	 

}
