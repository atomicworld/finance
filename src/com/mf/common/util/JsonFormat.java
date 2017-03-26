package com.mf.common.util;

import java.util.ArrayList;
import java.util.List;

import com.mf.flowmng.entity.FlowBean;
import com.mf.flowmng.entity.LineBean;
import com.mf.flowmng.entity.NodeBean;


import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * 
 * @author fangzp 
 *
 */
public class JsonFormat {

	
	public  FlowBean getFlowBean(String jsonString){
		FlowBean fb = null;
		try{
		   if(jsonString != null && !"".equals(jsonString.trim())){
			   fb = new FlowBean();
			   JSONObject jj = JSONObject.fromObject(jsonString);
			   if(jj != null){
			     fb.setTitle(jj.get("title")==null?"":jj.get("title").toString());
				 fb.setNodes(jj.get("nodes")==null?"":jj.get("nodes").toString());
				 fb.setLines(jj.get("lines")==null?"":jj.get("lines").toString());
				 fb.setAreas(jj.get("areas")==null?"":jj.get("areas").toString());
				 fb.setInitNum(jj.get("initNum")==null?"":jj.get("initNum").toString());
			  }
		   }    
		}catch(Exception e){
			e.printStackTrace();
		}
		return fb;
	}
	/**
	 * 获取nodes内的所有对象
	 * @param notes
	 * @return
	 */
	public List<NodeBean> getNodeBean(String notes){
		List<NodeBean>  nbList =  null;
		String tmp = notes;
		if(notes!=null&&!"".equals(notes)){
		    try{
		    	nbList =  new ArrayList();
			   if(!notes.trim().startsWith("["))notes = "["+notes;
			   if(!notes.trim().endsWith("]"))notes = notes+"]";
			   JSONArray json = JSONArray.fromObject(notes); 
			   if(json.size()>0){
					  for(int i=0;i<json.size();i++){
					    JSONObject node = json.getJSONObject(i);  // 遍历 jsonarray 数组，把每一个对象转成 json 对象
					    String[] nodeArry = getNodes(tmp, "demo_node_").split("---");
					    for(int j=0;j<nodeArry.length;j++){
					    	if(node.get(nodeArry[j])!= null){  
					            JSONObject nodeInfor = JSONObject.fromObject(node.get(nodeArry[j]).toString()); // 得到 每个对象中的属性值
					            // 得到 每个对象中的属性值  
					            NodeBean  nb = new NodeBean();
					            nb.setAlt(nodeInfor.get("alt")==null?"":nodeInfor.get("alt").toString());
					            nb.setHeight(nodeInfor.get("height")==null?"":nodeInfor.get("height").toString());
					            nb.setLeft(nodeInfor.get("left")==null?"":nodeInfor.get("left").toString());
					            nb.setName(nodeInfor.get("name")==null?"":nodeInfor.get("name").toString());
					            nb.setNodesName(nodeArry[j]);
					            nb.setTop(nodeInfor.get("top")==null?"":nodeInfor.get("top").toString());
					            nb.setType(nodeInfor.get("type")==null?"":nodeInfor.get("type").toString());
					            nb.setWidth(nodeInfor.get("width")==null?"":nodeInfor.get("width").toString());
					            nbList.add(nb); 
					    	}
					    }
					    
					  }
				}				
	        }catch(Exception e){
		     e.printStackTrace();
	        }
		}
	   return nbList;
	}

	/**
	 * 获取lines内的所有对象
	 * @param notes
	 * @return
	 */
	public  List<LineBean> getLineBean(String lines){
		List<LineBean>  lnList =  null;
		String tmp = lines;
		if(lines!=null&&!"".equals(lines)){
		    try{
		       lnList =  new ArrayList();
			   if(!lines.trim().startsWith("["))lines = "["+lines;
			   if(!lines.trim().endsWith("]"))lines = lines+"]";
			   JSONArray json = JSONArray.fromObject(lines); 
			   if(json.size()>0){
					  for(int i=0;i<json.size();i++){
					    JSONObject line = json.getJSONObject(i);  // 遍历 jsonarray 数组，把每一个对象转成 json 对象
					    String[] lineArry = getNodes(tmp, "demo_line_").split("---");
					    for(int j=0;j<lineArry.length;j++){
					    	 if(line.get(lineArry[j])!= null){   
					            JSONObject nodeInfor = JSONObject.fromObject(line.get(lineArry[j]).toString()); // 得到 每个对象中的属性值
					             // 得到 每个对象中的属性值
					            LineBean  nb = new LineBean();
					            nb.setAlt(nodeInfor.get("alt")==null?"":nodeInfor.get("alt").toString());
					            nb.setFrom(nodeInfor.get("from")==null?"":nodeInfor.get("from").toString());
					            nb.setLinesName(lineArry[j]);
					            nb.setName(nodeInfor.get("name")==null?"":nodeInfor.get("name").toString());
					            nb.setTo(nodeInfor.get("to")==null?"":nodeInfor.get("to").toString());
					            nb.setType(nodeInfor.get("type")==null?"":nodeInfor.get("type").toString());
					            lnList.add(nb); 
					    	 }
					    }
					    
					  }
				}				
	        }catch(Exception e){
		     e.printStackTrace();
	        }
		}
	   return lnList;
	}
	
	/**
	 * 获取node 或line的具体节点名称
	 * @param text
	 * @param baseInfor
	 * @return
	 */
	private  String getNodes(String text,String baseInfor){
		StringBuffer  bf = new StringBuffer();
		String[] nodeArry = text.split("},");
		for(int i=0;i<nodeArry.length;i++){

		   for(int j=0;j<=30;j++){//暂定流程有30个环节点
			 if(nodeArry[i].toString().indexOf(baseInfor+""+j)>0){
				bf.append(baseInfor+""+j).append("---");
			 } 
		   }
		}
		return bf.toString();
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String jsonString = "{\"title\":\"流程设计器\","
		                   +"\"nodes\":{\"demo_node_1\":{\"name\":\"检查\",\"left\":193,\"top\":139,\"type\":\"task\",\"width\":86,\"height\":24,\"alt\":true},\"demo_node_2\":{\"name\":\"复核\",\"left\":328,\"top\":234,\"type\":\"task\",\"width\":86,\"height\":24,\"alt\":true},\"demo_node_3\":{\"name\":\"开始\",\"left\":52,\"top\":39,\"type\":\"start\",\"width\":86,\"height\":24,\"alt\":true},\"demo_node_6\":{\"name\":\"财务复核\",\"left\":447,\"top\":347,\"type\":\"task\",\"width\":86,\"height\":24,\"alt\":true}},"
				           +"\"lines\":{\"demo_line_4\":{\"type\":\"sl\",\"from\":\"demo_node_3\",\"to\":\"demo_node_1\",\"name\":\"\"},\"demo_line_5\":{\"type\":\"sl\",\"from\":\"demo_node_1\",\"to\":\"demo_node_2\",\"name\":\"\"},\"demo_line_7\":{\"type\":\"sl\",\"from\":\"demo_node_2\",\"to\":\"demo_node_6\",\"name\":\"\",\"alt\":true}},"
		                   +"\"areas\":{},"
				           +"\"initNum\":8}";
	    JsonFormat  jf = new JsonFormat();
		FlowBean fb = jf.getFlowBean(jsonString);
		       System.out.println("nodes------------>"+fb.getNodes());  
		List<NodeBean> lnb = jf.getNodeBean("["+fb.getNodes()+"]");
		for(int i=0;i<lnb.size();i++){
			NodeBean  nb = (NodeBean)lnb.get(i);
			System.out.println("nodesName------------>"+nb.getNodesName()); 
			System.out.println("name------------>"+nb.getName()); 	
		}
		List<LineBean> llb = jf.getLineBean("["+fb.getLines()+"]");
		for(int i=0;i<llb.size();i++){
			LineBean  lb = (LineBean)llb.get(i);
			System.out.println("nodesName------------>"+lb.getLinesName()); 
			System.out.println("from------------>"+lb.getFrom()); 	
			System.out.println("to------------>"+lb.getTo()); 
		}	
	}	
		
}
