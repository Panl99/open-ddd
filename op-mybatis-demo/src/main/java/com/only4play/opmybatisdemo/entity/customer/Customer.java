package com.only4play.opmybatisdemo.entity.customer;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class Customer implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;


    private String username;

    private String grade;

    private Integer userStatus;


    public void init(){
        setUserStatus(1);
    }

    public void doUpdate(CustomerUpdater updater){
        setUsername(updater.getUsername());
    }


}