package com.adelmo.json.test;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Dao {

    public List<TreeJson> queryATree() {
        List<TreeJson> treeList = new ArrayList<TreeJson>();
        // 1. 获取数据库连接
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = JDBCTools.getConnection();

            String sql = "SELECT node_id, node_name, parent_id, url FROM T_DH_NODE t START WITH t.parent_id = '0' CONNECT BY t.parent_id = PRIOR t.node_id ORDER SIBLINGS BY t.channel_id";

            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                TreeJson treeJson = new TreeJson();
                treeJson.setNodeId(resultSet.getString(1));
                treeJson.setNodeName(resultSet.getString(2));
                treeJson.setParentId(resultSet.getString(3));
                treeJson.setUrl(resultSet.getString(4));
                treeList.add(treeJson);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return treeList;
    }

    public JSONArray getAll() {
        JSONArray jsonArray = new JSONArray();
        // 1. 获取数据库连接
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = JDBCTools.getConnection();

//			String sql = "SELECT node_id, node_name, parent_id, url"
//					+ "FROM t_dh_node START WITH t_dh_node.parent_id = '0'"
//					+ "CONNECT BY t_dh_node.parent_id = PRIOR t_dh_node.node_id"
//					+ "ORDER SIBLINGS BY t_dh_node.channel_id";

            String sql = "SELECT node_id, node_name, parent_id, url FROM A_TEST_NODE t WHERE t.parent_id = '0'";

            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            ResultSetMetaData md = resultSet.getMetaData();
            // Map rowData
            int columnCount = md.getColumnCount();
            JSONObject jsonObject = new JSONObject();
            while (resultSet.next()) {
                Map rowData = new HashMap();
                for (int i = 1; i <= columnCount; i++) {
                    String columnName = md.getColumnName(i);
                    String value = resultSet.getString(columnName);
                    jsonObject.put(columnName, value);
                    // rowData.put(md.getColumnName(i), resultSet.getObject(i));
                }
                System.out.println("jsonObject" + jsonObject);
                jsonArray.add(jsonObject);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return jsonArray;
    }

    public List<TreeJson> queryATree(String parentId) {
        List<TreeJson> treeList = new ArrayList<TreeJson>();
        // 1. 获取数据库连接
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = JDBCTools.getConnection();

//			String sql = "SELECT module_id, node_id, node_name, parent_id, url FROM A_TEST_NODE t WHERE t.parent_id = '"+parentId+"' and t.module_id = '"+moduleId+"'";

            String sql = "SELECT module_id, node_id, node_name, parent_id, url FROM A_TEST_NODE t WHERE t.parent_id = '" + parentId + "'";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                TreeJson treeJson = new TreeJson();
                treeJson.setModuleId(resultSet.getString(1));
                treeJson.setNodeId(resultSet.getString(2));
                treeJson.setNodeName(resultSet.getString(3));
                treeJson.setParentId(resultSet.getString(4));
                treeJson.setUrl(resultSet.getString(5));
                //把moduleId的值作为孩子节点的父节点
                parentId = resultSet.getString(1);
                treeJson.setChildren(this.queryATree(parentId));
                treeList.add(treeJson);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return treeList;
    }
}
