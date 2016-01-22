package com.example.dao.entity.tables.pojos;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by asales on 23/1/2016.
 */
@Embeddable
public class CustomerInfoKey implements Serializable{
    private String customerId;
    private String key;

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
