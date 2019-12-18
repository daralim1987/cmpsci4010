package edu.umsl.math.dao;

import edu.umsl.math.beans.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.UnavailableException;

public class ProblemDao {

	private Connection connection;
	private PreparedStatement results;
	private PreparedStatement probcnt;
	private PreparedStatement resultsCategory;
	private PreparedStatement addProblemRecord;
	private PreparedStatement addCategoryRecord;

	public ProblemDao() throws Exception {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mathprodb", "root", "");
			
			results = connection.prepareStatement(
					"SELECT pid, content, order_num, cid " + "FROM problem ORDER BY order_num DESC LIMIT ?, ?");
			
			probcnt = connection.prepareStatement("SELECT COUNT(pid) FROM problem");
			
			resultsCategory = connection.prepareStatement("SELECT cid, title " + "FROM category ?, ?");
			
			addProblemRecord = connection.prepareStatement("INSERT INTO problem ( " + "pid, content, order_num, cid ) " + "VALUES (?, ?, ?, ? )");
			
			addCategoryRecord = connection.prepareStatement("INSERT INTO category ( " + "cid, title ) " + "VALUES (?, ? )");
			
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new UnavailableException(exception.getMessage());
		}

	}
	
	//method to return problem count
	public int getProblemCount() {
		int cnt = 0;
		
		try {
			ResultSet rs = probcnt.executeQuery();
			rs.next();
			
			cnt = rs.getInt(1);
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}
		
		return cnt;
	}
	
	//Method to add problem
	public void addProblem(Problem proObj) throws SQLException {
		addProblemRecord.setInt(1, proObj.getPid());
		addProblemRecord.setString(2,  proObj.getContent());
		addProblemRecord.setInt(3, proObj.getOrder_num());
		addProblemRecord.setInt(4, proObj.getCid());

		addProblemRecord.executeUpdate();
	}

	//Method to add category
	public void addCategory(Category catObj) throws SQLException {
		addCategoryRecord.setInt(1, catObj.getCid());
		addCategoryRecord.setString(2, catObj.getTitle());
		
		addCategoryRecord.executeUpdate();
	}
	
//	method to return problem list
	public List<Problem> getProblemList() throws SQLException {
		List<Problem> problist = new ArrayList<Problem>();
		
		try {
			ResultSet resultsRS = results.executeQuery();

			while (resultsRS.next()) {
				Problem prob = new Problem();

				prob.setPid(resultsRS.getInt(1));
				prob.setContent(resultsRS.getString(2));
				prob.setOrder_num(resultsRS.getInt(3));
				prob.setCid(resultsRS.getInt(4));

				problist.add(prob);
			}
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}
		
		return problist;
	}
	
//	method to return category list
	public List<Category> getCategoryList() throws SQLException {
		List<Category> categorylist = new ArrayList<Category>();
		
		try {
			ResultSet resultsRSCategory = resultsCategory.executeQuery();

			while (resultsRSCategory.next()) {
				Category categoryObject = new Category();
				
				categoryObject.setCid(resultsRSCategory.getInt(1));
				categoryObject.setTitle(resultsRSCategory.getString(2));

				categorylist.add(categoryObject);
			}
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}
		
		return categorylist;
		
	}
	
	//method to return list of problem by page
	public List<Problem> getProblemListByPage(int pg) throws SQLException {
		List<Problem> problist = new ArrayList<Problem>();
		
		int st = 10 * (pg - 1);
		
		try {
			results.setInt(1, st);
			results.setInt(2, 10);
			
			ResultSet resultsRS = results.executeQuery();

			while (resultsRS.next()) {
				Problem prob = new Problem();

				prob.setPid(resultsRS.getInt(1));
				prob.setContent(resultsRS.getString(2));
				prob.setOrder_num(resultsRS.getInt(3));

				problist.add(prob);
			}
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}
		
		return problist;
	}

}
