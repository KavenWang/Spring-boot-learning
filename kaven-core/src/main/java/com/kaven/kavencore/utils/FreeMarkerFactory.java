package com.kaven.kavencore.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Locale;
import java.util.Map;

import org.apache.commons.lang3.CharEncoding;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import freemarker.template.Configuration;
import freemarker.template.Template;

/**
 * FreeMarkerFactory FreeMarker 工厂类，根据ftl模板生成html
 * @desc: FreeMarkerFactory
 * @author: wangwei
 * @createTime: 2017年6月26日 下午5:37:16
 * @history:
 * @version: v1.0
 */
public class FreeMarkerFactory {

	private static final Logger LOG = LoggerFactory.getLogger(FreeMarkerFactory.class);
	
	
	/**
     * 根据ftl模板文件,生成静态HTML文件
     * @param ftlPath   FTL模板文件路径,例如["c:/liang/template.ftl"]
     * @param filePath  生成HMTL文件路径，例如["d:/liang/lianggzone.html"]
     * @param data      Map数据
     * @return
     */
    public static boolean createHTML(String ftlPath, String filePath, Map<String, Object> data) throws IOException{    
        return createHTML(ftlPath, filePath, data, true);
    }
	
	/**
	 * 根据ftl模板文件,生成静态HTML文件
	 * @author: wangwei
	 * @createTime: 2017年6月26日 下午6:51:54
	 * @history:
	 * @param ftlPath FTL模板文件路径,例如["c:/liang/template.ftl"]
	 * @param filePath 生成HMTL文件路径，例如["d:/liang/lianggzone.html"]
	 * @param data Map数据
	 * @param isCreate4NoExists 是否文件夹不存在的时候创建
	 * @return
	 * @throws IOException boolean
	 */
	public static boolean createHTML(String ftlPath, String filePath, Map<String, Object> data, boolean isCreate4NoExists) throws IOException{
		
		String fileDir = StringUtils.substringBeforeLast(filePath, File.separator);// 获取HMTL文件目录
		//String fileName = StringUtils.substringBeforeLast(filePath, File.separator);// 获取HMTL文件名 
		String ftlDir = StringUtils.substringBeforeLast(ftlPath, File.separator);//  获取FTL文件目录
		String ftlName = StringUtils.substringAfterLast(ftlPath, File.separator);// 获取FTL文件名 
		
		 //文件递归创建生成文件目录
        if(isCreate4NoExists){
            File realDirectory = new File(fileDir);
            if (!realDirectory.exists()) {
                realDirectory.mkdirs();
            }
        }
        // step1 获取freemarker的配置
        Configuration freemarkerCfg = new Configuration(Configuration.VERSION_2_3_23);
        // step2 设置freemarker模板所放置的位置(文件夹)
        freemarkerCfg.setDirectoryForTemplateLoading(new File(ftlDir));
        // step3 设置freemarker模板编码
        freemarkerCfg.setEncoding(Locale.getDefault(), CharEncoding.UTF_8);
        // step4 找到对应freemarker模板并实例化
        Template template = freemarkerCfg.getTemplate(ftlName, CharEncoding.UTF_8); 
        // step5 初始化一个IO流
        Writer writer = null;
        OutputStream fileOut = null;
        OutputStreamWriter out = null;
        try{
        	fileOut = new FileOutputStream(new File(filePath));
        	out = new OutputStreamWriter(fileOut, CharEncoding.UTF_8);
            writer = new BufferedWriter(out);
            writer.flush();
            // step6 模板渲染出所要的内容
            template.process(data, writer);
        } catch (Exception e) {
        	LOG.error(e.getMessage());
            return false;
        }finally {
        	if(null!=fileOut){
        		fileOut.close();
			}
			if(null!=out){
				out.close();
			}
			if(null!=writer){
				writer.close();
			}
		}
		return true;
	}
}

	