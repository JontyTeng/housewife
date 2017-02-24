package gjp.service;

import gjp.dao.AccountingDao;
import gjp.domain.Accounting;

import java.util.List;


/**
* 账务业务层类
 */
public class AccountingService {
	//service都依赖dao
	private AccountingDao accountingDao = new AccountingDao();
	/**
	 * 查询所有
	*/
	public List<Accounting> selectAll() {
		return accountingDao.selectAll();
	}
	/**
	 * 按条件查询账务方法
	 * @param start
	 * @param end
	 * @return
	 */
	public List<Accounting> select(String start, String end) {
		return accountingDao.select(start, end);
	}
	/**
	 * 添加账务
	 * @param zw
	 */
	public void addAccounting(Accounting zw) {
		accountingDao.addAccounting(zw);
	}
	/**
	 * 编辑账务
	 * @param zw
	 */
		public void editAccounting(Accounting zw) {
		accountingDao.editAccounting(zw);
	}
		/**
		 * 删除账务
		 * @param zwid
		 */
		public void deleteAccounting(int zwid) {
			accountingDao.deleteAccounting(zwid);
		}

}
