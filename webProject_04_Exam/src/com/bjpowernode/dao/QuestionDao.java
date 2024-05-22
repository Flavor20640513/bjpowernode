package com.bjpowernode.dao;

import com.bjpowernode.entity.Question;
import com.bjpowernode.util.JdbcUtil;
import com.bjpowernode.util.ReflectUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class QuestionDao {
    public int insert (Question q) throws Exception{
        String sql="insert into question(title,optionA,optionB,optionC,optionD,answer) value(?,?,?,?,?,?)";
        PreparedStatement ps=null;
        int result=0;
        JdbcUtil jdbcUtil=new JdbcUtil();

        try {
            ps=jdbcUtil.getPs(sql);
            ps.setString(1,q.getTitle());
            ps.setString(2,q.getOptionA());
            ps.setString(3,q.getOptionB());
            ps.setString(4,q.getOptionC());
            ps.setString(5,q.getOptionD());
            ps.setString(6,q.getAnswer());
            result=ps.executeUpdate();
        } finally {
            jdbcUtil.close();
        }
        return result;
    }
    public int update (Question q) throws Exception{
        String sql="update question set title=?,optionA=?,optionB=?,optionC=?,optionD=?,answer=? where id=?";
        PreparedStatement ps=null;
        int result=0;
        JdbcUtil jdbcUtil=new JdbcUtil();

        try {
            ps=jdbcUtil.getPs(sql);
            ps.setString(1,q.getTitle());
            ps.setString(2,q.getOptionA());
            ps.setString(3,q.getOptionB());
            ps.setString(4,q.getOptionC());
            ps.setString(5,q.getOptionD());
            ps.setString(6,q.getAnswer());
            ps.setInt(7,q.getId());
            result=ps.executeUpdate();
        } finally {
            jdbcUtil.close();
        }
        return result;
    }
    public int delete (int id) throws Exception{
        String sql="delete from question where id=?";
        PreparedStatement ps=null;
        int result=0;
        JdbcUtil jdbcUtil=new JdbcUtil();

        try {
            ps=jdbcUtil.getPs(sql);
          ps.setInt(1, id);
            result=ps.executeUpdate();
        } finally {
            jdbcUtil.close();
        }
        return result;
    }
    public List findAll () throws Exception{
        String sql="select * from question";
        PreparedStatement ps=null;
        ResultSet result=null;
        JdbcUtil jdbcUtil=new JdbcUtil();
       List<Question> findList=new ArrayList();
        try {
            ps=jdbcUtil.getPs(sql);
            result=ps.executeQuery();
            findList=ReflectUtil.selectList(result, Question.class);
           /* while (result.next()){
                int id= Integer.parseInt(result.getString("id" ));
                String title=result.getString("title");
                String optionA=result.getString("optionA");
                String optionB=result.getString("optionB");
                String optionC=result.getString("optionC");
                String optionD=result.getString("optionD");
                String answer=result.getString("answer");
                Question q=new Question(id,title,optionA,optionB,optionC,optionD,answer);
                findList.add(q);
            }*/
        } finally {
            jdbcUtil.close(result);
        }
        return findList;
    }
    public List rand () throws Exception{
        String sql="select * from question order by rand() limit 4";
        PreparedStatement ps=null;
        ResultSet result=null;
        JdbcUtil jdbcUtil=new JdbcUtil();
        List<Question> findList=new ArrayList();
        try {
            ps=jdbcUtil.getPs(sql);
            result=ps.executeQuery();
           findList= ReflectUtil.selectList(result, Question.class);
        } finally {
            jdbcUtil.close(result);
        }
        return findList;
    }
    public int check(String title)throws Exception{
        int result=0;
        String sql="select count(*) from question where title=?";
        JdbcUtil util = new JdbcUtil();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps=util.getPs(sql);
            ps.setString(1, title);
            rs = ps.executeQuery();
            rs.next();
            result =rs.getInt("count(*)");
        } finally {
            util.close(rs);
        }
        return result;
    }
    public Question findById(String id)throws Exception{
        String sql="select * from question where id=?";
        JdbcUtil util = new JdbcUtil();
        PreparedStatement ps=null;
        ResultSet rs=null;
        List<Question> list=null;

        try {
            ps=util.getPs(sql);
            ps.setString(1, id);
            rs= ps.executeQuery();
            list =ReflectUtil.selectList(rs,Question.class);
        } finally {
            util.close(rs);
        }
        return list.get(0);
    }

}
