package com.lyg.unitl;

import java.util.ArrayList;
import java.util.List;

import com.lyg.entitys.TMenu;


public class Tree {
	private StringBuffer html = new StringBuffer();
    private List<TMenu> nodes;
    
    public Tree(List<TMenu> nodes){
        this.nodes = nodes;
    }
    
    public String buildTree(){
    	System.out.println(nodes.size()+"---");
        html.append("<ul>");
        for (TMenu node : nodes) {
            String id = node.getId();
            if (node.getPid().equals("0")) {
                html.append("\r\n<li id='" + id + "'>" + node.getName()+ "</li>");
                build(node);
            }
        }
        html.append("\r\n</ul>");
        return html.toString();
    }
    
    private void build(TMenu node){
        List<TMenu> children = getChildren(node);
        if (!children.isEmpty()) {
            html.append("\r\n<ul>");
            for (TMenu child : children) {
                String id = child.getId();
                html.append("\r\n<li id='" + id + "'>" + child.getName()+ "</li>");
                build(child);
            }
            html.append("\r\n</ul>");
        } 
    }
    
    private List<TMenu> getChildren(TMenu node){
        List<TMenu> children = new ArrayList<TMenu>();
        String id = node.getId();
        for (TMenu child : nodes) {
            if (id.equals(child.getPid())) {
                children.add(child);
            }
        }
        return children;
    }

}
