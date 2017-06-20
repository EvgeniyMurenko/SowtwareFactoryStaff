package com.SoftwareFactoryStaff.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "s_notices")
public class Notice implements Serializable {

    public Notice() {
    }

    public Notice(String title, String noticeText, Date dataCreate, Boolean isActiv, Set<NoticeLink> noticeLinks) {
        this.title = title;
        this.noticeText = noticeText;
        this.dataCreate = dataCreate;
        this.isActiv = isActiv;
        this.noticeLinks = noticeLinks;
    }

    @Id
    @GeneratedValue(generator = "increment2")
    @GenericGenerator(name = "increment2", strategy = "increment")
    @Column(name = "notices_id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "notices_text")
    private String noticeText;

    @Column(name = "data_create")
    private Date dataCreate;

    @Column(name = "isActiv")
    private Boolean isActiv;

    @OneToMany(mappedBy = "notice", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<NoticeLink> noticeLinks;

    public Set<NoticeLink> getNoticeLinks() {
        return noticeLinks;
    }

    public void setNoticeLinks(Set<NoticeLink> noticeLinks) {
        this.noticeLinks = noticeLinks;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNoticeText() {
        return noticeText;
    }

    public void setNoticeText(String noticeText) {
        this.noticeText = noticeText;
    }

    public Date getDataCreate() {
        return dataCreate;
    }

    public void setDataCreate(Date dataCreate) {
        this.dataCreate = dataCreate;
    }

    public Boolean getActiv() {
        return isActiv;
    }

    public void setActiv(Boolean activ) {
        isActiv = activ;
    }


}
