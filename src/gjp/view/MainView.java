package gjp.view;


import java.util.List;
import java.util.Scanner;

import gjp.domain.Accounting;
import gjp.service.AccountingService;


public class MainView {
	//本项目中view依赖service
	private AccountingService accountingService = new AccountingService();
	/**
	 * 运行方法
	 */
	public void run() {
		/*
		 * 1. 打印菜单 2. 获取用户输入 3. 调用对应方法
		 */
		boolean flag = true;
		Scanner in = new Scanner(System.in);
		while (flag) {
			System.out.println("---------------管家婆家庭记账软件---------------");
			System.out.println("1.添加账务　2.编辑账务　3.删除账务　4.查询账务　5.退出系统");
			System.out.println("请输入要操作的功能序号[1-5]:");
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
				System.out.println("再见！");
				flag = false;
				break;
			default:
				System.out.println("输入错误！");
			}
		}
	}
	/**
	 * 查询账务方法
	 */
	public void selectAccounting() {
		System.out.println("1.查询所有　2.按条件查询");
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
			System.out.println("输入错误！");
		}
	}
	/**
	 * 查询所有账务方法
	 */
	public void selectAll() {
		List<Accounting> accountingList = accountingService.selectAll();
		print(accountingList);
	}
	/*
	 * 输出账务方法
	 */
	private void print(List<Accounting> accountingList) {
		System.out.println("ID\t类别\t\t账户\t\t金额\t\t时间\t\t说明");
		for (Accounting zw : accountingList) {
			System.out.println(zw.getZwid() + "\t" + zw.getFlname() + "\t\t"
					+ zw.getAccount() + "\t\t" + zw.getMoney() + "\t\t"
					+ zw.getCreatetime() + "\t" + zw.getDescription());
		}
	}
	/**
	 * 按条件查询账务方法
	 */
	public void select() {
		/*
		 * 1. 获取用户输入查询日期范围。 
		 * 2. 调用service的select()方法完成条件查询功能
		 */
		Scanner in = new Scanner(System.in);
		System.out.print("请输入查询起始时间：");
		String start = in.next();
		System.out.print("请输入查询结束时间：");
		String end = in.next();
		List<Accounting> accountingList = accountingService.select(start, end);
		print(accountingList);
	}
	/**
	 * 添加账务方法
	 */
	public void addAccounting() {
		/*
		 * 1. 获取用户输入，封装到bean中。 
		 * 2. 调用service的addZhangWu()方法完成添加功能
		 */
		Scanner in = new Scanner(System.in);
		Accounting zw = new Accounting();
		System.out.print("请输入类别：");
		zw.setFlname(in.next());
		System.out.print("请输入账户：");
		zw.setAccount(in.next());
		System.out.print("请输入金额：");
		zw.setMoney(in.nextDouble());
		System.out.print("请输入时间：");
		zw.setCreatetime(in.next());
		System.out.print("请输入说明：");
		zw.setDescription(in.next());
		
		accountingService.addAccounting(zw);
		System.out.println("添加账务成功！");
	}
	/**
	 * 编辑账务方法
	 */
	public void editAccounting() {
		/*
		 * 1. 获取用户输入，封装到bean中。 
		 * 2. 调用service的editAccounting()方法完成添加功能
		 */
		Scanner in = new Scanner(System.in);
		Accounting zw = new Accounting();
		System.out.print("请输入ID：");
		zw.setZwid(in.nextInt());
		System.out.print("请输入新类别：");
		zw.setFlname(in.next());
		System.out.print("请输入新账户：");
		zw.setAccount(in.next());
	    System.out.print("请输入新金额：");
		zw.setMoney(in.nextDouble());
		System.out.print("请输入新时间：");
		zw.setCreatetime(in.next());
		System.out.print("请输入新说明：");
		zw.setDescription(in.next());
		
		accountingService.editAccounting(zw);
		System.out.println("编辑账务成功！");
	}
	/**
	 * 删除账务方法
	 */
	public void deleteAccounting() {
		/*
		 * 1. 获取用户输入，封装到bean中。 
		 * 2. 调用service的deleteAccounting()方法完成添加功能
		 */
		Scanner in = new Scanner(System.in);
		System.out.print("请输入ID：");
		
		accountingService.deleteAccounting(in.nextInt());
		System.out.println("删除账务成功！");
	}

}
