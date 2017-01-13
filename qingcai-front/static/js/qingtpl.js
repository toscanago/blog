/**
 * 青菜萝卜 前端模板
 * 所有前端模板的定义
 */

layui.define(function(exports) {
	
	var tpl = {
		// 首页博客列表
		blogListTpl:
		'{{#  layui.each(d.list, function(index, item){ }}\
			<article class="qing-entry-article">\
		    <div class="am-u-lg-12 am-u-md-12 am-u-sm-12 qing-entry-text">\
		    	 <div class="qing-list-title">\
		    	 		<span class="qing-category">{{item.categoryName}}<i></i></span><a href="{{item.url}}"> {{item.title}}</a>\
		    	 </div>\
		       <div class="qing-list-hint">\
			       	<span><i class="am-icon-user qing-list-author" title="作者"></i> {{item.author}} &nbsp;</span>\
				      <span><i class="am-icon-clock-o qing-list-clock" title="时间"></i> {{item.publishTime}}</span>\
				      <span><i class="am-icon-eye-slash qing-list-eye" title="阅读"></i> 阅读({{item.readNum}})</span>\
			        <span><i class="am-icon-comments-o qing-list-comment" title="评论"></i> 评论({{item.readNum}})</span>\
			        <span><i class="am-icon-heart-o qing-list-heart" title="点赞"></i> 点赞({{item.readNum}})</span>\
		       </div>\
		       {{# if(item.summary != null && item.summary.length > 200) { }}\
		       			{{# item.summary = item.summary.substring(0,200) + "...."}}\
		       {{# } }}\
		       <p class="qing-list-summary">{{ item.summary }}</p>\
		       <div class="qing-list-tag">\
		       		{{# if(item.tags.length > 0) { }}\
		       			<i class="am-icon-tags "></i>\
		       		{{# } }}\
		       		{{#  layui.each(item.tags, function(index, tag){ }}\
		       				<span class="qing-blog-tag am-radius">#{{tag}}</span>\
		       	  {{# });}}\
	            <!--<a href="{{item.url}}" class="qing-read-more">阅读全文>></a>-->\
	            <a href="article.html" class="qing-read-more">阅读全文>></a>\
		       </div> \
		    </div>\
			</article>\
		{{# });}}'
	    ,
		// 博客分类标签模板
		blogTagTpl: 
		'{{#  layui.each(d.data, function(index, item){ }}\
			{{# if((index + 1) % 4 == 0) { }}\
				<span class="qing-tag qing-tag-forth" >\
					{{item.tagName}}({{item.blogNum}})\
				</span>\
			{{# } else if((index + 1) % 3 == 0) { }}\
				<span class="qing-tag qing-tag-third" >\
					<a href="" >{{item.tagName}}({{item.blogNum}})</a>\
				</span>\
			{{# } else if((index + 1) % 2 == 0) { }}\
				<span class="qing-tag qing-tag-second" >\
					<a href="" >{{item.tagName}}({{item.blogNum}})</a>\
				</span>\
			{{# } else { }}\
				<span class="qing-tag qing-tag-first" >\
					<a href="" >{{item.tagName}}({{item.blogNum}})</a>\
				</span>\
			{{# }; }}\
		{{# });}}'
		,
		
		// 热门博客模板
		hotestBlogsTpl:
		'{{#  layui.each(d.data.list, function(index, item){ }}\
			<li>\
				<a href="{{item.url}}">{{item.title}}</a>\
				<span><i class="am-icon-comments-o" title="评论数"> </i> {{item.readNum}}</span>\
			</li>\
		{{# });}}'
		,
		
		// 最新博客模板
		latestBlogsTpl:
		'{{#  layui.each(d.data.list, function(index, item){ }}\
			<li>\
				<a href="{{item.url}}">{{item.title}}</a>\
				<span><i class="am-icon-eye" title="阅读数"> </i> {{item.readNum}}</span>\
			</li>\
		{{# });}}'
		
	}
    // 导出模板文件
	exports('qingtpl', tpl);
});