package com.briup.smartcity.bean.extend;

import com.briup.smartcity.bean.Article;
import com.briup.smartcity.bean.BaseUser;
import com.briup.smartcity.bean.Category;
import org.springframework.stereotype.Component;

@Component
public class ArticleExtend extends Article{
//    具有资讯信息的属性值通过Article父类中可以被继承的方法提供
    private BaseUser baseUser;
    private Category category;

    public ArticleExtend(){

    }

    public BaseUser getBaseUser() {
        return baseUser;
    }

    public void setBaseUser(BaseUser baseUser) {
        this.baseUser = baseUser;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "ArticleExtend{" +
                "baseUser=" + baseUser +
                ", category=" + category +
                '}';
    }
}
