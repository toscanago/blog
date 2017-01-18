package me.huding.luobo.model.base;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseAnnouncement<M extends BaseAnnouncement<M>> extends Model<M> implements IBean {

	public void setId(java.lang.Long id) {
		set("id", id);
	}

	public java.lang.Long getId() {
		return get("id");
	}

	public void setDateStart(java.util.Date dateStart) {
		set("date_start", dateStart);
	}

	public java.util.Date getDateStart() {
		return get("date_start");
	}

	public void setVisible(java.lang.Boolean visible) {
		set("visible", visible);
	}

	public java.lang.Boolean getVisible() {
		return get("visible");
	}

	public void setTitle(java.lang.String title) {
		set("title", title);
	}

	public java.lang.String getTitle() {
		return get("title");
	}

	public void setContent(java.lang.String content) {
		set("content", content);
	}

	public java.lang.String getContent() {
		return get("content");
	}

	public void setCategory(java.lang.Integer category) {
		set("category", category);
	}

	public java.lang.Integer getCategory() {
		return get("category");
	}

	public void setCreatedUser(java.lang.Integer createdUser) {
		set("created_user", createdUser);
	}

	public java.lang.Integer getCreatedUser() {
		return get("created_user");
	}

}