package com.codechobo.studeygroup_����;

import java.util.ArrayList;
import java.util.List;

public class InvenDataSheet {
	List<InvenVO> prdlist = new ArrayList<InvenVO>();

	public InvenDataSheet() {
		
	}
	
	public static List<InvenVO> DataSet() {
		
		List<InvenVO> prdlist = new ArrayList<InvenVO>();
		
		prdlist.add(new InvenVO("Ű����","Űũ��",150000,6,"I-1","�԰��"));
		prdlist.add(new InvenVO("���콺","������",60000,10,"I-2","�賲��"));
		prdlist.add(new InvenVO("��ħ��","����",30000,20,"I-3","������"));
		prdlist.add(new InvenVO("�����","LG",300000,15,"I-4","�ӿ���"));
		prdlist.add(new InvenVO("������","�Ｚ",160000,3,"I-5","������"));
		
		//System.out.println(prdlist[0].product);
		/*
		 * System.out.println(prdlist.get(0).getProduct());
		 * System.out.println(prdlist.indexOf("���콺"));
		 * System.out.println(prdlist.indexOf("������"));
		 * System.out.println(prdlist.indexOf("30000"));
		 * System.out.println(prdlist.indexOf("10"));
		 * System.out.println(prdlist.indexOf("I-5"));
		 */
		
		return prdlist;
		
	} 
		/*
		InvenVO.standOutput();
		
		InvenVO ivo[] = new InvenVO[prdlist.size()];
		prdlist.toArray(ivo);
		
		for(InvenVO vo : prdlist) {
			vo.invenOutput();
		}
	}
	*/
	/*
	public static void main(String[] args) {
		new InvenDataSheet().DataSet();
	}
	*/

		
	
	
}