package com.lyg.entitys;

import java.util.List;

public class TComment {
    private String id;

    private String customerId;

    private String parentCommentId;

    private String contentId;

    private Integer type;

    private String content;

    private String commentDate;

    private String commentTime;

    private Integer state;
    
    
    //--------
    private List<TComment> replyComment; //评论回复信息
    private TCustomer customer;          //评论者
    private TCustomer replyCustomer;     //回复者

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId == null ? null : customerId.trim();
    }

    public String getParentCommentId() {
        return parentCommentId;
    }

    public void setParentCommentId(String parentCommentId) {
        this.parentCommentId = parentCommentId == null ? null : parentCommentId.trim();
    }

    public String getContentId() {
        return contentId;
    }

    public void setContentId(String contentId) {
        this.contentId = contentId == null ? null : contentId.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(String commentDate) {
        this.commentDate = commentDate == null ? null : commentDate.trim();
    }

    public String getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(String commentTime) {
        this.commentTime = commentTime == null ? null : commentTime.trim();
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

	public List<TComment> getReplyComment() {
		return replyComment;
	}

	public void setReplyComment(List<TComment> peplyComment) {
		this.replyComment = peplyComment;
	}

	public TCustomer getCustomer() {
		return customer;
	}

	public void setCustomer(TCustomer customer) {
		this.customer = customer;
	}

	public TCustomer getReplyCustomer() {
		return replyCustomer;
	}

	public void setReplyCustomer(TCustomer replyCustomer) {
		this.replyCustomer = replyCustomer;
	}
    
    
}