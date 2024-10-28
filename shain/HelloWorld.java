package webapp;

import java.util.ArrayList;

public class HelloWorld {

	public static void main(String[] args) {
		
		// リスト作成
		ArrayList<ShainBean> shainList = new ArrayList();
		
		//社員１を作る
		ShainBean shain1 = new ShainBean();

		shain1.setId(101);
		shain1.setName("鈴木");
		shain1.setSei("男");
		shain1.setNen(2003);
		shain1.setAddress("宮城県仙台市");
		
		// リストに追加
		shainList.add(shain1);

		//社員２を作る
		ShainBean shain2 = new ShainBean();

		shain2.setId(102);
		shain2.setName("佐藤");
		shain2.setSei("女");
		shain2.setNen(2004);
		shain2.setAddress("福岡県福岡市");
		
		// リストに追加
		shainList.add(shain2);
		
		// リスト表示 
		for(ShainBean shain : shainList) {
			
			 System.out.println(shain.getId() + ":" + shain.getName() 
		        + ":" + shain.getSei() + ":" + shain.getNen() 
		        + ":" + shain.getAddress());
			
		}
		

	} // ============== main END

}
