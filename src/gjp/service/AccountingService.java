package gjp.service;

import gjp.dao.AccountingDao;
import gjp.domain.Accounting;

import java.util.List;


/**
* ����ҵ�����
 */
public class AccountingService {
	//service������dao
	private AccountingDao accountingDao = new AccountingDao();
	/**
	 * ��ѯ����
	*/
	public List<Accounting> selectAll() {
		return accountingDao.selectAll();
	}
	/**
	 * ��������ѯ���񷽷�
	 * @param start
	 * @param end
	 * @return
	 */
	public List<Accounting> select(String start, String end) {
		return accountingDao.select(start, end);
	}
	/**
	 * �������
	 * @param zw
	 */
	public void addAccounting(Accounting zw) {
		accountingDao.addAccounting(zw);
	}
	/**
	 * �༭����
	 * @param zw
	 */
		public void editAccounting(Accounting zw) {
		accountingDao.editAccounting(zw);
	}
		/**
		 * ɾ������
		 * @param zwid
		 */
		public void deleteAccounting(int zwid) {
			accountingDao.deleteAccounting(zwid);
		}

}
