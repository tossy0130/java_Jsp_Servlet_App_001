package webapp;

import java.util.ArrayList;

public class HelloWorld {

	public static void main(String[] args) {
		
		// ���X�g�쐬
		ArrayList<ShainBean> shainList = new ArrayList();
		
		//�Ј��P�����
		ShainBean shain1 = new ShainBean();

		shain1.setId(101);
		shain1.setName("���");
		shain1.setSei("�j");
		shain1.setNen(2003);
		shain1.setAddress("�{�錧���s");
		
		// ���X�g�ɒǉ�
		shainList.add(shain1);

		//�Ј��Q�����
		ShainBean shain2 = new ShainBean();

		shain2.setId(102);
		shain2.setName("����");
		shain2.setSei("��");
		shain2.setNen(2004);
		shain2.setAddress("�����������s");
		
		// ���X�g�ɒǉ�
		shainList.add(shain2);
		
		// ���X�g�\�� 
		for(ShainBean shain : shainList) {
			
			 System.out.println(shain.getId() + ":" + shain.getName() 
		        + ":" + shain.getSei() + ":" + shain.getNen() 
		        + ":" + shain.getAddress());
			
		}
		

	} // ============== main END

}
