/**
 * Copyright (c) 2015-2016, Silly Boy 胡建洪(1043244432@qq.com).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package me.huding.luobo.back;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Map.Entry;

import org.beetl.core.Configuration;
import org.beetl.core.GroupTemplate;
import org.beetl.core.Template;
import org.beetl.core.resource.FileResourceLoader;

import com.jfinal.kit.PathKit;

import me.huding.luobo.model.Blog;
import me.huding.luobo.utils.DateStyle;
import me.huding.luobo.utils.DateUtils;
import me.huding.luobo.utils.IOUtils;

/**
 * 
 *  新闻正文静态化工具类
 *
 * @author JianhongHu
 * @version 1.0
 * @date 2016年4月1日
 */
public class StaticsUtils {

	public static final String ROOT_DIR = PathKit.getWebRootPath() + File.separator
			+ "template";
	private static FileResourceLoader resourceLoader = null;
	private static Configuration cfg = null;
	private static GroupTemplate gt = null;
	
	public static final String TEMPLATE_FILE = "/template.html";
	
//	public static final String TEMPLATE_FILE = "/article.html";
	
	static {
		init();
	}
	
	public static void init(){
		try {
			resourceLoader = new FileResourceLoader(ROOT_DIR);
			cfg = Configuration.defaultConfiguration();
			gt = new GroupTemplate(resourceLoader, cfg);
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @param filePath
	 * @param bean
	 * @return
	 * @throws IOException
	 */
	public static boolean render(Blog bean) throws IOException {
		Template t = gt.getTemplate(TEMPLATE_FILE);
		for(Entry<String, Object> entry : bean._getAttrsEntrySet()){
			String key = entry.getKey();
			if(key.equals("publishTime")){
				String value = DateUtils.DateToString(bean.getPublishTime(), DateStyle.YYYY_MM_DD );
				t.binding(entry.getKey(),value);
			} else {
				t.binding(entry.getKey(),entry.getValue());
			}
			
		}
		OutputStream stream = null;
		try {
			stream = new FileOutputStream(new File(bean.getPath()));
			t.renderTo(stream);
			stream.close();
		} finally {
			IOUtils.closeQuietly(stream);
		}
		return true;
	}
	
}
