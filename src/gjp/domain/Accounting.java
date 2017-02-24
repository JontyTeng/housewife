package gjp.domain;

/**
 * 账务类
 */
public class Accounting {
	private int zwid;// id
	private String flname;// 分类名称
	private String account;// 账户名称
	private double money;// 金额
	private String createtime;// 创建时间
	private String description;// 说明

	public String getFlname() {
		return flname;
	}
	public void setFlname(String flname) {
		this.flname = flname;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String zhangHu) {
		this.account = zhangHu;
	}
	public int getZwid() {
		return zwid;
	}
	public void setZwid(int zwid) {
		this.zwid = zwid;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	public String getCreatetime() {
		return createtime;
	}
	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}


