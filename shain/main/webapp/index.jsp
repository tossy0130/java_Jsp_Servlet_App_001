<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
 <%@page import="java.util.ArrayList"%>
 <%@page import="info.searchman.*" %> 
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>�Ј��ꗗ</title>
<style>
table {
border-collapse: collapse; /* �Z���̋��E�����d�˂ĒP���ɂ��� */
}

th, td {
border: 1px solid black; /* �Z���̋��E���̃X�^�C����ݒ� */
padding: 10px;
}
</style>
</head>
<body>
<h1>�Ј��ꗗ</h1>

<table border="1">
<tr bgcolor="#cccccc">
<th>ID</th>
<th>���O</th>
<th>��</th>
<th>�N</th>
<th>�Z��</th>
<th>�ύX</th>
<th>�폜</th>
</tr>

<%
//�Ј����X�g�����
ArrayList<ShainBean> shainList = new ArrayList<>();

//�Ј��P�����
ShainBean shain1 = new ShainBean();
shain1.setId(101);
shain1.setName("��؋`�M");
shain1.setSei("�j");
shain1.setNen(2003);
shain1.setAddress("�{�錧���s");
//�Ј����X�g�ɒǉ�
shainList.add(shain1);

//�Ј��Q�����
ShainBean shain2 = new ShainBean();
shain2.setId(102);
shain2.setName("�������D");
shain2.setSei("��");
shain2.setNen(2004);
shain2.setAddress("�����������s");
//�Ј����X�g�ɒǉ�
shainList.add(shain2);
%>

<%
	for(ShainBean shain : shainList) {
%>
	<tr>
		<td><%= shain.getId() %></td>
		<td><%= shain.getName() %></td>
		<td><%= shain.getSei() %></td>
		<td><%= shain.getNen() %></td>
		<td><%= shain.getAddress() %></td>
		<td>�ύX</td>
		<td>�폜</td>
	</tr>
	
<% 
	} 
%>




</table>
<p></p>
<!-- �u�Ј���o�^����v�{�^�� -->
<form action="ShainInsert">
<input type="submit" value="�Ј���o�^����">
</form>
</body>
</html>