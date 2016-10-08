package com.netpet.spools.core.util;

import java.io.*;

/**
 * Created by David on 2016/8/28.
 */
public class DaoCreatorUtil {

    public static void main(String[] args) throws Exception{
        File input = new File("F:\\b.txt");
        FileReader fr = new FileReader(input);
        BufferedReader bf = new BufferedReader(fr);

        String line;

        while ((line = bf.readLine()) != null) {
            String[] sources = line.split("\\|");

            DaoCreatorUtil batisUtil = new DaoCreatorUtil();
            batisUtil.table = sources[0];
            batisUtil.entity = sources[1];
            batisUtil.idType = sources[2];
            batisUtil.source = sources[3];

            batisUtil.run(batisUtil);

            File output = new File("F:\\" + sources[1] + "Dao.xml");
            BufferedWriter bw = new BufferedWriter(new FileWriter(output));
            bw.write(batisUtil.result.toString());

            bw.flush();
            bw.close();
        }

        bf.close();
    }

    public void run(DaoCreatorUtil batisUtil) {
        batisUtil.start();
        batisUtil.createColumns();
        batisUtil.createProperties();
        batisUtil.createResultMap();
        batisUtil.createColumnSql();
        batisUtil.getById();
        batisUtil.insert();
        batisUtil.update();
        batisUtil.delete();
        batisUtil.queryCount();
        batisUtil.query();
        batisUtil.createConditions();
        batisUtil.end();
        System.out.println(batisUtil.result.toString());
    }

    public void start() {
        result.append("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n");
        result.append("<!DOCTYPE mapper\n");
        result.append("    PUBLIC \"-//mybatis.org//DTD Mapper 3.0//EN\"\n");
        result.append("    \"http://mybatis.org/dtd/mybatis-3-mapper.dtd\">\n");

        result.append("<mapper namespace=\"com.baojiabei.provider.dao.hrps." + entity + "Dao\">\n");
    }

    public void end() {
        result.append("</mapper>\n");
    }

    public void createColumns() {
        source = source.replace(" ", "");
        columns = source.split(",");
    }

    public void createProperties() {
        properties = new String[columns.length];
        for (int i = 0; i < columns.length; i++) {
            String column = columns[i];
            if (column.contains("_")) {
                String[] cols = column.split("_");
                StringBuffer sb = new StringBuffer(cols[0]);
                for (int j = 1; j < cols.length; j++) {
                    String col = cols[j];
                    sb.append(col.substring(0, 1).toUpperCase()).append(col.substring(1));
                }
                properties[i] = sb.toString();
            } else {
                properties[i] = column;
            }

            if (properties[i].length() > maxColumnLength) {
                maxColumnLength = properties[i].length();
            }
        }
    }

    public void createResultMap() {
        result.append(this.getTab(1));
        result.append("<resultMap id=\"result" + entity + "\" type=\"" +  entity + "\">\n");

        // 第一行
        result.append(this.getTab(2));
        result.append("<id     property=\"" + properties[0] + "\"" + this.appendSpace(properties[0]));
        result.append("column=\"" + columns[0] + "\"" + this.appendSpace(columns[0]) + "/>");
        result.append("\n");

        for (int i = 1; i < columns.length; i++) {
            result.append(this.getTab(2));
            result.append("<result property=\"" + properties[i] + "\"" + this.appendSpace(properties[i]));
            result.append("column=\"" + columns[i] + "\"" + this.appendSpace(columns[i]) + "/>");
            result.append("\n");
        }
        result.append(this.getTab(1) + "</resultMap>\n");
    }

    public void createColumnSql() {
        StringBuffer sb = new StringBuffer("\n");
        sb.append(this.getTab(1));
        sb.append("<sql id=\"column\">\n");
        sb.append(this.getTab(2));

        int count = 1;

        for (int i = 1; i < columns.length; i++) {
            sb.append(columns[i]).append(", ");
            if (sb.toString().length() >= 120 * count) {
                sb.append("\n");
                sb.append(this.getTab(2));
                count++;
            }
        }

        // 替换最后逗号
        if (sb.toString().endsWith(", ")) {
            sb.replace(sb.length() - 2, sb.length(), " ");
        }

        sb.append("\n");
        sb.append(this.getTab(1) + "</sql>");

        result.append(sb.toString() + "\n");
    }

    public void getById() {
        StringBuffer sb = new StringBuffer("\n");
        sb.append(this.getTab(1));
        sb.append("<select id=\"getById\" parameterType=\"" + idType + "\" resultMap=\"" + "result" + entity + "\">");
        sb.append("\n");
        sb.append(this.getTab(2));
        sb.append("select " + columns[0]).append(",");
        sb.append("\n");
        sb.append(this.getTab(2) + "<include refid=\"column\"/>");
        sb.append("\n");

        sb.append(this.getTab(2));
        sb.append("from " + table.replace(" ", "").trim());
        sb.append("\n");

        sb.append(this.getTab(2));
        sb.append("where " + columns[0] + " = #{id}");
        sb.append("\n");

        sb.append(this.getTab(2));
        sb.append("<if test=\"forUpdate==true\">\n");

        sb.append(this.getTab(3));
        sb.append("for update of " + table + "\n");

        sb.append(this.getTab(2));
        sb.append("</if>\n");

        sb.append(this.getTab(1));
        sb.append("</select>");

        result.append(sb.toString() + "\n");
    }

    public void insert() {
        StringBuffer sb = new StringBuffer("\n");

        sb.append(this.getTab(1));
        sb.append("<insert id=\"insert\" parameterType=\"" + entity + "\" keyProperty=\"" + properties[0] + "\"\n");
        sb.append(this.getTab(2) + "useGeneratedKeys=\"true\">\n");

        sb.append(this.getTab(2));
        sb.append("insert into " + table + " (" + "\n");
        sb.append(this.getTab(2) + "<include refid=\"column\"/>" + "\n");
        sb.append(this.getTab(2) + ") values (\n");

        for (int i = 1; i < properties.length; i++) {
            sb.append(this.getTab(2) + "#{" + properties[i] + "}");
            if (i != properties.length - 1) {
                sb.append(",");
            }
            sb.append("\n");
        }

        sb.append(this.getTab(2) + ")" + "\n");

        sb.append(this.getTab(1));
        sb.append("</insert>");

        result.append(sb.toString() + "\n");
    }

    public void update() {
        StringBuffer sb = new StringBuffer("\n");

        sb.append(this.getTab(1));
        sb.append("<update id=\"update\" parameterType=\"" + entity + "\">\n");

        sb.append(this.getTab(2) + "update " + table + "\n");
        sb.append(this.getTab(2) + "set\n");

        for (int i = 1; i < columns.length; i++) {
            sb.append(this.getTab(2));
            sb.append(columns[i] + this.appendSpace(columns[i]));
            sb.append(" = #{");
            sb.append(properties[i]);
            sb.append("}");
            if (i != columns.length - 1) {
                sb.append(",");
            }
            sb.append("\n");
        }

        sb.append(this.getTab(2) + "where " + columns[0] + " = " + "#{" + properties[0] + "}\n");


        sb.append(this.getTab(1));
        sb.append("</update>");

        result.append(sb.toString() + "\n");
    }

    public void delete() {
        StringBuffer sb = new StringBuffer("\n");

        sb.append(this.getTab(1));
        sb.append("<delete id=\"delete\" parameterType=\"" + idType + "\">\n");
        sb.append(this.getTab(2));
        sb.append("delete from " + table + "\n");
        sb.append(this.getTab(2));
        sb.append("where " + columns[0] + " = #{" + properties[0] + "}\n");
        sb.append(this.getTab(1));
        sb.append("</delete>");

        result.append(sb.toString() + "\n");
    }

    public void queryCount() {
        StringBuffer sb = new StringBuffer("\n");

        sb.append(this.getTab(1));
        sb.append("<select id=\"queryCount\" resultType=\"java.lang.Integer\" parameterType=\"" + this.getCriteria() +"\">\n");

        sb.append(this.getTab(2));
        sb.append("select count(" + columns[0] + ")\n");
        sb.append(this.getTab(2));
        sb.append("from " + table + "\n");
        sb.append(this.getTab(2));
        sb.append("<include refid=\"conditions\"/>\n");

        sb.append(this.getTab(1));
        sb.append("</select>");

        result.append(sb.toString() + "\n");
    }

    public void query() {
        StringBuffer sb = new StringBuffer("\n");

        sb.append(this.getTab(1));
        sb.append("<select id=\"query\" resultMap=\"result" + entity + "\" parameterType=\"" + this.getCriteria() + "\">\n");

        sb.append(this.getTab(2));
        sb.append("select " + columns[0] + ",\n");
        sb.append(this.getTab(2));
        sb.append("<include refid=\"column\"/>\n");
        sb.append(this.getTab(2));
        sb.append("from " + table + "\n");
        sb.append(this.getTab(2));
        sb.append("<include refid=\"conditions\"/>\n");
        sb.append(this.getTab(2));
        sb.append("order by " + columns[columns.length - 1] + " desc\n");
        sb.append(this.getTab(2));
        sb.append("<if test=\"paging==true\">\n");
        sb.append(this.getTab(3));
        sb.append("limit #{limit} offset #{offset}\n");
        sb.append(this.getTab(2));
        sb.append("</if>\n");

        sb.append(this.getTab(1));
        sb.append("</select>\n");

        result.append(sb.toString() + "\n");
    }

    public void createConditions() {
        StringBuffer sb = new StringBuffer("");

        sb.append(this.getTab(1));
        sb.append("<sql id=\"conditions\">\n");

        sb.append(this.getTab(2));
        sb.append("<where>\n");

        for (int i = 0; i < columns.length; i++) {
            sb.append(this.getTab(3));
            sb.append("<if test=\"" + properties[i] + " != null and " + properties[i] + " != ''\">\n");

            sb.append(this.getTab(4));
            sb.append("and " + columns[i] + " = " + "#{" + properties[i] + "}\n");

            sb.append(this.getTab(3));
            sb.append("</if>");

            sb.append("\n");
        }


        sb.append(this.getTab(2));
        sb.append("</where>\n");

        sb.append(this.getTab(1));
        sb.append("</sql>\n");

        result.append(sb.toString() + "\n");
    }


    private String getTab(int clazz) {
        String ts = "";
        for (int i = 0; i < clazz; i++) {
            ts += "    ";
        }
        return ts;
    }

    private String getCriteria() {
        return this.entity.endsWith("His") ? this.entity.substring(0, this.entity.length() - 3) + "Criteria" : this.entity + "Criteria";
    }

    private String appendSpace(String column) {
        StringBuffer sb = new StringBuffer("");
        for (int i = 0; i < maxColumnLength + 4 - column.length(); i++) {
            sb.append(" ");
        }
        return sb.toString();
    }

    private String source = "seq_nbr, status, op, create_datetime, update_datetime";

    private String entity = "StaffServiceInfoHis";

    private String table = "ps_staff_service_info";

    private String idType = "java.lang.Long";

    private String[] properties;

    private String[] columns;

    private int maxColumnLength = 0;

    private StringBuffer result = new StringBuffer("");
}