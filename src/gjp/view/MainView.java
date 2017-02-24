package gjp.view;


import java.util.List;
import java.util.Scanner;

import gjp.domain.Accounting;
import gjp.service.AccountingService;


public class MainView {
	//����Ŀ��view����service
	private AccountingService accountingService = new AccountingService();
	/**
	 * ���з���
	 */
	public void run() {
		/*
		 * 1. ��ӡ�˵� 2. ��ȡ�û����� 3. ���ö�Ӧ����
		 */
		boolean flag = true;
		Scanner in = new Scanner(System.in);
		while (flag) {
			System.out.println("---------------�ܼ��ż�ͥ�������---------------");
			System.out.println("1.�������2.�༭����3.ɾ������4.��ѯ����5.�˳�ϵͳ");
			System.out.println("������Ҫ�����Ĺ������[1-5]:");
			int op = in.nextInt();
			switch (op) {
			case 1:
				addAccounting();
				break;
			case 2:
				editAccounting();
				break;
			case 3:
				deleteAccounting();
				break;
			case 4:
				selectAccounting();
				break;
			case 5:
				System.out.println("�ټ���");
				flag = false;
				break;
			default:
				System.out.println("�������");
			}
		}
	}
	/**
	 * ��ѯ���񷽷�
	 */
	public void selectAccounting() {
		System.out.println("1.��ѯ���С�2.��������ѯ");
		Scanner in = new Scanner(System.in);
		int op = in.nextInt();
		switch (op) {
		case 1:
			selectAll();
			break;
		case 2:
			select();
			break;
		default:
			System.out.println("�������");
		}
	}
	/**
	 * ��ѯ�������񷽷�
	 */
	public void selectAll() {
		List<Accounting> accountingList = accountingService.selectAll();
		print(accountingList);
	}
	/*
	 * ������񷽷�
	 */
	private void print(List<Accounting> accountingList) {
		System.out.println("ID\t���\t\t�˻�\t\t���\t\tʱ��\t\t˵��");
		for (Accounting zw : accountingList) {
			System.out.println(zw.getZwid() + "\t" + zw.getFlname() + "\t\t"
					+ zw.getAccount() + "\t\t" + zw.getMoney() + "\t\t"
					+ zw.getCreatetime() + "\t" + zw.getDescription());
		}
	}
	/**
	 * ��������ѯ���񷽷�
	 */
	public void select() {
		/*
		 * 1. ��ȡ�û������ѯ���ڷ�Χ�� 
		 * 2. ����service��select()�������������ѯ����
		 */
		Scanner in = new Scanner(System.in);
		System.out.print("�������ѯ��ʼʱ�䣺");
		String start = in.next();
		System.out.print("�������ѯ����ʱ�䣺");
		String end = in.next();
		List<Accounting> accountingList = accountingService.select(start, end);
		print(accountingList);
	}
	/**
	 * ������񷽷�
	 */
	public void addAccounting() {
		/*
		 * 1. ��ȡ�û����룬��װ��bean�С� 
		 * 2. ����service��addZhangWu()���������ӹ���
		 */
		Scanner in = new Scanner(System.in);
		Accounting zw = new Accounting();
		System.out.print("���������");
		zw.setFlname(in.next());
		System.out.print("�������˻���");
		zw.setAccount(in.next());
		System.out.print("�������");
		zw.setMoney(in.nextDouble());
		System.out.print("������ʱ�䣺");
		zw.setCreatetime(in.next());
		System.out.print("������˵����");
		zw.setDescription(in.next());
		
		accountingService.addAccounting(zw);
		System.out.println("�������ɹ���");
	}
	/**
	 * �༭���񷽷�
	 */
	public void editAccounting() {
		/*
		 * 1. ��ȡ�û����룬��װ��bean�С� 
		 * 2. ����service��editAccounting()���������ӹ���
		 */
		Scanner in = new Scanner(System.in);
		Accounting zw = new Accounting();
		System.out.print("������ID��");
		zw.setZwid(in.nextInt());
		System.out.print("�����������");
		zw.setFlname(in.next());
		System.out.print("���������˻���");
		zw.setAccount(in.next());
	    System.out.print("�������½�");
		zw.setMoney(in.nextDouble());
		System.out.print("��������ʱ�䣺");
		zw.setCreatetime(in.next());
		System.out.print("��������˵����");
		zw.setDescription(in.next());
		
		accountingService.editAccounting(zw);
		System.out.println("�༭����ɹ���");
	}
	/**
	 * ɾ�����񷽷�
	 */
	public void deleteAccounting() {
		/*
		 * 1. ��ȡ�û����룬��װ��bean�С� 
		 * 2. ����service��deleteAccounting()���������ӹ���
		 */
		Scanner in = new Scanner(System.in);
		System.out.print("������ID��");
		
		accountingService.deleteAccounting(in.nextInt());
		System.out.println("ɾ������ɹ���");
	}

}
