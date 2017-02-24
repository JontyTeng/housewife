package gjp.dao;

import java.sql.SQLException;
import java.util.List;

import gjp.domain.Accounting;
import gjp.tools.JDBCUtils;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;


/**
* �������ݲ���
 */
public class AccountingDao{
	//��ȡ���ݿ����ӳأ��õ����������ݵĶ��� QueryRunner
	QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
	/**
	 * ��ѯ��������
	 */
	public List<Accounting> selectAll() {
		String sql = "select * from gjp_accounting";
		try {
			return qr.query(sql, new BeanListHandler<Accounting>(Accounting.class));
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	/**
	 * ��������ѯ���񷽷�
	 * @param start
	 * @param end
	 * @return
	 */
	public List<Accounting> select(String start, String end) {
		String sql = "select * from gjp_accounting where createtime between ? and ?";
		Object[] params = {start, end};
		try {
			return qr.query(sql, new BeanListHandler<Accounting>(Accounting.class), params);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	/**
	 * �������
	 * @param zw
	 */
	public  void addAccounting(Accounting zw) {
		String sql = "insert into gjp_accounting(flname,money,account,createtime,description) values(?,?,?,?,?)";
		try {
			Object[] params = {zw.getFlname(),zw.getMoney(),zw.getAccount(),zw.getCreatetime(),zw.getDescription()};
			qr.update(sql, params);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}	
	}
	/**
	 * �༭����
	 * @param zw
	 */
	public void editAccounting(Accounting zw) {
		String sql = "update gjp_accounting set flname=?, money=?,account=?,createtime=?,description=? where zwid=?";
		try {
			Object[] params = {zw.getFlname(),zw.getMoney(),zw.getAccount(),zw.getCreatetime(),zw.getDescription(),zw.getZwid()};
			qr.update(sql, params);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}	
	}
	/**
	 * ɾ������
	 * @param zwid
	 */
	public void deleteAccounting(int zwid) {
		String sql = "delete from gjp_accounting where zwid=?";
		try {
			qr.update(sql, zwid);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
