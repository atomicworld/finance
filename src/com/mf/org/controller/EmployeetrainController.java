package com.mf.org.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mf.common.pub.PubConstants;
import com.mf.common.util.WaterIdGener;
import com.mf.org.entity.Employee;
import com.mf.org.entity.Employeetrain;
import com.mf.org.entity.EmplyTrain;
import com.mf.org.service.DeptService;
import com.mf.org.service.EmployeetrainService;
import com.mf.org.service.EmplyTrainService;
import com.mf.org.service.impl.EmployeeServiceImpl;
import com.mf.util.Common;
import com.mf.util.PageView;
import com.mf.util.WebTool;

/**
 * @author hw
 * @2015-08-21
 */
@Controller
@RequestMapping(value="/mf/org/employeetrain/")
public class EmployeetrainController {

	@Autowired
	private EmployeetrainService employeetrainService;
	@Autowired
	private EmployeeServiceImpl employeeService;
	@Autowired
	private EmplyTrainService emplyTrainService;
	@Autowired
	private DeptService deptService;
	
	/** 跳到培训页面 */
	@RequestMapping(value="list")
	public String list(HttpServletRequest request){
		String tmp = request.getSession().getAttribute("operator").toString();
		if(tmp.equals(PubConstants.SuperAdmin))
			return "/mf/org/emplytrain/train/list1";
		return "/mf/org/emplytrain/train/list";
	}
	
	/** 找到培训信息 */
	@RequestMapping(value="showlist",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> showlist(Model model,Employeetrain employeetrain,HttpServletRequest request){
		PageView pageView = null;
		String pageNow=request.getParameter("pager.pageNo");
		String pageSize=request.getParameter("pager.pageSize");
		if(Common.isEmpty(pageNow)){
			pageView = new PageView(1);
		}else{
			pageView = new PageView(Integer.parseInt(pageSize),Integer.parseInt(pageNow));
		}
		Map<String, Object> map=new HashMap<String, Object>();
		pageView = employeetrainService.query(pageView, employeetrain);
		List<Employeetrain> list=pageView.getRecords();
		map.put("rows", list); 
		map.put("pager.pageNo", pageView.getPageNow());
		map.put("pager.totalRows", pageView.getRowCount());
		return map;
	}
	
	/** 跳到新增培训页面 */
	@RequestMapping(value="addUI")
	public String addUI(Model model){
		
		return "/mf/org/emplytrain/train/add";
	}
	
	/** 跳到新增人员页面 */
	@RequestMapping(value="addPeople")
	public String addPeople(Model model){
		
		List<Employee> list = employeeService.getEmployees();
		System.out.println(list.size());
		model.addAttribute("rows",list);
		return "/mf/org/emplytrain/trainpeople/addPeople";
	}
	
	/** 找到人员信息 */
	@RequestMapping(value="showPeoplelist",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> showPeoplelist(Model model,Employee employee,HttpServletRequest request){
		PageView pageView = null;
		String pageNow=request.getParameter("pager.pageNo");
		String pageSize=request.getParameter("pager.pageSize");
		if(Common.isEmpty(pageNow)){
			pageView = new PageView(1);
		}else{
			pageView = new PageView(Integer.parseInt(pageSize),Integer.parseInt(pageNow));
		}
		Map<String, Object> map=new HashMap<String, Object>();
		pageView = employeeService.findAll(pageView, employee);
		List<Employee> list=pageView.getRecords();
		map.put("rows", list); 
		map.put("pager.pageNo", pageView.getPageNow());
		map.put("pager.totalRows", pageView.getRowCount());
		return map;
	}
	
	//新增
	@RequestMapping(value="add")
	public String add(Model model, HttpServletResponse response, HttpServletRequest request){
		String result="{\"msg\":\"suc\"}";
		try{
			/**********     会议表的数据  begin    ***************/
			//获取页面传回来的table的值，并且存入到数据库
			String startdt = request.getParameter("startdt");//培训开始日期
			String enddt = request.getParameter("enddt");//培训结束日期
			String numofpeople = request.getParameter("numofpeople");//人数
			String hours = request.getParameter("hours");//学时
			String project = request.getParameter("project");//培训项目
			String sponsor = request.getParameter("sponsor");//主办单位
			String content = request.getParameter("content");//培训内容
			//生成主键
			String key = WaterIdGener.genPKWithPrefix("HY");
			
			Employeetrain employeetrain = new Employeetrain();
			employeetrain.setTrainno(key);
			employeetrain.setStartdt(startdt);
			employeetrain.setEnddt(enddt);
			employeetrain.setNumofpeople(numofpeople);
			employeetrain.setHours(hours);
			employeetrain.setProject(project);
			employeetrain.setSponsor(sponsor);
			employeetrain.setContent(content);
			employeetrainService.add(employeetrain);
			/*****************       会议信息  end     ****************/
			
			/*****************		会议人员对应表	begin	****************/
			String [] emplynm_values = request.getParameterValues("emplynm");
			String [] idnum_values = request.getParameterValues("idnum");
			String [] score_values = request.getParameterValues("score");
			String [] result_values = request.getParameterValues("result");
			String [] remark_values = request.getParameterValues("remark");
			String [] emplyno_values = request.getParameterValues("emplyno");
			if (null != emplyno_values && null != idnum_values && null != emplynm_values ) { //当存在人员的时候
				for (int j = 0; j < emplyno_values.length; j++) {
					EmplyTrain emplyTrain = new EmplyTrain();
					emplyTrain.setId(WaterIdGener.genPKWithPrefix("P"));//主键，自增
					emplyTrain.setTrainno(key);//会议信息主键
					emplyTrain.setEmplyno(emplyno_values[j]);//人员信息主键
					emplyTrain.setEmplynm(emplynm_values[j]);
					emplyTrain.setIdnum(idnum_values[j]);
					emplyTrain.setScore(score_values[j]);//分数
					emplyTrain.setResult(result_values[j]);//结果
					emplyTrain.setRemark(remark_values[j]);//备注
					emplyTrainService.add(emplyTrain);
				}
			}
			/*****************		会议人员对应表	end		****************/
			
			
		}catch(Exception e){
			result = "{\"msg\":\"fail\",\"message\":\""
					+ WebTool.getErrorMsg(e.getMessage()) + "\"}";
			e.printStackTrace();
		}
		WebTool.writeJson(result, response);
		return null;
	}
	
	
	//编辑页面
	@RequestMapping(value="getById")
	public String getById(Model model, String trainno){
		
		//找到会议那张表
		Employeetrain employeetrain = employeetrainService.getById(trainno);
		model.addAttribute("employeetrain",employeetrain);
		
		//找到员工-会议表
		List<EmplyTrain> list_emplyTrain = emplyTrainService.getByTraino(trainno);
		model.addAttribute("planlist", list_emplyTrain);
		
		return "/mf/org/emplytrain/train/edit";
	}
	
	
	
	//更新
	@RequestMapping(value="updateAll")
	public String updateAll(Model model, HttpServletResponse response, HttpServletRequest request){
		String result="{\"msg\":\"suc\"}";
		try{
		/**********     会议表的数据  begin    ************************************/
			//获取页面传回来的table的值，并且存入到数据库
			String startdt = request.getParameter("startdt");//培训开始日期
			String enddt = request.getParameter("enddt");//培训结束日期
			String numofpeople = request.getParameter("numofpeople");//人数
			String hours = request.getParameter("hours");//学时
			String project = request.getParameter("project");//培训项目
			String sponsor = request.getParameter("sponsor");//主办单位
			String content = request.getParameter("content");//培训内容
			
			//找到主键
			String key = request.getParameter("trainno");
			Employeetrain employeetrain = employeetrainService.getById(key);//根据主键找到
			employeetrain.setTrainno(key);
			employeetrain.setStartdt(startdt);
			employeetrain.setEnddt(enddt);
			employeetrain.setNumofpeople(numofpeople);
			employeetrain.setHours(hours);
			employeetrain.setProject(project);
			employeetrain.setSponsor(sponsor);
			employeetrain.setContent(content);
			employeetrainService.modify(employeetrain);
			
		/*****************       会议信息  end     ******************************/
			
		/*****************		会议人员对应表	begin	***********************/
			//先删除后增加
			emplyTrainService.deleteByTrainno(key);
			
			String [] emplynm_values = request.getParameterValues("emplynm");
			String [] idnum_values = request.getParameterValues("idnum");
			String [] score_values = request.getParameterValues("score");
			String [] result_values = request.getParameterValues("result");
			String [] remark_values = request.getParameterValues("remark");
			String [] emplyno_values = request.getParameterValues("emplyno");
			if (null != emplyno_values && null != idnum_values &&
					null != emplynm_values ) { //这两个不能为空
//				List<EmplyTrain> list = new ArrayList<EmplyTrain>();
				for (int j = 0; j < emplyno_values.length; j++) {
					EmplyTrain emplyTrain = new EmplyTrain();
					emplyTrain.setId(WaterIdGener.genPKWithPrefix("P"));//主键，自增
					emplyTrain.setTrainno(key);//会议信息主键
					emplyTrain.setEmplyno(emplyno_values[j]);//人员信息主键
					emplyTrain.setEmplynm(emplynm_values[j]);
					emplyTrain.setIdnum(idnum_values[j]);
					emplyTrain.setScore(score_values[j]);//分数
					emplyTrain.setResult(result_values[j]);//结果
					emplyTrain.setRemark(remark_values[j]);//备注
					emplyTrainService.add(emplyTrain);
				}
			}
			/*****************		会议人员对应表	end		****************/
		}catch(Exception e){
			result = "{\"msg\":\"fail\",\"message\":\""
					+ WebTool.getErrorMsg(e.getMessage()) + "\"}";
			e.printStackTrace();
		}
		WebTool.writeJson(result, response);
		return null;
	}
	
	
	
	@RequestMapping(value="deleteAll")
	public String deleteAll(Model model,String ids, HttpServletResponse response){
		String result=null;
		try{
			
			//先删除 人员——会议对应表
			emplyTrainService.deleteByTrainno(ids);
			
			//根据会议编号删除
			employeetrainService.deleteByTrainno(ids);
			
		    result="{\"status\":1,\"message\":\"删除成功！\"}";
		    
		}catch(Exception e){
			result="{\"status\":0,\"message\":\"" +WebTool.getErrorMsg(e.getMessage())+"\"}";
			e.printStackTrace();
		}
		WebTool.writeJson(result, response);
		return null;
	}
	
	
	/** 找到培训信息 */
	@RequestMapping(value="showDetail")
	public String showDetail(Model model,String trainno,HttpServletRequest request){
		
		Employeetrain employeetrain = employeetrainService.getById(trainno);
		List<EmplyTrain> list = emplyTrainService.getByTraino(trainno);
		
		model.addAttribute("planlist",list);
		model.addAttribute("employeetrain",employeetrain);
		
		return "/mf/org/emplytrain/train/show";
	}
}

