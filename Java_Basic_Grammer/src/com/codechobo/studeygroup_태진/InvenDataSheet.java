package com.codechobo.studeygroup_태진;

import java.util.ArrayList;
import java.util.List;

public class InvenDataSheet {
	List<InvenVO> prdlist = new ArrayList<InvenVO>();

	public InvenDataSheet() {
		
	}
	
	public static List<InvenVO> DataSet() {
		
		List<InvenVO> prdlist = new ArrayList<InvenVO>();
		
		prdlist.add(new InvenVO("키보드","키크론",150000,6,"I-1","함경식"));
		prdlist.add(new InvenVO("마우스","로지텍",60000,10,"I-2","김남영"));
		prdlist.add(new InvenVO("받침대","웰럽",30000,20,"I-3","정현우"));
		prdlist.add(new InvenVO("모니터","LG",300000,15,"I-4","임영진"));
		prdlist.add(new InvenVO("프린터","삼성",160000,3,"I-5","장태진"));
		
		//System.out.println(prdlist[0].product);
		/*
		 * System.out.println(prdlist.get(0).getProduct());
		 * System.out.println(prdlist.indexOf("마우스"));
		 * System.out.println(prdlist.indexOf("장태진"));
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