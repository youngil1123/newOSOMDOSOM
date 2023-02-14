package com.osom.dto;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class TagParser {
	public static String getTagValue(String tag,Element eElement) {
		NodeList nList = eElement.getElementsByTagName(tag).item(0).getChildNodes();
		Node nValue = (Node)nList.item(0);
		if(nValue==null) return null;
		return nValue.getNodeValue();
	}

}
