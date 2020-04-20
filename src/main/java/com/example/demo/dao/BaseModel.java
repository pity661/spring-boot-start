package com.example.demo.dao;

import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

/**
 * @program: demo
 * @description:
 * @author: wenky huwenqi@panda-fintech.com
 * @create: 2019-09-05 14:48
 */
// 父类不会映射到数据库
@MappedSuperclass
public class BaseModel {

    /**
     * 主键自增id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pkaid;

    /**
     * 创建时间
     */
    @NotNull
    @Column(name = "created_at", nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date createdAt = new Date();

    /**
     * 更新时间
     */
    @NotNull
    @Column(name = "updated_at", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @UpdateTimestamp
    private Date updatedAt = new Date();

    public Long getPkaid() {
        return pkaid;
    }

    public void setPkaid(Long pkaid) {
        this.pkaid = pkaid;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}
